package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;

import com.mastercard.pts.integrated.issuing.annotation.Workflow;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DevicePromotionPlan;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.DevicePromotionPlanPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Workflow
public class DevicePromotionPlanWorkFlow {

	@Autowired
	private Navigator navigator;
	
    @Autowired
    private TestContext context;
    
    public void addNewDevicePromtionPlan(DevicePromotionPlan devicePromotionPlan) {
    	DevicePromotionPlanPage page = navigator.navigateToPage(DevicePromotionPlanPage.class);
		page.createDevicePromotionPlan(devicePromotionPlan);
	}
}