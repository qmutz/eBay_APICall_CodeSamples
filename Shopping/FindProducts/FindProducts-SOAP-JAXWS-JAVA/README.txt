INTRODUCTION
============
This sample uses wsimport tool that ships with JAX-WS to generate Java code stubs and demonstrates how to make Shopping API calls.


INSTRUCTIONS
============

1. Software Requirements:


    JAX-WS Reference Implementation 
    JDK 1.5 or higher

2. Generate Java code stub using wsimport tool:

    Once you have set up JAW-WS on your machine, go to the {JAX-WS install-dir}/bin directory where you will find the wsimport tool. Open command prompt, change the directory to {JAX-WS install-dir}/bin and enter the following command:

         wsimport -extension http://developer.ebay.com/webservices/latest/ShoppingService.wsdl
 
    This will generate the required Java classes from the WSDL