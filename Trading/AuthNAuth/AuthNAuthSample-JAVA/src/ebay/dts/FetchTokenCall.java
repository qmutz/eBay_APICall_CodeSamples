/*
 * © 2010-2013 eBay Inc., All Rights Reserved
 * Licensed under CDDL 1.0 -  http://opensource.org/licenses/cddl1.php
 */

package ebay.dts;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/**
 *
 * @author zhuyang
 */
public class FetchTokenCall {

    private static Logger logger = Logger.getLogger("GetSessionIDCall.logger");
    private String appID=null;
    private String devID=null;
    private String cert=null;
    private String usertoken=null;
    private String tokenExpirationTime=null;
    private String longErrorMessage=null;

    public FetchTokenCall (){
    }

    public FetchTokenCall (boolean isProduction,String devid, String appid, String cert){
       this.isProduction=isProduction;
       this.devID=devid;
       this.appID=appid;
       this.cert=cert;
    }
    public String getLongErrorMessage() {
        return longErrorMessage;
    }

    public String getTokenExpirationTime() {
        return tokenExpirationTime;
    }

    public String getUsertoken() {
        return usertoken;
    }

    private boolean isProduction;

   
   /**
    * Send FetchToken request
    * @param sessionID String
    * <br>
    * @return The Document object.
   */
    public Document sendRequest(String sessionID) {
        logger.info("Entering in FetchTokenCall.sendRequest for sessionID="
                + sessionID);
        try {
            // make the API request
            String verb = "FetchToken";
            byte[] bytes = new String(fetchTokenRequestXML()).getBytes();
            ByteArrayInputStream bin = new ByteArrayInputStream(bytes);

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuild = factory.newDocumentBuilder();
           // File getAccountFile = new File("./ebay.dts.FetchToken.xml");
           // Document req = docBuild.parse(getAccountFile);
            Document req = docBuild.parse(bin);
            req.getElementsByTagName("SessionID").item(0).setTextContent(sessionID);
            System.out.println("sessionID in request"
                    + req.getElementsByTagName("SessionID").item(0).getTextContent());
            
            Document response = TradingAPIConnection.sendApiXMPPostCall(isProduction, req, verb, appID, devID, cert);
            return response;
        } catch (Exception e) {
            return null;
        }
    }

   /**
    *
    * @param response Document
    */
    public void getUserTokenString(Document response) {
        logger.info("Entering in FetchTokenCall.getUserTokenString .....");

        if (response != null) {
            NodeList ackNodes = response.getElementsByTagName("Ack");
            String ack = ackNodes.item(0).getTextContent();
            if (ack.compareTo("Failure") == 0) {
                NodeList longErrorNode = response.getElementsByTagName("LongMessage");
                this.longErrorMessage = "RequestError: " +longErrorNode.item(0).getTextContent();
            } else {
                NodeList bufferNodes = response.getElementsByTagName("eBayAuthToken");
                this.usertoken = bufferNodes.item(0).getTextContent();
                NodeList expirNode2 = response.getElementsByTagName("HardExpirationTime");
                this.tokenExpirationTime = expirNode2.item(0).getTextContent();
                logger.info("FetchTokenCall.retrieveToken ===>   user token="
                        + usertoken);
                logger.info("FetchTokenCall.retrieveToken ===> ExpirationTime ="
                        + tokenExpirationTime);
            }
        }

    }
    private String fetchTokenRequestXML() {
        StringBuffer request = new StringBuffer("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
        request.append("<FetchTokenRequest xmlns=\"urn:ebay:apis:eBLBaseComponents\">");
        request.append(" <SessionID>MNO</SessionID>");
        request.append("</FetchTokenRequest>");
        return request.toString();
    }
}
