
package com.ebay.marketplace.services;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;
import org.w3c.dom.Element;


/**
 * 
 * 			Reserved for future use.
 * 		
 * 
 * <p>Java class for GetItemInfoReportFilter complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetItemInfoReportFilter">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="jobAction" type="{http://www.ebay.com/marketplace/services}GetItemJobActionType"/>
 *         &lt;element name="filterType" type="{http://www.ebay.com/marketplace/services}ItemEventType"/>
 *         &lt;element name="includeAttributes" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="includeDescription" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="reportDateFrom" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="reportDateTo" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="timeFrame" type="{http://www.w3.org/2001/XMLSchema}token" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="changedFieldSelector" type="{http://www.w3.org/2001/XMLSchema}token" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType(name = "GetItemInfoReportFilter", propOrder = {
    "jobAction",
    "filterType",
    "includeAttributes",
    "includeDescription",
    "reportDateFrom",
    "reportDateTo",
    "timeFrame",
    "changedFieldSelector",
    "any"
})
public class GetItemInfoReportFilter {

    @XmlElement(required = true)
    protected GetItemJobActionType jobAction;
    @XmlElement(required = true)
    protected ItemEventType filterType;
    protected Boolean includeAttributes;
    protected Boolean includeDescription;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar reportDateFrom;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar reportDateTo;
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected List<String> timeFrame;
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected List<String> changedFieldSelector;
    @XmlAnyElement(lax = true)
    protected List<Object> any;

    /**
     * Gets the value of the jobAction property.
     * 
     * @return
     *     possible object is
     *     {@link GetItemJobActionType }
     *     
     */
    public GetItemJobActionType getJobAction() {
        return jobAction;
    }

    /**
     * Sets the value of the jobAction property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetItemJobActionType }
     *     
     */
    public void setJobAction(GetItemJobActionType value) {
        this.jobAction = value;
    }

    /**
     * Gets the value of the filterType property.
     * 
     * @return
     *     possible object is
     *     {@link ItemEventType }
     *     
     */
    public ItemEventType getFilterType() {
        return filterType;
    }

    /**
     * Sets the value of the filterType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ItemEventType }
     *     
     */
    public void setFilterType(ItemEventType value) {
        this.filterType = value;
    }

    /**
     * Gets the value of the includeAttributes property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncludeAttributes() {
        return includeAttributes;
    }

    /**
     * Sets the value of the includeAttributes property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeAttributes(Boolean value) {
        this.includeAttributes = value;
    }

    /**
     * Gets the value of the includeDescription property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncludeDescription() {
        return includeDescription;
    }

    /**
     * Sets the value of the includeDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeDescription(Boolean value) {
        this.includeDescription = value;
    }

    /**
     * Gets the value of the reportDateFrom property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getReportDateFrom() {
        return reportDateFrom;
    }

    /**
     * Sets the value of the reportDateFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setReportDateFrom(XMLGregorianCalendar value) {
        this.reportDateFrom = value;
    }

    /**
     * Gets the value of the reportDateTo property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getReportDateTo() {
        return reportDateTo;
    }

    /**
     * Sets the value of the reportDateTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setReportDateTo(XMLGregorianCalendar value) {
        this.reportDateTo = value;
    }

    /**
     * Gets the value of the timeFrame property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the timeFrame property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTimeFrame().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getTimeFrame() {
        if (timeFrame == null) {
            timeFrame = new ArrayList<String>();
        }
        return this.timeFrame;
    }

    /**
     * Gets the value of the changedFieldSelector property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the changedFieldSelector property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getChangedFieldSelector().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getChangedFieldSelector() {
        if (changedFieldSelector == null) {
            changedFieldSelector = new ArrayList<String>();
        }
        return this.changedFieldSelector;
    }

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
