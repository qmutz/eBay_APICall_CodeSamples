<?php require_once('../get-common/ServiceEndpointsAndTokens.php') ?>
<?php require_once('../get-common/LargeMerchantServiceSession.php') ?>
<?php require_once('../get-common/DOMUtils.php') ?>
<?php require_once('../get-common/PrintUtils.php') ?>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title>DownloadFile</title>
</head>
<body>
<form action="DownloadFile.php" method="post">
	<p>Task Reference ID
	<input type="text" name="taskReferenceId"<?php if(!empty($_REQUEST['taskReferenceId'])) echo 'value="' . $_REQUEST['taskReferenceId'] . '"'?> /><br />
	File Reference ID
	<input type="text" name="fileReferenceId"<?php if(!empty($_REQUEST['fileReferenceId'])) echo 'value="' . $_REQUEST['fileReferenceId'] . '"'?> /><br />
	<input type="submit" name="submit" value="Download File" /></p>
</form>
<?php
$debug = "";
	
	function createDownloadRequest($taskReferenceId, $fileReferenceId)
	{
		$request  = '<downloadFileRequest xmlns:sct="http://www.ebay.com/soaframework/common/types" xmlns="http://www.ebay.com/marketplace/services">';
        $request .= '<taskReferenceId>' . $taskReferenceId . '</taskReferenceId>';
        $request .= '<fileReferenceId>' . $fileReferenceId . '</fileReferenceId>';
        $request .= '</downloadFileRequest>';
        
        return $request;
	}
	
	/**
	 * Parses for the Error Message in the MIME multipart message.
	 * @param $response MIME multipart message
	 * @return string XML Error Message Response
	 */
	function parseForErrorMessage($response)
	{
		$beginErrorMessage = strpos($response, '<?xml');
		$endErrorMessage = strpos($response, '</errorMessage>', $beginErrorMessage);
		$endErrorMessage += strlen('</errorMessage>');
		
		return substr($response, $beginErrorMessage, $endErrorMessage - $beginErrorMessage);
	}
	
	/**
	 * Parses for the XML Response in the MIME multipart message.
	 * @param string $response MIME multipart message
	 * @return string XML Response
	 */
	function parseForResponseXML($response)
	{
		$beginResponseXML = strpos($response, '<?xml');
		
		$endResponseXML = strpos($response, '</downloadFileResponse>',
			$beginResponseXML);
		
		//Assume a service level error and die.
		if($endResponseXML === FALSE) {
			$errorXML = parseForErrorMessage($response);
			PrintUtils::printXML($errorXML);
			die();
		}	
		
		$endResponseXML += strlen('</downloadFileResponse>');
		
		return substr($response, $beginResponseXML,
			$endResponseXML - $beginResponseXML);
	}
	
	/**
	 * Parses for the file bytes between the MIME boundaries.
	 * @param $uuid UUID corresponding to the Content-ID of the file bytes.
	 * @param string $response MIME multipart message
	 * @return string bytes of the file
	 */
	function parseForFileBytes($uuid, $response)
	{
		$contentId = 'Content-ID: <' . $uuid . '>';
		
		$mimeBoundaryPart = strpos($response,'--MIMEBoundaryurn_uuid_');
		
		$beginFile = strpos($response, $contentId, $mimeBoundaryPart);
		$beginFile += strlen($contentId);
		
		//Accounts for the standard 2 CRLFs.
		$beginFile += 4;
		
		$endFile = strpos($response,'--MIMEBoundaryurn_uuid_',$beginFile);
		
		//Accounts for the standard 1 CRLFs.
		$endFile -= 2;
		
		$fileBytes = substr($response, $beginFile, $endFile - $beginFile);
		
		return $fileBytes;
	}
	
	/**
	 * Parses the XML Response for the UUID to ascertain the
	 * index of the file bytes in the MIME Message.
	 * @param DomDocument $responseDOM DOM of the XML Response.
	 * @return string UUID referring to the message body
	 */
	function parseForXopIncludeUUID($responseDOM)
	{
		$xopInclude = $responseDOM->getElementsByTagName('Include')->item(0);
		$uuid = $xopInclude->getAttributeNode('href')->nodeValue;
		$uuid = substr($uuid, strpos($uuid,'urn:uuid:'));
		
		return $uuid;
	}
	
	/**
	 * Writes the response file's bytes to disk.
	 * @param string $bytes bytes comprising a file
	 * @param string $zipFilename name of the zip to be created
	 */
	function writeZipFile($bytes, $zipFilename)
	{
		echo "<p><b>Writing File to $zipFilename : ";
		
		$handler = fopen($zipFilename, 'wb') 
			or die("Failed. Cannot Open $zipFilename to Write!</b></p>");
		fwrite($handler, $bytes);
		fclose($handler);
		
		echo 'Success.</b></p>';
	}
	
	if( isset( $_POST['taskReferenceId'] ) && isset( $_POST['fileReferenceId'] ) )
	{
        $session = new LargeMerchantServiceSession('XML','XML', ENV_SANDBOX);
        
        $request = createDownloadRequest(
        	$_POST['taskReferenceId'], $_POST['fileReferenceId']);
        
		$response = $session->sendFileTransferServiceDownloadRequest($request);
		
		//$debug = $response;
		
		$responseXML = parseForResponseXML($response);
		
		$responseDOM = DOMUtils::createDOM($responseXML);
		
		PrintUtils::printDOM($responseDOM);
		
		$uuid = parseForXopIncludeUUID($responseDOM);
		
		$fileBytes = parseForFileBytes($uuid, $response);
		
		writeZipFile($fileBytes, 'DownloadFile.zip');
		
	}
?>
<hr />
<a href="./../index.php">Index</a>
<?php if (!empty($debug)) : ?>
<pre>
<?php echo htmlspecialchars($debug); ?>
</pre>
<?php endif; ?>
</body>
</html>
