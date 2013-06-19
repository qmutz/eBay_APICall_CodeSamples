<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title>Large Merchant Services Samples</title>
</head>
<body>
<h1>Large Merchant Services Samples</h1>
<h2>Index</h2>
<?php 

	$operations = array(
		'CreateUploadJob', 'StartUploadJob',
		'StartDownloadJob', 
		'GetJobStatus', 'GetJobs', 'AbortJob', 
		'DownloadFile', 'UploadFile');

	foreach($operations as $op) {
		echo "<a href=\"./$op/$op.php\">$op</a><br />\n";
	}

?>
</body>
</html>