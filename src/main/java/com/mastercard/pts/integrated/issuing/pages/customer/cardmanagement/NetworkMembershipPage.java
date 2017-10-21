package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.NetworkMembership;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.customer.navigation.CardManagementNav;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

import net.thucydides.core.annotations.findby.By;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_INSTITUTION_PARAMETER_SETUP,
		CardManagementNav.L2_NETWORKMEMBERSHIP })
public class NetworkMembershipPage extends AbstractBasePage {
	
	private static final Logger logger = LoggerFactory
			.getLogger(NetworkMembershipPage.class);

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement interchangeDwn;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@id='networkCode']/select")
	private MCWebElement interchangePopupDwn;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn='presentmentTimeLimit']")
	private MCWebElement presentmentTimeLimitTxt;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@id='cutoverHrs']/select")
	private MCWebElement cutoverHoursDwn;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@id='cutoverMi']/select")
	private MCWebElement cutoverMinsDwn;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@id='settlementCurrency']/select")
	private MCWebElement settlementCurrencyDwn;
	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addNetworkMembershipBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "tables:1:rows:1:cols:colspanMarkup:inputField:input:dropdowncomponent")
	private MCWebElement InterchangeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "tables:1:rows:1:cols:nextCol:colspanMarkup:inputField:input:inputTextField")
	private MCWebElement PresentmentTimeLimitTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "tables:1:rows:2:cols:colspanMarkup:inputField:input:dropdowncomponent")
	private MCWebElement CutoverHoursDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "tables:1:rows:2:cols:nextCol:colspanMarkup:inputField:input:dropdowncomponent")
	private MCWebElement CutoverMinsDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "tables:1:rows:3:cols:colspanMarkup:inputField:input:dropdowncomponent")
	private MCWebElement SettlementCurrencyDDwn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//a/img[@alt='Edit Record']")
	private MCWebElement EditRupayNtkBtn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//a/img[@alt='Delete Record']")
	private MCWebElement DeleteRupayNtkBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement saveBtn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@class = 'feedbackPanelERROR']")
	private MCWebElement PanelError;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@class = 'feedbackPanelINFO']")
	private MCWebElement PanelInfo;

	@PageElement(findBy = FindBy.CLASS, valueToFind = "feedbackPanelINFO")
	private MCWebElement ConfirmationMsgTxt;

	@PageElement(findBy = FindBy.CLASS, valueToFind = "exportCSV")
	private MCWebElement DownloadBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cancel")
	private MCWebElement cancelBtn;

	public void clickAddNetworkMemberShip() {
		clickWhenClickable(addNetworkMembershipBtn);
		switchToNetworkMembershipFrame();
	}

	public void switchToNetworkMembershipFrame() {
		switchToIframe(Constants.ADD_NETWORK_MEMBERSHIP_FRAME);

	}

	public void selectInterchangeType(NetworkMembership ntk) {
		selectByVisibleText(InterchangeDDwn, ntk.getInterchange());
	}

	public void fillPresentTime(NetworkMembership ntk) {
		enterValueinTextBox(PresentmentTimeLimitTxt, ntk.getPresentmentTimeLimitDays());
	}

	public void selectCutoverHours() {
		SelectDropDownByIndex(CutoverHoursDDwn, 1);
	}

	public void selectCutoverMinutes() {
		SelectDropDownByIndex(CutoverMinsDDwn, 2);
	}

	public void selectSettlementCurrency(NetworkMembership ntk) {
		selectByVisibleText(SettlementCurrencyDDwn, ntk.getPresentmentTimeLimitDays());
	}

	public void clickSaveBtn() {
		clickWhenClickable(saveBtn);
	}

	public boolean verifyErrorsOnNetworkPage() {
		return publishErrorOnPage();
	}

	public void verifyNewNetworkSuccess() {
		if (!verifyErrorsOnNetworkPage()) {
			logger.info("Network membership Added Successfully");
			SwitchToDefaultFrame();
		} else {
			logger.info("Error in record Addition");
			clickWhenClickable(cancelBtn);
			SwitchToDefaultFrame();

		}
	}

	// public void addnetworkmembership(String interchangeType, String
	// presentTimelimit, String settlementCurrency) {
	// getAddNetworkMembership().click();
	// addWicketAjaxListeners(getFinder().getWebDriver());
	// switchToIframe(Constants.ADD_NETWORK_MEMBERSHIP_FRAME);
	// selectByVisibleText(InterchangeDDwn, interchangeType);
	// enterText(PresentmentTimeLimitTxt, presentTimelimit);
	// SelectDropDownByIndex(CutoverHoursDDwn, 1);
	// addWicketAjaxListeners(getFinder().getWebDriver());
	// waitForElementVisible(CutoverHoursDDwn);
	// SelectDropDownByIndex(CutoverMinsDDwn, 2);
	// selectByVisibleText(SettlementCurrencyDDwn, settlementCurrency);
	// ClickButton(saveBtn);
	//
	// try {
	// if (PanelError.isVisible()) {
	// System.out.println("inside error pannel");
	// cancelBtn.click();
	// }
	// } catch (Exception e) {
	// System.out.println("error pannel not present");
	// }
	// SwitchToDefaultFrame();
	// }

	public void editnetworkmembership(String interchange) {
		WebElement EditRupayNtkBtn = getFinder().getWebDriver().findElement(
				By.xpath("//td[contains(.,'" + interchange + "')]/following::a[1]/img[@alt='Edit Record']"));
		EditRupayNtkBtn.click();
		addWicketAjaxListeners(getFinder().getWebDriver());
		switchToIframe(Constants.EDIT_NETWORK_MEMBERSHIP_FRAME);
		addWicketAjaxListeners(getFinder().getWebDriver());
		selectByVisibleText(CutoverHoursDDwn, MapUtils.fnGetInputDataFromMap("CutOverHours"));
		addWicketAjaxListeners(getFinder().getWebDriver());
		selectByVisibleText(CutoverMinsDDwn, MapUtils.fnGetInputDataFromMap("CutOverMins"));
		addWicketAjaxListeners(getFinder().getWebDriver());
		ClickButton(saveBtn);
		addWicketAjaxListeners(getFinder().getWebDriver());

	}

	public void deletenetworkmembership(String interchangeName) {
		WebElement DeleteRupayNtkBtn = getFinder().getWebDriver().findElement(
				By.xpath("//td[contains(.,'" + interchangeName + "')]/following::a[2]/img[@alt='Delete Record']"));
		waitForElementVisible(DeleteRupayNtkBtn);
		DeleteRupayNtkBtn.click();
		Alert alert = getFinder().getWebDriver().switchTo().alert();
		logger.info(alert.getText());
		alert.accept();

	}

	public void downloadlists() throws FileNotFoundException {
		logger.info("List of network");
		ClickButton(DownloadBtn);

	}

	public String checkErrormessage() {
		return PanelError.getText().split("\\n")[0];
	}

	public boolean verifyNetworkMembership(String network) {
		getAddNetworkMembership().click();
		addWicketAjaxListeners(getFinder().getWebDriver());
		switchToIframe(Constants.ADD_NETWORK_MEMBERSHIP_FRAME);
		List<WebElement> drpDwnOptions = InterchangeDDwn.getSelect().getOptions();
		drpDwnOptions.forEach(drpDwnOption -> {
			if (drpDwnOption.getText().equals(network)) {
				logger.info(network + " network is present");
			}
		});
		ClickButton(cancelBtn);
		return true;

	}

	public String getConfirmationMessage() {
		return ConfirmationMsgTxt.getText().split("\\n")[0];

	}
	
	public void verifyUiOperationStatus() {
		logger.info("Network Membership");
		verifyUiOperation("Add Network Membership");
		verifySearchButton("Search");
	}
	
	public void addNewNetworkMembership(List<NetworkMembership> networkMemeberList)
	{
		if(isNoRecordsFoundInTable())
			{
			networkMemeberList.forEach(networkMember->{
			logger.info("create network member of interchange : {}",networkMember.getInterchange());
			clickAddNewButton();
			runWithinPopup(
					"Add Network Membership",
					() -> {
						addNetworkMember(networkMember);
							verifyNoErrors();
					});
	
			verifyOperationStatus();       
			});
		}
	}
	
	private void addNetworkMember(NetworkMembership nm)
	{
			WebElementUtils.selectDropDownByVisibleText(interchangePopupDwn, nm.getInterchange());
			WebElementUtils.selectDropDownByVisibleText(cutoverHoursDwn, nm.getCutoverHours());
			WebElementUtils.selectDropDownByVisibleText(cutoverMinsDwn, nm.getCutoverMins());
			WebElementUtils.selectDropDownByVisibleText(settlementCurrencyDwn, nm.getsettlementCurrency());
			WebElementUtils.enterText(presentmentTimeLimitTxt, nm.getPresentmentTimeLimitDays());
			clickSaveButton();
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.elementToBeClickable(interchangeDwn));
	}
	public MCWebElement getAddNetworkMembership() {
		return addNetworkMembershipBtn;
	}

	public void setAddNetworkMembership(MCWebElement addNetworkMembership) {
		this.addNetworkMembershipBtn = addNetworkMembership;
	}
}
