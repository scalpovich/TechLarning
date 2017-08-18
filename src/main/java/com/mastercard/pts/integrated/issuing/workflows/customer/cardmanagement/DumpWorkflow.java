package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;

import com.mastercard.pts.integrated.issuing.annotation.Workflow;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.ProcessBatches;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.ProcessBatchesPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.utils.DateUtils;

@Workflow
public class DumpWorkflow {

	@Autowired
	private Navigator navigator;
	
	@Autowired
	private TestContext context;

	private static final String CARDHOLDER_DUMP="Cardholder Dump [CARDHOLDER_DUMP]";
	
	private static final String AUTHORIZATION_DOWNLOAD="Authorization Download [AUTHORIZATION_DOWNLOAD]";
	
	private static final String ACCOUNT_DOWNLOAD="Account Dump [ACCOUNT_DUMP]";
	
	private static final String KYC_DOWNLOAD="KYC Dump[KYC_DUMP]";
	
	
	public void executeDownLoadProcessBatch(ProcessBatches batch){	
		ProcessBatchesPage page = navigator.navigateToPage(ProcessBatchesPage.class);
		page.processDownloadBatch(batch);
		
	}
	
	public String createFilePathToLinuxBox(String fileType, String institutionCode, ProcessBatches batch)
	{
		String partialFileName = null;
		
		switch(batch.getBatchName())
		{
		
		case AUTHORIZATION_DOWNLOAD:
		case CARDHOLDER_DUMP:
		if(((String) context.get("type")).contains("Prepaid"))
			partialFileName=  fileType + institutionCode + "P"+ DateUtils.getDate();
		else if(((String) context.get("type")).contains("Debit"))
			partialFileName= fileType + institutionCode + "D"+ DateUtils.getDate();
		
		break;
		
		
		case ACCOUNT_DOWNLOAD :	
			if(((String) context.get("type")).contains("Prepaid"))
				partialFileName=  fileType +"_"+institutionCode+"_PREPAID_"+"RUNNING"+"_"  +  DateUtils.getDateddMMyyyy();
			else if(((String) context.get("type")).contains("Debit"))
				partialFileName=  fileType +"_"+institutionCode+"__RUNNING"+"_"  +  DateUtils.getDateddMMyyyy();
			 break;

		case KYC_DOWNLOAD:	 
			if(((String) context.get("type")).contains("Prepaid"))
				partialFileName=  fileType +"_"+institutionCode+"_P_" +  DateUtils.getDateddMMyyyy();
			
			else if(((String) context.get("type")).contains("Debit"))
				partialFileName=  fileType +"_"+institutionCode+"_D"+"_"  +  DateUtils.getDateddMMyyyy();
			 break;
			 
			 default:
				  break;
		
		}
		
		return partialFileName;
	}

}
