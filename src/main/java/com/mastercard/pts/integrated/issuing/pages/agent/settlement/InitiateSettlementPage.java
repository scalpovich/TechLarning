package com.mastercard.pts.integrated.issuing.pages.agent.settlement;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.utils.SimulatorUtilities;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = SettlementNav.TAB_SETTLEMENT, treeMenuItems = { SettlementNav.L1_INITIATE_SETTLEMENT })
public class InitiateSettlementPage extends AbstractBasePage {
	private static final Logger logger = LoggerFactory.getLogger(InitiateSettlementPage.class);

	@Value("${default.wait.timeout_in_sec}")
	private long timeoutInSec;

	// main screen locators
	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value='Search']")
	private MCWebElement searchBtn;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "div .Title")
	private MCWebElement masterDetailContentTitle;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#brancId")
	private MCWebElement brancIdDDwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#programCode")
	private MCWebElement programCodeDDwn;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value='Modify']")
	private MCWebElement modifyBtn;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "#amountToBeSettled")
	private MCWebElement amountToBeSettledTxt;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "#remarks")
	private MCWebElement remarksTxt;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value='Submit']")
	private MCWebElement submitBtn;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = ".SuccessMessageTxt")
	private MCWebElement successMessage;
	
	public void verifyUiOperationStatus() {
		logger.info("Initiate Settlement");
		verifyButton("Search");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.visibilityOf(masterDetailContentTitle), WebElementUtils.visibilityOf(brancIdDDwn),
				WebElementUtils.visibilityOf(programCodeDDwn));
	}

	// methods
	@Override
	public void clickSearchButton() {
		new WebDriverWait(driver(), timeoutInSec).until(
				WebElementUtils.elementToBeClickable(searchBtn)).click();
	}
	
	public String getMasterDetailContentTitleText() {
		logger.info("Initiate Settlement Master Detail Tilte Text: {}");
		return new WebDriverWait(driver(), timeoutInSec).until(WebElementUtils.visibilityOf(masterDetailContentTitle)).getText();
	}
	
	public void clickModifyButton() {
		new WebDriverWait(driver(), timeoutInSec).until(
				WebElementUtils.elementToBeClickable(modifyBtn)).click();
	}
	
	public void clickModifyCheckerSubmitButton() {
		new WebDriverWait(driver(), timeoutInSec).until(
				WebElementUtils.elementToBeClickable(submitBtn)).click();
	}
	
	public String getSettlementInitiativeSuccessMessage() {
		return new WebDriverWait(driver(), timeoutInSec).until(
				WebElementUtils.visibilityOf(successMessage))
				.getText();
	}
	
	public void initiateSettlementForAgency(String branchID, String programCode) {
		WebElementUtils.selectDropDownByVisibleText(brancIdDDwn, branchID );
		WebElementUtils.selectDropDownByVisibleText(programCodeDDwn, programCode);
		clickSearchButton();
		SimulatorUtilities.wait(3000);//this to wait till the table gets loaded
		String xpathBuild = "//*[@class='dataview']/tbody/tr[1]";
		String amountToBeSettled = driver().findElement(By.xpath(xpathBuild+"//td[1]")).getText();
		WebElementUtils.retryUntil(driver().findElement(By.xpath(xpathBuild+"//td[1]"))::click,
				() -> WebElementUtils
						.hasClass(
								getFinder().findOne(FindBy.X_PATH,
										xpathBuild),
								"select"));
		clickModifyButton();
		WebElementUtils.enterText(amountToBeSettledTxt, amountToBeSettled);
		WebElementUtils.enterText(remarksTxt, ConstantData.GENERIC_DESCRIPTION);
		clickModifyCheckerSubmitButton();
	}
}
