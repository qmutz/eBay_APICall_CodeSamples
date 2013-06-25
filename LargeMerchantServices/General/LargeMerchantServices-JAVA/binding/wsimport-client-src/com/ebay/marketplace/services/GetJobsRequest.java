
package com.ebay.marketplace.services;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * 
 * 			Lists all jobs that have been submitted with this Seller ID that have the job type
 * 			specified in the request. You can enter a request with no job type field to see the
 * 			status of all of your jobs, you can put a few job type fields in your request to
 * 			see the status for specific job types, or you can put a single job type field in
 * 			your request.
 * 		
 * 
 * <p>Java class for GetJobsRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetJobsRequest">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.ebay.com/marketplace/services}BaseServiceRequest">
 *       &lt;sequence>
 *         &lt;element name="creationTimeFrom" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="creationTimeTo" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="jobType" type="{http://www.w3.org/2001/XMLSchema}token" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="jobStatus" type="{http://www.ebay.com/marketplace/services}JobStatus" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetJobsRequest", propOrder = {
    "creationTimeFrom",
    "creationTimeTo",
    "jobType",
    "jobStatus"
})
public class GetJobsRequest
    extends BaseServiceRequest
{

    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar creationTimeFrom;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar creationTimeTo;
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected List<String> jobType;
    protected List<JobStatus> jobStatus;

    /**
     * Gets the value of the creationTimeFrom property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreationTimeFrom() {
        return creationTimeFrom;
    }

    /**
     * Sets the value of the creationTimeFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreationTimeFrom(XMLGregorianCalendar value) {
        this.creationTimeFrom = value;
    }

    /**
     * Gets the value of the creationTimeTo property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreationTimeTo() {
        return creationTimeTo;
    }

    /**
     * Sets the value of the creationTimeTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreationTimeTo(XMLGregorianCalendar value) {
        this.creationTimeTo = value;
    }

    /**
     * Gets the value of the jobType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the jobType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getJobType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getJobType() {
        if (jobType == null) {
            jobType = new ArrayList<String>();
        }
        return this.jobType;
    }

    /**
     * Gets the value of the jobStatus property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the jobStatus property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getJobStatus().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JobStatus }
     * 
     * 
     */
    public List<JobStatus> getJobStatus() {
        if (jobStatus == null) {
            jobStatus = new ArrayList<JobStatus>();
        }
        return this.jobStatus;
    }

}
