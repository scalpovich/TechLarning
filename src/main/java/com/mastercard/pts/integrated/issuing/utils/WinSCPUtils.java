package com.mastercard.pts.integrated.issuing.utils;

import org.openqa.selenium.winium.DesktopOptions;

import com.mastercard.pts.integrated.issuing.workflows.customer.transaction.TransactionWorkflow;


public class WinSCPUtils {
	
	TransactionWorkflow transactionWorkflow;

	public static final String  WIN_SCP_PATH = "C:\\WinSCP\\WinSCP.exe";
	
	private DesktopOptions setWinSCP() {
		DesktopOptions options = new DesktopOptions();
		MiscUtils.reportToConsole(ConstantData.MESSAGE_CONSTANT  + WIN_SCP_PATH );
		options.setApplicationPath(WIN_SCP_PATH );
		return options;
	}
	
	public void launchWinSCP(){
	//	transactionWorkflow.startWiniumDriverWithApplication(setWinSCP());
	}
	
	public void loginToWinSCPApplication(){
		transactionWorkflow.loginToWinSCP();
	}
	
	
}
