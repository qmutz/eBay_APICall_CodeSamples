Project Description
===================
This Java sample project illustrates the use of HttpURLConnection for posting Trading API Request XML to eBay trading API web service and Jaxb framework for Java-XML mapping. 
Two sample applications: AddFixedPriceItemCall and GetSellerListCall are provided for demonstrating the approach.  



SOFTWARE REQUIREMENTS
=====================
1. JAXWS2.1.5 or higher 
      - set the JWSDP_HOME system variable to point to your JAXWS2.1.5 installation directory. 

2.JDK 1.6 or higher 


INSTRUCTIONS
============
A. Binding Trading API Schema
     1. Download the latest Trading API XSD file and save it to ${TradingAPIClientSamples-Java_HOME}/XSD folder 
     2. Execute the jaxb-codeGen.xml script and generate java classes represent the Trading API Schema saved in step 1 
           > ant -f  ${TradingAPIClientSamples-Java_HOME}/jaxb-codeGen.xml 
 
B.  Build and run the samples
    
    1. build and run the AddFixedPriceItemCall sample application
      1.1 go to ${TradingAPIClientSamples-Java_HOME}/samples/AddFixedPriceItemCall folder
      1.2 edit the Configruation.xml file to specify your Sandbox user auth token 
      1.3 make neccessary modification to ${TradingAPIClientSamples-Java_HOME}/samples/AddFixedPriceItemCall/src/com/ebay/sample/AddFixedPriceItemCall.java 
      1.4 execute the ant script to list an item to Sandbox environment  
       > ant -f build.xml
    
    2. build and run the GetSellerListCall sample application
      1.1 go to ${TradingAPIClientSamples-Java_HOME}/samples/GetSellerListCall folder
      1.2 edit the Configruation.xml file to specify your Sandbox user auth token 
      1.3 make neccessary modification to ${TradingAPIClientSamples-Java_HOME}/samples/GetSellerListCall/src/com/ebay/sample/GetSellerListCall.java 
      1.4 execute the ant script to retrieve your active item list 
       > ant -f build.xml
