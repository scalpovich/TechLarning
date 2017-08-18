package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.AbstractModelPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;
@Component
@Navigation(tabTitle =  CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_INSTITUTION_PARAMETER_SETUP,
		CardManagementNav.L2_TRANSACTION_REGISTRATION})
public class TransactionRegistrationPage extends AbstractModelPage {
	
	@PageElement(findBy = FindBy.NAME, valueToFind =  "searchDiv:rows:1:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement interchangeDrpDwn;
	
	
	@PageElement(findBy = FindBy.NAME, valueToFind =  "searchDiv:rows:1:componentList:1:componentPanel:input:dropdowncomponent")
	private MCWebElement transactionCode;

	@PageElement(findBy = FindBy.CSS, valueToFind =  "input[type='submit']")
	private MCWebElement searchBtn;

	@PageElement(findBy = FindBy.X_PATH,valueToFind = "//table[@class='dataview']")
	private MCWebElement tableHandle;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value='save']")
	private MCWebElement saveBtn2;
	
	
	private static final Logger logger = LoggerFactory
			.getLogger(TransactionRegistrationPage.class);
	
	
	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(interchangeDrpDwn),
				WebElementUtils.elementToBeClickable(transactionCode),
				WebElementUtils.elementToBeClickable(searchBtn));
	}
	
	
	public void verifyUiOperationStatus() {
		logger.info("Transaction Routing");
		verifySearchButton("Search");
	}

	public void enableTransactionRegistrations() {
 
		List<String> interChangeData = WebElementUtils.getOptionsTextFromSelect(interchangeDrpDwn);
		for (String data : interChangeData) {
			if(!data.trim().contains("Select One")) {
			searchForInterChange(data);
			WebElementUtils.enableAllCheckBoxesInTable(tableHandle);
			saveBtn2.click();
			verifyOperationStatus();
			}
		}
	}

	public void searchForInterChange(String visibleTexts) {
		WebElementUtils.selectDropDownByVisibleText(interchangeDrpDwn,
				visibleTexts);
		clickSearchButton();
		WebElementUtils.visibilityOf(tableHandle);
	}

}
