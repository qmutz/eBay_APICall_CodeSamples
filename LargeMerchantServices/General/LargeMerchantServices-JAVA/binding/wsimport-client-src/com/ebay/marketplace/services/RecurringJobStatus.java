
package com.ebay.marketplace.services;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RecurringJobStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RecurringJobStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Active"/>
 *     &lt;enumeration value="Suspended"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RecurringJobStatus")
@XmlEnum
public enum RecurringJobStatus {


    /**
     * 
     * 					Job is active. 
     * 				
     * 
     */
    @XmlEnumValue("Active")
    ACTIVE("Active"),

    /**
     * 
     * 					Job is suspended. Use <b class="con">activateRecurringJob</b> to
     * 					restart a suspended recurring job.
     * 				
     * 
     */
    @XmlEnumValue("Suspended")
    SUSPENDED("Suspended");
    private final String value;

    RecurringJobStatus(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static RecurringJobStatus fromValue(String v) {
        for (RecurringJobStatus c: RecurringJobStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
