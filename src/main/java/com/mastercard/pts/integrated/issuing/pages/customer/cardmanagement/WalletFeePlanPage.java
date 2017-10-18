package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceCreation;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.WalletFeePlan;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.customer.navigation.CardManagementNav;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.DatePicker;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = { CardManagementNav.L1PROGRAM_SETUP,
		CardManagementNav.L2_WALLET_CONFIGURATION, CardManagementNav.L3_WALLET_FEE_PLAN })
public class WalletFeePlanPage extends AbstractBasePage {

	private static final Logger logger = LoggerFactory
			.getLogger(WalletFeePlanPage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=walletFeePlanCode]")
	private MCWebElement walletFeePlanCode;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=description]")
	private MCWebElement description;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:2:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement currency;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:2:componentList:1:componentPanel:input:dropdowncomponent")
	private MCWebElement productType;
	@Autowired
	DatePicker date;

	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addWalletFeePlanBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "productType:input:dropdowncomponent")
	private MCWebElement ProductTypeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "walletFeePlanCode:input:inputTextField")
	private MCWebElement PlancodeTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "description:input:inputTextField")
	private MCWebElement DescriptionTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "currencyCode:input:dropdowncomponent")
	private MCWebElement CurrencyDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement saveBtn;

	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement walletPlanSubdetailsBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "feeType:input:dropdowncomponent")
	private MCWebElement feeTypeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "feeAmt:input:inputAmountField")
	private MCWebElement feeAmountTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "membershipPeriod:input:dropdowncomponent")
	private MCWebElement membershipFeePostingDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "waiveNumOfCycle:input:inputTextField")
	private MCWebElement waiveNoOfCycleTxt;

	public void verifyUiOperationStatus() {
		logger.info("Wallet Fee Plan");
		verifyUiOperation("Add Wallet Fee Plan");
	}
	public String Calelement = "//span[@id = 'walletFeeEndDate']";

	public void clickAddWalletFeePlan() {
		clickWhenClickable(addWalletFeePlanBtn);
		switchToAddFeeWalletPlanFrame();
	}

	public void switchToAddFeeWalletPlanFrame() {
		switchToIframe(Constants.ADD_FEE_WALLET_PLAN_FRAME);
	}

	public void selectProduct(DeviceCreation deviceCreation) {
		selectByVisibleText(ProductTypeDDwn, deviceCreation.getProduct());
	}

	public String enterPlanCode() {
		enterValueinTextBox(PlancodeTxt, CustomUtils.randomNumbers(6));
		return PlancodeTxt.getAttribute("value");
	}

	public String enterDescription() {
		enterValueinTextBox(DescriptionTxt, "Corporate gift prepaid emv");
		return DescriptionTxt.getAttribute("value");
	}

	public void selectCurrency(WalletFeePlan walletfeeplan) {
		selectByVisibleText(CurrencyDDwn, walletfeeplan.getCurrency());
	}

	public void clickSaveButton() {
		clickWhenClickable(saveBtn);
	}

	public void clickAddWalletPlanDetails() {
		switchToIframe(Constants.ADD_FEE_WALLET_PLAN_FRAME);
		clickWhenClickable(walletPlanSubdetailsBtn);
	}

	public void switchToAddWalletFeePlanDetailsFrame() {
		SwitchToDefaultFrame();
		switchToIframe(Constants.ADD_WALLET_FEE_PLAN_DETAILS_FRAME);
	}

	public void selectFeeType(WalletFeePlan walletfeeplan) {
		selectByVisibleText(feeTypeDDwn, walletfeeplan.getWalletFeePlanType());
	}

	public void selectEffectiveDate(WalletFeePlan walletfeeplan) {
		date.setDate(walletfeeplan.getEffectiveDate());
	}

	public void selectEndDate(WalletFeePlan walletfeeplan) {
		date.setDateCalendar2(walletfeeplan.getEndDate(), Calelement);

	}

	public void enterFeeAmount(WalletFeePlan walletfeeplan) {
		enterValueinTextBox(feeAmountTxt, walletfeeplan.getFeeAmount());
	}

	public void selectMemberFeePosting() {
		SelectDropDownByIndex(membershipFeePostingDDwn, 1);
	}

	public void enterWaiverCycle(WalletFeePlan walletfeeplan) {
		enterValueinTextBox(waiveNoOfCycleTxt, walletfeeplan.getWaiverPeriod());
	}

	public String addWalletFeePlan(DeviceCreation deviceCreation, WalletFeePlan walletfeeplan) {
		String walletPlanCode;
		String walletPLanDesc;
		walletPlanCode = enterPlanCode();
		walletPLanDesc = enterDescription();
		selectProduct(deviceCreation);
		selectCurrency(walletfeeplan);
		clickSaveButton();
		return walletPLanDesc + " " + "[" + walletPlanCode + "]";

	}

	public void addWalletFeePlanDetails(DeviceCreation deviceCreation, WalletFeePlan walletfeeplan) {
		clickWhenClickable(walletPlanSubdetailsBtn);
		SwitchToDefaultFrame();
		switchToIframe(Constants.ADD_WALLET_FEE_PLAN_DETAILS_FRAME);
		selectFeeType(walletfeeplan);
		selectEffectiveDate(walletfeeplan);
		selectEndDate(walletfeeplan);
		enterFeeAmount(walletfeeplan);
		selectMemberFeePosting();
		enterWaiverCycle(walletfeeplan);
		clickSaveButton();
	}



	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(walletFeePlanCode),
				WebElementUtils.elementToBeClickable(description),
				WebElementUtils.elementToBeClickable(currency),
				WebElementUtils.elementToBeClickable(productType));
	}
}
