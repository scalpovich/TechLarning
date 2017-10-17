package com.mastercard.pts.integrated.issuing.pages.agent.services;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.agent.services.Checker;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = ServicesNav.TAB_SERVICES, treeMenuItems = { ServicesNav.L1_DEVICE_SALE_ISSUANCE, ServicesNav.L2_CHECKER_REQUEST })
public class CheckerPage extends AbstractBasePage {
	private static final Logger logger = LoggerFactory.getLogger(CheckerPage.class);

	@Value("${default.wait.timeout_in_sec}")
	private long timeoutInSec;

	// main screen locators
	@PageElement(findBy = FindBy.CSS, valueToFind = "div .Title")
	private MCWebElement masterDetailContentTitle;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#applicationNumber")
	private MCWebElement applicationNumberTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "dateCreateDDMMYYYY")
	private MCWebElement applicationDateTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#applicationType")
	private MCWebElement applicationTypeDdwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#regesteredMobileNumber")
	private MCWebElement mobileNumberTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value='search']")
	private MCWebElement searchBtn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@class='dataview']//td[2]")
	private MCWebElement tableFirstRecord;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#programCode")
	private MCWebElement programCodeDdwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#cardPackID")
	private MCWebElement cardPackIdTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value='Modify']")
	private MCWebElement modifyBtn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value='OK']")
	private MCWebElement okBtn;

	@PageElement(findBy = FindBy.CSS, valueToFind = ".SuccessMessageTxt")
	private MCWebElement approvalMessage;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#memo")
	private MCWebElement commentTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value='Approve']")
	private MCWebElement approveBtn;

	public void verifyUiOperationStatus() {
		logger.info("Checker");
		verifyButton("Search");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.visibilityOf(applicationNumberTxt), WebElementUtils.visibilityOf(applicationTypeDdwn),
				WebElementUtils.visibilityOf(programCodeDdwn), WebElementUtils.visibilityOf(cardPackIdTxt), WebElementUtils.visibilityOf(mobileNumberTxt),
				WebElementUtils.visibilityOf(applicationDateTxt), WebElementUtils.visibilityOf(masterDetailContentTitle));
	}

	// methods
	public String getMasterDetailContentTitleText() {
		logger.info("Corporate User View Edit Master Detail Tilte Text: {}");
		return new WebDriverWait(driver(), timeoutInSec).until(WebElementUtils.visibilityOf(masterDetailContentTitle)).getText();
	}

	public void enterApplicationNumber(String applicationNumber) {
		WebElementUtils.enterText(cardPackIdTxt, applicationNumber);
	}

	public void selectProgramCode(String programCode) {
		WebElementUtils.selectDropDownByVisibleText(programCodeDdwn, programCode);
	}

	public void selectApplicationType(String applicationType) {
		WebElementUtils.selectDropDownByVisibleText(applicationTypeDdwn, applicationType);
	}

	public void enterCardPackId(String cardPackId) {
		WebElementUtils.enterText(cardPackIdTxt, cardPackId);
	}

	public void enterMobileNumber(String mobileNumber) {
		WebElementUtils.enterText(mobileNumberTxt, mobileNumber);
	}

	public void enterComment(String comment) {
		WebElementUtils.enterText(commentTxt, comment);
	}

	public void clickModifyButton() {
		new WebDriverWait(driver(), timeoutInSec).until(WebElementUtils.elementToBeClickable(modifyBtn)).click();
	}

	public void clickApproveButton() {
		WebElementUtils.scrollDown(driver(), 0, 250);
		new WebDriverWait(driver(), timeoutInSec).until(WebElementUtils.elementToBeClickable(approveBtn)).click();
	}

	public void clickTableFirstRecord() {
		WebElementUtils.retryUntil(tableFirstRecord::click,
				() -> WebElementUtils.hasClass(getFinder().findOne(FindBy.X_PATH, "//*[@class='dataview']/tbody/tr[1]"), "select"));
	}

	public void clickOKButton() {
		new WebDriverWait(driver(), timeoutInSec).until(WebElementUtils.elementToBeClickable(okBtn)).click();
	}

	@Override
	public void clickSearchButton() {
		new WebDriverWait(driver(), timeoutInSec).until(WebElementUtils.elementToBeClickable(searchBtn)).click();
	}

	public String getApprovalMessage() {
		return new WebDriverWait(driver(), timeoutInSec).until(WebElementUtils.visibilityOf(approvalMessage)).getText();
	}

	public void cardSaleChecker(Checker details) {
		logger.info("Card Sale Checker: {}", details.getProgram());

		enterCardPackId(details.getCardPackId());
		clickSearchButton();
		clickTableFirstRecord();
		clickModifyButton();
		enterComment(details.getComment());
		clickApproveButton();
	}
}
