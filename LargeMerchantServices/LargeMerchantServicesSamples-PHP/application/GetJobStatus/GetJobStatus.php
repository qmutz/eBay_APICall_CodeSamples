<?php require_once('../get-common/ServiceEndpointsAndTokens.php') ?>
<?php require_once('../get-common/LargeMerchantServiceSession.php') ?>
<?php require_once('../get-common/PrintUtils.php') ?>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title>GetJobStatus</title>
</head>
<body>
  <form action="GetJobStatus.php" method="post">
    <p>Job ID
    <input type="text" name="jobId"<?php if (!empty($_REQUEST['jobId'])) echo 'value="' . $_REQUEST['jobId'] . '" '?> /><br />
    <input type="submit" name="submit" value="Get Job Status" /></p>
  </form>
<?php

function createGetJobStatusRequest($jobId)
{
  $request  = '<getJobStatusRequest xmlns:sct="http://www.ebay.com/soaframework/common/types" xmlns="http://www.ebay.com/marketplace/services">';
  $request .= '<jobId>' . $jobId . '</jobId>';
  $request .= '</getJobStatusRequest>';

  return $request;
}

if( isset( $_POST['jobId'] ) )
{
  $session = new LargeMerchantServiceSession('XML','XML', ENV_SANDBOX);

  $request = createGetJobStatusRequest( $_POST['jobId'] );

  $response = $session->sendBulkDataExchangeRequest(
			'getJobStatus', $request);

  $xml = simplexml_load_string($response);
  if(!empty($xml) && 'Success' == (string)$xml->ack)
  {
    $id_array = array("JobID"=>(string)$xml->jobProfile->jobId,
	                      "UploadID"=>(string)$xml->jobProfile->inputFileReferenceId,
                        "DownloadID"=>(string)$xml->jobProfile->fileReferenceId);
  }
  PrintUtils::printXML($response);
}
?>
<hr />
<a href="./../index.php">Index</a>
<?php if (!empty($id_array['JobID'])) :?>
<a href="./../AbortJob/AbortJob.php?jobId=<?php echo $id_array['JobID'] ;?>">AbortJob</a>
<?php if (!empty($id_array['DownloadID'])) :?>
<a href="./../DownloadFile/DownloadFile.php?taskReferenceId=<?php echo $id_array['JobID'] ;?>&fileReferenceId=<?php echo $id_array['DownloadID']; ?>">DownloadFile</a>
<?php endif; ?>
<?php endif; ?>
</body>
</html>
