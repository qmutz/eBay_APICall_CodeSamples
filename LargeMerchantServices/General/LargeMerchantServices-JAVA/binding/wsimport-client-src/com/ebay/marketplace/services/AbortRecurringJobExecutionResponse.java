
package com.ebay.marketplace.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 			Returns Success or Failure to indicate whether the next instance of a Recurring
 * 			Job has been deleted. f so, the Recurring Job schedule remains active. If you want
 * 			to remove the recurringJob completely, use DeleteRecurringJob. Use
 * 			getRecurringJobExecutionStatus to see the last completed instance of a
 * 			recurring job.
 * 		
 * 
 * <p>Java class for AbortRecurringJobExecutionResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AbortRecurringJobExecutionResponse">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.ebay.com/marketplace/services}BaseServiceResponse">
 *       &lt;sequence>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AbortRecurringJobExecutionResponse")
public class AbortRecurringJobExecutionResponse
    extends BaseServiceResponse
{


}
