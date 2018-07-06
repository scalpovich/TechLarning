package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceRange;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.StopListDeviceRange;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.WithdrawDeviceRange;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_ACTIVITY, CardManagementNav.L2_STOP_LIST,
		CardManagementNav.L3_WITHDRAW_DEVICE_RANGE })
public class WithdrawDeviceRangePage extends AbstractBasePage {

	private static final Logger logger = LoggerFactory
			.getLogger(WithdrawDeviceRangePage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=rangeStart]")
	private MCWebElement rangeStart;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=rangeEnd]")
	private MCWebElement rangeEnd;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=rangeStart]")
	private MCWebElement rangeStartDDwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=rangeEnd]")
	private MCWebElement rangeEndDDwn;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "withdrawalReasonCode:input:dropdowncomponent")
	private MCWebElement withdarwReasonDDwn;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "withdrawalDescription:input:textAreaComponent")
	private MCWebElement withdarwalDescriptionTxt;
	
	

	public void verifyUiOperationStatus() {
		logger.info("Withdraw Device Range");
		verifySearchButton("Search");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.elementToBeClickable(rangeStart),
				WebElementUtils.elementToBeClickable(rangeEnd));
	}
	
	public void withdrawDeviceRange(WithdrawDeviceRange withdrawDeviceRange,DeviceRange deviceRange){
		String startRange=null;
		String endRange=null;
		if(!deviceRange.getIssuerBin().contains("[")){
			startRange=deviceRange.getIssuerBin()+""+deviceRange.getFromDeviceNumber();
			endRange=deviceRange.getIssuerBin()+""+deviceRange.getToDeviceNumber();
		}
		else{
			startRange=deviceRange.getIssuerBinCode(deviceRange.getIssuerBin())+""+deviceRange.getFromDeviceNumber();
			endRange=deviceRange.getIssuerBinCode(deviceRange.getIssuerBin())+""+deviceRange.getToDeviceNumber();
		}
		enterStartRange(startRange);
		enterEndRange(endRange);
		clickSearchButton();
		editFirstRecord();
		runWithinPopup("Edit Withdraw Device Range", ()->{
			selectWithdrawReason(withdrawDeviceRange.getWithdrawReason());
			enterWithdrawalDescription(withdrawDeviceRange.getWithdrawDescription());
			clickSaveButton();
		});
	}
	
	public void enterStartRange(String startRange){
		enterText(rangeStartDDwn, "5877658362331600");
	}
	
	public void enterEndRange(String endRange){
		enterText(rangeEndDDwn, "5877658362331699");
	}
	
	public void selectWithdrawReason(String withdrawReason){
		selectDropDownByText(withdarwReasonDDwn, withdrawReason);	
	}
	
	public void enterWithdrawalDescription(String description){
		enterText(withdarwalDescriptionTxt, description);
	}
}