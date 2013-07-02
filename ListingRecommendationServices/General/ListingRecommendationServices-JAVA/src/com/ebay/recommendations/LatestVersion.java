/*  © 2013 eBay Inc., All Rights Reserved */ 
/* Licensed under CDDL 1.0 -  http://opensource.org/licenses/cddl1.php */

package com.ebay.recommendations;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;

public class LatestVersion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HttpClient client = new HttpClient();
		String fullUri="https://svcs.ebay.com/services/selling/listingrecommendation/latestVersion";
		HttpMethod method = new GetMethod(fullUri);
		// REPLACE YOUR TOKEN IN THE <YOUR_TOKEN_HERE> PLACE HOLDER
		method.addRequestHeader("Authorization", "TOKEN AgAAAA**AQAAAA**aAAAAA**vGu1Tw**nY+sHZ2PrBmdj6wVnY+sEZ2PrA2dj6AFkYClDpOFogidj6x9nY+seQ**/3kBAA**AAMAAA**hbbdMZSJmJc9GSPMh5+2LZ8tndQYZcrRXr3WxqJfJSQCfN9JaqsE3/wGnT9/paUpflk27UuWBYPVhAj4qyqcu6JNA8cX/U0Mg1k1Hp1cjU0MWWFgKgjuD50MbSGBPBWl0Q3tHdPWPq1t6sBjNNJTYB6pfdmKXzdyFjvknVbyLfxL7tOnylq77QI7WJCZz5RCs2nn22moF0JOSc8BsfE7tYx3JffB6upVgzJsAz64sPvXweQBIG04Z3AMmfA+WfFsxySxydGRTqmWeMZFR9s/RifpU6M5aHSlqzfweRm9f0OcP8yG6Ho4b5E6ZHEG5dniXIGPr9FNWYmEaP1lmgnjo34xpsIsMMj5Vx4YX8ilYMjNNSEs+CsSjENL3qwXUWQdye9PcTTQgG57a267DN/m3lNr6SaR2ZfXt+joK/3/V/E8+oJ36XfHWbnbjBxTJBJ1/FHH366cc8e8wTXSSwD0cezfK2j6skAN0n+RVgLRoOt0F3P0GD8ULLhNyqzD7/1C8c0+KZu+o66Lxhpa+V0gxQbSnzNYSSez4U1o1tdugVnfrTemfOr3nwYUXyf/P09mdcR0lehyji6HtYPz12tE7pbTD48LUWTi6R6ylq+OxokKqv7w4TCSaeuYqDj1yBCAoni8Rh/4ZBKpSsFo+KoCbSngFNIwsCMjKnGzXXtYG61+N0Esq3cg7y08UnXdgneMgqn/xabqF9Q6gOm1fj68XY+ZpAx3a7eLi/u9aq0mM0MCUUPmC/JPNzwieaUfCZzw");
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
