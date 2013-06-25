<?php require_once('../get-common/ServiceEndpointsAndTokens.php') ?>
<?php require_once('../get-common/LargeMerchantServiceSession.php') ?>
<?php require_once('../get-common/PrintUtils.php') ?>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title>StartUploadJob</title>
</head>
<body>
  <form action="StartUploadJob.php" method="post">
    <p>Job ID
    <input type="text" name="jobId"<?php if(!empty($_REQUEST['jobId'])) echo " value='" . $_REQUEST['jobId'] . "'"?> /><br />
    <input type="submit" name="submit" value="Start Upload Job" /></p>
  </form>
<?php

function createStartUploadJobRequest($jobId)
{
  $request  = '<startUploadJobRequest xmlns:sct="http://www.ebay.com/soaframework/common/types" xmlns="http://www.ebay.com/marketplace/services">';
  $request .= '<jobId>' . $jobId . '</jobId>';
  $request .= '</startUploadJobRequest>';

  return $request;
}

if( isset( $_POST['jobId'] ) )
{
  $session = new LargeMerchantServiceSession('XML','XML', ENV_SANDBOX);

  $request = createStartUploadJobRequest( $_POST['jobId'] );

  $response = $session->sendBulkDataExchangeRequest(
			'startUploadJob', $request);

  $xml = simplexml_load_string($response);
  if(!empty($xml) && 'Success' == (string)$xml->ack)
  {
    $id_array = array("JobID"=>$_POST['jobId']);
  }
  PrintUtils::printXML($response);
}
?>
<hr />
<a href="./../index.php">Index</a>
<?php if (!empty($id_array['JobID'])) :?>
<a href="./../GetJobStatus/GetJobStatus.php?jobId=<?php echo $id_array['JobID'] ;?>">GetJobStatus</a>
<?php endif; ?>
</body>
</html>
