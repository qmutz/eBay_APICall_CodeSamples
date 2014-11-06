/*  © 2008-2013 eBay Inc., All Rights Reserved */ 
/* Licensed under CDDL 1.0 -  http://opensource.org/licenses/cddl1.php */

/**
 * This program is licensed under the terms of the eBay Common Development and
 * Distribution License (CDDL) Version 1.0 (the "License") and any subsequent
 * version thereof released by eBay.  The then-current version of the License
 * can be found at http://www.opensource.org/licenses/cddl1.php
 */
import java.util.Properties;
import java.io.*;
import java.net.*;
import org.w3c.dom.*;
import javax.net.ssl.HttpsURLConnection;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.dom.DOMSource;

/**
 * GeteBayOfficialTime.java
 *
 * This class returns the Official eBay Time in GMT.
 *
 * Any error messages are displayed.
 *
 * @author  Michael Hawthornthwaite (Acid Computer Services) - www.acidcs.co.uk
 */

public class GeteBayOfficialTime {

    /**
     * This variable stores the location of the config file, containing
     * the properties that need to be set for this code to work.
     */
    private static final String configFileLocation = "config.properties";
    /**
     * This variable stores the location of the XML, containing
     * the XML template needed for this call.
     */
    private static final String xmlFileLocation = "request.xml";

    /**
     * Main Entry point for program
     */
    public static void main(String[] args)
    {
        //Load the properties file into a Properties object
        Properties config = new Properties();
        try
        {
            config.load(new FileInputStream(configFileLocation));
        }
        catch (Exception e)
        {
            System.out.println("ERROR: Could not open properties file\n:" + e.toString());
            return;
        }

        //Get all the properties into local strings
        String devID = config.getProperty("DevID");
        String appID = config.getProperty("AppID");
        String certID = config.getProperty("CertID");
        String serverUrl = config.getProperty("ServerUrl");
        String userToken = config.getProperty("UserToken");
        //set other variables needed for call
        String compatLevel = "551";
        String siteID = "0";
        //SET THE NAME OF THE CALL BEING MADE!
        String verb = "GeteBayOfficialTime";



        try
        {
            //Create a HttpsURLConnection with the correct server
            URL server = new URL(serverUrl);
            HttpsURLConnection connection = (HttpsURLConnection) (server.openConnection());

            //set the connection to do both input and output. Request Method = POST
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");

            //Add the necessary headers to the connection
            addeBayHTTPHeaders(connection, devID, appID, certID, compatLevel,verb,siteID);

            //Send the request and return the resulting XML document
            Document xmlDoc = SendRequest(connection, userToken);
            //if null is returned then there was an error
            if(xmlDoc == null)
                return;

            //Check for errors
            NodeList errorsNode = xmlDoc.getElementsByTagName("Errors");
            if(errorsNode.getLength() > 0) //there are errors
            {
                //Output the error
                Element errElement = (Element) errorsNode.item(0);

                //Output the error code
                Node errCodeNode = errElement.getElementsByTagName("ErrorCode").item(0).getChildNodes().item(0);
                System.out.println("Response Error : " + errCodeNode.getNodeValue());

                //Output the short error message
                Node errShortNode = errElement.getElementsByTagName("ShortMessage").item(0).getChildNodes().item(0);
                System.out.println(errShortNode.getNodeValue());

                //Output the long error message if there is one
                try
                {
                    Node errLongNode = errElement.getElementsByTagName("LongMessage").item(0).getChildNodes().item(0);
                    System.out.println(errLongNode.getNodeValue());
                }
                catch(Exception e) {}
            }
            else //CALL SUCCESSFUL
            {
                //Output the Result
                Node timeNode = xmlDoc.getElementsByTagName("Timestamp").item(0).getChildNodes().item(0);
                System.out.println("eBay Official Time: " + timeNode.getNodeValue() + " GMT");
            }


        }
        catch(Exception e)
        {
            //Output error message
	    System.out.println("ERROR: \n" + e.toString());
	    e.printStackTrace();
        }

    }



    /**
     * Sends the request to the Server and returns the Document (XML)
     * that is returned as the response.
     * @param connection The HttpsURLConnection object to be used to execute the request
     * @return The Document (Xml) returned from the server after the request was made.
     */
    private static Document SendRequest(HttpsURLConnection connection, String requestToken)
    {

        try
        {
            //Get the XML file into a Document object
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuild = factory.newDocumentBuilder();
            Document xmlDoc = docBuild.parse(new File(xmlFileLocation));

            //Set the values of the nodes
            xmlDoc.getElementsByTagName("eBayAuthToken").item(0).getChildNodes().item(0).setNodeValue(requestToken);

            //Get the output stream of the connection
            OutputStream out = connection.getOutputStream();

            //Transform and write the Document to the stream
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer tr = tf.newTransformer();
            Source input = new DOMSource(xmlDoc);
            Result output = new StreamResult(out);
            tr.transform(input, output);
            out.flush();
            out.close();

            //Get the Input stream for the response
            InputStream in = connection.getInputStream();
            //Get the stream into a Document object
            Document response = docBuild.parse(in);
            //close the input stream and connection
            in.close();
            connection.disconnect();

            //return the response XML Document
            return response;



        }
        catch(IOException e)
        {
            System.out.println("SendRequest IO Error: " + e.toString());
            e.printStackTrace();
            return null;
        }
        catch(Exception e)
        {
            System.out.println("Error Sending Request: " + e.toString());
            e.printStackTrace();
            return null;
        }
    }


    /**
     * Adds the necessary headers to the HttpsURLConnection passed in
     * order for the call to be successful
     * @param connection The HttpsURLConnection to add the headers to
     * @param devID Developer ID, as registered with the Developer's Program.
     * @param appID Application ID, as registered with the Developer's Program.
     * @param certID Certificate ID, as registered with the Developer's Program.
     * @param compatLevel Regulates versioning of the XML interface for the API.
     * @param verb Name of the function being called e.g. "GetItem"
     * @param siteID The Id of the eBay site the call should be executed on
     */
    private static void addeBayHTTPHeaders(HttpsURLConnection connection,
                                           String devID, String appID,
                                           String certID, String compatLevel,
                                           String verb, String siteID)
    {

        // Add the Compatibility Level Header
        connection.addRequestProperty("X-EBAY-API-COMPATIBILITY-LEVEL", compatLevel);

        // Add the Developer Name, Application Name, and Certification Name Headers
        connection.addRequestProperty("X-EBAY-API-DEV-NAME", devID);
        connection.addRequestProperty("X-EBAY-API-APP-NAME", appID);
        connection.addRequestProperty("X-EBAY-API-CERT-NAME", certID);

        // Add the API verb Header
        connection.addRequestProperty("X-EBAY-API-CALL-NAME", verb);

        // Add the Site Id Header
        connection.addRequestProperty("X-EBAY-API-SITEID", siteID);

        // Add the Content-Type Header
        connection.addRequestProperty("Content-Type", "text/xml");
    }



    /**
     * Allows the user to enter a line of text onto the standard
     * input (usually the console), and then return it as a string.
     * @return The string entered by the user
     */
    private static String readLine()
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      try {
         return br.readLine();
      } catch (IOException ioe) {
         System.out.println("IO error trying to read your name!");
         ioe.printStackTrace();
         return "";
      }
    }
}
