
package com.ebay.marketplace.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 			Suspends the next instance of a recurring job. The recurring job will resume with
 * 			subsequent job instances. Use <b 
 * 			class="con">getRecurringJobExecutionHistory</b> and <b 
 * 			class="con">getRecurringJobExecutionStatus</b> to identify any reporting 
 * 			gaps. 
 * 		
 * 
 * <p>Java class for AbortRecurringJobExecutionRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AbortRecurringJobExecutionRequest">
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
@XmlType(name = "AbortRecurringJobExecutionRequest", propOrder = {
    "recurringJobId"
})
public class AbortRecurringJobExecutionRequest
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
