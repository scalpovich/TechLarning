package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.HighRiskMCC;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_INSTITUTION_PARAMETER_SETUP,
		CardManagementNav.L2_RISK_ASSESMENT_MANAGEMENT,
		CardManagementNav.L3_HIGH_RISK_MCC
		})
public class HighRiskMCCPage extends AbstractBasePage {

	private static final Logger logger = LoggerFactory
			.getLogger(HighRiskMCCPage.class);
	
	public static final String MCC_CODE="Action Auto Rental [3354]";

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement mccCode;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "mccCode:input:dropdowncomponent")
	private MCWebElement mccCodePopupDDwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#effectiveDate")
	private MCWebElement effectiveDateDPkr;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#endDate")
	private MCWebElement endDateDPkr;
	
	public void verifyUiOperationStatus() {
		logger.info("High Risk MCC");
		addHighRiskMCC();
		verifyUiOperation("Add High Risk MCC");
	}
	
	public void addHighRiskMCC() {
		logger.info("Add High Risk MCC");
		clickAddNewButton();
		runWithinPopup("High Risk MCC", () -> {
			addNewHighRiskMCC();
			Boolean addedRecord=verifyDuplicateAndClickCancel();
			if (!addedRecord) {
				identifyAddedRecordinTableAndDelete(MCC_CODE);
			}
		});
	}

	private void addNewHighRiskMCC() {
		WebElementUtils.selectDropDownByVisibleText(mccCodePopupDDwn, MCC_CODE);
		WebElementUtils.pickDate(effectiveDateDPkr, futureDate);
		WebElementUtils.pickDate(endDateDPkr, futureDate);
		clickSaveButton();
	}
	
	public void addHighRiskMerchantCategoryCode(HighRiskMCC highRiskMCC) {
		logger.info("Add High Risk MCC");
		deleteExistingRecord(highRiskMCC.getMccCode());
		clickAddNewButton();
		runWithinPopup("High Risk MCC", () -> {
			addNewHighRiskMerchantCategoryCode(highRiskMCC.getMccCode());
		});
	}

	private void addNewHighRiskMerchantCategoryCode(String mccCode) {
		WebElementUtils.selectDropDownByVisibleText(mccCodePopupDDwn, mccCode);
		WebElementUtils.pickDate(effectiveDateDPkr, futureDate);
		WebElementUtils.pickDate(endDateDPkr, futureDate);
		clickSaveButton();
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.elementToBeClickable(mccCode));
	}
}