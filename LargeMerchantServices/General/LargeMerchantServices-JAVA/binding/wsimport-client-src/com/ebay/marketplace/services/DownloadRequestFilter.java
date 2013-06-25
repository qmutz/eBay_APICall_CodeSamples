
package com.ebay.marketplace.services;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlType;
import org.w3c.dom.Element;


/**
 * 
 * 			Lets you request only the data within specific parameters, such as a date range.
 * 		
 * 
 * <p>Java class for DownloadRequestFilter complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DownloadRequestFilter">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="feeSettlementReportFilter" type="{http://www.ebay.com/marketplace/services}FeeSettlementReportFilter" minOccurs="0"/>
 *         &lt;element name="getItemInfoReportFilter" type="{http://www.ebay.com/marketplace/services}GetItemInfoReportFilter" minOccurs="0"/>
 *         &lt;element name="siteFilter" type="{http://www.ebay.com/marketplace/services}SiteFilter" minOccurs="0"/>
 *         &lt;element name="activeInventoryReportFilter" type="{http://www.ebay.com/marketplace/services}ActiveInventoryReportFilter" minOccurs="0"/>
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
@XmlType(name = "DownloadRequestFilter", propOrder = {
    "feeSettlementReportFilter",
    "getItemInfoReportFilter",
    "siteFilter",
    "activeInventoryReportFilter",
    "any"
})
public class DownloadRequestFilter {

    protected FeeSettlementReportFilter feeSettlementReportFilter;
    protected GetItemInfoReportFilter getItemInfoReportFilter;
    protected SiteFilter siteFilter;
    protected ActiveInventoryReportFilter activeInventoryReportFilter;
    @XmlAnyElement(lax = true)
    protected List<Object> any;

    /**
     * Gets the value of the feeSettlementReportFilter property.
     * 
     * @return
     *     possible object is
     *     {@link FeeSettlementReportFilter }
     *     
     */
    public FeeSettlementReportFilter getFeeSettlementReportFilter() {
        return feeSettlementReportFilter;
    }

    /**
     * Sets the value of the feeSettlementReportFilter property.
     * 
     * @param value
     *     allowed object is
     *     {@link FeeSettlementReportFilter }
     *     
     */
    public void setFeeSettlementReportFilter(FeeSettlementReportFilter value) {
        this.feeSettlementReportFilter = value;
    }

    /**
     * Gets the value of the getItemInfoReportFilter property.
     * 
     * @return
     *     possible object is
     *     {@link GetItemInfoReportFilter }
     *     
     */
    public GetItemInfoReportFilter getGetItemInfoReportFilter() {
        return getItemInfoReportFilter;
    }

    /**
     * Sets the value of the getItemInfoReportFilter property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetItemInfoReportFilter }
     *     
     */
    public void setGetItemInfoReportFilter(GetItemInfoReportFilter value) {
        this.getItemInfoReportFilter = value;
    }

    /**
     * Gets the value of the siteFilter property.
     * 
     * @return
     *     possible object is
     *     {@link SiteFilter }
     *     
     */
    public SiteFilter getSiteFilter() {
        return siteFilter;
    }

    /**
     * Sets the value of the siteFilter property.
     * 
     * @param value
     *     allowed object is
     *     {@link SiteFilter }
     *     
     */
    public void setSiteFilter(SiteFilter value) {
        this.siteFilter = value;
    }

    /**
     * Gets the value of the activeInventoryReportFilter property.
     * 
     * @return
     *     possible object is
     *     {@link ActiveInventoryReportFilter }
     *     
     */
    public ActiveInventoryReportFilter getActiveInventoryReportFilter() {
        return activeInventoryReportFilter;
    }

    /**
     * Sets the value of the activeInventoryReportFilter property.
     * 
     * @param value
     *     allowed object is
     *     {@link ActiveInventoryReportFilter }
     *     
     */
    public void setActiveInventoryReportFilter(ActiveInventoryReportFilter value) {
        this.activeInventoryReportFilter = value;
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
