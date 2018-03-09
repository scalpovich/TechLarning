package com.mastercard.pts.integrated.issuing.pages.agent.transactions;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.agent.transactions.LoadBalanceRequest;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.DBUtility;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.pts.integrated.issuing.utils.simulator.SimulatorUtilities;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = TransactionsNav.TAB_TRANSACTIONS, treeMenuItems = {
		TransactionsNav.L1_LOAD_BALANCE,
		TransactionsNav.L2_LOAD_BALANCE_REQUEST })
public class LoadBalanceRequestPage extends TransactionsAbstractPage {
	private static final String QUERY_TO_ACTIVATE_AGENCY = "update AGENT set STATUS = '00' Where PARENT_AGENT = 'Admin555' and AGENT_ID = 'AGNC001'";
	
	@Autowired
	private DBUtility dbUtility;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value='Search']")
	private MCWebElement searchBtn;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value='Submit']")
	private MCWebElement submitBtn;

	@PageElement(findBy = FindBy.CSS, valueToFind = ".SuccessMessageTxt")
	private MCWebElement applicationSuccessMessage;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#sourceAmount_1")
	private MCWebElement loadAmountTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#sourceCurrency_1")
	private MCWebElement transactionCurrencyDdwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#PayMode")
	private MCWebElement paymentModeDdwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#Documents")
	private MCWebElement documentsVerifiedDdwn;

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.visibilityOf(masterDetailContentTitle),
				WebElementUtils.visibilityOf(deviceNumberTxt));
	}

	@Override
	public void clickSearchButton() {
		SimulatorUtilities.wait(3000);//this to wait till the search button is rendered
		new WebDriverWait(driver(), timeoutInSec).until(
				WebElementUtils.elementToBeClickable(searchBtn)).click();
	}
	
	@Override
	public void clickSubmitButton() {
		new WebDriverWait(driver(), timeoutInSec).until(
				WebElementUtils.elementToBeClickable(submitBtn)).click();
	}

	public String getLoadBalanceRequestSuccessMessage() {
		return new WebDriverWait(driver(), timeoutInSec).until(
				WebElementUtils.visibilityOf(applicationSuccessMessage))
				.getText();
	}
	
	public String getRequestReferenceNumber() {
		String message = getLoadBalanceRequestSuccessMessage();
		return message.substring(message.lastIndexOf(' ') + 1);
	}
	
	public void enterTransactionDetails(String transactionDetails) {
		int rowCount = driver().findElements(By.xpath("//*[@class='dataview']/tbody[1]/tr[@class='even' or @class = 'odd']")).size();
		String[] values = transactionDetails.trim().split(",");
			for (int i = 0; i < values.length ; i++)
			{
				for (int j = 1; j <= rowCount; j++)
				{
					String[] data = values[i].trim().split(":");
					String currencyName = data[0].trim();
					String xpathBuild = "//*[@class='dataview']/tbody[1]/tr[@class='even' or @class='odd']["+j+"]";
					if (driver().findElement(By.xpath(xpathBuild+"/td[2]")).getText().trim().equalsIgnoreCase(currencyName))
					{
						String transactionAmountCSS = "#sourceAmount_"+j;
						driver().findElement(By.cssSelector(transactionAmountCSS)).sendKeys(data[1].trim());
						String transactionCurrencyCSS = "#sourceCurrency_"+j;
						WebElementUtils.retryUntilNoErrors(() -> new Select(driver().findElement(By.cssSelector(transactionCurrencyCSS))).selectByVisibleText(data[0].trim()));
						break;
					}
				}
			}
	}

	public String performLoadBalanceRequestAndGetRequestReferenceNumber(Device device, LoadBalanceRequest details) {
		WebElementUtils.enterText(deviceNumberTxt, device.getDeviceNumber());
		clickSearchButton();
		enterTransactionDetails(details.getTransactionDetails());
		WebElementUtils.scrollDown(driver(), 0, 350);
		WebElementUtils.selectDropDownByVisibleText(paymentModeDdwn, details.getPaymentMode());
		WebElementUtils.selectDropDownByVisibleText(documentsVerifiedDdwn, details.getDocumentsVerified());
		clickSubmitButton();
		return getRequestReferenceNumber();
	}
	
	public void activateAgencyThroughDB() {
			dbUtility.activateAgencyThroughDB(QUERY_TO_ACTIVATE_AGENCY);
	}
}
