package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = { CardManagementNav.L1_INSTITUTION_PARAMETER_SETUP,
		CardManagementNav.L2_RISK_ASSESMENT_MANAGEMENT, CardManagementNav.L3_HIGH_RISK_MERCHANT_LOCATION })
public class HighRiskMerchantLocationPage extends AbstractBasePage {

	private static final Logger logger = LoggerFactory.getLogger(HighRiskMerchantLocationPage.class);
	
	public static final String TEXT = "123"+CustomUtils.randomAlphaNumeric(2);

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

	public void verifyUiOperationStatus() {
		logger.info("High Risk Merchant Location");
		addHighRiskMerchantLocation();
		verifyUiOperation("Add High Risk Merchant Location");
	}

	public void addHighRiskMerchantLocation() {
		logger.info("Add High Risk Merchant Location");
		clickAddNewButton();
		runWithinPopup("High Risk Merchant Location", () -> {
			addNewHighRiskMerchantLocation();
			verifyDuplicateAndClickCancel();
		});
	}

	private void addNewHighRiskMerchantLocation() {
		WebElementUtils.enterText(acquirerId, TEXT);
		WebElementUtils.enterText(merchantId, TEXT);
		WebElementUtils.enterText(merchantLocationDescription, TEXT);
		WebElementUtils.enterText(merchantLocationId, TEXT);
		WebElementUtils.pickDate(effectiveDateDPkr, futureDate);
		WebElementUtils.pickDate(endDateDPkr, futureEndDate);
		clickSaveButton();
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.elementToBeClickable(acquirerId), WebElementUtils.elementToBeClickable(merchantId),
				WebElementUtils.elementToBeClickable(merchantLocationId));
	}
}
