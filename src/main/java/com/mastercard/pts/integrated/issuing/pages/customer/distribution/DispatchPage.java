package com.mastercard.pts.integrated.issuing.pages.customer.distribution;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.distribution.Dispatch;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.pts.integrated.issuing.utils.simulator.SimulatorUtilities;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = DistributionNav.TAB_DISTRIBUTION, treeMenuItems = { DistributionNav.L1_ACTIVITY,
		DistributionNav.L2_INVENTORY, DistributionNav.L3_DISPATCH })
public class DispatchPage extends AbstractBasePage {
	private static final Logger logger = LoggerFactory.getLogger(DispatchPage.class);
	private String cardPackIdCreationMessage;

	@Value("${default.wait.timeout_in_sec}")
	private long timeoutInSec;

	// main screen locators
	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement agencyDdwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:1:componentPanel:input:dropdowncomponent")
	private MCWebElement branchIdDdwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:2:componentList:0:componentPanel:input:inputTextField")
	private MCWebElement orderNumberTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value='Search']")
	private MCWebElement searchBtn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value='Submit']")
	private MCWebElement submitBtn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value='OK']")
	private MCWebElement okBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "courierId:input:dropdowncomponent")
	private MCWebElement courierAgencyDdwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#dispatchDate")
	private MCWebElement dispatchDateDpkr;

	@PageElement(findBy = FindBy.NAME, valueToFind = "qtyDispatched:input:inputTextField")
	private MCWebElement quantityToDispatchTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "memoDispatch:input:textAreaComponent")
	private MCWebElement memoTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value='Download in xls']")
	private MCWebElement downloadinXLSBtn;

	@PageElement(findBy = FindBy.CSS, valueToFind = ".feedbackPanelINFO")
	private MCWebElement successMessage;

	public void verifyUiOperationStatus() {
		logger.info("Dispatch");
		verifySearchButton("Search");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.visibilityOf(agencyDdwn));
	}

	// methods
	public void selectAgency(String agency) {
		WebElementUtils.selectDDByVisibleText(agencyDdwn, agency);
	}

	public void selectBranchId(String branchId) {
		WebElementUtils.selectDDByVisibleText(branchIdDdwn, branchId);
	}

	public void enterOrderNumber(String orderNumber) {
		WebElementUtils.enterText(orderNumberTxt, orderNumber);
	}

	public void selectCourierAgency(String courierAgency) {
		WebElementUtils.selectDDByVisibleText(courierAgencyDdwn, courierAgency);
	}

	public void enterQuantityToDispatch(String quantityToDispatch) {
		WebElementUtils.enterText(quantityToDispatchTxt, quantityToDispatch);
	}

	public void enterMemo(String memo) {
		WebElementUtils.enterText(memoTxt, memo);
	}

	@Override
	public void clickSubmitButton() {
		new WebDriverWait(driver(), timeoutInSec).until(WebElementUtils.elementToBeClickable(submitBtn)).click();
	}

	public void clickDownloadinXLSButton() {
		new WebDriverWait(driver(), timeoutInSec).until(WebElementUtils.elementToBeClickable(downloadinXLSBtn)).click();
		SimulatorUtilities.wait(5000);// this delay to wait till the file is
										// downloaded
	}

	public void clickOKButton() {
		new WebDriverWait(driver(), timeoutInSec).until(WebElementUtils.elementToBeClickable(okBtn)).click();
	}

	public String getLastCardPackID() {
		String message = getCardPackIdCreationMessage();
		return message.substring(message.lastIndexOf(' ') + 1);
	}

	public String getCardPackIdCreationMessage() {
		return cardPackIdCreationMessage;
	}

	public String getDisptachSuccessMessage() {
		return new WebDriverWait(driver(), timeoutInSec).until(WebElementUtils.visibilityOf(successMessage)).getText();
	}

	public String dispatchOrder(Dispatch details) {
		logger.info("Dispatch Order Number: {}", details.getOrderNumber());

		selectAgency(details.getAgency());
		selectBranchId(details.getBranchId());
		enterOrderNumber(details.getOrderNumber());
		clickSearchButton();
		editFirstRecord();

		runWithinPopup("Edit Dispatch", () -> {
			selectCourierAgency(details.getCourierAgency());
			WebElementUtils.pickDate(dispatchDateDpkr, details.getEffectiveDate());
			enterQuantityToDispatch(details.getQuantityToDispatch());
			enterMemo(details.getMemo());
			clickDownloadinXLSButton();
			clickSaveButton();
			cardPackIdCreationMessage = getDisptachSuccessMessage();
			clickOKButton();
		});
		verifyOperationStatus();
		return getLastCardPackID();
	}
}
