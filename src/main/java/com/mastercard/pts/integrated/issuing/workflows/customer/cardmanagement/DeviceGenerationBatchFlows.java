package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.DeviceGenerationBatchPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;


@Component
public class DeviceGenerationBatchFlows {

	@Autowired
	Navigator navigator;
	
	private DeviceGenerationBatchPage deviceGenerationBatchPage;
	
	protected  static final Logger logger = LoggerFactory.getLogger(DeviceGenerationBatchFlows.class);
	
	public void deviceGenerationBatchExecution(){
		deviceGenerationBatchPage = navigator.navigateToPage(DeviceGenerationBatchPage.class);		
		deviceGenerationBatchPage.processAppropriateBatchForApplication();
	}	
	
	public void deviceGenerationFirstBatchExecution(){
		deviceGenerationBatchPage = navigator.navigateToPage(DeviceGenerationBatchPage.class);
		deviceGenerationBatchPage.processFirstBatch();
	}

     public void deviceGenerationBatchExecutionForFileUpload(){
		deviceGenerationBatchPage=navigator.navigateToPage(DeviceGenerationBatchPage.class);
		deviceGenerationBatchPage.processAllBatch();
	}
     
	public void deviceGenerationAllBatchExecution() {
		deviceGenerationBatchPage = navigator.navigateToPage(DeviceGenerationBatchPage.class);
		deviceGenerationBatchPage.processAllBatch();
		deviceGenerationBatchPage.clickProcessALL();
	}
}
