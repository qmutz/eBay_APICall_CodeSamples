<?php require_once('../get-common/ServiceEndpointsAndTokens.php') ?>
<?php require_once('../get-common/LargeMerchantServiceSession.php') ?>
<?php require_once('../get-common/DOMUtils.php') ?>
<?php require_once('../get-common/PrintUtils.php') ?>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title>StartDownloadJob</title>
</head>
<body>
<form action="StartDownloadJob.php" method="post">
<p><textarea cols="80"
	rows="10" name="userRequest"><?php if (empty($_POST['userRequest'])): ?>
<?php echo '<?xml version="1.0" encoding="utf-8"?>' . "\n"; ?>
<startDownloadJobRequest xmlns="http://www.ebay.com/marketplace/services">
  <!-- other reports include FeeSettlementReport and SoldReport. -->
  <downloadJobType>ActiveInventoryReport</downloadJobType>
  <UUID><?php echo uniqid("",true); ?></UUID>
</startDownloadJobRequest>
<?php else :?>
<?php echo $_POST['userRequest']; ?>
<?php endif; ?></textarea> <br />
<input type="submit" name="submit" value="Start Download Job" /></p></form>
<?php
$debug = "";
function parseResponseAndPrintExamples(SimpleXMLElement $xml)
{
  echo '<p><b>Parsing Example</b></p>';

  $ack = (string)$xml->ack;

  if($ack === 'Success')
  {
    $jobId = (string)$xml->jobId;
    $timestamp = (string)$xml->timestamp;
     
    echo $ack . '. Job #' . $jobId . ' started at ' . $timestamp;
  }
  else
  {
    $error = (string)$xml->error;
    $errorMessage = (string)$error->message;

    echo 'Error. ' . $errorMessage;
  }
}

function getRequest()
{
  ini_set('magic_quotes_gpc', false);
  global $debug;

  $request = $_POST['userRequest'];

  if( get_magic_quotes_gpc() ) {
    $request = stripslashes( $request );
  }

  return $request;
}

if( isset( $_POST['userRequest'] ) )
{
  $session = new LargeMerchantServiceSession('XML','XML', ENV_SANDBOX);

  $request = getRequest();

  $responseXML = $session->sendBulkDataExchangeRequest(
			'startDownloadJob', $request);

  $xml = simplexml_load_string($responseXML);
  if(!empty($xml) && 'Success' == (string)$xml->ack)
  {
    $id_array = array("JobID"=>(string)$xml->jobId);
  }
  PrintUtils::printXML($responseXML);

  parseResponseAndPrintExamples($xml);
}
?>
<hr />
<a href="./../index.php">Index</a>
<?php if (!empty($id_array['JobID'])) :?>
<a href="./../GetJobStatus/GetJobStatus.php?jobId=<?php echo $id_array['JobID'] ;?>">GetJobStatus</a>
<?php endif; ?>
<?php if (!empty($debug)) :?>
<pre>
<?php echo $debug; ?>
</pre>
<?php endif; ?>
</body>
</html>
