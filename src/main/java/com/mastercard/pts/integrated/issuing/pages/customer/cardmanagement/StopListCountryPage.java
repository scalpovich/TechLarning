package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceRange;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.StopListCountry;
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
		CardManagementNav.L3_STOP_LIST_COUNTRY
		})

public class StopListCountryPage extends AbstractBasePage {
	
	private static final Logger logger = LoggerFactory.getLogger(StopListCountryPage.class);
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement rangeStart;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:1:componentPanel:input:dropdowncomponent")
	private MCWebElement rangeEnd;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:2:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement country;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "stopCountryContainer:minCardRange:input:dropdowncomponent")
	private MCWebElement startRangeDDwn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "stopCountryContainer:maxCardRange:input:dropdowncomponent")
	private MCWebElement endRangeDDwn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "stopCountryContainer:countryCode:input:dropdowncomponent")
	private MCWebElement countryDDwn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "stopCountryContainer:search")
	private MCWebElement btnSearch;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "stopCountryDetailContainer:responseCode:input:dropdowncomponent")
	private MCWebElement responseCodeDDwn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "stopCountryDetailContainer:abrevName:input:textAreaComponent")
	private MCWebElement txDescription;

	public void verifyUiOperationStatus() {
		logger.info("Stop List Country");
		verifyUiOperation("Add Stop List Country");
	}
	
	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(rangeStart),
				WebElementUtils.elementToBeClickable(rangeEnd),
				WebElementUtils.elementToBeClickable(country)
				);
	}
	
	public  void stopListCountry(StopListCountry stopListCountry,DeviceRange deviceRange){
		clickAddNewButton();
		runWithinPopup("Add Stop List Country", ()->{
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
			waitForElementVisible(startRangeDDwn);
			selectStartRange(String.format("%s [%s]", startRange, startRange));
			selectEndtRange(String.format("%s [%s]", endRange, endRange));
			selectCountry(stopListCountry.getStoplistCountry());
			clickSearch();
			waitForElementVisible(responseCodeDDwn);
			selectResponseCode(stopListCountry.getStopListReason());
			enterDescription(stopListCountry.getStopListReasonDescription());
			clickSaveButton();
		});
		verifyOperationStatus();
	}
	
	public void selectStartRange(String startRange){
		selectDropDownByText(startRangeDDwn, startRange);
	}
	
	public void selectEndtRange(String endRange){
		selectDropDownByText(endRangeDDwn, endRange);
	}

	public void selectCountry(String country){
		selectDropDownByText(countryDDwn, country);
    }
	
	public void clickSearch(){
		ClickButton(btnSearch);	
	}
	
	public void selectResponseCode(String responseCode){
		selectDropDownByText(responseCodeDDwn, responseCode);
	}
	
	public void enterDescription(String description){
		enterText(txDescription, description);
	}
	
	
}