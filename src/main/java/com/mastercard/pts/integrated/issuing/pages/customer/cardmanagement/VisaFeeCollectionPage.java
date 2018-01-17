package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.VisaFeeCollection;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.DateUtils;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_ACTIVITY, CardManagementNav.L2_VISA,
		CardManagementNav.L3_VISA_FEE_COLLECTION })
public class VisaFeeCollectionPage extends AbstractBasePage {
	
	@Autowired
	private TestContext context;
	
	@Autowired
	protected DateUtils date;

	private static final Logger logger = LoggerFactory
			.getLogger(VisaFeeCollectionPage.class);

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement transactionCode;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:1:componentPanel:input:dropdowncomponent")
	private MCWebElement sourceBin;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=cardNumber]")
	private MCWebElement cardNumber;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "countryCode:input:dropdowncomponent")
	private MCWebElement country;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "destinationBin:input:inputTextField")
	private MCWebElement destinationBin;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "sourceCurrencyCode:input:dropdowncomponent")
	private MCWebElement sourceCurrency;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "reasonCode:input:inputTextField")
	private MCWebElement reasonCode;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "eventDate:input:inputTextField")
	private MCWebElement eventDate;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "cardNumber:input:inputTextField")
	private MCWebElement deviceNumber;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "transactionIdentifier:input:inputTextField")
	private MCWebElement transactionIdentifier;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "sourceAmount:input:inputAmountField")
	private MCWebElement sourceAmount;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "messageText:input:inputTextField")
	private MCWebElement messageText;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement saveButton;
	
	public void verifyUiOperationStatus() {
		logger.info("VISA Fee Collection");
		verifyUiOperation("Add Visa Fees");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(transactionCode),
				WebElementUtils.elementToBeClickable(sourceBin),
				WebElementUtils.elementToBeClickable(cardNumber)
				);
	}
	public void addVisaFeeCollection(VisaFeeCollection visafeecollection,String option)
	{
		Device device=context.get(ContextConstants.DEVICE);
		clickAddNewButton();
		elementToBeClickable(transactionCode);
		selectByVisibleText(transactionCode, option);
		selectByVisibleText(sourceBin, device.getDeviceNumber().substring(0, 4));
		selectByVisibleText(country, visafeecollection.getCountry());
		WebElementUtils.enterText(destinationBin, device.getDeviceNumber().substring(0, 4));
		selectByVisibleText(sourceCurrency, visafeecollection.getSourceCurrency());
		WebElementUtils.enterText(reasonCode, visafeecollection.getReasonCode());
		WebElementUtils.enterText(eventDate, date.getDateMMDDFormat());
		WebElementUtils.enterText(deviceNumber, device.getDeviceNumber());
		WebElementUtils.enterText(sourceAmount, visafeecollection.getSourceAmount());
		WebElementUtils.enterText(messageText, RandomStringUtils.randomAlphanumeric(10));	
		clickSaveButton();
	}
}