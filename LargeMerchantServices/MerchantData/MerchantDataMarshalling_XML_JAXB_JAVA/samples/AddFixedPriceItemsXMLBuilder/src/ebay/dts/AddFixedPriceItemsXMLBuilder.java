/* 
 * © 2010-2013 eBay Inc., All Rights Reserved 
 * Licensed under CDDL 1.0 -  http://opensource.org/licenses/cddl1.php
 */


package ebay.dts;


import ebay.apis.eblbasecomponents.AddFixedPriceItemRequestType;
import ebay.apis.eblbasecomponents.AmountType;
import ebay.apis.eblbasecomponents.BulkDataExchangeRequestsType;
import ebay.apis.eblbasecomponents.BuyerPaymentMethodCodeType;
import ebay.apis.eblbasecomponents.CategoryType;
import ebay.apis.eblbasecomponents.CountryCodeType;
import ebay.apis.eblbasecomponents.CurrencyCodeType;
import ebay.apis.eblbasecomponents.ItemType;
import ebay.apis.eblbasecomponents.ListingTypeCodeType;
import ebay.apis.eblbasecomponents.MerchantDataRequestHeaderType;
import ebay.apis.eblbasecomponents.ObjectFactory;
import ebay.apis.eblbasecomponents.ReturnPolicyType;
import ebay.apis.eblbasecomponents.ShippingDetailsType;
import ebay.apis.eblbasecomponents.ShippingServiceOptionsType;
import ebay.apis.eblbasecomponents.ShippingTypeCodeType;
import ebay.apis.eblbasecomponents.SiteCodeType;
import ebay.apis.eblbasecomponents.WarningLevelCodeType;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;

/**
 *
 * @author zhuyang
 */
public class AddFixedPriceItemsXMLBuilder {

    private static String jaxb_object_tree_package_name = "ebay.apis.eblbasecomponents";
    private static String request_element_name_string="AddFixedPriceItemRequest";
    private static Logger logger = Logger.getLogger("AddFixedPriceItemsXMLBuilder.logger");
    private static String FixedPriceItemRequestXMLFilePath="c:/AddFixedPriceItemsRequest.xml";
    public static void main(String [] args){
        marshal(buildBulkDataRequest());
    }

    private static void marshal(BulkDataExchangeRequestsType request) {

	    FileInputStream fis = null;
	    try {
	        JAXBContext jc = JAXBContext.newInstance(jaxb_object_tree_package_name);
	        Marshaller m = jc.createMarshaller();
	        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

	        ObjectFactory of = new ObjectFactory();
	        String tmpXmlFile = "c:/tmp.xml";
	        JAXBElement<BulkDataExchangeRequestsType> requetElement = of.createBulkDataExchangeRequests(request);
	        m.marshal(requetElement, new FileWriter(tmpXmlFile));
	        fis = new FileInputStream(tmpXmlFile);
	        addNameSpace(tmpXmlFile,request_element_name_string);
	        fis.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
    }

    private static BulkDataExchangeRequestsType buildBulkDataRequest(){
        BulkDataExchangeRequestsType bulkDataExchangereq = new BulkDataExchangeRequestsType();
        MerchantDataRequestHeaderType header = new MerchantDataRequestHeaderType();
        String version = "825";
        header.setSiteID(0);
        header.setVersion(version);

        bulkDataExchangereq.setHeader(header);
        List<AddFixedPriceItemRequestType> addFixedPriceItemList = bulkDataExchangereq.getAddFixedPriceItemRequest();
        addFixedPriceItemList.add(0, createRequestType(version,0));
        addFixedPriceItemList.add(1, createRequestType(version,1));

        return bulkDataExchangereq;

    }



    private static AddFixedPriceItemRequestType createRequestType(String version,int skuPlus) {
        String errorLang= "en_US";
        AddFixedPriceItemRequestType fixedPriceItemType = new AddFixedPriceItemRequestType();
        fixedPriceItemType.setVersion(version);
        fixedPriceItemType.setItem(buildItem(skuPlus));
        fixedPriceItemType.setWarningLevel(WarningLevelCodeType.HIGH);
        fixedPriceItemType.setErrorLanguage(errorLang);
        return fixedPriceItemType;

    }
    private static ItemType buildItem(int skuPlus) {
       ItemType item = new ItemType(); 
       String descStr="Test. Do not bid"+" - " +skuPlus;


       item.setSite(SiteCodeType.US);
       item.setCurrency(CurrencyCodeType.USD);
       item.setCountry(CountryCodeType.US);
       item.setListingDuration("Days_7");

       item.setTitle("Minimal fixed-price listing");
       item.setDescription(descStr);
       item.setLocation(" San Jose, CA");

       item.setQuantity(new Integer(4));
       item.setListingType(ListingTypeCodeType.FIXED_PRICE_ITEM);
       AmountType amount = new AmountType();
       Double price = new Double (457.39);
       amount.setValue(price);
       amount.setCurrencyID(CurrencyCodeType.USD);
       item.setStartPrice(amount);

       List<BuyerPaymentMethodCodeType> paymentMethods = item.getPaymentMethods();
       paymentMethods.add(BuyerPaymentMethodCodeType.PAY_PAL);
       item.setPayPalEmailAddress("ve2@testtest.com");

       item.setSKU("1122334456-"+ (String.valueOf(skuPlus)));
       CategoryType cat = new CategoryType();
       cat.setCategoryID("1463");
       item.setPrimaryCategory(cat);
       item.setDispatchTimeMax(new Integer(3));

       item.setShippingDetails(getShippingDetails());
       ReturnPolicyType rpt = new ReturnPolicyType();
       rpt.setReturnsAcceptedOption("ReturnsAccepted");

       rpt.setRefundOption("MoneyBack");
       rpt.setReturnsWithinOption("Days_30");
       rpt.setDescription("Text description of return policy details");
       rpt.setShippingCostPaidByOption("Buyer");
       item.setReturnPolicy(rpt);
        //define gallery picture type
        //PictureDetailsType pd = new PictureDetailsType();
        //pd.setGalleryType(GalleryTypeCodeType.GALLERY);
        //pd.setGalleryURL(IMAGEURL);
        //item.setPictureDetails(pd);

        return item;


    }

    private static ShippingDetailsType getShippingDetails() {
        // construct shipping details container
        ShippingDetailsType sd = new ShippingDetailsType();
        sd.setShippingType(ShippingTypeCodeType.FLAT);
        ShippingServiceOptionsType st1 = new ShippingServiceOptionsType();
        st1.setShippingService("UPSGround");
        AmountType amount = new AmountType();
        amount.setValue(2.0);
        amount.setCurrencyID(CurrencyCodeType.USD);
        st1.setShippingServiceCost(amount);
        st1.setShippingServicePriority(new Integer(1));
        List<ShippingServiceOptionsType> options = sd.getShippingServiceOptions();
        options.add(st1);
        return sd;
    }

    private static void addNameSpace(String tmpXmlFilePath, String requestElementNameString){
        try {
           File tmpfile = new File(tmpXmlFilePath);
		   BufferedReader reader = new BufferedReader(new FileReader(tmpfile));
		   String line = "", oldtext = "";
		   while ((line = reader.readLine()) != null){
		       oldtext += line + "\r\n";
		   }
		   reader.close();
		   logger.info(oldtext);
		   String newtext = oldtext.replaceAll("<"+requestElementNameString+">","<"+requestElementNameString+" xmlns=\"urn:ebay:apis:eBLBaseComponents\">");

		   File requestXMLfile = new File (FixedPriceItemRequestXMLFilePath);
		   FileWriter writer = new FileWriter(requestXMLfile);
		   writer.write(newtext);
		   if ( requestXMLfile.exists() ) {
		        logger.info("FixedPriceItemRequest XML data file "+ requestXMLfile.getPath()+ " is created");
		   }
           writer.close();
       }catch (IOException ioe){
           ioe.printStackTrace();
       }
   }


}
