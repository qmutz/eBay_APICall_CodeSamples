set AXIS_LIB=C:/eBaySupport/Projects/CodeSampleUpdation/Java/axis2-1.4.1/lib
set EBAYSOAP_LIB=../bin/ebaysoap.jar

set SAMPLE_CLASSPATH=%AXIS_LIB%/axis-1.3.jar;%AXIS_LIB%/jaxrpc.jar;%AXIS_LIB%/log4j-1.2.15.jar;%AXIS_LIB%/commons-discovery.jar;%AXIS_LIB%/commons-logging-1.1.1.jar;%AXIS_LIB%/saaj.jar;%AXIS_LIB%/wsdl4j-1.6.2.jar


java -cp ./classes.ant;%EBAYSOAP_LIB%;%SAMPLE_CLASSPATH% com.ebay.dts.GeteBayTime