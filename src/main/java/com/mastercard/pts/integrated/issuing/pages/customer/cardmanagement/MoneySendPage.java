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
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.MoneySend;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_ACTIVITY, CardManagementNav.L2_MASTERCARD,
		CardManagementNav.L3_MONEY_SEND})
public class MoneySendPage extends AbstractBasePage {

	private static final Logger logger = LoggerFactory
			.getLogger(MoneySendPage.class);
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=originatorCardNumber]")
	private MCWebElement deviceNumberTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=beneficiaryCardNumber]")
	private MCWebElement beneficiaryCardNumberTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "vmtFastFundContainer:currencyToTransfer:input:dropdowncomponent")
	private MCWebElement currencyDDwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=amountToTransfer]")
	private MCWebElement amountToTransferTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=beneficiaryContactNumber]")
	private MCWebElement beneficiaryContactNumberTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=beneficiaryName]")
	private MCWebElement beneficiaryNameTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=memo]")
	private MCWebElement memoTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value='Calculate Fees']")
	private MCWebElement calculateFeesBtn;

	public void verifyUiOperationStatus() {
		logger.info("Money Send");
		verifySearchButton("Search");
	}
	
	public void searchDeviceAndSelectWallet(Device device) {
		logger.info("Source device number: " + device.getDeviceNumber());
		WebElementUtils.enterText(deviceNumberTxt, device.getDeviceNumber());
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

	public void submitMoneySendRequest(MoneySend moneySend){
		logger.info("Beneficiary device number: " + moneySend.getBeneficiaryDeviceNumber());
		WebElementUtils.enterText(beneficiaryCardNumberTxt, moneySend.getBeneficiaryDeviceNumber());
		WebElementUtils.selectDropDownByVisibleText(currencyDDwn, moneySend.getCurrency());
		WebElementUtils.enterText(amountToTransferTxt, moneySend.getAmount());
		WebElementUtils.enterText(beneficiaryContactNumberTxt, moneySend.getContactNumber());
		WebElementUtils.enterText(beneficiaryNameTxt, moneySend.getName());
		WebElementUtils.enterText(memoTxt, moneySend.getMemo());
		calculateFeesBtn.click();	
		verifyOperationStatus();
	}
	
	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(deviceNumberTxt));
	}
}