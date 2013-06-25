<?php
/*  © 2013 eBay Inc., All Rights Reserved */ 
/* Licensed under CDDL 1.0 -  http://opensource.org/licenses/cddl1.php */
require_once('keys.php') ?>
<?php require_once('eBaySession.php') ?>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML>
<HEAD>
<META http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<TITLE>GetItem</TITLE>
</HEAD>
<BODY>
<FORM action="GetItem.php" method="post">
    <P>Item ID: <INPUT type="text" name="Id">
    <BR><INPUT type="submit" name="submit">
</FORM>

<?php
    if(isset($_POST['Id']))
    {
        //Get the ItemID inputted
        $id = $_POST['Id'];
    
    
        //SiteID must also be set in the Request's XML
        //SiteID = 0  (US) - UK = 3, Canada = 2, Australia = 15, ....
        //SiteID Indicates the eBay site to associate the call with
        $siteID = 0;
        //the call being made:
        $verb = 'GetItem';
        
        ///Build the request Xml string
        $requestXmlBody = '<?xml version="1.0" encoding="utf-8" ?>';
        $requestXmlBody .= '<GetItemRequest xmlns="urn:ebay:apis:eBLBaseComponents">';
        $requestXmlBody .= "<RequesterCredentials><eBayAuthToken>$userToken</eBayAuthToken></RequesterCredentials>";;
        $requestXmlBody .= "<ItemID>$id</ItemID>";
        $requestXmlBody .= '</GetItemRequest>';
        
        //Create a new eBay session with all details pulled in from included keys.php
        $session = new eBaySession($userToken, $devID, $appID, $certID, $serverUrl, $compatabilityLevel, $siteID, $verb);
        
        //send the request and get response
        $responseXml = $session->sendHttpRequest($requestXmlBody);
        if(stristr($responseXml, 'HTTP 404') || $responseXml == '')
            die('<P>Error sending request');
        
        //Xml string is parsed and creates a DOM Document object
        $responseDoc = new DomDocument();
        $responseDoc->loadXML($responseXml);
        
        
        //get any error nodes
        $errors = $responseDoc->getElementsByTagName('Errors');
        
        //if there are error nodes
        if($errors->length > 0)
        {
            echo '<P><B>eBay returned the following error(s):</B>';
            //display each error
            //Get error code, ShortMesaage and LongMessage
            $code = $errors->item(0)->getElementsByTagName('ErrorCode');
            $shortMsg = $errors->item(0)->getElementsByTagName('ShortMessage');
            $longMsg = $errors->item(0)->getElementsByTagName('LongMessage');
            //Display code and shortmessage
            echo '<P>', $code->item(0)->nodeValue, ' : ', str_replace(">", "&gt;", str_replace("<", "&lt;", $shortMsg->item(0)->nodeValue));
            //if there is a long message (ie ErrorLevel=1), display it
            if(count($longMsg) > 0)
                echo '<BR>', str_replace(">", "&gt;", str_replace("<", "&lt;", $longMsg->item(0)->nodeValue));
    
        }

        else //no errors
        {
            //get the nodes needed
            $titleNode = $responseDoc->getElementsByTagName('Title');
            $primaryCategoryNode = $responseDoc->getElementsByTagName('PrimaryCategory');
            $categoryNode = $primaryCategoryNode->item(0)->getElementsByTagName('CategoryName');
            $listingDetailsNode = $responseDoc->getElementsByTagName('ListingDetails');
            $startedNode = $listingDetailsNode->item(0)->getElementsByTagName('StartTime');
            $endsNode = $listingDetailsNode->item(0)->getElementsByTagName('EndTime');
            
            $sellingStatusNode = $responseDoc->getElementsByTagName('SellingStatus');
            $currentPriceNode = $sellingStatusNode->item(0)->getElementsByTagName('CurrentPrice');
            $currency = $currentPriceNode->item(0)->getAttribute('currencyID');
            $startPriceNode = $responseDoc->getElementsByTagName('StartPrice');
            $buyItNowPriceNode = $responseDoc->getElementsByTagName('BuyItNowPrice');
            $bidCountNode = $sellingStatusNode->item(0)->getElementsByTagName('BidCount');
            
            $sellerNode = $responseDoc->getElementsByTagName('Seller');
            
            //Display the details
            echo '<P><B>', $titleNode->item(0)->nodeValue, " ($id)</B>";
            echo '<BR>Category: ', $categoryNode->item(0)->nodeValue;
            echo '<BR>Started: ', $startedNode->item(0)->nodeValue;
            echo '<BR>Ends: ', $endsNode->item(0)->nodeValue;
            
            echo "<P>Current Price: ", $currentPriceNode->item(0)->nodeValue, $currency;
            echo "<BR>Start Price: ", $startPriceNode->item(0)->nodeValue, $currency;
            echo "<BR>BuyItNow Price: ", $buyItNowPriceNode->item(0)->nodeValue, $currency;
            echo "<BR>Bid Count: ", $bidCountNode->item(0)->nodeValue;
            
            //Display seller detail if present
            if($sellerNode->length > 0)
            {
                echo '<P><B>Seller</B>';
                $userIDNode = $sellerNode->item(0)->getElementsByTagName('UserID');
                $scoreNode = $sellerNode->item(0)->getElementsByTagName('FeedbackScore');
                $regDateNode = $sellerNode->item(0)->getElementsByTagName('RegistrationDate');
                
                echo '<BR>UserID: ', $userIDNode->item(0)->nodeValue;
                echo '<BR>Feedback Score: ', $scoreNode->item(0)->nodeValue;
                echo '<BR>Registration Date: ', $regDateNode->item(0)->nodeValue;
            }
        }
    }
?>

</BODY>
</HTML>
