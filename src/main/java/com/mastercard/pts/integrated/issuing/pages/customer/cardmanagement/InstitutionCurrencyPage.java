package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.InstitutionCurrency;
import com.mastercard.pts.integrated.issuing.pages.AbstractModelPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_INSTITUTION_PARAMETER_SETUP,
		CardManagementNav.L2_INSTITUTION_CURRENCY })
public class InstitutionCurrencyPage extends AbstractModelPage {
	
	private static final Logger logger = LoggerFactory
			.getLogger(InstitutionCurrencyPage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=currencyCodeAlpha]")
	private MCWebElement currencyCodeAlpha;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=description]")
	private MCWebElement description;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:2:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement status;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[@id='currencyCode']/span/select")
	private MCWebElement currencyCodePopupDwn;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind  = "//td[@id='status']/span/select")
	private MCWebElement statusPopupDwn;

	public void verifyUiOperationStatus() {
		logger.info("Institution Currency");
		verifyUiOperation("Add Institution Currency");
	}

	public void addInstitutionCurrency(InstitutionCurrency currency)
	{
		logger.info("create currency : {}",
				currency.getCurrency());
		clickAddNewButton();

		runWithinPopup(
				"Add Institution Currency",
				() -> {
						addInstituteCurrency(currency);
						verifyNoErrors();
				});

		verifyOperationStatus();
	}
	
	private void addInstituteCurrency(InstitutionCurrency currency) {
		WebElementUtils.selectDropDownByVisibleText(currencyCodePopupDwn,currency.getCurrency());
		WebElementUtils.selectDropDownByVisibleText(statusPopupDwn,currency.getStatus());
		clickSaveButton();
	}	
	
	
	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(currencyCodeAlpha),
				WebElementUtils.elementToBeClickable(description),
				WebElementUtils.elementToBeClickable(status)
				);
	}
}
