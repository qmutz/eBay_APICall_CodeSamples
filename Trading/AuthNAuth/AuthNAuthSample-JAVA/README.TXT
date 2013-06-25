 INTRODUCTION
 ============

  This sample project illustrates on how to implement the auth & auth Java Desktop Application. The GetSessionID and FetchToken API calls required for generating
  user tokens are fired using Java HttpURLConnection POST.

  For using this sample you must have obtained your Sandbox or Production key set that includes three IDs (DevID, AppID, and CertID) and generated an RuName.  
 

 SOFTWARE REQUIREMENTS
 =====================

      1. JDK1.6 or  higher
      2. Ant 1.7.1 or higher



 INSTRUCTIONS
 ============
       1. Download and unzip the project file : UserTokenTool.zip
       2. Build project
               > ant -f  build.xml

       3. run the UserTokenTool
               > java -jar dist/java -jar dist/UserTokenTool.jar

