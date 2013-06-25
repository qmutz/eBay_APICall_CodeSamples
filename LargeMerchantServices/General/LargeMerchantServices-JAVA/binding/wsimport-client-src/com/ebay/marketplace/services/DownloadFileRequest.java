
package com.ebay.marketplace.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 			Downloads a file (typically a report) from eBay.
 * 			</p>
 * 			<h3>Using downloadFile with the Bulk Data Exchange API</h3>
 * 			<p>If you are using Large Merchant Services, the most
 * 			common uses of this call are to download responses to large-volume
 * 			requests and to download reports.</p>
 * 			<p>After you have uploaded a data file that includes requests
 * 			(such as multiple AddFixedPriceItem requests),
 * 			you need to use the BDX getStatus call to determine when a response
 * 			file is ready to download. After the BDX upload processing is complete,
 * 			you call downloadFile to retrieve the response.
 * 			<br><br>
 * 			To get a report, you begin by using the Bulk Data Exchange API's
 * 			startDownloadJob call, and then use startDownloadJob to start the
 * 			report processing.
 * 			<br><br>
 * 			The Bulk Data Exchange API assigns a jobId for your report and
 * 			you need to use the BDX getStatus call to determine when the report is ready to download.
 * 			After the BDX download processing is complete, your application can call
 * 			downloadFile to download the report.</p>
 * 			<h3>Using downloadFile for Custom Item Specifics</h3>
 * 			<p>You can also use downloadFile to download recommendations
 * 			for custom Item Specifics. This is a very large data set that
 * 			can't be retrieved through a more traditional synchronous call. <br>
 * 			<br>
 * 			You do not use the Bulk Data Exchange API at all for this use case.
 * 			(You also do not use uploadFile.)
 * 			Instead, you call GetCategorySpecifics in the Trading API to obtain
 * 		  the necessary file and task reference IDs, and then pass them in
 * 		  the downloadFile call to retrieve the recommendations file.
 * 		  See
 * 		  <a href="http://developer.ebay.com/DevZone/XML/docs/Reference/eBay/GetCategorySpecifics.html#downloadFile">GetCategorySpecifics</a>
 * 		  for details.</p>
 * 		
 * 
 * <p>Java class for DownloadFileRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DownloadFileRequest">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.ebay.com/marketplace/services}BaseServiceRequest">
 *       &lt;sequence>
 *         &lt;element name="taskReferenceId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="fileReferenceId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DownloadFileRequest", propOrder = {
    "taskReferenceId",
    "fileReferenceId"
})
public class DownloadFileRequest
    extends BaseServiceRequest
{

    @XmlElement(required = true)
    protected String taskReferenceId;
    @XmlElement(required = true)
    protected String fileReferenceId;

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

}
