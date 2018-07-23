package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;


import java.util.Arrays;
import java.util.Collection;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.HighRiskMerchantLocation;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = { CardManagementNav.L1_INSTITUTION_PARAMETER_SETUP,
		CardManagementNav.L2_RISK_ASSESMENT_MANAGEMENT, CardManagementNav.L3_HIGH_RISK_MERCHANT_LOCATION })
public class HighRiskMerchantLocationPage extends AbstractBasePage {

	private static final Logger logger = LoggerFactory.getLogger(HighRiskMerchantLocationPage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=acquirerId]")
	private MCWebElement acquirerId;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=merchantId]")
	private MCWebElement merchantId;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=merchantLocationId]")
	private MCWebElement merchantLocationId;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=description]")
	private MCWebElement merchantLocationDescription;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#effectiveDate")
	private MCWebElement effectiveDateDPkr;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#endDate")
	private MCWebElement endDateDPkr;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "span.feedbackPanelINFO")
	private MCWebElement feedbackPanelLbl;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn='merchantLocationId']")
	private MCWebElement planCodeSearchTxt;
	
	public void verifyUiOperationStatus() {
		logger.info("High Risk Merchant Location");
		verifyUiOperation("Add High Risk Merchant Location");
	}
	
	public void addAcquireeId(HighRiskMerchantLocation plan){
		enterText(acquirerId, plan.getAcquireeId());
	}
	
	public void addMerchantId(HighRiskMerchantLocation plan){
		enterText(merchantId, plan.getMerchantId());
	}
	
	public void addMerchantLocationDescription(HighRiskMerchantLocation plan){
		enterText(merchantLocationDescription, plan.getMerchantLocationDescription());
	}
	
	public void addMerchantLocationId(HighRiskMerchantLocation plan){
		enterText(merchantLocationId, plan.getMerchantLocationId());
	}
	
	public void addEffectiveDate(){
		WebElementUtils.pickDate(effectiveDateDPkr, futureDate);
	}
	
	private void addEndDate(){
		WebElementUtils.pickDate(endDateDPkr, futureEndDate);
	} 

	public void addHighRiskMerchantLocation(HighRiskMerchantLocation plan) {
		logger.info("Add High Risk Merchant Location");
		clickAddNewButton();
		runWithinPopup("High Risk Merchant Location", () -> {
			addAcquireeId(plan);
			addMerchantId(plan);
			addMerchantLocationDescription(plan);
			addMerchantLocationId(plan);
			addEffectiveDate();
			addEndDate();
			clickSaveButton();
			verifyDuplicateAndClickCancel();
		});
	}
	
	public String getFeedbackText() {
		return feedbackPanelLbl.getText();
	}
	
	public void enterMerchantLocationIdInSearchBox(HighRiskMerchantLocation plan) {
		enterValueinTextBox(planCodeSearchTxt, plan.getMerchantLocationId());
	}
	
	public Boolean isNoRecordsFoundInTableView() {
		return isNoRecordsFoundInTable();
	}
	
	public void saveWithoutMandatoryFields(){
		clickAddNewButton();
		switchToIframe("Add High Risk Merchant Location");
		clickSaveButton();
	}
	
	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.elementToBeClickable(acquirerId), WebElementUtils.elementToBeClickable(merchantId),
				WebElementUtils.elementToBeClickable(merchantLocationId));
	}
}
