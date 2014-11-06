/*  © 2008-2013 eBay Inc., All Rights Reserved */ 
/* Licensed under CDDL 1.0 -  http://opensource.org/licenses/cddl1.php */

package com.ebay.dts;

import com.ebay.api.soap.*;

import java.net.URL;
import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.Properties;
import java.text.SimpleDateFormat;
import java.io.IOException;
import java.io.FileInputStream;
import org.apache.axis.types.URI.MalformedURIException;

/**
 *
 * @author Bruce Thompson
 *
 *
 *
 */

public class GeteBayTime {

  private static EBayAPIInterface binding = null;

  public static void main(String[] args) throws MalformedURIException, RemoteException {

  	// Create the request URL (setupAPIInterface is defined below)
  	String file = "config.properties";
    setupAPIInterface(file, "GeteBayOfficialTime");

    // Make the call
    GeteBayOfficialTimeRequestType theCall = new GeteBayOfficialTimeRequestType();
     theCall.setVersion("579");   // change for new versions
    GeteBayOfficialTimeResponseType result = binding.geteBayOfficialTime(theCall);

    // Get the ebay time
    // Result inherits from AbstractResponseType
    Calendar cal = result.getTimestamp();           // the time is returned in gmt
    cal.setTimeZone(TimeZone.getTimeZone("PST"));   // convert to pst to get official ebay time

    // Display official ebay time in gmt
    int year = cal.get(Calendar.YEAR);
    int month = cal.get(Calendar.MONTH);
    month = month + 1;   // months go from 0-11; make human readable
    int day = cal.get(Calendar.DAY_OF_MONTH);
    int hour24 = cal.get(Calendar.HOUR_OF_DAY);
    int min = cal.get(Calendar.MINUTE);
    int sec = cal.get(Calendar.SECOND);
    System.out.println("official time at ebay headquarters is: " + year + "-" + month + "-" + day + " " + hour24 + ":" + min + ":" + sec + " PST");

    // Format the result and display in local time
    SimpleDateFormat formatter = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss Z");
    System.out.println("in your time zone: " + formatter.format( cal.getTime() ));

}

  /**
   *
   * Create the request URL, set credentials,
   * and locate the eBay service.
   *
   */

   private static void setupAPIInterface(String filename, String callName) {


    // Read properties file to load developer credentials
    Properties keys = new Properties();
    try {
        //keys.load(new FileInputStream("keys.properties"));
        keys.load(new FileInputStream(filename));
    } catch (IOException e) {
        System.out.println(e);
    }

    String baseURL = keys.getProperty("url");
    int siteId = Integer.parseInt(keys.getProperty("siteid"));
    int version = Integer.parseInt(keys.getProperty("version"));

    ClientCredentialHandler.setDevId( keys.getProperty("devid") );
    ClientCredentialHandler.setAppId( keys.getProperty("appid") );
    ClientCredentialHandler.setAuthCert( keys.getProperty("cert") );
 // Use if the call you are making requires a token (which most calls do)
    ClientCredentialHandler.setToken( keys.getProperty("token") );

  // Use only if the call you are making accepts a username and password
  // ClientCredentialHandler.setUsername( keys.getProperty("username") );
  // ClientCredentialHandler.setPassword( keys.getProperty("password") );


    try {
      String requestURL = baseURL +
          "?callname=" + callName +
          "&siteid=" + siteId +
          "&appid=" + ClientCredentialHandler.getAppId() +
          "&version=" + version ;

      binding = new EBayAPIInterfaceServiceLocator().geteBayAPI(new URL(requestURL));
      ((EBayAPISoapBindingStub) binding).setTimeout(60000);
    }
    catch (Exception e) {
      System.out.println("Error locating eBay API Interface: " + e);
      System.exit(1);
    }
  }
}
