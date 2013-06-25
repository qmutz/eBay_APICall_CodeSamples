<?php require_once('AbstractEbayServiceRequest.php') ?>
<?php

/**
 * Implementation for the File Transfer Service Download Request.
 */
class FileTransferServiceDownloadRequest extends AbstractEbayServiceRequest
{
	
	public function __construct($dataFormat, $responseDataFormat, $securityToken,
		$operationName, $endpoint)
	{
		parent::__construct($dataFormat, $responseDataFormat, $securityToken,
			$operationName, $endpoint);
	}
	
	protected function getHeaders()
	{
		$headers = parent::getHeadersBaseline();
		
		$contentType = 'text/xml';
		
		array_push($headers, 'Content-Type: ' . $contentType)	;
		array_push($headers, 'X-EBAY-SOA-SERVICE-NAME: FileTransferService');
		
		return $headers;
	}
	
	protected function setAdditionalOptions($connection)
	{
		//No additional options necessary.
	}
	
}

?>