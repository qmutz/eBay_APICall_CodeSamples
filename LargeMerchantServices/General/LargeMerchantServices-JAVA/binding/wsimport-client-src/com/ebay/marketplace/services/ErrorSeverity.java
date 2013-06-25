
package com.ebay.marketplace.services;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ErrorSeverity.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ErrorSeverity">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Error"/>
 *     &lt;enumeration value="Warning"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ErrorSeverity")
@XmlEnum
public enum ErrorSeverity {


    /**
     * 
     * 				The request that triggered the error was not processed successfully.
     * 				When a serious application-level error occurs, the error is returned
     * 				instead of the business data.
     * 				
     * 
     */
    @XmlEnumValue("Error")
    ERROR("Error"),

    /**
     * 
     * 				The request was processed successfully, but something occurred that may
     * 				affect your application or the user. For example, eBay may have changed a
     * 				value the user sent in. In this case, eBay returns a normal, successful
     * 				response and also returns the warning.
     * 				
     * 
     */
    @XmlEnumValue("Warning")
    WARNING("Warning");
    private final String value;

    ErrorSeverity(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ErrorSeverity fromValue(String v) {
        for (ErrorSeverity c: ErrorSeverity.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
