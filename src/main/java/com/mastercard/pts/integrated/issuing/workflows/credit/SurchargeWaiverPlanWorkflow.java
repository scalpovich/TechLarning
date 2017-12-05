package com.mastercard.pts.integrated.issuing.workflows.credit;

import junit.framework.Assert;

import org.springframework.beans.factory.annotation.Autowired;

import com.mastercard.pts.integrated.issuing.annotation.Workflow;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.SurchargeWailverPlan;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.SurchargeWailverPlanPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.DatePicker;

@Workflow
public class SurchargeWaiverPlanWorkflow {
	@Autowired
	private Navigator navigator;
	
	public void verifyValidSurchargeWaiverPlanCode(SurchargeWailverPlan surchargeWailverPlan,DatePicker datePicker,String tagName,String expectedValue) {
		SurchargeWailverPlanPage page = navigator.navigateToPage(SurchargeWailverPlanPage.class);
		
		Assert.assertEquals("WaiverPlan code is not as per the format", true, page.enterWaiverPlanValid(surchargeWailverPlan));
		Assert.assertEquals("WaiverPlan description is not as per the format", true, page.enterWaiverPlanDescriptionValid(surchargeWailverPlan));
		Assert.assertEquals("CurrencyValidation error message is not displayed",true, page.currencyValidation());
		page.currencySelect();
		page.addDetailsButtonClick();
		page.addNewButtonClick();
		page.saveButtonClick();
		CustomUtils.ThreadDotSleep(3000);
		Assert.assertTrue("interchange error message is not displayed",page.interchangeMsgValidation());
		Assert.assertTrue("mcg error message is not displayed",page.mcgMsgValidation());
		Assert.assertTrue("waiverTransaction error message is not displayed",page.waiverTransactionMsgDescriptionValidation());
		Assert.assertTrue("effectiveDate error message is not displayed",page.effectiveDateErrorMsgValidation());
		Assert.assertTrue("endDate error message is not displayed",page.endDateErrorMsgValidation());
		Assert.assertTrue("surchargeRate error message is not displayed",page.surchargeRateErrorMsgValidation());
		page.interchangeSelect();
		page.mcgSelect();
		page.enterWaiverTransactionDescription(surchargeWailverPlan);
		page.effectiveDateSelect(datePicker, surchargeWailverPlan);
		page.endDateSelect(datePicker, surchargeWailverPlan);
		page.enterSurchargeRate(surchargeWailverPlan);
		page.saveButtonClick();
		page.saveButtonClickInner();
		Assert.assertTrue("Record is not added successfully",page.successMessageDiplay());
	}
	public void verifyInvalidSurchargeWaiverPlanCode(SurchargeWailverPlan surchargeWailverPlan) {
		SurchargeWailverPlanPage page = navigator.navigateToPage(SurchargeWailverPlanPage.class);
		Assert.assertEquals("WaiverPlan code is not as per the format", false, page.enterWaiverPlanInvalid(surchargeWailverPlan));
		Assert.assertEquals("waiverPlanCodeErrorMessage is displayed",Constants.WAIVERPLAN_CODE_ERRMSG, page.waiverPlanCodeErrorMessage());
		Assert.assertEquals("WaiverPlan description is not as per the format", false, page.enterWaiverPlanDescriptionInvalid(surchargeWailverPlan));
		Assert.assertEquals("waiverPlanCodeErrorMessage is displayed",Constants.WAIVERPLAN_DESC_ERRMSG, page.waiverPlanDescriptionErrorMessage());
		page.cancelButtonClick();
		
	}
}
