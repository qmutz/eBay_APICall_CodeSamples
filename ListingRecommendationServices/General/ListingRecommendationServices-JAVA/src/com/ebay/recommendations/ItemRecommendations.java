/*  © 2013 eBay Inc., All Rights Reserved */ 
/* Licensed under CDDL 1.0 -  http://opensource.org/licenses/cddl1.php */

package com.ebay.recommendations;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;

public class ItemRecommendations {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		HttpClient client = new HttpClient();
		String fullUri="https://svcs.ebay.com/services/selling/listingrecommendation/v1/item/300878655630/itemRecommendations/";
		HttpMethod method = new GetMethod(fullUri);
		// REPLACE YOUR TOKEN IN THE <YOUR_TOKEN_HERE> PLACE HOLDER
		method.addRequestHeader("Authorization", "TOKEN <YOUR_TOKEN_HERE>");
		method.addRequestHeader("X-EBAY-GLOBAL-ID", "EBAY-US");
		
		method.addRequestHeader("Accept", "application/xml");
				
		try {
		        	client.executeMethod(method);
		        	 String response = method.getResponseBodyAsString();
		        	 System.out.println(response);
		}catch (Exception e) {
			e.printStackTrace();
		}	
		
	}

}
