<?php require_once('../get-common/ServiceEndpointsAndTokens.php') ?>
<?php require_once('../get-common/LargeMerchantServiceSession.php') ?>
<?php require_once('../get-common/PrintUtils.php') ?>
<?php require_once('MultiPartMessage.php')?>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title>UploadFile</title>
</head>
<body>
  <form action="UploadFile.php" method="post">
    <p>Task Reference ID
    <input type="text" name="taskReferenceId"<?php if(!empty($_REQUEST['taskReferenceId'])) echo " value='" . $_REQUEST['taskReferenceId'] . "'"?> /><br />
    File Reference ID
    <input type="text" name="fileReferenceId"<?php if(!empty($_REQUEST['fileReferenceId'])) echo " value='" . $_REQUEST['fileReferenceId'] . "'"?> /><br />
    <input type="submit" name="submit" value="Upload File" /></p>
  </form>
<?php
$debug = "";

/**
 * Reads the GZIP'd Request file.
 * @return string bytes comprising the request file.
 */
function readRequestFile()
{
  $file = 'AddFixedPriceItemExample.gz';
  $handle = fopen($file, 'r');
  $fileData = fread( $handle, filesize($file) );
  fclose($handle);

  return $fileData;
}

function createUploadFileRequest($taskReferenceId, $fileReferenceId, $fileSize)
{
  $request  = '<uploadFileRequest xmlns:sct="http://www.ebay.com/soaframework/common/types" xmlns="http://www.ebay.com/marketplace/services">';
  $request .= '<taskReferenceId>' . $taskReferenceId . '</taskReferenceId>';
  $request .= '<fileReferenceId>' . $fileReferenceId . '</fileReferenceId>';
  $request .= '<fileFormat>gzip</fileFormat>';
  $request .= '<fileAttachment>';
  $request .= '<Size>' . $fileSize . '</Size>';
  $request .= '<Data><xop:Include xmlns:xop="http://www.w3.org/2004/08/xop/include" href="cid:'
  . MultiPartMessage::$URN_UUID_ATTACHMENT . '" /></Data>';
  $request .= '</fileAttachment>';
  $request .= '</uploadFileRequest>';

  return $request;
}

if( isset( $_POST['taskReferenceId'] ) && isset( $_POST['fileReferenceId'] ) )
{
  $taskReferenceId = $_POST['taskReferenceId'];
  $fileReferenceId = $_POST['fileReferenceId'];
  $file = readRequestFile();

  $session = new LargeMerchantServiceSession(
        	'XML','XML', ENV_SANDBOX);

  $requestBody = createUploadFileRequest($taskReferenceId,
  $fileReferenceId, strlen($file) );

  $request = MultiPartMessage::build($requestBody,$file);

  $responseXML = $session->sendFileTransferServiceUploadRequest($request);
  $xml = simplexml_load_string($responseXML);
  if(!empty($xml) && 'Success' == (string)$xml->ack)
  {
    $id_array = array("JobID"=>$taskReferenceId,
                      "UploadID"=>$fileReferenceId);
  }

  PrintUtils::printXML($responseXML);
}
?>
<hr />
<a href="./../index.php">Index</a>
<?php if (!empty($id_array['JobID']) && !empty($id_array['UploadID'])) :?>
<a href="./../StartUploadJob/StartUploadJob.php?jobId=<?php echo $id_array['JobID'] ;?>" >StartUploadJob</a>
<?php endif; ?>
<?php if(!empty($debug)) :?>
<pre>
<?php echo htmlentities($debug); ?>
</pre>
<?php endif;?>
</body>
</html>
