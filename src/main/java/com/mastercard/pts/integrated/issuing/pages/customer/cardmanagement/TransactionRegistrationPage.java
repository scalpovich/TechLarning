package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.jbehave.core.model.ExamplesTable;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.AbstractModelPage;
import com.mastercard.pts.integrated.issuing.pages.customer.navigation.CardManagementNav;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1INSTITUTION_PARAMETER_SETUP, CardManagementNav.L2TRANSACTIONREGISTRATION })
@Component
@Navigation(tabTitle =  CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_INSTITUTION_PARAMETER_SETUP,
		CardManagementNav.L2_TRANSACTION_REGISTRATION})
public class TransactionRegistrationPage extends AbstractModelPage {
	private static final Logger logger = LoggerFactory
			.getLogger(TransactionRegistrationPage.class);
	

	@PageElement(findBy = FindBy.NAME, valueToFind =  "searchDiv:rows:1:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement interchangeDrpDwn;
	
	
	@PageElement(findBy = FindBy.NAME, valueToFind =  "searchDiv:rows:1:componentList:1:componentPanel:input:dropdowncomponent")
	private MCWebElement transactionCode;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement interchangeTypeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:searchButtonPanel:buttonCol:searchButton")
	private MCWebElement searchBtn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@type = 'checkbox'][@name ='selectAll']")
	private MCWebElement BusinessDate;

	@PageElement(findBy = FindBy.NAME, valueToFind = "Save")
	private MCWebElement save;

@PageElement(findBy = FindBy.X_PATH,valueToFind = "//table[@class='dataview']")
	private MCWebElement tableHandle;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value='save']")
	private MCWebElement saveBtn2;

	@PageElement(findBy = FindBy.CLASS, valueToFind = "feedbackPanelINFO")
	private MCWebElement ConfirmationMsgTxt;

	public void addtransactionregistration() {
		waitForElementVisible(BusinessDate);
		BusinessDate.click();
		CustomUtils.ThreadDotSleep(3000);
		save.click();
	}

	public void listTransactiontypes(String interchange) {
		selectByVisibleText(interchangeTypeDDwn, interchange);
		addWicketAjaxListeners(getFinder().getWebDriver());
		ClickButton(searchBtn);
	}

	public boolean checkTransactionChannelEnabled(ExamplesTable TransactionType) {
		for (int i = 0; i < TransactionType.getRows().size(); i++) {
			String DropDownValue = TransactionType.getRow(i).get(TransactionType.getHeaders().get(0));
			WebElement OriginatedFromATM = getFinder().getWebDriver().findElement(By.xpath(
					"//td[contains(.,'" + DropDownValue + "')]/following::td[2]/span/input[@fld_fqn='orgFromAtm']"));
			WebElement OriginatedFromAPI = getFinder().getWebDriver().findElement(By.xpath(
					"//td[contains(.,'" + DropDownValue + "')]/following::td[5]/span/input[@fld_fqn='orgFromApi']"));
			WebElement OriginatedFromCustPortal = getFinder().getWebDriver().findElement(By.xpath("//td[contains(.,'"
					+ DropDownValue + "')]/following::td[6]/span/input[@fld_fqn='orgFromCustPortal']"));
			WebElement OriginatedFromAgentPortal = getFinder().getWebDriver().findElement(By.xpath("//td[contains(.,'"
					+ DropDownValue + "')]/following::td[7]/span/input[@fld_fqn='orgFromAgentPortal']"));
			WebElement OriginatedFromCardPortal = getFinder().getWebDriver().findElement(By.xpath("//td[contains(.,'"
					+ DropDownValue + "')]/following::td[8]/span/input[@fld_fqn='orgFromCardPortal']"));

			Assert.assertEquals(true, OriginatedFromAPI.isEnabled());
			Assert.assertEquals(true, OriginatedFromCustPortal.isEnabled());

			if (DropDownValue.equals(Constants.Balance_Inquiry_String)) {
				Assert.assertEquals(true, OriginatedFromAgentPortal.isEnabled());
				Assert.assertEquals(true, OriginatedFromCardPortal.isEnabled());
			}
			if (DropDownValue.equals(Constants.Purchase_Auth_String)) {
				WebElement OriginatedFromPOS = getFinder().getWebDriver().findElement(By.xpath("//td[contains(.,'"
						+ DropDownValue + "')]/following::td[3]/span/input[@fld_fqn='orgFromPos']"));
				WebElement OriginatedFromEcom = getFinder().getWebDriver().findElement(By.xpath("//td[contains(.,'"
						+ DropDownValue + "')]/following::td[4]/span/input[@fld_fqn='orgFromEcom']"));
				Assert.assertEquals(true, OriginatedFromPOS.isEnabled());
				Assert.assertEquals(true, OriginatedFromEcom.isEnabled());
			}
			if (!DropDownValue.equals(Constants.Purchase_Auth_String)) {
				Assert.assertEquals(true, OriginatedFromATM.isEnabled());
			}
		}
		return true;
	}

	public String selectTransaction(String TransactionType) {
		WebElement OriginatedFromATM = getFinder().getWebDriver().findElement(By.xpath(
				"//td[contains(.,'" + TransactionType + "')]/following::td[2]/span/input[@fld_fqn='orgFromAtm']"));
		WebElement OriginatedFromAPI = getFinder().getWebDriver().findElement(By.xpath(
				"//td[contains(.,'" + TransactionType + "')]/following::td[5]/span/input[@fld_fqn='orgFromApi']"));
		WebElement OriginatedFromCustPortal = getFinder().getWebDriver().findElement(By.xpath("//td[contains(.,'"
				+ TransactionType + "')]/following::td[6]/span/input[@fld_fqn='orgFromCustPortal']"));

		if (!OriginatedFromATM.isSelected()) {
			OriginatedFromATM.click();
		}
		if (!OriginatedFromAPI.isSelected()) {
			OriginatedFromAPI.click();
		}
		if (!OriginatedFromCustPortal.isSelected()) {
			OriginatedFromCustPortal.click();
		}
		ClickButton(save);
		return ConfirmationMsgTxt.getText().split("\\n")[0];
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

public void verifyUiOperationStatus() {
		logger.info("Transaction Routing");
		verifySearchButton("Search");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(interchangeDrpDwn),
				WebElementUtils.elementToBeClickable(transactionCode),
				WebElementUtils.elementToBeClickable(searchBtn));
	}

}
