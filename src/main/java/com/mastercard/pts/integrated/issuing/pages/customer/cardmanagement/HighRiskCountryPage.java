package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = { CardManagementNav.L1_INSTITUTION_PARAMETER_SETUP,
		CardManagementNav.L2_RISK_ASSESMENT_MANAGEMENT, CardManagementNav.L3_HIGH_RISK_COUNTRY })
public class HighRiskCountryPage extends AbstractBasePage {
	
	@Autowired
	TestContext context;

	private static final Logger logger = LoggerFactory.getLogger(HighRiskCountryPage.class);
	
	public static final String HIGH_RISK_COUNTRY="ALGERIA [012]"; 

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement countryCodeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "countryCode:input:dropdowncomponent")
	private MCWebElement countryCodePopupDDwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#effectiveDate")
	private MCWebElement effectiveDateDPkr;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#endDate")
	private MCWebElement endDateDPkr;

	public void verifyUiOperationStatus() {
		logger.info("High Risk Country");
		addHighRiskCountry();
		verifyUiOperation("Add High Risk Country");
	}

	public void addHighRiskCountry() {
		logger.info("Add High Risk Country");
		clickAddNewButton();
		runWithinPopup("High Risk Country", () -> {
			addNewHighRiskCountry();
			Boolean addedRecord=verifyDuplicateAndClickCancel();
			if (!addedRecord) {
				identifyAddedRecordinTableAndDelete(HIGH_RISK_COUNTRY);
			}
		});
	}

	private void addNewHighRiskCountry() {
		WebElementUtils.selectDropDownByIndex(countryCodePopupDDwn, 1);
		WebElementUtils.pickDate(effectiveDateDPkr, futureDate);
		WebElementUtils.pickDate(endDateDPkr, futureDate);
		clickSaveButton();
	}
	
	public void addAndVerifyHighRiskCountry() {
		logger.info("Add High Risk Country");
		deleteExistingRecord(context.get(ConstantData.HIGH_RISK_COUNTRY));
		clickAddNewButton();
		runWithinPopup("High Risk Country", () -> {
			addNewHighRiskCountryAndSave();
		});
	}

	private void addNewHighRiskCountryAndSave() {
		selectByVisibleText(countryCodePopupDDwn, context.get(ConstantData.HIGH_RISK_COUNTRY));
		WebElementUtils.pickDate(effectiveDateDPkr, futureDate);
		WebElementUtils.pickDate(endDateDPkr, futureEndDate);
		clickSaveButton();
	}
	
	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.elementToBeClickable(countryCodeDDwn));
	}
}