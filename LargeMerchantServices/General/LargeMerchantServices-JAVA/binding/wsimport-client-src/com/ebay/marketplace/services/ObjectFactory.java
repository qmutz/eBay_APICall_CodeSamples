
package com.ebay.marketplace.services;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.ebay.marketplace.services package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _DeleteRecurringJobRequest_QNAME = new QName("http://www.ebay.com/marketplace/services", "deleteRecurringJobRequest");
    private final static QName _AbortRecurringJobExecutionResponse_QNAME = new QName("http://www.ebay.com/marketplace/services", "abortRecurringJobExecutionResponse");
    private final static QName _StartUploadJobResponse_QNAME = new QName("http://www.ebay.com/marketplace/services", "startUploadJobResponse");
    private final static QName _GetJobsResponse_QNAME = new QName("http://www.ebay.com/marketplace/services", "getJobsResponse");
    private final static QName _StartUploadJobRequest_QNAME = new QName("http://www.ebay.com/marketplace/services", "startUploadJobRequest");
    private final static QName _GetRecurringJobExecutionStatusResponse_QNAME = new QName("http://www.ebay.com/marketplace/services", "getRecurringJobExecutionStatusResponse");
    private final static QName _StartDownloadJobResponse_QNAME = new QName("http://www.ebay.com/marketplace/services", "startDownloadJobResponse");
    private final static QName _GetJobsRequest_QNAME = new QName("http://www.ebay.com/marketplace/services", "getJobsRequest");
    private final static QName _StartDownloadJobRequest_QNAME = new QName("http://www.ebay.com/marketplace/services", "startDownloadJobRequest");
    private final static QName _GetRecurringJobExecutionHistoryRequest_QNAME = new QName("http://www.ebay.com/marketplace/services", "getRecurringJobExecutionHistoryRequest");
    private final static QName _AbortRecurringJobExecutionRequest_QNAME = new QName("http://www.ebay.com/marketplace/services", "abortRecurringJobExecutionRequest");
    private final static QName _SuspendRecurringJobRequest_QNAME = new QName("http://www.ebay.com/marketplace/services", "suspendRecurringJobRequest");
    private final static QName _GetJobStatusResponse_QNAME = new QName("http://www.ebay.com/marketplace/services", "getJobStatusResponse");
    private final static QName _SuspendRecurringJobResponse_QNAME = new QName("http://www.ebay.com/marketplace/services", "suspendRecurringJobResponse");
    private final static QName _GetRecurringJobExecutionStatusRequest_QNAME = new QName("http://www.ebay.com/marketplace/services", "getRecurringJobExecutionStatusRequest");
    private final static QName _CreateRecurringJobResponse_QNAME = new QName("http://www.ebay.com/marketplace/services", "createRecurringJobResponse");
    private final static QName _CreateUploadJobRequest_QNAME = new QName("http://www.ebay.com/marketplace/services", "createUploadJobRequest");
    private final static QName _GetRecurringJobsResponse_QNAME = new QName("http://www.ebay.com/marketplace/services", "getRecurringJobsResponse");
    private final static QName _GetRecurringJobExecutionHistoryResponse_QNAME = new QName("http://www.ebay.com/marketplace/services", "getRecurringJobExecutionHistoryResponse");
    private final static QName _ActivateRecurringJobRequest_QNAME = new QName("http://www.ebay.com/marketplace/services", "activateRecurringJobRequest");
    private final static QName _GetJobStatusRequest_QNAME = new QName("http://www.ebay.com/marketplace/services", "getJobStatusRequest");
    private final static QName _ActivateRecurringJobResponse_QNAME = new QName("http://www.ebay.com/marketplace/services", "activateRecurringJobResponse");
    private final static QName _DeleteRecurringJobResponse_QNAME = new QName("http://www.ebay.com/marketplace/services", "deleteRecurringJobResponse");
    private final static QName _GetRecurringJobsRequest_QNAME = new QName("http://www.ebay.com/marketplace/services", "getRecurringJobsRequest");
    private final static QName _CreateUploadJobResponse_QNAME = new QName("http://www.ebay.com/marketplace/services", "createUploadJobResponse");
    private final static QName _CreateRecurringJobRequest_QNAME = new QName("http://www.ebay.com/marketplace/services", "createRecurringJobRequest");
    private final static QName _AbortJobRequest_QNAME = new QName("http://www.ebay.com/marketplace/services", "abortJobRequest");
    private final static QName _AbortJobResponse_QNAME = new QName("http://www.ebay.com/marketplace/services", "abortJobResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.ebay.marketplace.services
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link WeeklyRecurrence }
     * 
     */
    public WeeklyRecurrence createWeeklyRecurrence() {
        return new WeeklyRecurrence();
    }

    /**
     * Create an instance of {@link GetRecurringJobExecutionStatusRequest }
     * 
     */
    public GetRecurringJobExecutionStatusRequest createGetRecurringJobExecutionStatusRequest() {
        return new GetRecurringJobExecutionStatusRequest();
    }

    /**
     * Create an instance of {@link DailyRecurrence }
     * 
     */
    public DailyRecurrence createDailyRecurrence() {
        return new DailyRecurrence();
    }

    /**
     * Create an instance of {@link DownloadRequestFilter }
     * 
     */
    public DownloadRequestFilter createDownloadRequestFilter() {
        return new DownloadRequestFilter();
    }

    /**
     * Create an instance of {@link ErrorMessage }
     * 
     */
    public ErrorMessage createErrorMessage() {
        return new ErrorMessage();
    }

    /**
     * Create an instance of {@link AuctionItemDetails }
     * 
     */
    public AuctionItemDetails createAuctionItemDetails() {
        return new AuctionItemDetails();
    }

    /**
     * Create an instance of {@link StartUploadJobResponse }
     * 
     */
    public StartUploadJobResponse createStartUploadJobResponse() {
        return new StartUploadJobResponse();
    }

    /**
     * Create an instance of {@link JobProfile }
     * 
     */
    public JobProfile createJobProfile() {
        return new JobProfile();
    }

    /**
     * Create an instance of {@link GetItemInfoReportFilter }
     * 
     */
    public GetItemInfoReportFilter createGetItemInfoReportFilter() {
        return new GetItemInfoReportFilter();
    }

    /**
     * Create an instance of {@link CreateRecurringJobRequest }
     * 
     */
    public CreateRecurringJobRequest createCreateRecurringJobRequest() {
        return new CreateRecurringJobRequest();
    }

    /**
     * Create an instance of {@link GetJobStatusResponse }
     * 
     */
    public GetJobStatusResponse createGetJobStatusResponse() {
        return new GetJobStatusResponse();
    }

    /**
     * Create an instance of {@link MonthlyRecurrence }
     * 
     */
    public MonthlyRecurrence createMonthlyRecurrence() {
        return new MonthlyRecurrence();
    }

    /**
     * Create an instance of {@link FeeSettlementReportFilter }
     * 
     */
    public FeeSettlementReportFilter createFeeSettlementReportFilter() {
        return new FeeSettlementReportFilter();
    }

    /**
     * Create an instance of {@link ActiveInventoryReportFilter }
     * 
     */
    public ActiveInventoryReportFilter createActiveInventoryReportFilter() {
        return new ActiveInventoryReportFilter();
    }

    /**
     * Create an instance of {@link GetRecurringJobExecutionHistoryRequest }
     * 
     */
    public GetRecurringJobExecutionHistoryRequest createGetRecurringJobExecutionHistoryRequest() {
        return new GetRecurringJobExecutionHistoryRequest();
    }

    /**
     * Create an instance of {@link CreateRecurringJobResponse }
     * 
     */
    public CreateRecurringJobResponse createCreateRecurringJobResponse() {
        return new CreateRecurringJobResponse();
    }

    /**
     * Create an instance of {@link StartUploadJobRequest }
     * 
     */
    public StartUploadJobRequest createStartUploadJobRequest() {
        return new StartUploadJobRequest();
    }

    /**
     * Create an instance of {@link ErrorData }
     * 
     */
    public ErrorData createErrorData() {
        return new ErrorData();
    }

    /**
     * Create an instance of {@link ActivateRecurringJobRequest }
     * 
     */
    public ActivateRecurringJobRequest createActivateRecurringJobRequest() {
        return new ActivateRecurringJobRequest();
    }

    /**
     * Create an instance of {@link GetRecurringJobExecutionStatusResponse }
     * 
     */
    public GetRecurringJobExecutionStatusResponse createGetRecurringJobExecutionStatusResponse() {
        return new GetRecurringJobExecutionStatusResponse();
    }

    /**
     * Create an instance of {@link GetRecurringJobsResponse }
     * 
     */
    public GetRecurringJobsResponse createGetRecurringJobsResponse() {
        return new GetRecurringJobsResponse();
    }

    /**
     * Create an instance of {@link GetJobsResponse }
     * 
     */
    public GetJobsResponse createGetJobsResponse() {
        return new GetJobsResponse();
    }

    /**
     * Create an instance of {@link GetRecurringJobsRequest }
     * 
     */
    public GetRecurringJobsRequest createGetRecurringJobsRequest() {
        return new GetRecurringJobsRequest();
    }

    /**
     * Create an instance of {@link GetJobsRequest }
     * 
     */
    public GetJobsRequest createGetJobsRequest() {
        return new GetJobsRequest();
    }

    /**
     * Create an instance of {@link CreateUploadJobRequest }
     * 
     */
    public CreateUploadJobRequest createCreateUploadJobRequest() {
        return new CreateUploadJobRequest();
    }

    /**
     * Create an instance of {@link GetJobStatusRequest }
     * 
     */
    public GetJobStatusRequest createGetJobStatusRequest() {
        return new GetJobStatusRequest();
    }

    /**
     * Create an instance of {@link CreateUploadJobResponse }
     * 
     */
    public CreateUploadJobResponse createCreateUploadJobResponse() {
        return new CreateUploadJobResponse();
    }

    /**
     * Create an instance of {@link AbortRecurringJobExecutionRequest }
     * 
     */
    public AbortRecurringJobExecutionRequest createAbortRecurringJobExecutionRequest() {
        return new AbortRecurringJobExecutionRequest();
    }

    /**
     * Create an instance of {@link ActivateRecurringJobResponse }
     * 
     */
    public ActivateRecurringJobResponse createActivateRecurringJobResponse() {
        return new ActivateRecurringJobResponse();
    }

    /**
     * Create an instance of {@link AbortRecurringJobExecutionResponse }
     * 
     */
    public AbortRecurringJobExecutionResponse createAbortRecurringJobExecutionResponse() {
        return new AbortRecurringJobExecutionResponse();
    }

    /**
     * Create an instance of {@link DeleteRecurringJobResponse }
     * 
     */
    public DeleteRecurringJobResponse createDeleteRecurringJobResponse() {
        return new DeleteRecurringJobResponse();
    }

    /**
     * Create an instance of {@link GetItemJobActionType }
     * 
     */
    public GetItemJobActionType createGetItemJobActionType() {
        return new GetItemJobActionType();
    }

    /**
     * Create an instance of {@link FixedPriceItemDetails }
     * 
     */
    public FixedPriceItemDetails createFixedPriceItemDetails() {
        return new FixedPriceItemDetails();
    }

    /**
     * Create an instance of {@link RecurringJobDetail }
     * 
     */
    public RecurringJobDetail createRecurringJobDetail() {
        return new RecurringJobDetail();
    }

    /**
     * Create an instance of {@link AbortJobRequest }
     * 
     */
    public AbortJobRequest createAbortJobRequest() {
        return new AbortJobRequest();
    }

    /**
     * Create an instance of {@link StartDownloadJobRequest }
     * 
     */
    public StartDownloadJobRequest createStartDownloadJobRequest() {
        return new StartDownloadJobRequest();
    }

    /**
     * Create an instance of {@link SiteFilter }
     * 
     */
    public SiteFilter createSiteFilter() {
        return new SiteFilter();
    }

    /**
     * Create an instance of {@link ErrorParameter }
     * 
     */
    public ErrorParameter createErrorParameter() {
        return new ErrorParameter();
    }

    /**
     * Create an instance of {@link StartDownloadJobResponse }
     * 
     */
    public StartDownloadJobResponse createStartDownloadJobResponse() {
        return new StartDownloadJobResponse();
    }

    /**
     * Create an instance of {@link AbortJobResponse }
     * 
     */
    public AbortJobResponse createAbortJobResponse() {
        return new AbortJobResponse();
    }

    /**
     * Create an instance of {@link SuspendRecurringJobResponse }
     * 
     */
    public SuspendRecurringJobResponse createSuspendRecurringJobResponse() {
        return new SuspendRecurringJobResponse();
    }

    /**
     * Create an instance of {@link DeleteRecurringJobRequest }
     * 
     */
    public DeleteRecurringJobRequest createDeleteRecurringJobRequest() {
        return new DeleteRecurringJobRequest();
    }

    /**
     * Create an instance of {@link SuspendRecurringJobRequest }
     * 
     */
    public SuspendRecurringJobRequest createSuspendRecurringJobRequest() {
        return new SuspendRecurringJobRequest();
    }

    /**
     * Create an instance of {@link GetRecurringJobExecutionHistoryResponse }
     * 
     */
    public GetRecurringJobExecutionHistoryResponse createGetRecurringJobExecutionHistoryResponse() {
        return new GetRecurringJobExecutionHistoryResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteRecurringJobRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ebay.com/marketplace/services", name = "deleteRecurringJobRequest")
    public JAXBElement<DeleteRecurringJobRequest> createDeleteRecurringJobRequest(DeleteRecurringJobRequest value) {
        return new JAXBElement<DeleteRecurringJobRequest>(_DeleteRecurringJobRequest_QNAME, DeleteRecurringJobRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbortRecurringJobExecutionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ebay.com/marketplace/services", name = "abortRecurringJobExecutionResponse")
    public JAXBElement<AbortRecurringJobExecutionResponse> createAbortRecurringJobExecutionResponse(AbortRecurringJobExecutionResponse value) {
        return new JAXBElement<AbortRecurringJobExecutionResponse>(_AbortRecurringJobExecutionResponse_QNAME, AbortRecurringJobExecutionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StartUploadJobResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ebay.com/marketplace/services", name = "startUploadJobResponse")
    public JAXBElement<StartUploadJobResponse> createStartUploadJobResponse(StartUploadJobResponse value) {
        return new JAXBElement<StartUploadJobResponse>(_StartUploadJobResponse_QNAME, StartUploadJobResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetJobsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ebay.com/marketplace/services", name = "getJobsResponse")
    public JAXBElement<GetJobsResponse> createGetJobsResponse(GetJobsResponse value) {
        return new JAXBElement<GetJobsResponse>(_GetJobsResponse_QNAME, GetJobsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StartUploadJobRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ebay.com/marketplace/services", name = "startUploadJobRequest")
    public JAXBElement<StartUploadJobRequest> createStartUploadJobRequest(StartUploadJobRequest value) {
        return new JAXBElement<StartUploadJobRequest>(_StartUploadJobRequest_QNAME, StartUploadJobRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRecurringJobExecutionStatusResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ebay.com/marketplace/services", name = "getRecurringJobExecutionStatusResponse")
    public JAXBElement<GetRecurringJobExecutionStatusResponse> createGetRecurringJobExecutionStatusResponse(GetRecurringJobExecutionStatusResponse value) {
        return new JAXBElement<GetRecurringJobExecutionStatusResponse>(_GetRecurringJobExecutionStatusResponse_QNAME, GetRecurringJobExecutionStatusResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StartDownloadJobResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ebay.com/marketplace/services", name = "startDownloadJobResponse")
    public JAXBElement<StartDownloadJobResponse> createStartDownloadJobResponse(StartDownloadJobResponse value) {
        return new JAXBElement<StartDownloadJobResponse>(_StartDownloadJobResponse_QNAME, StartDownloadJobResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetJobsRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ebay.com/marketplace/services", name = "getJobsRequest")
    public JAXBElement<GetJobsRequest> createGetJobsRequest(GetJobsRequest value) {
        return new JAXBElement<GetJobsRequest>(_GetJobsRequest_QNAME, GetJobsRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StartDownloadJobRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ebay.com/marketplace/services", name = "startDownloadJobRequest")
    public JAXBElement<StartDownloadJobRequest> createStartDownloadJobRequest(StartDownloadJobRequest value) {
        return new JAXBElement<StartDownloadJobRequest>(_StartDownloadJobRequest_QNAME, StartDownloadJobRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRecurringJobExecutionHistoryRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ebay.com/marketplace/services", name = "getRecurringJobExecutionHistoryRequest")
    public JAXBElement<GetRecurringJobExecutionHistoryRequest> createGetRecurringJobExecutionHistoryRequest(GetRecurringJobExecutionHistoryRequest value) {
        return new JAXBElement<GetRecurringJobExecutionHistoryRequest>(_GetRecurringJobExecutionHistoryRequest_QNAME, GetRecurringJobExecutionHistoryRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbortRecurringJobExecutionRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ebay.com/marketplace/services", name = "abortRecurringJobExecutionRequest")
    public JAXBElement<AbortRecurringJobExecutionRequest> createAbortRecurringJobExecutionRequest(AbortRecurringJobExecutionRequest value) {
        return new JAXBElement<AbortRecurringJobExecutionRequest>(_AbortRecurringJobExecutionRequest_QNAME, AbortRecurringJobExecutionRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SuspendRecurringJobRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ebay.com/marketplace/services", name = "suspendRecurringJobRequest")
    public JAXBElement<SuspendRecurringJobRequest> createSuspendRecurringJobRequest(SuspendRecurringJobRequest value) {
        return new JAXBElement<SuspendRecurringJobRequest>(_SuspendRecurringJobRequest_QNAME, SuspendRecurringJobRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetJobStatusResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ebay.com/marketplace/services", name = "getJobStatusResponse")
    public JAXBElement<GetJobStatusResponse> createGetJobStatusResponse(GetJobStatusResponse value) {
        return new JAXBElement<GetJobStatusResponse>(_GetJobStatusResponse_QNAME, GetJobStatusResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SuspendRecurringJobResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ebay.com/marketplace/services", name = "suspendRecurringJobResponse")
    public JAXBElement<SuspendRecurringJobResponse> createSuspendRecurringJobResponse(SuspendRecurringJobResponse value) {
        return new JAXBElement<SuspendRecurringJobResponse>(_SuspendRecurringJobResponse_QNAME, SuspendRecurringJobResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRecurringJobExecutionStatusRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ebay.com/marketplace/services", name = "getRecurringJobExecutionStatusRequest")
    public JAXBElement<GetRecurringJobExecutionStatusRequest> createGetRecurringJobExecutionStatusRequest(GetRecurringJobExecutionStatusRequest value) {
        return new JAXBElement<GetRecurringJobExecutionStatusRequest>(_GetRecurringJobExecutionStatusRequest_QNAME, GetRecurringJobExecutionStatusRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateRecurringJobResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ebay.com/marketplace/services", name = "createRecurringJobResponse")
    public JAXBElement<CreateRecurringJobResponse> createCreateRecurringJobResponse(CreateRecurringJobResponse value) {
        return new JAXBElement<CreateRecurringJobResponse>(_CreateRecurringJobResponse_QNAME, CreateRecurringJobResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateUploadJobRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ebay.com/marketplace/services", name = "createUploadJobRequest")
    public JAXBElement<CreateUploadJobRequest> createCreateUploadJobRequest(CreateUploadJobRequest value) {
        return new JAXBElement<CreateUploadJobRequest>(_CreateUploadJobRequest_QNAME, CreateUploadJobRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRecurringJobsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ebay.com/marketplace/services", name = "getRecurringJobsResponse")
    public JAXBElement<GetRecurringJobsResponse> createGetRecurringJobsResponse(GetRecurringJobsResponse value) {
        return new JAXBElement<GetRecurringJobsResponse>(_GetRecurringJobsResponse_QNAME, GetRecurringJobsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRecurringJobExecutionHistoryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ebay.com/marketplace/services", name = "getRecurringJobExecutionHistoryResponse")
    public JAXBElement<GetRecurringJobExecutionHistoryResponse> createGetRecurringJobExecutionHistoryResponse(GetRecurringJobExecutionHistoryResponse value) {
        return new JAXBElement<GetRecurringJobExecutionHistoryResponse>(_GetRecurringJobExecutionHistoryResponse_QNAME, GetRecurringJobExecutionHistoryResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ActivateRecurringJobRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ebay.com/marketplace/services", name = "activateRecurringJobRequest")
    public JAXBElement<ActivateRecurringJobRequest> createActivateRecurringJobRequest(ActivateRecurringJobRequest value) {
        return new JAXBElement<ActivateRecurringJobRequest>(_ActivateRecurringJobRequest_QNAME, ActivateRecurringJobRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetJobStatusRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ebay.com/marketplace/services", name = "getJobStatusRequest")
    public JAXBElement<GetJobStatusRequest> createGetJobStatusRequest(GetJobStatusRequest value) {
        return new JAXBElement<GetJobStatusRequest>(_GetJobStatusRequest_QNAME, GetJobStatusRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ActivateRecurringJobResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ebay.com/marketplace/services", name = "activateRecurringJobResponse")
    public JAXBElement<ActivateRecurringJobResponse> createActivateRecurringJobResponse(ActivateRecurringJobResponse value) {
        return new JAXBElement<ActivateRecurringJobResponse>(_ActivateRecurringJobResponse_QNAME, ActivateRecurringJobResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteRecurringJobResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ebay.com/marketplace/services", name = "deleteRecurringJobResponse")
    public JAXBElement<DeleteRecurringJobResponse> createDeleteRecurringJobResponse(DeleteRecurringJobResponse value) {
        return new JAXBElement<DeleteRecurringJobResponse>(_DeleteRecurringJobResponse_QNAME, DeleteRecurringJobResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRecurringJobsRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ebay.com/marketplace/services", name = "getRecurringJobsRequest")
    public JAXBElement<GetRecurringJobsRequest> createGetRecurringJobsRequest(GetRecurringJobsRequest value) {
        return new JAXBElement<GetRecurringJobsRequest>(_GetRecurringJobsRequest_QNAME, GetRecurringJobsRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateUploadJobResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ebay.com/marketplace/services", name = "createUploadJobResponse")
    public JAXBElement<CreateUploadJobResponse> createCreateUploadJobResponse(CreateUploadJobResponse value) {
        return new JAXBElement<CreateUploadJobResponse>(_CreateUploadJobResponse_QNAME, CreateUploadJobResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateRecurringJobRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ebay.com/marketplace/services", name = "createRecurringJobRequest")
    public JAXBElement<CreateRecurringJobRequest> createCreateRecurringJobRequest(CreateRecurringJobRequest value) {
        return new JAXBElement<CreateRecurringJobRequest>(_CreateRecurringJobRequest_QNAME, CreateRecurringJobRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbortJobRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ebay.com/marketplace/services", name = "abortJobRequest")
    public JAXBElement<AbortJobRequest> createAbortJobRequest(AbortJobRequest value) {
        return new JAXBElement<AbortJobRequest>(_AbortJobRequest_QNAME, AbortJobRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbortJobResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ebay.com/marketplace/services", name = "abortJobResponse")
    public JAXBElement<AbortJobResponse> createAbortJobResponse(AbortJobResponse value) {
        return new JAXBElement<AbortJobResponse>(_AbortJobResponse_QNAME, AbortJobResponse.class, null, value);
    }

}
