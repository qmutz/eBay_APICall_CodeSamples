
package com.ebay.marketplace.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 		Indicates the success or failure of transferring the report information to the seller's application.
 * 		
 * 
 * <p>Java class for DownloadFileResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DownloadFileResponse">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.ebay.com/marketplace/services}BaseServiceResponse">
 *       &lt;sequence>
 *         &lt;element name="fileAttachment" type="{http://www.ebay.com/marketplace/services}FileAttachment" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DownloadFileResponse", propOrder = {
    "fileAttachment"
})
public class DownloadFileResponse
    extends BaseServiceResponse
{

    protected FileAttachment fileAttachment;

    /**
     * Gets the value of the fileAttachment property.
     * 
     * @return
     *     possible object is
     *     {@link FileAttachment }
     *     
     */
    public FileAttachment getFileAttachment() {
        return fileAttachment;
    }

    /**
     * Sets the value of the fileAttachment property.
     * 
     * @param value
     *     allowed object is
     *     {@link FileAttachment }
     *     
     */
    public void setFileAttachment(FileAttachment value) {
        this.fileAttachment = value;
    }

}
