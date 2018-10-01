package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.mastercard.pts.integrated.issuing.annotation.Workflow;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.CloseBatchPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.utils.simulator.SimulatorUtilities;

@Workflow
public class CloseBatchFlows {

	@Autowired
	Navigator navigator;
	
	private CloseBatchPage closeBatchPage;
	
	protected  static final Logger logger = LoggerFactory.getLogger(CloseBatchFlows.class);
	
	public void closeBatchExecution(){
		closeBatchPage = navigator.navigateToPage(CloseBatchPage.class);
		closeBatchPage.allBatchNumberRetrieval();
		SimulatorUtilities.wait(5000);
		closeBatchPage.identifyBatchNumberToProcess();
		closeBatchPage.processAppropriateBatchForApplication();
	}
	
	public void closeFirstBatchExecution(){
		closeBatchPage=navigator.navigateToPage(CloseBatchPage.class);
		closeBatchPage.processFirstBatch();
	}

    public void closeBatchExecutionForFileUpload(){
		closeBatchPage=navigator.navigateToPage(CloseBatchPage.class);
		closeBatchPage.processAllClick();
	}
}
