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

	private static final String CARDHOLDER_DUMP = "Cardholder Dump [CARDHOLDER_DUMP]";
	private static final String AUTHORIZATION_DOWNLOAD = "Authorization Download [AUTHORIZATION_DOWNLOAD]";
	private static final String ACCOUNT_DOWNLOAD = "Account Dump [ACCOUNT_DUMP]";
	private static final String KYC_DOWNLOAD = "KYC Dump[KYC_DUMP]";
	private static final CharSequence DEBIT = "Debit";
	private static final CharSequence PREPAID = "Prepaid";
	private static final CharSequence CREDIT = "Credit";

	public void executeDownLoadProcessBatch(ProcessBatches batch) {
		ProcessBatchesPage page = navigator.navigateToPage(ProcessBatchesPage.class);
		page.processDownloadBatch(batch);
	}

	public String createFilePathToLinuxBox(String fileType, String institutionCode, ProcessBatches batch) {
		String partialFileName = null;
		switch (batch.getBatchName()) {
		case AUTHORIZATION_DOWNLOAD:
		case CARDHOLDER_DUMP:
			partialFileName = forAuthDownloadAndCardHolderDump(fileType, institutionCode, partialFileName);
			break;
		case ACCOUNT_DOWNLOAD:
			partialFileName = forAccountDownload(fileType, institutionCode, partialFileName);
			break;
		case KYC_DOWNLOAD:
			partialFileName = forKycDownload(fileType, institutionCode, partialFileName);
			break;
		default:
			break;
		}
		return partialFileName;
	}

	private String forKycDownload(String fileType, String institutionCode, String partialFileName) {
		String pFileName = partialFileName;
		if (((String) context.get("type")).contains(PREPAID))
			pFileName = fileType + "_" + institutionCode + "_P_" + DateUtils.getDateddMMyyyy();
		else if (((String) context.get("type")).contains(DEBIT))
			pFileName = fileType + "_" + institutionCode + "_D" + "_" + DateUtils.getDateddMMyyyy();
		return pFileName;
	}

	private String forAccountDownload(String fileType, String institutionCode, String partialFileName) {
		String pFileName = partialFileName;
		if (((String) context.get("type")).contains("Prepaid"))
			pFileName = fileType + "_" + institutionCode + "_PREPAID_" + "RUNNING" + "_" + DateUtils.getDateddMMyyyy();
		else if (((String) context.get("type")).contains(DEBIT))
			pFileName = fileType + "_" + institutionCode + "__RUNNING" + "_" + DateUtils.getDateddMMyyyy();
		else if (((String) context.get("type")).contains(CREDIT))
			pFileName = fileType + "_" + institutionCode + "_CREDIT_RUNNING" + "_" + DateUtils.getDateddMMyyyy();
		return pFileName;
	}

	private String forAuthDownloadAndCardHolderDump(String fileType, String institutionCode, String partialFileName) {
		String pFileName = partialFileName;
		if (((String) context.get("type")).contains(PREPAID))
			pFileName = fileType + institutionCode + "P" + DateUtils.getDate();
		else if (((String) context.get("type")).contains(DEBIT))
			pFileName = fileType + institutionCode + "D" + DateUtils.getDate();
		else if (((String) context.get("type")).contains(CREDIT))
			pFileName = fileType + institutionCode + "C" + DateUtils.getDate();
		return pFileName;
	}

}
