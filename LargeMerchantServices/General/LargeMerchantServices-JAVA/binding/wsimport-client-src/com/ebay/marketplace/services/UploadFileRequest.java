
package com.ebay.marketplace.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * 
 * 			Transfers a data file to one of eBay's servers. After your
 * 			application makes this call, it needs to make the Bulk Data Exchange
 * 			'StartUploadJob' call so the data can be processed.
 * 		
 * 
 * <p>Java class for UploadFileRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UploadFileRequest">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.ebay.com/marketplace/services}BaseServiceRequest">
 *       &lt;sequence>
 *         &lt;element name="taskReferenceId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="fileReferenceId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="fileFormat" type="{http://www.w3.org/2001/XMLSchema}token"/>
 *         &lt;element name="fileAttachment" type="{http://www.ebay.com/marketplace/services}FileAttachment"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UploadFileRequest", propOrder = {
    "taskReferenceId",
    "fileReferenceId",
    "fileFormat",
    "fileAttachment"
})
public class UploadFileRequest
    extends BaseServiceRequest
{

    @XmlElement(required = true)
    protected String taskReferenceId;
    @XmlElement(required = true)
    protected String fileReferenceId;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String fileFormat;
    @XmlElement(required = true)
    protected FileAttachment fileAttachment;

    /**
     * Gets the value of the taskReferenceId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTaskReferenceId() {
        return taskReferenceId;
    }

    /**
     * Sets the value of the taskReferenceId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTaskReferenceId(String value) {
        this.taskReferenceId = value;
    }

    /**
     * Gets the value of the fileReferenceId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFileReferenceId() {
        return fileReferenceId;
    }

    /**
     * Sets the value of the fileReferenceId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFileReferenceId(String value) {
        this.fileReferenceId = value;
    }

    /**
     * Gets the value of the fileFormat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFileFormat() {
        return fileFormat;
    }

    /**
     * Sets the value of the fileFormat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFileFormat(String value) {
        this.fileFormat = value;
    }

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
