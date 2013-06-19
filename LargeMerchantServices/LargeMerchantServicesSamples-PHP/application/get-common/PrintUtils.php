<?php require_once('DOMUtils.php') ?>
<?php
class PrintUtils
{
	/**
	 * Pretty prints the provided XML.
	 * @param string $xml XML Blob
	 */
	public static function printXML($xml)
	{	
		$dom = DOMUtils::createDOM($xml);
		self::printDOM($dom);
	}
	
	/**
	 * Pretty prints the provided DOM.
	 * @param DomDocument $dom DOM representation of the XML
	 */
	public static function printDOM($dom)
	{
		echo '<p><pre>' . htmlspecialchars( $dom->saveXML() ) . '</pre></p>';
	}
}

?>