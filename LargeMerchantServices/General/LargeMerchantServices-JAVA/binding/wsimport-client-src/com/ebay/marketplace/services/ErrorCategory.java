
package com.ebay.marketplace.services;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ErrorCategory.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ErrorCategory">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="System"/>
 *     &lt;enumeration value="Application"/>
 *     &lt;enumeration value="Request"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ErrorCategory")
@XmlEnum
public enum ErrorCategory {


    /**
     * 
     * 				Indicates that an error has occurred on the eBay system side, such as a
     * 				database or server down. An application can retry the request as-is a
     * 				reasonable number of times (eBay recommends twice). If the error
     * 				persists, contact Developer Technical Support. Once the problem has been
     * 				resolved, the request may be resent in its original form.
     * 				
     * 
     */
    @XmlEnumValue("System")
    SYSTEM("System"),

    /**
     * 
     * 				An error occurred due to a problem with the request, such as missing or
     * 				invalid fields. The problem must be corrected before the request can be
     * 				made again. If the problem is due to something in the application (such
     * 				as a missing required field), the application must be changed. Once the
     * 				problem in the application or data is resolved, resend the corrected
     * 				request to eBay.
     * 				
     * 
     */
    @XmlEnumValue("Application")
    APPLICATION("Application"),

    /**
     * 
     * 				An error occurred due to a problem with the request, such as invalid or
     * 				missing data. The problem must be corrected before the request can be
     * 				made again. If the problem is a result of end-user data, the application
     * 				must alert the end-user to the problem and provide the means for the
     * 				end-user to correct the data. Once the problem in the data is resolved,
     * 				resend the request to eBay with the corrected data.
     * 				
     * 
     */
    @XmlEnumValue("Request")
    REQUEST("Request");
    private final String value;

    ErrorCategory(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ErrorCategory fromValue(String v) {
        for (ErrorCategory c: ErrorCategory.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
