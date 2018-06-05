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
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.StopListDevice;
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
		CardManagementNav.L3_STOP_LIST_DEVICE
		})

public class StopListDevicePage extends AbstractBasePage {
	
	private static final Logger logger = LoggerFactory.getLogger(StopListDevicePage.class);
	
	@Autowired
	private TestContext context;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=cardNumber]")
	private MCWebElement cardNumber;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:1:componentPanel:input:dropdowncomponent")
	private MCWebElement interchange;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "stopCardContainer:cardNumber:input:inputTextField")
	private MCWebElement stopListDeviceNumberTxt;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "stopCardContainer:search")
	private MCWebElement searchStopListBtn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "stopCardDetailContainer:reasonCode:input:dropdowncomponent")
	private MCWebElement reasonCodeDDwn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "stopCardDetailContainer:abrevName:input:textAreaComponent")
	private MCWebElement stopListDeviceDescriptionTxt;
	
	public void verifyUiOperationStatus() {
		logger.info("Stop List Device");
		verifyButton("Search");
	}
	
	public void addStopListDevice(StopListDevice stopListDevice){
		Device device=context.get(ContextConstants.DEVICE);
		clickAddNewButton();
		runWithinPopup("Add Stop List Device", ()->{
			enterDeviceNumber("5887653444876018");
		    ClickButton(searchStopListBtn);
		    selectReasonCode(stopListDevice.getStopListReason());
		    enterStopListDescription(stopListDevice.getStopListReasonDescription());
		    clickSaveButton();
		});
	}
	
	public void enterDeviceNumber(String deviceNumber){
		enterText(stopListDeviceNumberTxt, deviceNumber);	
	}
	
	public void selectReasonCode(String reasonCode){
		WebElementUtils.selectDDByVisibleText(reasonCodeDDwn, reasonCode);
	}
	
	public void enterStopListDescription(String description){
		enterText(stopListDeviceDescriptionTxt, description);	
	}
	
	
		
	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(cardNumber),
				WebElementUtils.elementToBeClickable(interchange)
				);
	}
}