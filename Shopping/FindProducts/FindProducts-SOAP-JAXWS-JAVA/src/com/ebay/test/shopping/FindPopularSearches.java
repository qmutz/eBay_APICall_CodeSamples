/*  © 2011-2013 eBay Inc., All Rights Reserved */ 
/* Licensed under CDDL 1.0 -  http://opensource.org/licenses/cddl1.php */

package com.ebay.test.shopping;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.MessageContext;

import ebay.apis.eblbasecomponents.CatalogProductType;
import ebay.apis.eblbasecomponents.ProductIDCodeType;
import ebay.apis.eblbasecomponents.ProductIDType;
import javax.xml.ws.handler.Handler;

/**
 *
 * @author rvenkitasubraman
 * This is based on the FindPopularSearchResults sample
 */
public class FindPopularSearches {

    private static final String APPID = "YOUR APP ID";
    private static final String CALLNAME = "FindProducts";
    private static final String VERSION = "655";
    private static final String BASEURL = "http://open.api.ebay.com/shopping?";
    private static BindingProvider bp;

    public static void main(String[] args) {
        String endpointURL = BASEURL;

        try { 
            ebay.apis.eblbasecomponents.Shopping service = new ebay.apis.eblbasecomponents.Shopping();
            ebay.apis.eblbasecomponents.ShoppingInterface port = service.getShopping();
            bp = (BindingProvider) port;
            // bp = (BindingProvider) port;
            bp.getRequestContext().
                    put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
                    endpointURL);
            // Add the logging handler
            List<Handler> handlerList = bp.getBinding().getHandlerChain();
            if (handlerList == null) {
                handlerList = new ArrayList<Handler>();
            }
            LoggingHandler loggingHandler = new LoggingHandler();
            handlerList.add(loggingHandler);
            // register the handerList
            bp.getBinding().setHandlerChain(handlerList);

            Map<String,Object> requestProperties = bp.getRequestContext();
            Map<String, List<String>> httpHeaders = new HashMap<String, List<String>>();
            requestProperties.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpointURL);
            // set reqired HTTP Headers :
            // http://developer.ebay.com/DevZone/shopping/docs/Concepts/ShoppingAPI_FormatOverview.html#StandardURLParameters
            httpHeaders.put("X-EBAY-API-CALL-NAME", Collections.singletonList(CALLNAME));
            httpHeaders.put("X-EBAY-API-APP-ID", Collections.singletonList(APPID));
            httpHeaders.put("X-EBAY-API-VERSION", Collections.singletonList(VERSION));

            requestProperties.put(MessageContext.HTTP_REQUEST_HEADERS, httpHeaders);
            // initialize WS operation arguments here
            ebay.apis.eblbasecomponents.FindProductsRequestType request = new ebay.apis.eblbasecomponents.FindProductsRequestType();
            // Using Keyword search
            request.setQueryKeywords("iPod Touch 4G");
            // Setting the resultset size to 10
            request.setMaxEntries(10);
            
            // You can search based on categories too.
            
            // submit the request
            ebay.apis.eblbasecomponents.FindProductsResponseType response = port.findProducts(request);
            // process result here
            System.out.println(" EndpointURL : " + endpointURL);
            System.out.println("Status = " + response.getAck());

            List<CatalogProductType> resultList = response.getProduct();
            if (resultList != null) {
                for (CatalogProductType result : resultList) {
                	List<ProductIDType>productIds = result.getProductID();
                	String ePID = "";
                	for (ProductIDType productIDType : productIds) {
                		if(productIDType.getType().equals(ProductIDCodeType.REFERENCE)){
                			ePID=productIDType.getValue();
                		}
					}
                	System.out.format("ProductID(ePID): %s, Details URL: %s", ePID,result.getDetailsURL());
                	System.out.println();
                }
            }
        } catch (Exception ex) {
        	ex.printStackTrace(System.err);        
        }
    }
}
