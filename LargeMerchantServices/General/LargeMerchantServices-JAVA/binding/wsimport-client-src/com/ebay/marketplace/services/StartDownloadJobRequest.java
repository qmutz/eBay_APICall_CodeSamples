
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
 * 		Begins processing the data for a report file to download. You must use the getJobStatus or
 * 		getRecurringJobExecutionStatus calls to determine when the report data is available for download.
 * 		
 * 
 * <p>Java class for StartDownloadJobRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StartDownloadJobRequest">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.ebay.com/marketplace/services}BaseServiceRequest">
 *       &lt;sequence>
 *         &lt;element name="downloadJobType" type="{http://www.w3.org/2001/XMLSchema}token"/>
 *         &lt;element name="UUID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="downloadRequestFilter" type="{http://www.ebay.com/marketplace/services}DownloadRequestFilter" minOccurs="0"/>
 *         &lt;element name="recurringJob" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StartDownloadJobRequest", propOrder = {
    "downloadJobType",
    "uuid",
    "downloadRequestFilter",
    "recurringJob"
})
public class StartDownloadJobRequest
    extends BaseServiceRequest
{

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String downloadJobType;
    @XmlElement(name = "UUID", required = true)
    protected String uuid;
    protected DownloadRequestFilter downloadRequestFilter;
    protected Boolean recurringJob;

    /**
     * Gets the value of the downloadJobType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDownloadJobType() {
        return downloadJobType;
    }

    /**
     * Sets the value of the downloadJobType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDownloadJobType(String value) {
        this.downloadJobType = value;
    }

    /**
     * Gets the value of the uuid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUUID() {
        return uuid;
    }

    /**
     * Sets the value of the uuid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUUID(String value) {
        this.uuid = value;
    }

    /**
     * Gets the value of the downloadRequestFilter property.
     * 
     * @return
     *     possible object is
     *     {@link DownloadRequestFilter }
     *     
     */
    public DownloadRequestFilter getDownloadRequestFilter() {
        return downloadRequestFilter;
    }

    /**
     * Sets the value of the downloadRequestFilter property.
     * 
     * @param value
     *     allowed object is
     *     {@link DownloadRequestFilter }
     *     
     */
    public void setDownloadRequestFilter(DownloadRequestFilter value) {
        this.downloadRequestFilter = value;
    }

    /**
     * Gets the value of the recurringJob property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isRecurringJob() {
        return recurringJob;
    }

    /**
     * Sets the value of the recurringJob property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRecurringJob(Boolean value) {
        this.recurringJob = value;
    }

}
