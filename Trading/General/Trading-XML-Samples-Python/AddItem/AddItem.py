#!C:\Python27\python.exe -u
###############################################################################
# © 2008-2013 eBay Inc., All Rights Reserved */
# Licensed under CDDL 1.0 -  http://opensource.org/licenses/cddl1.php */  #
###############################################################################


#Send Content-type header to browser
print "Content-type: text/html"
print

#import the HTTP, DOM and ConfigParser modules needed
import httplib, ConfigParser, codecs
from xml.dom.minidom import parse, parseString


# open config file
config = ConfigParser.ConfigParser()
config.read("config.ini")

# specify eBay API dev,app,cert IDs
devID = config.get("Keys", "Developer")
appID = config.get("Keys", "Application")
certID = config.get("Keys", "Certificate")

#get the server details from the config file
serverUrl = config.get("Server", "URL")
serverDir = config.get("Server", "Directory")
paypalEmailAddress = config.get("Authentication", "PaypalEmailAddress")


# specify eBay token
# note that eBay requires encrypted storage of user data
userToken = config.get("Authentication", "Token")


#eBay Call Variables
#siteID specifies the eBay international site to associate the call with
#0 = US, 2 = Canada, 3 = UK, ....
siteID = "0"
#verb specifies the name of the call
verb = "AddItem"
#The API level that the application conforms to
compatabilityLevel = "433"


#Setup the HTML Page with name of call as title
print "<HTML>"
print "<HEAD><TITLE>", verb, "</TITLE></HEAD>"
print "<BODY>"

#FUNCTION: addItem
# Lists an item on eBay
def addItem():
    # specify the connection to the eBay environment
    connection = httplib.HTTPSConnection(serverUrl)
    # specify a POST with the results of generateHeaders and generateRequest
    # detailLevel = 1, ViewAllNodes = 1  - this gets the entire tree
    connection.request("POST", serverDir, buildRequestXml("ReturnAll", "1"), buildHttpHeaders())
    response = connection.getresponse()
    if response.status != 200:
        print "Error sending request: " + response.reason
        exit
    else: #response successful
        # store the response data and close the connection
        data = response.read()
        connection.close()
        
        # parse the response data into a DOM
        response = parseString(data)
    
        # check for any Errors
        errorNodes = response.getElementsByTagName('Errors')
        if (errorNodes != []): #there are errors
            print "<P><B>eBay returned the following errors</B>"
            #Go through each error:
            for error in errorNodes:
                #output the error code and short message
                print "<P>" + ((error.getElementsByTagName('ErrorCode')[0]).childNodes[0]).nodeValue
                print " : " + ((error.getElementsByTagName('ShortMessage')[0]).childNodes[0]).nodeValue.replace("<", "&lt;")
                    #output Long Message if it exists (depends on ErrorLevel setting)
                if (error.getElementsByTagName('LongMessage')!= []):
                    print "<BR>" + ((error.getElementsByTagName('LongMessage')[0]).childNodes[0]).nodeValue.replace("<", "&lt;")

        else: #eBay returned no errors - output results
            # check for the <ItemID> tag and print
            if (response.getElementsByTagName('ItemID')!=[]):
                print "<P><B>Item ID is: "
                print ((response.getElementsByTagName('ItemID')[0]).childNodes[0]).nodeValue, "</B>"
        
        response.unlink()
        

# FUNCTION: buildHttpHeaders
# Build together the required headers for the HTTP request to the eBay API
def buildHttpHeaders():
    httpHeaders = {"X-EBAY-API-COMPATIBILITY-LEVEL": compatabilityLevel,
               "X-EBAY-API-DEV-NAME": devID,
               "X-EBAY-API-APP-NAME": appID,
               "X-EBAY-API-CERT-NAME": certID,
               "X-EBAY-API-CALL-NAME": verb,
               "X-EBAY-API-SITEID": siteID,
               "Content-Type": "text/xml"}
    return httpHeaders

# FUNCTION: buildRequestXml
# Build the body of the call (in XML) incorporating the required parameters to pass
def buildRequestXml(detailLevel, viewAllNodes):
    requestXml = "<?xml version='1.0' encoding='utf-8'?>"+\
              "<AddItemRequest xmlns=\"urn:ebay:apis:eBLBaseComponents\">"+\
              "<RequesterCredentials><eBayAuthToken>" + userToken + "</eBayAuthToken></RequesterCredentials>"
    
    if (detailLevel != ""):
        requestXml = requestXml + "<DetailLevel>" + detailLevel + "</DetailLevel>"
                     
    requestXml = requestXml + "<Item>"+\
    				"<BuyItNowPrice currencyID=\"USD\">10.0</BuyItNowPrice>"+\
    				"<Country>US</Country>"+\
    				"<Currency>USD</Currency>"+\
    				"<Description>This is a test.</Description>"+\
    				"<ListingDuration>Days_7</ListingDuration>"+\
    				"<Location>San Jose, CA</Location>"+\
    				"<PaymentMethods>PaymentSeeDescription</PaymentMethods>"+\
    				"<PrimaryCategory>"+\
    				"  <CategoryID>357</CategoryID>"+\
    				"</PrimaryCategory>"+\
    				"<Quantity>1</Quantity>"+\
    				"<StartPrice>1.0</StartPrice>"+\
					"<ListingType>Chinese</ListingType>"+\
					"<PaymentMethods>PayPal</PaymentMethods>"+\
		            "<PayPalEmailAddress>" + paypalEmailAddress + "</PayPalEmailAddress>"+\
    				"<ShippingTermsInDescription>True</ShippingTermsInDescription>"+\
    				"<Title>Test item title</Title>"+\
					"<ReturnPolicy>"+\
					"	<ReturnsAcceptedOption>ReturnsAccepted</ReturnsAcceptedOption>"+\
					"	<RefundOption>MoneyBack</RefundOption>"+\
					"	<ReturnsWithinOption>Days_14</ReturnsWithinOption>"+\
					"</ReturnPolicy>"+\
					   "<ShippingDetails>"+\
					"	<ShippingType>Flat</ShippingType>"+\
					"	<ShippingServiceOptions>"+\
					"		<ShippingService>UPSGround</ShippingService>"+\
					"		<ShippingServiceAdditionalCost currencyID=\"USD\">2.0</ShippingServiceAdditionalCost>"+\
					"		<ShippingServiceCost currencyID=\"USD\">9.0</ShippingServiceCost>"+\
					"		<ShippingServicePriority>1</ShippingServicePriority>"+\
					"	</ShippingServiceOptions>"+\
					"</ShippingDetails>"+\
					"<DispatchTimeMax>1</DispatchTimeMax>"+\
  				"</Item>"+\
              "</AddItemRequest>"
    return requestXml
    
addItem()
    

#finish HTML page
print "</BODY>"
print "</HTML>"
