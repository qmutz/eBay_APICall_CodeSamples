<?php require_once('../get-common/ServiceEndpointsAndTokens.php') ?>
<?php require_once('../get-common/LargeMerchantServiceSession.php') ?>
<?php require_once('../get-common/PrintUtils.php') ?>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title>GetJobs</title>
</head>
<body>
<form action="GetJobs.php" method="post">
	<input type="hidden" name="complete" value="complete"></input>
	<p><input type="submit" name="submit" value="Get Jobs" /></p>
</form>
<?php
	
	function createGetJobsRequest()
	{
		$request  = '<getJobsRequest xmlns:sct="http://www.ebay.com/soaframework/common/types" xmlns="http://www.ebay.com/marketplace/services" />';
        
        return $request;
	}

	if( isset( $_POST['complete'] ) )
	{   
        $session = new LargeMerchantServiceSession('XML','XML', ENV_SANDBOX);
        
        $request = createGetJobsRequest();
		
		$response = $session->sendBulkDataExchangeRequest(
			'getJobs', $request);
		
		PrintUtils::printXML($response);
	}
?>
<hr />
<a href="./../index.php">Index</a>
</body>
</html>