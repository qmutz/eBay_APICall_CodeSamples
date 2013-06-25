/*
 * © 2009-2013 eBay Inc., All Rights Reserved
 * Licensed under CDDL 1.0 -  http://opensource.org/licenses/cddl1.php
 */

package ebay.dts;

import ebay.apis.eblbasecomponents.CustomSecurityHeaderType;
import ebay.apis.eblbasecomponents.GeteBayOfficialTimeRequestType;
import ebay.apis.eblbasecomponents.GeteBayOfficialTimeResponseType;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.MessageContext;

/**
 *
 * @author zhuyang
 */
public class AppGeteBayOfficialTime {

    /**
     * @param args the command line arguments
     */
     static String m_TOKEN = "";
     static String m_APPID = "";
     static String m_TRADING_API_URL = "https://api.sandbox.ebay.com/wsapi";
	 static String m_siteId = "0";
     static String m_version = "825";



     public static void main(String[] args) {
         System.out.println("Starting  AppGeteBayOfficialTime.main ....");
         BindingProvider bp=null;
         String callName = "GeteBayOfficialTime";
        try {
			// Call Web Service Operation
            ebay.apis.eblbasecomponents.EBayAPIInterfaceService service = new ebay.apis.eblbasecomponents.EBayAPIInterfaceService();
            ebay.apis.eblbasecomponents.EBayAPIInterface port = service.getEBayAPI();
            bp = (BindingProvider) port;

            Map requestProperties = bp.getRequestContext();
            String endpoint = m_TRADING_API_URL +
                    "?callname=" + callName +
                    "&siteid=" + m_siteId +
                    "&appid=" + m_APPID +
                    "&version=" + m_version;
            // set server http address
            requestProperties.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpoint);

            // set http header
            Map<String, List<String>> httpHeaders = new HashMap<String, List<String>>();
            httpHeaders.put("Accept-Encoding", Collections.singletonList("gzip"));
            requestProperties.put(MessageContext.HTTP_REQUEST_HEADERS, httpHeaders);

            //set RequesterCredentials SOAP Header
            // <RequesterCredentials soapenv:mustUnderstand="0" xmlns="urn:ebay:apis:eBLBaseComponents">
            // 1. create CustomeSecurityHeaderType object
            CustomSecurityHeaderType auth = new CustomSecurityHeaderType();
            // 2. specify eBayAuthToken

            auth.setEBayAuthToken(m_TOKEN);
            // 3. register the CustomeSecurityHeaderType object into javax.xml.ws.Holder object
            javax.xml.ws.Holder holder = new javax.xml.ws.Holder<CustomSecurityHeaderType>(auth);

            // create eBay API request object
            GeteBayOfficialTimeRequestType geteBayOfficialTimeRequest = new GeteBayOfficialTimeRequestType();
            // set property for the API object
            geteBayOfficialTimeRequest.setVersion(m_version);
            //
           GeteBayOfficialTimeResponseType result = port.geteBayOfficialTime(geteBayOfficialTimeRequest, holder);


           XMLGregorianCalendar xmlCal=       result.getTimestamp();
           java.util.Calendar timestamp =xmlCal.toGregorianCalendar();
           String timeStr = convertToGMTString(timestamp);
           System.out.println("eBay official time in GMT: " +timeStr);

           System.out.println("Finishing  AppGeteBayOfficialTime.main ....");

        } catch (Exception ex) {
            ex.printStackTrace();
            // TODO handle custom exceptions here
        }

    }
    public static String convertToGMTString(java.util.Calendar cal){
           java.text.SimpleDateFormat fmt = new java.text.SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
           fmt.setTimeZone( TimeZone.getTimeZone("GMT"));
           fmt.setCalendar(cal);
           java.util.Date date = cal.getTime();
           String timeStr = fmt.format(date);
           return timeStr;
    }
}
