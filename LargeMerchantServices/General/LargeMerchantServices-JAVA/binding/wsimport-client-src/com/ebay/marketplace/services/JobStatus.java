
package com.ebay.marketplace.services;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JobStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="JobStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Created"/>
 *     &lt;enumeration value="Scheduled"/>
 *     &lt;enumeration value="InProcess"/>
 *     &lt;enumeration value="Completed"/>
 *     &lt;enumeration value="Aborted"/>
 *     &lt;enumeration value="Failed"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "JobStatus")
@XmlEnum
public enum JobStatus {


    /**
     * 
     * 					The job ID and file reference ID have been created as a result of the
     * 					createUploadJobRequest or the startDownloadJobRequest.
     * 				
     * 
     */
    @XmlEnumValue("Created")
    CREATED("Created"),

    /**
     * 
     * 					The job has been internally scheduled for processing by the Bulk Data
     * 					Exchange service.
     * 				
     * 
     */
    @XmlEnumValue("Scheduled")
    SCHEDULED("Scheduled"),

    /**
     * 
     * 					Processing on the data file or the report has begun.
     * 				
     * 
     */
    @XmlEnumValue("InProcess")
    IN_PROCESS("InProcess"),

    /**
     * 
     * 					Processing on the data file or the report has finished.
     * 				
     * 
     */
    @XmlEnumValue("Completed")
    COMPLETED("Completed"),

    /**
     * 
     * 					The Bulk Data Exchange has been aborted due to the abortJobRequset call.
     * 				
     * 
     */
    @XmlEnumValue("Aborted")
    ABORTED("Aborted"),

    /**
     * 
     * 					The Bulk Data Exchange job has not completed successfully, due to
     * 					incorrect data format, request errors, or Bulk Data Exchange
     * 					service errors.
     * 				
     * 
     */
    @XmlEnumValue("Failed")
    FAILED("Failed");
    private final String value;

    JobStatus(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static JobStatus fromValue(String v) {
        for (JobStatus c: JobStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
