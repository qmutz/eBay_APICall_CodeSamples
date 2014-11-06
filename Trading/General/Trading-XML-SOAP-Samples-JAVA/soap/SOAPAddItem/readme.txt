Java SOAP AddItem Call
eBay Developers Program
http://developer.ebay.com
Last updated: July 2013
--------------------------


Project Description
===================
   SampleAddItem is an example Java class that uses Apache Axis to make a 
   call to the AddItem method of the Ebay SOAP API.  


Getting Started
===============

 1) Verify that you have Java 1.5.x or higher installed. You can verify your 
   Java installation by opening a command prompt and typing:
   
	> java -version

   2) Verify that you have Apache Ant installed and that you have 
   properly configured the ANT_HOME environment variable. You can 
   read more about installing Ant here: 
   
   	http://ant.apache.org/manual/install.html
   	
   After installing Ant you can verify your installation by opening a command
   prompt and typing:
   
	> ant

   A successful installation of Ant should throw an error saying that 'build.xml
   does not exist!'.

   3) Verify that you have the Apache Axis libraries on your system. Specifically,
   you should have the following Java libraries in your $axis_install\lib\ directory:
	
	axis.jar
	axis-ant.jar
	commons-discovery.jar
	commons-logging.jar
	jaxrpc.jar
	log4j-1.2.8.jar
	saaj.jar
	wsdl4j.jar
	
   where $axis_install is the location that you downloaded and unzipped Apache Axis 
    to.  If you do not have the above jars, you can find them in the 'externalJars' folder 
	provided in the zipped package.
	
   4) Edit config.properties so that the following keys reflect your environment:

	url
	siteid
	version
	devid
	appid
	cert
	token

   The url key is either going to be the production Ebay URL:

	https://api.ebay.com/wsapi

   or the sandbox Ebay URL:

	https://api.sandbox.ebay.com/wsapi

   The siteid for the United States is 0, you can find a list of all the available
   site ID's by visiting this page:
   
	http://developer.ebay.com/DevZone/XML/docs/WebHelp/FieldDifferences-Site_IDs.html
   
   The version used when testing this project was 397.  You should have 
   received the devid,appid and cert when you signed up for the Ebay 
   Developer Program. The token can be created programmatically or using 
   this link:

	https://developer.ebay.com/DevZone/account/tokens/

   5) Edit build.xml build scirpt and point the axis.home property to Axis installation directory


   6) Run build.xml script to compile the source files as:

        > ant -f build.xm
   

   7) Make sure the file client-config.wsdd is at the top level of the directory
that contains your compiled classes (in the sample package, GeteBayTime/classes).

   8) Edit the run.bat to point the AXIS_LIB to poin to the path %AXIS_PATH%/lib directory on your local file 
      Make sure that the versions of the jars set in the %SAMPLE_CLASSPATH% variable are all right. 
      Run SampleAddItem class:
       > run.bat
   
   