
package com.ebay.marketplace.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 			Returns the job profile for a specified recurring job ID. This job profile
 * 			includes the job ID, job type, job status, creation time, completion time, error
 * 			count, percent complete, and file reference ID.
 * 		
 * 
 * <p>Java class for GetRecurringJobExecutionStatusResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetRecurringJobExecutionStatusResponse">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.ebay.com/marketplace/services}BaseServiceResponse">
 *       &lt;sequence>
 *         &lt;element name="jobProfile" type="{http://www.ebay.com/marketplace/services}JobProfile" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetRecurringJobExecutionStatusResponse", propOrder = {
    "jobProfile"
})
public class GetRecurringJobExecutionStatusResponse
    extends BaseServiceResponse
{

    protected JobProfile jobProfile;

    /**
     * Gets the value of the jobProfile property.
     * 
     * @return
     *     possible object is
     *     {@link JobProfile }
     *     
     */
    public JobProfile getJobProfile() {
        return jobProfile;
    }

    /**
     * Sets the value of the jobProfile property.
     * 
     * @param value
     *     allowed object is
     *     {@link JobProfile }
     *     
     */
    public void setJobProfile(JobProfile value) {
        this.jobProfile = value;
    }

}
