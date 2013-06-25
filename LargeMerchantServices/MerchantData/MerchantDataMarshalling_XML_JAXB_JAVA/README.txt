INTRODUCTION
============

   This sample illustrates the use of JAVA JAXB framework to bind to Merchant Data Schema and construct data file to be uploaded to Large Merchant Service. 
   Running this sample project will generate an AddFixedPriceItems.xml document that can be used in LMS: Java Sample project.

SOFTWARE REQUIREMENTS
=====================

      1. JAXWS2.1.5: https://jax-ws.dev.java.net/2.1.5/  or higher

         - set the JWSDP_HOME system variable to point to the JAXWS2.1.5 installation directory. 

      2. JDK 1.6 or higher

  

INSTRUCTIONS
============
           
           1. Download the latest Merchant Data XSD file here: http://developer.ebay.com/webservices/latest/merchantdataservice.xsd and save it to ${MerchantDataMarshalling_JAXB_HOME}/XSD folder

           2. Execute the jaxb-codeGen.xml script and generate java classes represent the Marchant Data schema saved in step 2 
      > ant -f  ${MerchantDataMarshalling_JAXB_HOME}/jaxb-codeGen.xml

           3. Build and run the AddFixedPriceItemsXMLBuilder sample to create a data file for AddFixedPriceItemRequest
      > ant -f ${MerchantDataMarshalling_JAXB_HOME}/samples/AddFixedPriceItemsXMLBuilder/build.xml
