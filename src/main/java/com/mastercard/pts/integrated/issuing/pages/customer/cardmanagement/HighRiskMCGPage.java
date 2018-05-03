package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.HighRiskMCG;
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
		CardManagementNav.L3_HIGH_RISK_MCG
		})
public class HighRiskMCGPage extends AbstractBasePage {

	private static final Logger logger = LoggerFactory
			.getLogger(HighRiskMCGPage.class);

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement mcgCode;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "mcgCode:input:dropdowncomponent")
	private MCWebElement mcgCodePopupDDwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#effectiveDate")
	private MCWebElement effectiveDateDPkr;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#endDate")
	private MCWebElement endDateDPkr;



	public void verifyUiOperationStatus() {
		logger.info("High Risk MCG");
		//addHighRiskMCG();
		verifyUiOperation("Add High Risk MCG");
	}
	
	public void addHighRiskMCG() {
		logger.info("Add High Risk MCG");
		clickAddNewButton();
		runWithinPopup("High Risk MCG", () -> {
			addNewHighRiskMCG();
			verifyDuplicateAndClickCancel();
		});
	}

	private void addNewHighRiskMCG() {
		WebElementUtils.selectDropDownByIndex(mcgCodePopupDDwn, 1);
		WebElementUtils.pickDate(effectiveDateDPkr, futureDate);
		WebElementUtils.pickDate(endDateDPkr, futureDate);
		clickSaveButton();
	}
	
	public void addHighRiskMerchantCategoryGroup(HighRiskMCG highRiskMCG) {
		logger.info("Add High Risk MCG");
		clickAddNewButton();
		runWithinPopup("High Risk MCG", () -> {
			addNewHighRiskMCG();
			verifyDuplicateAndClickCancel();
		});
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.elementToBeClickable(mcgCode));
	}
}
