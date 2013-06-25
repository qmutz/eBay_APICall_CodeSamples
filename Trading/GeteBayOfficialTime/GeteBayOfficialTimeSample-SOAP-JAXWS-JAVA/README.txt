 INTRODUCTION
 ============
  	
        This sample project illustrates on how to use JAVA JAX-WS framework to execute GeteBayOfficialTime Trading SOAP request.   
        For using this sample you must have got your Sandbox or Production key set that includes three IDs (DevID, AppID, and CertID) and an eBay User Token. 
 
 SOFTWARE REQUIREMENTS
 =====================

      1. JAXWS2.1.5 or higher. 
         -  JAXWS2.1.5 can be downloded here : https://jax-ws.dev.java.net/2.1.5/
      2. JDK 1.5 or higher 

 INSTRUCTIONS
 ============

      1. set the environment variable 'JWSDP_HOME' and point to your JAX-WS root directory of the JAX-WS bundle
      2. Build the Trading API Clent Stub
     
           > ant -f  ./Trading_JAX-WS_SOAP_Client/codeGen.xml
     
      3. Build and run the GeteBayOfficialTime API sample
     
         -  edit the ./Trading_JAX-WS_SOAP_Client/samples/AppGeteBayOfficialTime/src/ebay/dts/AppGeteBayOfficialTime.java and specify  m_TOKEN, m_APPID and m_TRADING_API_URL properties.
     
         -  build  and run the AppGeteBayOfficialTime  project:
     
            > ant -f  ./Trading_JAX-WS_SOAP_Client/samples/AppGeteBayOfficialTime/build.xml
     
   