package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.ManualAlerts;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_INSTITUTION_PARAMETER_SETUP,
		CardManagementNav.L2_EVENTS, 
		CardManagementNav.L3_MANUAL_ALERTS 
})

public class ManualAlertsPage extends AbstractBasePage {

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=evtJobId]")
	private MCWebElement evtJobId;
	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addManualAlertBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "productType:input:dropdowncomponent")
	private MCWebElement selectProductDdwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "eventCode:input:dropdowncomponent")
	private MCWebElement selectEventCodeDdwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement saveBtn;	

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchPanel:searchForm:searchDiv:rows:1:componentList:0:componentPanel:input:inputTextField")
	private MCWebElement clientCodeTxt;	

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchPanel:searchForm:searchDiv:rows:1:componentList:1:componentPanel:input:dropdowncomponent")
	private MCWebElement programCodeDdwn;	

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchPanel:searchForm:searchDiv:rows:2:componentList:0:componentPanel:input:inputTextField")
	private MCWebElement firstNameTxt;	

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchPanel:searchForm:searchDiv:rows:2:componentList:1:componentPanel:input:inputTextField")
	private MCWebElement familyNameTxt;	

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchPanel:searchForm:searchDiv:rows:3:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement deviceTypeDdwn;	

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchPanel:searchForm:searchDiv:rows:2:componentList:0:componentPanel:input:inputTextField")
	private MCWebElement cbsClientIDTxt;

	public void addManualRecipient(ManualAlerts manualAlert){
		switchToIframe(Constants.ADD_MANUAL_RECIPIENT);
		enterValueinTextBox(clientCodeTxt, manualAlert.getClientCode());
		selectByVisibleText(programCodeDdwn, manualAlert.getProgramCodeDdwn());
		enterValueinTextBox(firstNameTxt, manualAlert.getFirstNameTxt());
		enterValueinTextBox(familyNameTxt, manualAlert.getFamilyNameTxt());
		selectByVisibleText(deviceTypeDdwn, manualAlert.getDeviceTypeDdwn());
		enterValueinTextBox(cbsClientIDTxt, manualAlert.getCbsClientIDTxt());		

	}

	private static final Logger logger = LoggerFactory
			.getLogger(ManualAlertsPage.class);

	public void verifyUiOperationStatus() {
		logger.info("Manual Event");
		verifySearchButton("Search");
	}
	public void clickAddcurrency(){
		clickWhenClickable(addManualAlertBtn);
		switchToWindow(Constants.ADD_MANUAL_ALERTS);
	}
	public void addAlertDetails(ManualAlerts alertpage){
		selectByVisibleText(selectProductDdwn,alertpage.getProduct());
		selectByVisibleText(selectEventCodeDdwn,alertpage.getEventCode());		
		waitForLoaderToDisappear();
		clickWhenClickable(saveBtn);
		waitForLoaderToDisappear();
		clickWhenClickable(addManualAlertBtn);
	}

	public void switchToWindow(String screenName) {
		addWicketAjaxListeners(driver());
		switchToIframe(screenName);
	} 

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.elementToBeClickable(evtJobId));
	}
}