package com.mastercard.pts.integrated.issuing.pages.agent.services;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.agent.services.CurrencySetup;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.pts.integrated.issuing.utils.simulator.SimulatorUtilities;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = ServicesNav.TAB_SERVICES, treeMenuItems = { ServicesNav.L1_TRAVEL_CARD_CURRENCY_MANAGEMENT, ServicesNav.L2_CURRENCY_SETUP })
public class CurrencySetupPage extends ServicesAbstractPage {
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value='Search']")
	private MCWebElement searhBtn;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "#accountCurrency")
	private MCWebElement accountCurrencyDdwn;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "#accountPriority")
	private MCWebElement accountPriorityDdwn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "mpts.agentPortal.initiateSettlementAcceptance.add")
	private MCWebElement addButton;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "#remarks")
	private MCWebElement remarksTxt;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "mpts.agentPortal.customerRegistrationDetails.submit")
	private MCWebElement submitButton;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = ".SuccessMessageTxt")
	private MCWebElement successMessage;
		
	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.visibilityOf(masterDetailContentTitle), WebElementUtils.visibilityOf(cardNumberTxt));
	}
	
	public void clickSearchButtonWithDeviceNumber() {
		SimulatorUtilities.wait(3000);//this to wait till the search button is rendered
		new WebDriverWait(driver(), timeoutInSec).until(
				WebElementUtils.elementToBeClickable(searhBtn)).click();
	}
	
	public void clickAddButton() {
		WebElementUtils.scrollDown(driver(), 0, 250);
		new WebDriverWait(driver(), timeoutInSec)
		.until(WebElementUtils.elementToBeClickable(addButton))
		.click();
	}
	
	@Override
	public void clickSubmitButton() {
		WebElementUtils.scrollDown(driver(), 0, 250);
		new WebDriverWait(driver(), timeoutInSec)
		.until(WebElementUtils.elementToBeClickable(submitButton)).click();
	}
	
	public void enterDeviceNumber(String deviceNumber) {
		WebElementUtils.enterText(cardNumberTxt, deviceNumber);
	}
	
	public void enterRemarks(String remarks) {
		WebElementUtils.enterText(remarksTxt, remarks);
	}
	
	public void selectCurrency(String currency) {
		WebElementUtils.selectDropDownByVisibleText(accountCurrencyDdwn, currency);
	}
	
	public void selectPriority(String priority) {
		WebElementUtils.selectDropDownByVisibleText(accountPriorityDdwn, priority);
	}
	
	@Override
	public String getSuccessMessage() {
		return new WebDriverWait(driver(), timeoutInSec)
		.until(WebElementUtils.visibilityOf(successMessage)).getText();
	}
	
	public void setupCurrency(CurrencySetup details, Device device) {
		enterDeviceNumber(device.getDeviceNumber());
		clickSearchButtonWithDeviceNumber();
		String[] values = details.getCurrencyWithPriority().trim().split(",");
		for (int i = 0; i < values.length ; i++) {
			String[] data = values[i].trim().split(":");
			selectCurrency(data[0].trim());
			selectPriority(data[1].trim());
			clickAddButton();
		}
		enterRemarks(details.getRemarks());
		clickSubmitButton();
	}
}