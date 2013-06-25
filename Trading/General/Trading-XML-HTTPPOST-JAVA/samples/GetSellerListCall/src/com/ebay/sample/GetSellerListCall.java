/**
 * © 2010-2013 eBay Inc., All Rights Reserved 
 * Licensed under CDDL 1.0 -  http://opensource.org/licenses/cddl1.php
 */
package com.ebay.sample;

import ebay.apis.eblbasecomponents.*;
import java.io.*;
import java.net.URL;
import java.util.*;
import javax.xml.bind.*;
import javax.net.ssl.HttpsURLConnection;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 *
 * @author zhuyang@ebay.com
 */
public class GetSellerListCall {

    private static String JAXB_PACKAGE_NAME = "ebay.apis.eblbasecomponents";
    private String USERTOKEN;
    private String SERVERURL;
    private static JAXBContext jc;
    private Properties prop;

    public GetSellerListCall() {
	        prop = new Properties();
	        try {
	            String path = (new java.io.File(".").getCanonicalPath());
	            String CONFIG_PROPERTIES = path + System.getProperty("file.separator") + "configuration.xml";
	            if (CONFIG_PROPERTIES == null && CONFIG_PROPERTIES.length() == 0) {
	                System.err.println(" the configuration.xml roperties file is not found.");
	                System.exit(0);
	            }
	            prop.loadFromXML(new FileInputStream(CONFIG_PROPERTIES));
	            SERVERURL = prop.getProperty("serverURL");
	            USERTOKEN = prop.getProperty("userToken");
	            System.out.println("API Server URL: "+SERVERURL );
	        } catch (IOException ioe) {
	            //handle exception
	        }
	    }


	    public static void main(String[] args) {

	        GetSellerListCall sample = new GetSellerListCall();
	        // create and initial an GetSellerListRequestType object
	        GetSellerListRequestType request = new GetSellerListRequestType();
	        XMLRequesterCredentialsType requestCredential = new XMLRequesterCredentialsType();
	        requestCredential.setEBayAuthToken(sample.USERTOKEN);
	        request.setRequesterCredentials(requestCredential);

	        try {
	            java.util.Calendar nowCal = java.util.Calendar.getInstance();
	            java.util.Calendar fromCal = (java.util.Calendar) nowCal.clone();
	            XMLGregorianCalendar xmlgregorianTo = toApiTime(nowCal);
	            XMLGregorianCalendar xmlgregorianFrom = fromApiTime(fromCal,24);

	            request.setErrorLanguage("en_US");
	            request.setIncludeWatchCount(Boolean.TRUE);
	            request.setStartTimeFrom(xmlgregorianFrom);
	            request.setStartTimeTo(xmlgregorianTo);

	            // marshal the GetSellerListRequestType object to the XML document
	            String requestXML = sample.marshalObject2Xml(request);
	            // open SSL HTTPS connect and send request
	            InputStreamReader inputStream = sample.openConnectionFireRequest(requestXML, "GetSellerList");
	            // unmarshal response stream into a Java content tree
	            Object returnedObj = sample.unmarshalInputStream(inputStream);
	            if (returnedObj != null && returnedObj instanceof GetSellerListResponseType) {
	                GetSellerListResponseType response = (GetSellerListResponseType) returnedObj;

	                if (response.getAck().compareTo(AckCodeType.SUCCESS) == 0) {
	                    System.out.println(response.getBuild());
	                    ItemArrayType itemArray = response.getItemArray();
	                    Iterator<ItemType> itemIter = itemArray.getItem().iterator();
	                    while (itemIter.hasNext()) {
	                        ItemType item = itemIter.next();
	                        System.out.println(item.getItemID());
	                    }
	                }
	            }
	        } catch (Exception e) {
	            //handle exception
	        }
	    }

	    /*
	     *  marshal GetSellerListRequestType object to XML data  file
	     *
	     */
	    private String marshalObject2Xml(GetSellerListRequestType requestobj) throws Exception {
	        String requestXmlFileName = "GetSellerListRequest.xml";
	        jc = JAXBContext.newInstance(JAXB_PACKAGE_NAME);
	        Marshaller m = jc.createMarshaller();
	        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
	        ObjectFactory of = new ObjectFactory();

	        JAXBElement<GetSellerListRequestType> requestElement = of.createGetSellerListRequest(requestobj);
	        m.marshal(requestElement, new FileWriter(requestXmlFileName));
	        return requestXmlFileName;
	    }

	    /*
	     * open SSL https connection and send the request xml data
	     *
	     */
	    public InputStreamReader openConnectionFireRequest(String XmlFileName, String ApiCallName) throws Exception {
	        URL url = new URL(SERVERURL);
	        // open SSL https connection
	        HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
	        conn.setRequestMethod("POST");

	        conn.setDoInput(true);
	        conn.setDoOutput(true);
	        conn.setRequestProperty("Content-Type", "text/xml");
	        // required headers
	        conn.setRequestProperty("X-EBAY-API-COMPATIBILITY-LEVEL", "825");
	        conn.setRequestProperty("X-EBAY-API-CALL-NAME", ApiCallName);
	        conn.setRequestProperty("X-EBAY-API-SITEID", "0");

	        PrintWriter output = new PrintWriter(new OutputStreamWriter(conn.getOutputStream()));
	        Thread.sleep(11000);
	        String fileContent = convertFileContent2String(XmlFileName);

	        System.out.println(conn.getURL());
	        System.out.println(fileContent);
	        output.println(fileContent);
	        output.close();
	        conn.connect();
	        InputStreamReader isr = new InputStreamReader(conn.getInputStream());
	        return isr;
	    }

	    /*
	     * read input stream and unmarshal it into a Java content tree
	     */
	    public Object unmarshalInputStream(InputStreamReader isr) {
	        Object returnedObj = null;
	        try {
	            int c = 0;
	            String addFixedPriceItemResponse = "GetSellerListResponse.xml";
	            OutputStream f = new FileOutputStream(addFixedPriceItemResponse);
	            while ((c = isr.read()) > -1) {
	                f.write(c);
	            }
	            f.close();
	            String responseXML = convertFileContent2String(addFixedPriceItemResponse);
	            System.out.println(responseXML);
	            InputStream input = new ByteArrayInputStream(responseXML.getBytes());
	            JAXBContext context = JAXBContext.newInstance(JAXB_PACKAGE_NAME);
	            Unmarshaller unmarshaller = context.createUnmarshaller();
	            JAXBElement<Object> poe = (JAXBElement) unmarshaller.unmarshal(input);
	            returnedObj = poe.getValue();

	            isr.close();
	        } catch (Exception e) {
	           //handle exception
	        }
	        return returnedObj;
	    }

	    private static String convertFileContent2String(String fileName) {
	        String fileContentInString = "";
	        try {
	            File soapFile = new File(fileName);
	            byte fileContent[] = new byte[(int) soapFile.length()];
	            FileInputStream soapFileIS = new FileInputStream(soapFile);
	            soapFileIS.read(fileContent, 0, fileContent.length);
	            fileContentInString = new String(fileContent);
	        } catch (Exception ex) {
	            //handle exception
	        }

	        return fileContentInString;
	    }

	     private static XMLGregorianCalendar toApiTime(Calendar nowCal) throws Exception {
	        GregorianCalendar gregorian = new GregorianCalendar();
	        gregorian.setTime(nowCal.getTime());
	        return (DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorian));
	    }

	    private static XMLGregorianCalendar fromApiTime(Calendar fromCal, int durationInHour) throws Exception {
	        fromCal.add(java.util.Calendar.HOUR, -(durationInHour));
	        GregorianCalendar gregorian = new GregorianCalendar();
	        gregorian.setTime(fromCal.getTime());

	        return (DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorian));
    }
}