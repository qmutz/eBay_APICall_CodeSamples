
package com.ebay.marketplace.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 			Deletes the recurring job. If you only want to delete a single instance of the
 * 			recurring job, use <b class="con">abortRecurringJob</b>. If you only 
 * 			want to stop the recurring job, but plan to start it again later, use <b 
 * 			class="con">suspendRecurringJob</b>.
 * 		
 * 
 * <p>Java class for DeleteRecurringJobRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DeleteRecurringJobRequest">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.ebay.com/marketplace/services}BaseServiceRequest">
 *       &lt;sequence>
 *         &lt;element name="recurringJobId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DeleteRecurringJobRequest", propOrder = {
    "recurringJobId"
})
public class DeleteRecurringJobRequest
    extends BaseServiceRequest
{

    @XmlElement(required = true)
    protected String recurringJobId;

    /**
     * Gets the value of the recurringJobId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecurringJobId() {
        return recurringJobId;
    }

    /**
     * Sets the value of the recurringJobId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecurringJobId(String value) {
        this.recurringJobId = value;
    }

}
