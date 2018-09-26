package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.google.inject.Provider;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.SendToCarrier;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.DateUtils;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.pts.integrated.issuing.utils.simulator.SimulatorUtilities;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_ACTIVITY, CardManagementNav.L2_DEVICE,
		CardManagementNav.L3_SEND_TO_CARRIER })
public class SendToCarrierPage extends AbstractBasePage {

	private static final Logger logger = LoggerFactory
			.getLogger(SendToCarrierPage.class);

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement productTypeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:1:componentPanel:input:dropdowncomponent")
	private MCWebElement fileTypeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:2:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement fileNameTxt;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@value = 'Search'][@type = 'submit']")
	private MCWebElement searchBtn;
	
    @PageElement(findBy = FindBy.CSS, valueToFind = "span.time>label+label")
	private MCWebElement institutionDateTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value='Save']")
	private MCWebElement saveBtn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "dataPanel:inlineTable:container:dataList:0:colList:colHeaders:2:inputField:checkBoxComponent")
	private MCWebElement selectChkBx;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "vendorCode:input:dropdowncomponent")
	private MCWebElement carrierVendorCodeDDwn;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@fld_fqn='expectedRecieptDate']/..")
	private MCWebElement expectedDeliveryDateTxt;
	
	public void verifyUiOperationStatus() {
		logger.info("Send to Carriage");
		verifySearchButton("Search");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.elementToBeClickable(productTypeDDwn),
				WebElementUtils.elementToBeClickable(fileTypeDDwn),
				WebElementUtils.elementToBeClickable(fileNameTxt));
	}
	
	public void processSendToCarrierBatch(SendToCarrier sendToCarrier)
	{
		WebElementUtils.selectDropDownByVisibleText(productTypeDDwn, sendToCarrier.getProductType());
		doSelectByVisibleText(fileTypeDDwn, sendToCarrier.getFileType());
		SimulatorUtilities.wait(6000);
		doSelectByVisibleText(fileNameTxt, sendToCarrier.getFileName());
        clickSearchButton();
        SimulatorUtilities.wait(2000);
        ClickCheckBox(selectChkBx, true);
        WebElementUtils.selectDropDownByVisibleText(carrierVendorCodeDDwn,sendToCarrier.getCourierVendorName());
        WebElementUtils.pickDate(expectedDeliveryDateTxt, DateUtils.convertInstitutionDateInLocalDateFormat(getTextFromPage(institutionDateTxt)));
        clickSaveButton();
		verifyOperationStatus();
	}	
}
