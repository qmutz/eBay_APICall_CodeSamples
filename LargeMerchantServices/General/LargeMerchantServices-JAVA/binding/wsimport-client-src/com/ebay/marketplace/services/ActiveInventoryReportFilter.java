
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
 * 			Specify in this filter what exactly needs to be included in the active inventory report.
 * 		
 * 
 * <p>Java class for ActiveInventoryReportFilter complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ActiveInventoryReportFilter">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="includeListingType" type="{http://www.ebay.com/marketplace/services}IncludeListingType" minOccurs="0"/>
 *         &lt;element name="fixedPriceItemDetails" type="{http://www.ebay.com/marketplace/services}FixedPriceItemDetails" minOccurs="0"/>
 *         &lt;element name="auctionItemDetails" type="{http://www.ebay.com/marketplace/services}AuctionItemDetails" minOccurs="0"/>
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
@XmlType(name = "ActiveInventoryReportFilter", propOrder = {
    "includeListingType",
    "fixedPriceItemDetails",
    "auctionItemDetails",
    "any"
})
public class ActiveInventoryReportFilter {

    protected IncludeListingType includeListingType;
    protected FixedPriceItemDetails fixedPriceItemDetails;
    protected AuctionItemDetails auctionItemDetails;
    @XmlAnyElement(lax = true)
    protected List<Object> any;

    /**
     * Gets the value of the includeListingType property.
     * 
     * @return
     *     possible object is
     *     {@link IncludeListingType }
     *     
     */
    public IncludeListingType getIncludeListingType() {
        return includeListingType;
    }

    /**
     * Sets the value of the includeListingType property.
     * 
     * @param value
     *     allowed object is
     *     {@link IncludeListingType }
     *     
     */
    public void setIncludeListingType(IncludeListingType value) {
        this.includeListingType = value;
    }

    /**
     * Gets the value of the fixedPriceItemDetails property.
     * 
     * @return
     *     possible object is
     *     {@link FixedPriceItemDetails }
     *     
     */
    public FixedPriceItemDetails getFixedPriceItemDetails() {
        return fixedPriceItemDetails;
    }

    /**
     * Sets the value of the fixedPriceItemDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link FixedPriceItemDetails }
     *     
     */
    public void setFixedPriceItemDetails(FixedPriceItemDetails value) {
        this.fixedPriceItemDetails = value;
    }

    /**
     * Gets the value of the auctionItemDetails property.
     * 
     * @return
     *     possible object is
     *     {@link AuctionItemDetails }
     *     
     */
    public AuctionItemDetails getAuctionItemDetails() {
        return auctionItemDetails;
    }

    /**
     * Sets the value of the auctionItemDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link AuctionItemDetails }
     *     
     */
    public void setAuctionItemDetails(AuctionItemDetails value) {
        this.auctionItemDetails = value;
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
