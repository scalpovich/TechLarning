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
	protected DateUtils date;
	@Autowired
	private TestContext context;

	private static final Logger logger = LoggerFactory
			.getLogger(VisaFeeCollectionPage.class);

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement transactionCode;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:1:componentPanel:input:dropdowncomponent")
	private MCWebElement sourceBin;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=cardNumber]")
	private MCWebElement cardNumber;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "transactionCode:input:dropdowncomponent")
	private MCWebElement addFeesTransactionCodeDD;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "sourceBin:input:dropdowncomponent")
	private MCWebElement addFeesSourceBinDD;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "countryCode:input:dropdowncomponent")
	private MCWebElement countryDD;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "destinationBin:input:inputTextField")
	private MCWebElement destinationBinTxt;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "sourceCurrencyCode:input:dropdowncomponent")
	private MCWebElement sourceCurrencyDD;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "reasonCode:input:inputTextField")
	private MCWebElement reasonCodeTxt;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "eventDate:input:inputTextField")
	private MCWebElement eventDateTxt;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "cardNumber:input:inputTextField")
	private MCWebElement deviceNumberTxt;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "transactionIdentifier:input:inputTextField")
	private MCWebElement transactionIdentifier;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "sourceAmount:input:inputAmountField")
	private MCWebElement sourceAmountTxt;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "messageText:input:inputTextField")
	private MCWebElement messageTextTxt;
	
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
	public void addVisaFeeCollection(VisaFeeCollection visafeecollection)
	{
		Device device=context.get(ContextConstants.DEVICE);
		clickAddRecordButton();
		runWithinPopup("Add Visa Fees",() -> {selectTransactionCode(visafeecollection.getTransactionCode());
		selectSourceBin(device.getDeviceNumber());
		selectCountry(visafeecollection.getCountry());
		enterDestinationBin(device.getDeviceNumber());
		selectSourceCurrency(visafeecollection.getSourceCurrency());
		enterReasonCode(visafeecollection.getReasonCode());
		enterEventDate(date.getDateMMDDFormat());
		enterDeviceNumber(device.getDeviceNumber());
		enterSourceAmount(visafeecollection.getSourceAmount());
		enterMessagetextAndClickOnSaveButton();});
		verifyOperationStatus();

	}
    public void clickAddRecordButton()
    {
    	clickAddNewButton();
    }
	public void selectTransactionCode(String option)
	{
		WebElementUtils.selectDropDownByVisibleText(addFeesTransactionCodeDD, option);		
	}
	public void selectSourceBin(String option)
	{
		WebElementUtils.selectDropDownByVisibleText(addFeesSourceBinDD, option.substring(0, 6)+" ["+option.substring(0, 6)+"]");		
	}
	
	public void selectCountry(String option)
	{
		WebElementUtils.selectDropDownByVisibleText(countryDD, option);	
	}
	
	public void enterDestinationBin(String option)
	{
		WebElementUtils.enterText(destinationBinTxt, option.substring(0, 6));
	}
	
	public void selectSourceCurrency(String option)
	{
		WebElementUtils.selectDropDownByVisibleText(sourceCurrencyDD,option);
	}
	
	public void enterReasonCode(String option)
	{
		WebElementUtils.enterText(reasonCodeTxt,option);
	}
	public void enterEventDate(String option)
	{
		WebElementUtils.enterText(eventDateTxt,option);
	}
	public void enterDeviceNumber(String option)
	{
		WebElementUtils.enterText(deviceNumberTxt, option);
	}
	
	public void enterSourceAmount(String option)
	{
		WebElementUtils.enterText(sourceAmountTxt, option);
	}
	public void enterMessagetextAndClickOnSaveButton()
	{
		WebElementUtils.enterText(messageTextTxt, RandomStringUtils.randomAlphanumeric(10));	
		clickSaveButton();
	}
	
}