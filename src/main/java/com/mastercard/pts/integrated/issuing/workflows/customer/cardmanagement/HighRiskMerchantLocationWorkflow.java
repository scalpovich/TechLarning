package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;

import com.mastercard.pts.integrated.issuing.annotation.Workflow;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.HighRiskMerchantLocation;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.HighRiskMerchantLocationPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;


@Workflow
public class HighRiskMerchantLocationWorkflow {

	@Autowired
	private Navigator navigator;

	private HighRiskMerchantLocationPage page;

	public void createhighRiskMerchantLocationWithDetails(HighRiskMerchantLocation plan) {
		page = navigator.navigateToPage(HighRiskMerchantLocationPage.class);
	    page.addHighRiskMerchantLocation(plan);
	}
	
	public String getFeedbackText() {
		page.SwitchToDefaultFrame();	
		return page.getFeedbackText();
	}
	
	public boolean isNoRecordsFoundInTableView(HighRiskMerchantLocation plan) {
		page.enterMerchantLocationIdInSearchBox(plan);
		page.clickSearchButton();
		
		return page.isNoRecordsFoundInTableView();
	}
	
	public void saveWithoutMandatoryFields(){
		page = navigator.navigateToPage(HighRiskMerchantLocationPage.class);
	    page.saveWithoutMandatoryFields();
	}
	
	public List<WebElement> validateError(){
	   return page.getValidationErrors();
	}

}
