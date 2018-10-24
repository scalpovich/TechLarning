
package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.ThreeDECommerceSecurityParameters;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.pts.integrated.issuing.utils.simulator.SimulatorUtilities;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_INSTITUTION_PARAMETER_SETUP,
		CardManagementNav.L2_THREE_D_E_COMMERCE_SECURITY_PARAMETERES })
public class ThreeDECommerceSecurityParametersPage extends AbstractBasePage {

	private static final Logger logger = LoggerFactory.getLogger(ThreeDECommerceSecurityParametersPage.class);

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement interchange;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=minCardRange]")
	private MCWebElement minCardRange;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=maxCardRange]")
	private MCWebElement maxCardRange;

	@PageElement(findBy = FindBy.NAME, valueToFind = "networkCode:input:dropdowncomponent")
	private MCWebElement addInterchangeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "validateCavvAav:input:dropdowncomponent")
	private MCWebElement validateCAVVAAVDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "minCardRange:input:inputTextField")
	private MCWebElement addMinCardRangeTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "maxCardRange:input:inputTextField")
	private MCWebElement addMaxCardRangeTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "decWithoutCavvAavMc:checkBoxComponent")
	private MCWebElement declineAllTransactionsWithoutCAVVAAVChkBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "skipValidationMc:checkBoxComponent")
	private MCWebElement skipCvv2ChkBx;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "decNonsecuredTxnMc:checkBoxComponent")
	private MCWebElement declineAllNonSecuredTransaction;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "decMerchantRiskBaseTxnMc:checkBoxComponent")
	private MCWebElement declineMerchantRiskBasedTransaction;

	public void verifyUiOperationStatus() {
		logger.info("3D E-Commerce Security Parameters");
		verifySearchButton("Search");
	}

	public void add3DECommerceSecurityParameters(ThreeDECommerceSecurityParameters eCommerceSecurityParameters) {
		logger.info("Add 3D E-Commerce Security Parameters");
		selectSearchInterchange(eCommerceSecurityParameters.geteCommerceSecurityInterchange());
		clickSearchButton();
		clickAddNewButton();
		runWithinPopup("Add 3D E-Commerce Security", () -> {
			selectThreeDECommerceInterchange(eCommerceSecurityParameters.geteCommerceSecurityInterchange());
			selectValidateCAVVAVV(eCommerceSecurityParameters.getValidateCAVVAAV());
			enterDeviceRangeFrom(eCommerceSecurityParameters.getDeviceRangeFrom());
			enterDeviceRangeTo(eCommerceSecurityParameters.getDeviceRangeTo());
			selectDeclineAllTransactionsWithoutCAVVAAVCheck();
			clickSaveButton();
			verifyDuplicateBinAndClickCancel();
		});
	}

	public void edit3DESParams(ThreeDECommerceSecurityParameters threeDESParams) {
		edit3DESecurityParameters(threeDESParams);
		runWithinPopup("Edit 3D E-Commerce Security", () -> {
			if (threeDESParams.getCheckStatus().equals("check"))
				ClickCheckBox(skipCvv2ChkBx, true);
			else
				ClickCheckBox(skipCvv2ChkBx, false);
			clickSaveButton();
		});
	}

	public void edit3DESecurityParameters(ThreeDECommerceSecurityParameters threeDESParams) {
		logger.info("Edit 3D E-Commerce Security Parameters");
		selectSearchInterchange(threeDESParams.geteCommerceSecurityInterchange());
		enterSearchDeviceRangeFrom(threeDESParams.getDeviceRangeFrom());
		clickSearchButton();
		editFirstRecord();
	}

	public void editDeclineAllNonSecuredTransaction(ThreeDECommerceSecurityParameters threeDESParams) {
		edit3DESecurityParameters(threeDESParams);
		runWithinPopup("Edit 3D E-Commerce Security", () -> {
			if (threeDESParams.getCheckStatus().equals("check"))
				ClickCheckBox(declineAllNonSecuredTransaction, true);
			else
				ClickCheckBox(declineAllNonSecuredTransaction, false);
			clickSaveButton();
			SimulatorUtilities.wait(3000);
		});
		
	}

	public void editMerchantRiskBasedDecisioningTransaction(ThreeDECommerceSecurityParameters threeDESParams) {
		edit3DESecurityParameters(threeDESParams);
		runWithinPopup("Edit 3D E-Commerce Security", () -> {
			if (threeDESParams.getCheckStatus().equals("check"))
				ClickCheckBox(declineMerchantRiskBasedTransaction, true);
			else
				ClickCheckBox(declineMerchantRiskBasedTransaction, false);
			clickSaveButton();
		});
	}

	public void editAll3DSecureFieldsToUncheck(ThreeDECommerceSecurityParameters threeDESParams) {
		edit3DESecurityParameters(threeDESParams);
		runWithinPopup("Edit 3D E-Commerce Security", () -> {
			if (declineAllTransactionsWithoutCAVVAAVChkBx.isSelected())
				declineAllTransactionsWithoutCAVVAAVChkBx.click();
			if (declineAllNonSecuredTransaction.isSelected())
				declineAllNonSecuredTransaction.click();
			if (declineMerchantRiskBasedTransaction.isSelected())
				declineMerchantRiskBasedTransaction.click();
			   clickSaveButton();
		});
	}

	public void selectSearchInterchange(String interchangeToSearch) {
		selectByVisibleText(interchange, interchangeToSearch);
	}

	public void selectThreeDECommerceInterchange(String interchangeToAdd) {
		selectByVisibleText(addInterchangeDDwn, interchangeToAdd);
	}

	public void selectValidateCAVVAVV(String validateCAVVAVV) {
		selectByVisibleText(validateCAVVAAVDDwn, validateCAVVAVV);
	}

	public void enterDeviceRangeFrom(String deviceRangeFrom) {
		enterText(addMinCardRangeTxt, deviceRangeFrom);
	}
	
	public void enterSearchDeviceRangeFrom(String deviceRangeFrom) {
		enterText(minCardRange, deviceRangeFrom);
	}

	public void enterDeviceRangeTo(String deviceRangeTo) {
		enterText(addMaxCardRangeTxt, deviceRangeTo);
	}
	
	public void enterSearchDeviceRangeTo(String deviceRangeTo) {
		enterText(maxCardRange, deviceRangeTo);
	}

	public void selectDeclineAllTransactionsWithoutCAVVAAVCheck() {
		ClickCheckBox(declineAllTransactionsWithoutCAVVAAVChkBx, true);
	}

	protected void verifyDuplicateBinAndClickCancel() {
		if (getMessageFromFeedbackPanel().contains("Overlapping High Device/Wallet and Low Device/Wallet Range")) {
			clickCancelButton();
		}
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.elementToBeClickable(interchange),
				WebElementUtils.elementToBeClickable(minCardRange), WebElementUtils.elementToBeClickable(maxCardRange));
	}
}
