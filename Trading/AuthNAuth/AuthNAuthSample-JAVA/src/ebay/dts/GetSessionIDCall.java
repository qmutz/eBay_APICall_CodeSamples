/*
 * © 2010-2013 eBay Inc., All Rights Reserved
 * Licensed under CDDL 1.0 -  http://opensource.org/licenses/cddl1.php
 */

package ebay.dts;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.net.URLEncoder;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/**
 *
 * @author zhuyang
 */
public class GetSessionIDCall {

    private static Logger logger = Logger.getLogger("GetSessionIDCall.logger");

    public String getRawSessionID() {
        return rawSessionID;
    }
    private String rawSessionID=null;

    private String appID = null;
    private String devID = null;
    private String cert = null;
    private String runame = null;
    private boolean isProduction;
    private String longErrorMessage=null;

    public String getLongErrorMessage() {
        return longErrorMessage;
    }

    public String getRuname() {
        return runame;
    }

    public GetSessionIDCall() {
    }

    public GetSessionIDCall(boolean isProduction, String devid, String appid, String cert) {
        this.isProduction = isProduction;
        this.devID = devid;
        this.appID = appid;
        this.cert = cert;
    }

   /**
    * Send GetSessionID request
    * @param runame String
    * <br>
    * @return The Document object.
   */
    public Document sendRequest(String runame) {
        logger.info("Entering GetSessionIDCall.sendRequest runame=" + runame);
        try {
            String verb = "GetSessionID";
            byte[] bytes = new String(getSessionIDRequestXML()).getBytes();
            ByteArrayInputStream bin = new ByteArrayInputStream(bytes);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuild = factory.newDocumentBuilder();
            //File getAccountFile = new File("GetSessionID.xml");
            //Document req = docBuild.parse(getAccountFile);
           Document req = docBuild.parse(bin);
            req.getElementsByTagName("RuName").item(0).setTextContent(runame);
            System.out.println("runame "
                    + req.getElementsByTagName("RuName").item(0).getTextContent());
            Document response = TradingAPIConnection.sendApiXMPPostCall(isProduction, req, verb, appID, devID, cert);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

   /**
    *
    * @param response Document
    */
    public void getSessionIDString(Document response) throws Exception{

        logger.info("Entering in GetSessionIDCall.getSessionIDString .....");
        if (response != null) {
            NodeList ackNodes = response.getElementsByTagName("Ack");
            String ack = ackNodes.item(0).getTextContent();
            if (ack.compareTo("Failure") == 0) {
                NodeList longErrorNode = response.getElementsByTagName("LongMessage");
                this.longErrorMessage = "RequestError: " + longErrorNode.item(0).getTextContent();

            } else {
                NodeList bufferNodes = response.getElementsByTagName("SessionID");
                rawSessionID= bufferNodes.item(0).getTextContent();
                logger.info("GetSessionIDCall.getSessionIDString ===> getRawSessionID = "
                        + rawSessionID);   
            }
        }else {
            logger.info("nothing returned  .....");

        }
    }

      /**
    *
    * @param response Document
    */
    public String getRowSessionIDString(Document response) throws Exception{

        logger.info("Entering in GetSessionIDCall.getSessionIDString .....");
        String getRawSessionID="";
        if (response != null) {
            NodeList ackNodes = response.getElementsByTagName("Ack");
            String ack = ackNodes.item(0).getTextContent();
            if (ack.compareTo("Failure") == 0) {
                NodeList longErrorNode = response.getElementsByTagName("LongMessage");
                this.longErrorMessage = "RequestError: " + longErrorNode.item(0).getTextContent();

            } else {
                NodeList bufferNodes = response.getElementsByTagName("SessionID");
                getRawSessionID = bufferNodes.item(0).getTextContent();
                logger.info("GetSessionIDCall.getSessionIDString ===> getRawSessionID = "
                        + getRawSessionID);

              //  this.sessionID = URLEncoder.encode(bufferNodes.item(0).getTextContent(),"UTF-8");
              //  logger.info("GetSessionIDCall.getSessionIDString ===> sessionID = "
              //          + sessionID);

            }
        }else {
            logger.info("nothing returned  .....");

        }
        return getRawSessionID;
    }
     private String getSessionIDRequestXML() {
        StringBuffer request = new StringBuffer("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
        request.append("<GetSessionIDRequest xmlns=\"urn:ebay:apis:eBLBaseComponents\">");
        request.append(" <RuName>MNO</RuName>");
        request.append("</GetSessionIDRequest>");
        return request.toString();
    }
}
