package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import java.io.File;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.mastercard.pts.integrated.issuing.annotation.Workflow;
import com.mastercard.pts.integrated.issuing.configuration.LinuxBox;
import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.BulkDeviceGenerationBatch;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.BulkDeviceRequest;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceProductionBatch;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.PinGenerationBatch;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.PreProductionBatch;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.ProcessBatches;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.VisaFeeCollection;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.BatchJobHistoryPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.BatchTraceHistoryPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.BulkDeviceGenerationBatchPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.DeviceProductionBatchPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.DeviceProductionBulkDeviceRequestPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.PinGenerationBatchPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.PreProductionBatchPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.ProcessBatchesPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.workflows.MenuFlows;

@Workflow
public class BatchProcessWorkflow extends MenuFlows{

	@Autowired
	private Navigator navigator;
	
	@Autowired
	private LinuxBox linuxBox;
	
	@Autowired
	private KeyValueProvider keyProvider;
	
	@Autowired
	private TestContext context;
	
	protected  static final Logger logger = LoggerFactory.getLogger(BatchProcessWorkflow.class); 

	public String createBulkDeviceRequest(BulkDeviceRequest request){	
		DeviceProductionBulkDeviceRequestPage page = navigator.navigateToPage(DeviceProductionBulkDeviceRequestPage.class);
		return page.addBulkDeviceRequestdata(request);
	}

	public void processBulkDeviceGenerationBatch(BulkDeviceGenerationBatch batch){	
		BulkDeviceGenerationBatchPage page = navigator.navigateToPage(BulkDeviceGenerationBatchPage.class);
		page.processBulkDeviceGenerationBatch(batch);
	}
    public void processPreProductionBatch(PreProductionBatch batch){
		PreProductionBatchPage page = navigator.navigateToPage(PreProductionBatchPage.class);
		page.processPreProductionBatch(batch);
	}

	public void processDeviceProductionBatch(DeviceProductionBatch batch){
       	DeviceProductionBatchPage page = navigator.navigateToPage(DeviceProductionBatchPage.class);
		page.processDeviceProductionBatch(batch);
	}
	
	public String processPinGenerationBatch(PinGenerationBatch batch){
		PinGenerationBatchPage page = navigator.navigateToPage(PinGenerationBatchPage.class);
		return page.processPinGenerationBatch(batch);
	}
	
	public boolean searchBatchTraceHistory(String jobId){
		BatchTraceHistoryPage page = navigator.navigateToPage(BatchTraceHistoryPage.class);
		return page.searchJob(jobId);
	}

	public boolean searchBatchJobHistory(String jobId){
		BatchJobHistoryPage page = navigator.navigateToPage(BatchJobHistoryPage.class);
		return page.searchJob(jobId);
	}

	public String processSystemInternalProcessingBatch(ProcessBatches batch){
		ProcessBatchesPage page = navigator.navigateToPage(ProcessBatchesPage.class);
		return page.processSystemInternalProcessingBatch(batch);
		
	}
public void processDownloadBatch(ProcessBatches batch){
		ProcessBatchesPage page = navigator.navigateToPage(ProcessBatchesPage.class);
		page.processDownloadBatch(batch);
		
	}


	public String processSystemInternalProcessingBatchWithoutDateCheck(ProcessBatches batch){
		ProcessBatchesPage page = navigator.navigateToPage(ProcessBatchesPage.class);
		return page.processSystemInternalProcessingBatchWithoutDateCheck(batch);
		
	}

	public String processSystemInternalProcessingMatchingBatch(ProcessBatches batch){
		ProcessBatchesPage page = navigator.navigateToPage(ProcessBatchesPage.class);
		return page.processSystemInternalProcessingBatchMatchingBatch(batch);
		
	}

	public String processIpmDownloadBatch(ProcessBatches batch){
		ProcessBatchesPage page = navigator.navigateToPage(ProcessBatchesPage.class);
		return page.ipmDownloadBatch(batch);
	}
	public String processVisaOutgoingBatch(ProcessBatches batch){
		ProcessBatchesPage page = navigator.navigateToPage(ProcessBatchesPage.class);
		return page.visaOutgoingDownloadBatch(batch);
	}
	
	public String getTransactionFromFile(File file)
	{
		String tranLine="";
		Scanner scnr = null;
		try{
		 scnr = new Scanner(file);
		while(scnr.hasNextLine()){
		   String line = scnr.nextLine();
		   if(line.startsWith(ConstantData.VISA_FEE_COLLECTION_TRANSACTIONCODE))
		   {
			   tranLine=line;
		   }
		}
		}catch(Exception e){
			 logger.error("Error in Getting Transaction Line from file",  e);
		}	
		finally
		{
			if(scnr !=null)
			scnr.close();
		}
		return tranLine;
	
	}
	
	public boolean validateVisaOutGoingFile(File visaOutGoingFile)
	{	VisaFeeCollection visafeecollection=VisaFeeCollection.createWithProvider(keyProvider);
		Device device=context.get(ContextConstants.DEVICE);
		String tranLine=getTransactionFromFile(visaOutGoingFile);
		return  tranLine.substring(61, 73).contains(visafeecollection.getSourceAmount()) && tranLine.substring(27, 43).equals(device.getDeviceNumber()) ;
	}
	
	
}
