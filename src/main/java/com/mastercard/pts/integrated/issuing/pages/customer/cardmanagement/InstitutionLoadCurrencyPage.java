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
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_INSTITUTION_PARAMETER_SETUP,
		CardManagementNav.L2_INSTITUTION_LOAD_CURRENCY })
public class InstitutionLoadCurrencyPage extends AbstractBasePage {
	
	private static final Logger logger = LoggerFactory.getLogger(InstitutionLoadCurrencyPage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=currencyCodeAlpha]")
	private MCWebElement currencyCodeAlpha;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=description]")
	private MCWebElement description;
	
	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addLoadCurrencyBtn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "currencyCode:input:dropdowncomponent")
	private MCWebElement selectCurrencyDdwn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement saveBtn;
	
	
	

	public void verifyUiOperationStatus() {
		logger.info("Allowed Load Currency");
		verifyUiOperation("Add Allowed Load Currency");
	}
	public void clickAddcurrency(){
		clickWhenClickable(addLoadCurrencyBtn);
		switchToAddLoadCurrency();
	}
	
	public void addCurrencyDetails(String currency){
		selectByVisibleText(selectCurrencyDdwn,currency);
		waitForLoaderToDisappear();
		clickWhenClickable(saveBtn);
		
	}
	public void switchToAddLoadCurrency() {
		addWicketAjaxListeners(driver());
		switchToIframe(Constants.ADD_ALLOWED_LOAD_CURRENCY);
	} 
	

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(currencyCodeAlpha),
				WebElementUtils.elementToBeClickable(description)
				);
	}
}
