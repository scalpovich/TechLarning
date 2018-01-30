package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.VisaMoneyTransfer;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_ACTIVITY, CardManagementNav.L2_VISA,
		CardManagementNav.L3_INITIATE_VISA_MONEY_TRANSFER })
public class InitiateVisaMoneyTransferPage extends AbstractBasePage {

	private static final Logger logger = LoggerFactory
			.getLogger(InitiateVisaMoneyTransferPage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=originatorCardNumber]")
	private MCWebElement originatorCardNumberTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "vmtFastFundContainer:vmtFastFundOption:input:dropdowncomponent")
	private MCWebElement vmtFastFundDDwn;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=beneficiaryCardNumber]")
	private MCWebElement beneficiaryCardNumberTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "vmtFastFundContainer:currencyToTransfer:input:dropdowncomponent")
	private MCWebElement currencyDDwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=amountToTransfer]")
	private MCWebElement amountTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=memo]")
	private MCWebElement memoTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value='Calculate Fees']")
	private MCWebElement calculateFeesBtn;

	public void verifyUiOperationStatus() {
		logger.info("Initiate Visa Money Transfer");
		verifySearchButton("Search");
	}

	private void selectVMT(String vmt){
		if(vmt.contains("VMT"))
			WebElementUtils.selectDropDownByVisibleText(vmtFastFundDDwn, "VISA Money Transfer (Offline) [44]");
		else if(vmt.contains("RVMT"))
			WebElementUtils.selectDropDownByVisibleText(vmtFastFundDDwn, "VISA Fast Fund(Real Time) [45]");
	}
	
	public void searchDeviceAndSelectWallet(Device device) {
		logger.info("Source device number: " + device.getDeviceNumber());
		WebElementUtils.enterText(originatorCardNumberTxt, device.getDeviceNumber());
		clickSearchButton();
		runWithinPopup("Search Result", () ->{
			for (int i = 1; i < 4; i++) {
				if ((device.getWalletNumber()).equals(getCellTextByColumnName(i, "Wallet Number"))){
					driver().findElement(By.cssSelector(String.format(".dataview tbody tr:nth-child(%s) td span a", i))).click();
					break;
				}
			}
		});
	}

	public void searchDeviceAndSelectSecondWallet(Device device) {
		logger.info("Source device number: " + device.getDeviceNumber());
		WebElementUtils.enterText(originatorCardNumberTxt, device.getDeviceNumber());
		clickSearchButton();
		runWithinPopup("Search Result", () ->{
			for (int i = 1; i < 4; i++) {
				if ((device.getWalletNumber2()).equals(getCellTextByColumnName(i, "Wallet Number"))){
					driver().findElement(By.cssSelector(String.format(".dataview tbody tr:nth-child(%s) td span a", i))).click();
					break;
				}
			}
		});
	}

	public void submitVisaMoneyTransferRequest(VisaMoneyTransfer visaMoneyTransfer){
		logger.info("Beneficiary device number: " + visaMoneyTransfer.getBeneficiaryDeviceNumber());
		selectVMT(visaMoneyTransfer.getVmt());
		WebElementUtils.enterText(beneficiaryCardNumberTxt, visaMoneyTransfer.getBeneficiaryDeviceNumber());
		WebElementUtils.selectDropDownByVisibleText(currencyDDwn, visaMoneyTransfer.getCurrency());
		WebElementUtils.enterText(amountTxt, visaMoneyTransfer.getAmount());
		WebElementUtils.enterText(memoTxt, visaMoneyTransfer.getMemo());
		calculateFeesBtn.click();
		clickSaveButton();
		verifyOperationStatus();
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils
				.elementToBeClickable(originatorCardNumberTxt));
	}
}