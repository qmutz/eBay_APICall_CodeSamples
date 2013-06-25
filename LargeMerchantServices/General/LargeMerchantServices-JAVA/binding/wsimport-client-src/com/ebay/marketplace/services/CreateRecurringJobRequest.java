
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
 * 			Creates a recurring Bulk Data Exchange job and assigns it a <b 
 * 			class="con">recurringJobId</b>.
 * 			When you create a recurring job, you must specify a recurrence interval, such
 * 			as daily, weekly, monthly, or a frequency in minutes.
 * 			<br><br>
 * 			Once a recurring job has been created, a separate job ID is created for each
 * 			job that is created/executed. For example, if a job runs every hour, it will
 * 			have a single <b class="con">recurringJobId</b> and each hourly job 
 * 			will have a unique <b class="con">jobId</b> and <b 
 * 			class="con">fileReferenceI</b>d.
 * 		
 * 
 * <p>Java class for CreateRecurringJobRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CreateRecurringJobRequest">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.ebay.com/marketplace/services}BaseServiceRequest">
 *       &lt;sequence>
 *         &lt;element name="UUID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="frequencyInMinutes" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="downloadJobType" type="{http://www.w3.org/2001/XMLSchema}token"/>
 *         &lt;element name="monthlyRecurrence" type="{http://www.ebay.com/marketplace/services}MonthlyRecurrence" minOccurs="0"/>
 *         &lt;element name="weeklyRecurrence" type="{http://www.ebay.com/marketplace/services}WeeklyRecurrence" minOccurs="0"/>
 *         &lt;element name="dailyRecurrence" type="{http://www.ebay.com/marketplace/services}DailyRecurrence" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreateRecurringJobRequest", propOrder = {
    "uuid",
    "frequencyInMinutes",
    "downloadJobType",
    "monthlyRecurrence",
    "weeklyRecurrence",
    "dailyRecurrence"
})
public class CreateRecurringJobRequest
    extends BaseServiceRequest
{

    @XmlElement(name = "UUID", required = true)
    protected String uuid;
    protected Integer frequencyInMinutes;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String downloadJobType;
    protected MonthlyRecurrence monthlyRecurrence;
    protected WeeklyRecurrence weeklyRecurrence;
    protected DailyRecurrence dailyRecurrence;

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
     * Gets the value of the frequencyInMinutes property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getFrequencyInMinutes() {
        return frequencyInMinutes;
    }

    /**
     * Sets the value of the frequencyInMinutes property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setFrequencyInMinutes(Integer value) {
        this.frequencyInMinutes = value;
    }

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
     * Gets the value of the monthlyRecurrence property.
     * 
     * @return
     *     possible object is
     *     {@link MonthlyRecurrence }
     *     
     */
    public MonthlyRecurrence getMonthlyRecurrence() {
        return monthlyRecurrence;
    }

    /**
     * Sets the value of the monthlyRecurrence property.
     * 
     * @param value
     *     allowed object is
     *     {@link MonthlyRecurrence }
     *     
     */
    public void setMonthlyRecurrence(MonthlyRecurrence value) {
        this.monthlyRecurrence = value;
    }

    /**
     * Gets the value of the weeklyRecurrence property.
     * 
     * @return
     *     possible object is
     *     {@link WeeklyRecurrence }
     *     
     */
    public WeeklyRecurrence getWeeklyRecurrence() {
        return weeklyRecurrence;
    }

    /**
     * Sets the value of the weeklyRecurrence property.
     * 
     * @param value
     *     allowed object is
     *     {@link WeeklyRecurrence }
     *     
     */
    public void setWeeklyRecurrence(WeeklyRecurrence value) {
        this.weeklyRecurrence = value;
    }

    /**
     * Gets the value of the dailyRecurrence property.
     * 
     * @return
     *     possible object is
     *     {@link DailyRecurrence }
     *     
     */
    public DailyRecurrence getDailyRecurrence() {
        return dailyRecurrence;
    }

    /**
     * Sets the value of the dailyRecurrence property.
     * 
     * @param value
     *     allowed object is
     *     {@link DailyRecurrence }
     *     
     */
    public void setDailyRecurrence(DailyRecurrence value) {
        this.dailyRecurrence = value;
    }

}
