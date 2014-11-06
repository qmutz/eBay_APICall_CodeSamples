#!C:/Perl64/bin/perl.exe
#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#
#© 2008-2013 eBay Inc., All Rights Reserved */
# Licensed under CDDL 1.0 -  http://opensource.org/licenses/cddl1.php */ #
#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#~#

use LWP::UserAgent;
use HTTP::Request;
use HTTP::Response;
use XML::DOM;
use CGI qw(:standard);
use CGI::Carp qw(fatalsToBrowser);

require '../common/config.pl';

##############################################################
# Declare and initialise variables with data needed for call #
##############################################################


#The name of the call being made
my $verb = 'GetSuggestedCategories';

#get the query input by the user
my $query = param('query');



#######################
# Setup the HTML Page #
#######################
#print the HTTP header line using the CGI header method
print header;
#print start of html doc
print start_html(-title=>$verb);

#setup the form for the user to select the size
print startform(-method=>"POST",
          -action=>"GetSuggestedCategories.pl");
print p();
print "Query: ";
print textfield(-name=>'query');
print "<BR>";
print submit(-value=>"Submit Query");


if(!$query == "") # Has user entered a query
{
    #########################
    # Setup Request Objects #
    #########################
    #UserAgent - used to dispatch web requests.
    my $objUserAgent = LWP::UserAgent->new;

    #get the HTTP::Headers object needed for calls to the eBay API
    my $httpHeader = geteBayHeaders();

    #Get the body of the XML request for this call
    my $requestXmlBody = buildCallXmlBody();
	
    #Create a HTTP:Request to the Sandbox server, using the headers and body specified
    my $httpRequest = HTTP::Request->new("POST", 'https://api.sandbox.ebay.com/ws/api.dll', $httpHeader, $requestXmlBody);

    #Send the request and get HTTP::Response object
    my $httpResponse = $objUserAgent->request($httpRequest);


    #See if there were any errors getting the response
    if ($httpResponse->is_error)
    {
        #There were errors - display them
        print $httpResponse->error_as_HTML;
    }
    else # No Errors
    {

        #####################################
        # Process the XML Response returned #
        #####################################
        #Create a new DOM::Parser
        my $parser = new XML::DOM::Parser;

        #Parse the response into a DOM::Document
        my $responseDoc = $parser->parse ($httpResponse->content);

        #Look for any error nodes
        my $errorNodes = $responseDoc->getElementsByTagName("Errors");

        #if there are some error nodes display them
        if($errorNodes->getLength() > 0)
        {
            print p("<B>eBay returned the following error(s):</B>");
            #go through each error node
            for(my $i = 0; $i < $errorNodes->getLength(); $i++)
            {
                #Get this error node
                my $thisNode = $errorNodes->item($i);
                #Get the error's code
                my $errCodeNode = $thisNode->getElementsByTagName('ErrorCode');
                #Get the error's short message
                my $errShortMsgNode = $thisNode->getElementsByTagName('ShortMessage');
                my $shortMsg = $errShortMsgNode->item(0)->getChildNodes()->item(0)->getNodeValue();
                $shortMsg =~ s/</&lt;/g;#Replace special chars
                $shortMsg =~ s/>/&gt;/g;
                #Get the error's long message
                my $errLongMsgNode = $thisNode->getElementsByTagName('LongMessage');
                #Print the Code with short message
                print "<P>" . $errCodeNode->item(0)->getChildNodes()->item(0)->getNodeValue() . " : $shortMsg";

                #See if there is a long message
                if($errLongMsgNode->getLength() > 0)
                {
                    my $longMsg = $errLongMsgNode->item(0)->getChildNodes()->item(0)->getNodeValue();
                    $longMsg =~ s/</&lt;/g; #Replace special chars
                    $longMsg =~ s/>/&gt;/g;
                    #Print the long message
                    print "<BR>$longMsg";
                }
            }
        }

        ########################################
        # Request Successful - Display Results #
        ########################################
        else
        {

            my $count = $responseDoc->getElementsByTagName('CategoryCount')->item(0)->getChildNodes()->item(0)->getNodeValue();
            print p("$count Categories.");
            #get the suggested Categories
            my $suggestedCategories = $responseDoc->getElementsByTagName('SuggestedCategory');

            #if there are some suggested categories
            if($suggestedCategories->getLength() > 0)
            {
                print p();
                print '<B>Suggested Categories</B>';
                #go through each one
                for(my $i = 0; $i < $suggestedCategories->getLength(); $i++)
                {
                    #get the details needed
                    my $thisCat = $suggestedCategories->item($i);
                    my $catName = $thisCat->getElementsByTagName('CategoryName')->item(0)->getChildNodes()->item(0)->getNodeValue();
                    my $catID = $thisCat->getElementsByTagName('CategoryID')->item(0)->getChildNodes()->item(0)->getNodeValue();
                    my $percentItems = $thisCat->getElementsByTagName('PercentItemFound')->item(0)->getChildNodes()->item(0)->getNodeValue();

                    #display the details
                    print "<BR>$catName ($catID) - $percentItems%<BR>";
                }
            }
        }



        #Avoid memory leaks - cleanup circular references for garbage collection
        $responseDoc->dispose();
    }
}

#Print out the end of the HTML page
print end_html;
exit;


########################################################
# buildCallXmlBody:                                    #
#    Builds the XML request body to send to the server #
#   containing the data needed by the API             #
########################################################
sub buildCallXmlBody()
{
    #build a string represntation of the XML, containg all the data
    my $xmlBody = "<?xml version=\"1.0\" encoding=\"utf-8\" ?>";
    $xmlBody .= "<GetSuggestedCategoriesRequest xmlns=\"urn:ebay:apis:eBLBaseComponents\">";
    $xmlBody .= "<RequesterCredentials><eBayAuthToken>$requestToken</eBayAuthToken></RequesterCredentials>";
    $xmlBody .= "<Query>$query</Query>";
    $xmlBody .= "</GetSuggestedCategoriesRequest>";

    #return the XML string
     return $xmlBody;
}



#########################################################
# geteBayHeaders:                                       #
#    Constuct and return a HTTP::Headers object for the #
#   eBay API call, using the declares global variables #
#########################################################
sub geteBayHeaders()
{
    #Create new HTTP::Headers object
    my $httpHeader = HTTP::Headers->new;

    #add all the headers with their values
    $httpHeader->push_header('X-EBAY-API-COMPATIBILITY-LEVEL' => $compatabilityLevel);
    $httpHeader->push_header('X-EBAY-API-DEV-NAME' => $devID);
    $httpHeader->push_header('X-EBAY-API-APP-NAME' => $appID);
    $httpHeader->push_header('X-EBAY-API-CERT-NAME' => $certID);
    $httpHeader->push_header('X-EBAY-API-CALL-NAME' => $verb);
    $httpHeader->push_header('X-EBAY-API-SITEID' => $siteID);
    $httpHeader->push_header('X-EBAY-API-Content-Type' => 'text/xml');

    #return the object
    return $httpHeader;
}
