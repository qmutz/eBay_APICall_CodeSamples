<?php

error_reporting(E_ALL);  // Turn on all errors, warnings and notices for easier debugging

//Seller Authorization Token
$userAuthToken= 'Authorization:TOKEN ADD SELLER TOKEN AND MAKE SURE THERE IS SPACE AFTER "TOKEN"';

//Endpoint URL to Use
$url = "https://svcs.ebay.com/services/selling/listingrecommendation/v1/item/recommendationItemIds?recommendationType=ItemSpecifics&pageNumber=1&entriesPerPage=1";

//Initializle cURL
$connection = curl_init();

//Set Endpoint URL
curl_setopt($connection,CURLOPT_URL,$url);

//Set HTTP Method
curl_setopt($connection, CURLOPT_HTTPGET, true);

//Create Array of  Required Headers
$headers = array();
$headers[] = $userAuthToken;
$headers[] = 'X-EBAY-GLOBAL-ID:EBAY-US';

//set the headers using the array of headers
curl_setopt($connection,CURLOPT_HTTPHEADER,$headers);

//set it to return the transfer as a string from curl_exec
curl_setopt($connection,CURLOPT_RETURNTRANSFER,1);

//stop CURL from verifying the peer's certificate
curl_setopt($connection, CURLOPT_SSL_VERIFYPEER, 0);
curl_setopt($connection, CURLOPT_SSL_VERIFYHOST, 0);

//Execute the Request
$response = curl_exec($connection);

//close the connection
curl_close($connection);

//Check If Response is OK
if (stristr($response, 'HTTP 404') || $response == '')
	die('<P>Error sending request, Please check the Request');

$data=json_decode($response,true);
if ($data === NULL) die('Error parsing json');
$entries='';
$entries = $data['pagination']['totalEntries'];


?>
<!-- Print the Required Fileds in table format -->
<table border='1px'>
<?php

if ($entries == 0){
	echo "Hurray! No Items to Recommend";
} else {
foreach	($data['items'] as $itemID);


echo '<tr><tH style="background-color:#E6E6FA; border-radius:20px"> <b>'."Number of Items Found For Recommendation =" .$entries.'</b></tH></tr>';
echo '<tr><th style="background-color:#E6E6FA; border-radius:20px">Below Is One of the ItemID That has ItemSpecifics Recommendation, Please Check itemRecommendations Call to See Recommendations</th></tr>';
$itemID1=$data['items'];
echo '<tr><td> <b>'.implode(", ",$itemID1).'</b></td></tr>';

	
	echo '</tr>';
}
echo '</table>';
?>



