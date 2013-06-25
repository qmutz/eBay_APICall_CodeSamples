
package com.ebay.marketplace.services;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import org.w3c.dom.Element;


/**
 * 
 * 		This is the base class for request container for all service operations.
 * 		
 * 
 * <p>Java class for BaseServiceRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BaseServiceRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;any/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BaseServiceRequest", propOrder = {
    "any"
})
@XmlSeeAlso({
    CreateRecurringJobRequest.class,
    GetRecurringJobsRequest.class,
    AbortJobRequest.class,
    CreateUploadJobRequest.class,
    GetJobStatusRequest.class,
    ActivateRecurringJobRequest.class,
    GetRecurringJobExecutionHistoryRequest.class,
    AbortRecurringJobExecutionRequest.class,
    StartDownloadJobRequest.class,
    GetJobsRequest.class,
    GetRecurringJobExecutionStatusRequest.class,
    SuspendRecurringJobRequest.class,
    DeleteRecurringJobRequest.class,
    StartUploadJobRequest.class
})
public abstract class BaseServiceRequest {

    @XmlAnyElement(lax = true)
    protected List<Object> any;

    /**
     * Gets the value of the any property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the any property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAny().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Element }
     * {@link Object }
     * 
     * 
     */
    public List<Object> getAny() {
        if (any == null) {
            any = new ArrayList<Object>();
        }
        return this.any;
    }

}
