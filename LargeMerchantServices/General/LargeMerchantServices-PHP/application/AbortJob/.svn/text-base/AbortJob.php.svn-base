<?php require_once('../get-common/ServiceEndpointsAndTokens.php') ?>
<?php require_once('../get-common/LargeMerchantServiceSession.php') ?>
<?php require_once('../get-common/PrintUtils.php') ?>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title>AbortJob</title>
</head>
<body>
  <form action="AbortJob.php" method="post">
    <p>Job ID
    <input type="text" name="jobId"<?php if (!empty($_REQUEST['jobId'])) echo 'value="' . $_REQUEST['jobId'] . '" '?> /><br />
    <input type="submit" name="submit" value="Abort Job" /></p>
  </form>
<?php

function createAbortJobRequest($jobId)
{
  $request  = '<abortJobRequest xmlns:sct="http://www.ebay.com/soaframework/common/types" xmlns="http://www.ebay.com/marketplace/services">';
  $request .= '<jobId>' . $jobId . '</jobId>';
  $request .= '</abortJobRequest>';

  return $request;
}

if( isset( $_POST['jobId'] ) )
{
  $session = new LargeMerchantServiceSession('XML','XML', ENV_SANDBOX);

  $request = createAbortJobRequest( $_POST['jobId'] );

  $response = $session->sendBulkDataExchangeRequest(
			'abortJob', $request);

  PrintUtils::printXML($response);
}
?>
<hr />
<a href="./../index.php">Index</a>
</body>
</html>
