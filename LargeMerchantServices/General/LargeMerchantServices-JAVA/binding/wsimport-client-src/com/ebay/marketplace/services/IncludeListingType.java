
package com.ebay.marketplace.services;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IncludeListingType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="IncludeListingType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *     &lt;enumeration value="Auction"/>
 *     &lt;enumeration value="FixedPrice"/>
 *     &lt;enumeration value="AuctionAndFixedPrice"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "IncludeListingType")
@XmlEnum
public enum IncludeListingType {


    /**
     * 
     * 					Chinese Acution type.
     * 				
     * 
     */
    @XmlEnumValue("Auction")
    AUCTION("Auction"),

    /**
     * 
     * 					Listing type is fixed price.
     * 				
     * 
     */
    @XmlEnumValue("FixedPrice")
    FIXED_PRICE("FixedPrice"),

    /**
     * 
     * 					Listing type is chinese Auction or fixed price.
     * 				
     * 
     */
    @XmlEnumValue("AuctionAndFixedPrice")
    AUCTION_AND_FIXED_PRICE("AuctionAndFixedPrice");
    private final String value;

    IncludeListingType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static IncludeListingType fromValue(String v) {
        for (IncludeListingType c: IncludeListingType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
