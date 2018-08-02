package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.DeviceGenerationBatchPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.utils.simulator.SimulatorUtilities;

@Component
public class DeviceGenerationBatchFlows {

	@Autowired
	Navigator navigator;
	
	private DeviceGenerationBatchPage deviceGenerationBatchPage;
	
	protected  static final Logger logger = LoggerFactory.getLogger(DeviceGenerationBatchFlows.class);
	
	public void deviceGenerationBatchExecution(){
		deviceGenerationBatchPage = navigator.navigateToPage(DeviceGenerationBatchPage.class);
		deviceGenerationBatchPage.allBatchNumberRetrieval();
		SimulatorUtilities.wait(30000);
		deviceGenerationBatchPage.identifyBatchNumberToProcess();
		deviceGenerationBatchPage.processAppropriateBatchForApplication();
	}	
	
	public void deviceGenerationFirstBatchExecution(){
		deviceGenerationBatchPage=navigator.navigateToPage(DeviceGenerationBatchPage.class);
		deviceGenerationBatchPage.processFirstBatch();
	}

     public void deviceGenerationBatchExecutionForFileUpload(){
		deviceGenerationBatchPage=navigator.navigateToPage(DeviceGenerationBatchPage.class);
		deviceGenerationBatchPage.processAllClick();
	}
}
