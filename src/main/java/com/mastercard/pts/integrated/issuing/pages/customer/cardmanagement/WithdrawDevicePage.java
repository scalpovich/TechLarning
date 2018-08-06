package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.WithdrawDevice;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_ACTIVITY, CardManagementNav.L2_STOP_LIST,
		CardManagementNav.L3_WITHDRAW_DEVICE })
public class WithdrawDevicePage extends AbstractBasePage {
	
	@Autowired
	TestContext context;

	 private static final Logger logger = LoggerFactory.getLogger(WithdrawDevicePage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=cardNumber]")
	private MCWebElement cardNumber;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:1:componentPanel:input:dropdowncomponent")
	private MCWebElement interchange;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=cardNumber]")
	private MCWebElement searchDeviceNumberTxt;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "withdrawalReasonCode:input:dropdowncomponent")
	private MCWebElement reasonCodeDDwn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "applyFees:checkBoxComponent")
	private MCWebElement applyFeesChkBx;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "withdrawalDescription:input:textAreaComponent")
	private MCWebElement withdrawDeviceDescription;
	
	

	public void verifyUiOperationStatus() {
		logger.info("Withdraw Device");
		verifySearchButton("Search");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.elementToBeClickable(cardNumber),
				WebElementUtils.elementToBeClickable(interchange));
	}
	
	public void withdrawStoplistDevice(WithdrawDevice withdrawDevice){
		Device device=context.get(ContextConstants.DEVICE);
		searchWithdrawDevice(device.getDeviceNumber());
		runWithinPopup("Withdraw Device", ()->{
			selectApplyFeesCheckBox();
			selectReasonCode(withdrawDevice.getWithdrawReason());
			enterWithdrawDeviceDescription(withdrawDevice.getWithdrawDescription());
			clickSaveButton();
		});
	}
	
	public void searchWithdrawDevice(String searchDeviceNumber){
		enterText(searchDeviceNumberTxt, searchDeviceNumber);
		clickSearchButton();
		editFirstRecord();
	}
	
	public void selectApplyFeesCheckBox(){
		ClickCheckBox(applyFeesChkBx, true);
	}
	
	public void selectReasonCode(String reasonCode){
		selectDropDownByText(reasonCodeDDwn, reasonCode);
	}
	
	public void enterWithdrawDeviceDescription(String description){
		enterText(withdrawDeviceDescription, description);
	}
	
}