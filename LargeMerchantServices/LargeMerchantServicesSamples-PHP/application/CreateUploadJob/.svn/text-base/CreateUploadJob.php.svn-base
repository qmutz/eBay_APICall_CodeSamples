<?php require_once('../get-common/ServiceEndpointsAndTokens.php') ?>
<?php require_once('../get-common/LargeMerchantServiceSession.php') ?>
<?php require_once('../get-common/PrintUtils.php') ?>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title>CreateUploadJob</title>
</head>
<body>
  <form action="CreateUploadJob.php" method="post">
    <p>Job Type
    <input type="text" name="jobType" value="AddFixedPriceItem" /><br />
    UUID
    <input type="text" name="uuid" value="<?php echo uniqid('', true)?>" /><br />
    <input type="submit" name="submit" value="Create Upload Job" /></p>
  </form>
<?php
$debug = "";
function createUploadJobRequest($jobType, $uuid)
{
  global $debug;
  $request  = '<createUploadJobRequest xmlns:sct="http://www.ebay.com/soaframework/common/types" xmlns="http://www.ebay.com/marketplace/services">';
  $request .= '<uploadJobType>' . $jobType . '</uploadJobType>';
  $request .= '<UUID>' . $uuid . '</UUID>';
  $request .= '</createUploadJobRequest>';

  return $request;
}

if( isset( $_POST['jobType'] ) && isset( $_POST['uuid'] ) )
{
  $session = new LargeMerchantServiceSession('XML','XML', ENV_SANDBOX);

  $request = createUploadJobRequest($_POST['jobType'], $_POST['uuid']);

  $response = $session->sendBulkDataExchangeRequest(
			'createUploadJob', $request);

  $xml = simplexml_load_string($response);
  if(!empty($xml) && 'Success' == (string)$xml->ack)
  {
    $id_array = array("JobID"=>(string)$xml->jobId,
		                  "UploadID"=>(string)$xml->fileReferenceId);
  }
  PrintUtils::printXML($response);
}
?>
<hr />
<a href="./../index.php">Index</a>
<?php if (!empty($id_array['JobID']) && !empty($id_array['UploadID'])) :?>
<a href="./../UploadFile/UploadFile.php?taskReferenceId=<?php echo $id_array['JobID'] ;?>&fileReferenceId=<?php echo $id_array['UploadID']; ?>" >UploadFile</a>
<?php endif; ?>
<?php if (!empty($debug)) :?>
<pre>
<?php echo htmlentities($debug); ?>
</pre>
<?php endif; ?>
</body>
</html>
