<?php
 
error_reporting(E_ALL);  // Turn on all errors, warnings and notices for easier debugging


$itemID= 221858149377;  //ItemID To USe for getting Recommendations, ItemID Should Belong to The Seller Whose Token is Being Used

//Seller Authorization Token
$userAuthToken= 'Authorization:TOKEN ADD SELLER TOKEN AND MAKE SURE THERE IS SPACE AFTER "TOKEN"';

//Endpoint URL to Use
$url = "https://svcs.ebay.com/services/selling/listingrecommendation/v1/item/$itemID/itemRecommendations";

//initialise a CURL session
$connection = curl_init();

//Set Endpoint URL 
curl_setopt($connection,CURLOPT_URL,$url);

//Set Method as GET; Bydefault it is Get, So it is OK if you do not set it if the call is Get call
curl_setopt($connection, CURLOPT_HTTPGET, true);

//Create Array of Headers
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

//Send the Request
$response = curl_exec($connection);

//get information about the cURL request
// $info = curl_getinfo($connection);
//echo 'Took ' . $info['total_time'] . ' seconds for url ' . $info['url']."<br />";

//close the connection
curl_close($connection);

//Check If Response is OK
if (stristr($response, 'HTTP 404') || $response == '')
    die('<P>Error sending request, Please check the Request');


$data=json_decode($response,true);
if ($data === NULL) die('Error parsing json');


?>

<!-- Print the Required Fileds in table format -->
<table border='1px'>
<?php
foreach ($data["Recommendation"] as $arrayRow){
	echo '<tr><th style="background-color:#E6E6FA; border-radius:20px">Recommendation</th></tr>';
	
	$ignoreArray = array(
			"recommendationData","value"
	);
	
	foreach($arrayRow as $arrayColKey => $arrayColValue){
		if(!in_array($arrayColKey,$ignoreArray)){
			echo '<tr><td> <b>'.$arrayColKey.'</b>     =>    '. $arrayColValue . '</td></tr>';
		}
		
	}
	
	echo '</tr>';
}
echo '</table>';
?>




