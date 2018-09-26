package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.BatchDefinition;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CarrierAcknowledgement;
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
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = { CardManagementNav.L1_ACTIVITY,
		CardManagementNav.L2_DEVICE, CardManagementNav.L3_CARRIER_ACKNOWLEDGEMENT })

public class CarrierAcknowledgementPage extends AbstractBasePage {

	private static final Logger logger = LoggerFactory.getLogger(CarrierAcknowledgementPage.class);

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement productType;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:1:componentPanel:input:dropdowncomponent")
	private MCWebElement fileType;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:2:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement vendorCode;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:2:componentList:1:componentPanel:input:dropdowncomponent")
	private MCWebElement fileName;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@value = 'Search'][@type = 'submit']")
	private MCWebElement searchBtn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value='Save']")
	private MCWebElement saveBtn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "span.time>label+label")
	private MCWebElement institutionDateTxt;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "awbNumber:input:inputTextField")
	private MCWebElement AWBNumberTxt;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "receivedBy:input:inputTextField")
	private MCWebElement receivedByTxt;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "status:input:dropdowncomponent")
	private MCWebElement statusDDwn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "relationship:input:inputTextField")
	private MCWebElement relationshipTxt;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@name='deliveryDate:input:dateTimeField:date']/..")
	private MCWebElement deliveryDateTxt;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "deliveryDate:input:dateTimeField:hours")
	private MCWebElement deliveryDateHours;	
			
	@PageElement(findBy = FindBy.NAME, valueToFind = "deliveryDate:input:dateTimeField:minutes")
	private MCWebElement deliveryDateMinutes;	
	
	public void verifyUiOperationStatus() {
		logger.info("Carrier Acknowledgement");
		verifySearchButton("Search");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.elementToBeClickable(productType),
				WebElementUtils.elementToBeClickable(fileType), WebElementUtils.elementToBeClickable(vendorCode),
				WebElementUtils.elementToBeClickable(fileName));
	}

	public void processCarrierAcknowledgementBatch(CarrierAcknowledgement carrierAcknowledgement) {
		WebElementUtils.selectDropDownByVisibleText(productType, carrierAcknowledgement.getProductType());
		doSelectByVisibleText(fileType, carrierAcknowledgement.getFileType());
		SimulatorUtilities.wait(5000);
		WebElementUtils.selectDropDownByVisibleText(vendorCode, carrierAcknowledgement.getCourierVendorName());
		SimulatorUtilities.wait(5000);
		doSelectByVisibleText(fileName, carrierAcknowledgement.getFileName());
		clickSearchButton();
		SimulatorUtilities.wait(2000);
		editCarrierAcknowledgementRecordDetails(carrierAcknowledgement);
		verifyOperationStatus();
	}

	public void editCarrierAcknowledgementRecordDetails(CarrierAcknowledgement carrierAcknowledgement) {
		editFirstRecord();
		
		runWithinPopup("Edit Carrier Acknowledgement", () -> {
			WebElementUtils.enterText(AWBNumberTxt, carrierAcknowledgement.getAWBNumber());
			WebElementUtils.selectDropDownByVisibleText(statusDDwn, carrierAcknowledgement.getStatus());
			SimulatorUtilities.wait(2000);
			WebElementUtils.enterText(receivedByTxt, carrierAcknowledgement.getReceivedBy());
			WebElementUtils.enterText(relationshipTxt, carrierAcknowledgement.getRelationship());
			WebElementUtils.pickDate(deliveryDateTxt, LocalDate.now());
			clickSaveButton();
		});
	}

}
