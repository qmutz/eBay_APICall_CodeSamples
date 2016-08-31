<?php
 
error_reporting(E_ALL);  // Turn on all errors, warnings and notices for easier debugging

//Seller Authorization Token
$userAuthToken= 'Authorization:TOKEN ADD SELLER TOKEN AND MAKE SURE THERE IS SPACE AFTER "TOKEN"';

//Endpoint URL to Use
$url = "https://svcs.ebay.com/services/selling/listingrecommendation/latestVersion";

//Initializle cURL
$connection = curl_init();

//Set Endpoint URL 
curl_setopt($connection,CURLOPT_URL,$url);

//Set HTTP Method
curl_setopt($connection, CURLOPT_HTTPGET, true);

//Create Array Of Headers
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

//Close Session
curl_close($connection);

//Check If Response is OK
if (stristr($response, 'HTTP 404') || $response == '')
    die('<P>Error sending request, Please check the Request');


$data=json_decode($response,true);
if ($data === NULL) die('Error parsing json');

?>
<!-- Print The Version In Table Format -->
<table border='1px'>
<?php

$Version = $data['Version'];

	echo '<tr><tH style="background-color:#E6E6FA; border-radius:20px"> <b>'."The Current Version of Listing Recommendation API is : " .$Version.'</b></tH></tr>';

echo '</table>';
?>