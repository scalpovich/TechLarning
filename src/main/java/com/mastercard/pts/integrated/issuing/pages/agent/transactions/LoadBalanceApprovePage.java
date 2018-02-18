package com.mastercard.pts.integrated.issuing.pages.agent.transactions;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.agent.transactions.LoadBalanceRequest;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.pts.integrated.issuing.utils.simulator.SimulatorUtilities;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = TransactionsNav.TAB_TRANSACTIONS, treeMenuItems = {
		TransactionsNav.L1_LOAD_BALANCE,
		TransactionsNav.L2_LOAD_BALANCE_APPROVE })
public class LoadBalanceApprovePage extends TransactionsAbstractPage {
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value='Search']")
	private MCWebElement searchBtn;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "#Submit")
	private MCWebElement submitBtn;

	@PageElement(findBy = FindBy.CSS, valueToFind = ".SuccessMessageTxt")
	private MCWebElement applicationSuccessMessage;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value='Modify']")
	private MCWebElement modifyBtn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#mpts_agentPortal_modifyChecker_approve")
	private MCWebElement modifyApproveBtn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#Remark")
	private MCWebElement memoTxt;

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
	
	public void clickModifyButton() {
		new WebDriverWait(driver(), timeoutInSec).until(
				WebElementUtils.elementToBeClickable(modifyBtn)).click();
	}

	public void clickModifyCheckerApproveButton() {
		new WebDriverWait(driver(), timeoutInSec).until(
				WebElementUtils.elementToBeClickable(modifyApproveBtn)).click();
	}

	public String getLoadBalanceApproveSuccessMessage() {
		return new WebDriverWait(driver(), timeoutInSec).until(
				WebElementUtils.visibilityOf(applicationSuccessMessage))
				.getText();
	}
	
	public void selectRecordWithReferenceNumber(String referenceNumber) {
		SimulatorUtilities.wait(3000);//this to wait till the table gets loaded
		int rowCount = driver().findElements(By.xpath("//*[@class='dataview']/tbody/tr")).size();
		for (int i = 1; i <= rowCount; i++)
		{
			String xpathBuild = "//*[@class='dataview']/tbody/tr["+i+"]";
			if (driver().findElement(By.xpath(xpathBuild+"//td[2]")).getText().trim().equalsIgnoreCase(referenceNumber))
			{
				WebElementUtils.retryUntil(driver().findElement(By.xpath(xpathBuild+"//td[2]"))::click,
								() -> WebElementUtils
										.hasClass(
												getFinder().findOne(FindBy.X_PATH,
														xpathBuild),
												"select"));
				break;
			}
		}
	}

	public void performLoadBalanceApprove(Device device, LoadBalanceRequest details) {
		WebElementUtils.enterText(deviceNumberTxt, device.getDeviceNumber());
		clickSearchButton();
		selectRecordWithReferenceNumber(details.getLoadRequestReferenceNumber());
		clickModifyButton();
		driver().switchTo().alert().accept();
		WebElementUtils.scrollDown(driver(), 0, 350);
		WebElementUtils.enterText(memoTxt, ConstantData.GENERIC_DESCRIPTION);
		clickModifyCheckerApproveButton();
	}
}