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
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_ACTIVITY,
		CardManagementNav.L2_STOP_LIST,
		CardManagementNav.L3_STOP_LIST_DEVICE_RANGE
		})

public class StopListDeviceRangePage extends AbstractBasePage {
	
	private static final Logger logger = LoggerFactory.getLogger(StopListDeviceRangePage.class);
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement rangeStart;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:1:componentPanel:input:dropdowncomponent")
	private MCWebElement rangeEnd;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "stopCardRangeContainer:rangeStart:input:dropdowncomponent")
	private MCWebElement starRangeDDwn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "stopCardRangeContainer:rangeEnd:input:dropdowncomponent")
	private MCWebElement endRangeDDwn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "stopCardRangeContainer:search")
	private MCWebElement searchRangeBtn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "stopCardRangeDetailContainer:reasonCode:input:dropdowncomponent")
	private MCWebElement stopListReasonCodeDDwn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "stopCardRangeDetailContainer:abrevName:input:textAreaComponent")
	private MCWebElement stopListDescriptionTxt;

	
	public void verifyUiOperationStatus() {
		logger.info("Stop List");
		verifyUiOperation("Add Stop List");
	}
	
	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(rangeStart),
				WebElementUtils.elementToBeClickable(rangeEnd)
				);
	}
	
	public void addStopListDeviceRange(StopListDeviceRange stopListDeviceRange,DeviceRange deviceRange){
		clickAddNewButton();
		runWithinPopup("Add Stop List", ()->{
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
			selectStartRange(String.format("%s [%s]", startRange, startRange));
			selectEndRange(String.format("%s [%s]", endRange, endRange));
			clickSearchRange();
			selectStopListReasonCode(stopListDeviceRange.getStopListReason());
			enterDescription(stopListDeviceRange.getStopListReasonDescription());
			clickSaveButton();
		});
	}
	
	public void selectStartRange(String starRange){
		selectDropDownByText(starRangeDDwn, starRange);
	}
	
	public void selectEndRange(String endRange){
		selectDropDownByText(endRangeDDwn, endRange);
	}
	
	public void clickSearchRange(){
		ClickButton(searchRangeBtn);
	}
	
	public void selectStopListReasonCode(String reasonCode){
		selectDropDownByText(stopListReasonCodeDDwn, reasonCode);
	}
	
	public void enterDescription(String desscription){
		enterText(stopListDescriptionTxt, desscription);
	}
}