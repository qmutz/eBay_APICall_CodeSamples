Large Merchant Services Samples (PHP)
http://developer.ebay.com/products/large-merchant-services/

** NOTE ***********************************************
*
* PLEASE EXERCISE CAUTION WHEN USING THESE SAMPLES
* If you make listings against the eBay Production site
* you will be charged listing fees!
*
* Please test in the Sandbox before using this against
* eBay production.
********************************************************


[Getting Started]
*****************

(1) Familiarize yourself with Large Merchant Services.
(2) Install php5+ and enable cURL. 
(3) Add your eBay Tokens to /get-common/ServiceEndpointsAndTokens.php
(4) For each Sample, set the environment to SANDBOX or PRODUCTION.
    For example in CreateUploadJob.php:
    >>$session = new LargeMerchantServiceSession('XML','XML', ENV_SANDBOX);
    Simply change ENV_SANDBOX to ENV_PRODUCTION or vice versa.
(5) Navigate to index.php for an Index of the Samples.


[Sample Use Case]
*******************

!NOTE! 
    MAKE SURE TO USE SANDBOX IF USING THE EXAMPLE REQUEST FILE,
    OTHERWISE THEY WILL BE LSITED IN PRODUCTION AND YOU WILL
    BE CHARGED LISTING FEES!

(1) Call CreateUploadJob with a job type of AddFixedPriceItem.
(2) Call UploadFile, it will default to AddFixedPriceItemExample.gz
    which is included for your convenience.
(3) Call GetJobStatus periodically until it gives a status of COMPLETED.
    Use the returned File Reference ID in DownloadFile.
(4) Call DownloadFile to download the response file. By default
    it will save as DownloadFile.zip in the same directory as
    DownloadFile.php
    

[Other Notes]
*************

The entire gamut of operations supported by Large Merchant Services are
not completely illustrated by these samples. For information on more
operations, such as those pertaining to Recurring Jobs, etc. please visit
the Large Merchant Services homepage.