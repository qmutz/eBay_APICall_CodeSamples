
package com.ebay.marketplace.services;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 			Returns the recurring job ID, creation time, frequency, job type, and job status
 * 			for each recurring job created by the seller making this call.
 * 		
 * 
 * <p>Java class for GetRecurringJobsResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetRecurringJobsResponse">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.ebay.com/marketplace/services}BaseServiceResponse">
 *       &lt;sequence>
 *         &lt;element name="recurringJobDetail" type="{http://www.ebay.com/marketplace/services}RecurringJobDetail" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetRecurringJobsResponse", propOrder = {
    "recurringJobDetail"
})
public class GetRecurringJobsResponse
    extends BaseServiceResponse
{

    protected List<RecurringJobDetail> recurringJobDetail;

    /**
     * Gets the value of the recurringJobDetail property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the recurringJobDetail property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRecurringJobDetail().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RecurringJobDetail }
     * 
     * 
     */
    public List<RecurringJobDetail> getRecurringJobDetail() {
        if (recurringJobDetail == null) {
            recurringJobDetail = new ArrayList<RecurringJobDetail>();
        }
        return this.recurringJobDetail;
    }

}
