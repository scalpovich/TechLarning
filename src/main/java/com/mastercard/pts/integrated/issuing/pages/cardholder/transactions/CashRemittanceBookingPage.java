package com.mastercard.pts.integrated.issuing.pages.cardholder.transactions;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.TransactionsNav;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = TransactionsNav.TAB_TRANSACTIONS, treeMenuItems = { TransactionsNav.L1_CASH_REMITTANCE_BOOKINGS })
public class CashRemittanceBookingPage extends AbstractBasePage {
	private static final Logger logger = LoggerFactory.getLogger(CashRemittanceBookingPage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "div .Title")
	private MCWebElement masterDetailContentTitle;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[contains(text(), 'Available Balance')]/following-sibling::td[1]")
	private MCWebElement availableBalanceLbl;

	@PageElement(findBy = FindBy.ID, valueToFind = "beneficiaryNationalId")
	private MCWebElement beneficiaryNationalIdTxt;

	@PageElement(findBy = FindBy.ID, valueToFind = "firstName")
	private MCWebElement firstNameTxt;

	@PageElement(findBy = FindBy.ID, valueToFind = "middleName")
	private MCWebElement middleNameTxt;

	@PageElement(findBy = FindBy.ID, valueToFind = "lastName")
	private MCWebElement lastNameTxt;

	@PageElement(findBy = FindBy.ID, valueToFind = "address1")
	private MCWebElement address1Txt;

	@PageElement(findBy = FindBy.ID, valueToFind = "address2")
	private MCWebElement address2Txt;

	@PageElement(findBy = FindBy.ID, valueToFind = "address3")
	private MCWebElement address3Txt;

	@PageElement(findBy = FindBy.ID, valueToFind = "countryName")
	private MCWebElement countryNameTxt;

	@PageElement(findBy = FindBy.ID, valueToFind = "selectedState")
	private MCWebElement selectedStateDDwn;

	@PageElement(findBy = FindBy.ID, valueToFind = "selectedCity")
	private MCWebElement selectedCityTxt;

	@PageElement(findBy = FindBy.ID, valueToFind = "zipCode")
	private MCWebElement zipCodeTxt;

	@PageElement(findBy = FindBy.ID, valueToFind = "emailId")
	private MCWebElement emailIdTxt;

	@PageElement(findBy = FindBy.ID, valueToFind = "mobileNumber")
	private MCWebElement mobileNumberTxt;

	@PageElement(findBy = FindBy.ID, valueToFind = "txnAmount")
	private MCWebElement txnAmountTxt;

	@PageElement(findBy = FindBy.ID, valueToFind = "selectedTxnCurrency")
	private MCWebElement selectedTxnCurrencyDDwn;
	
	@PageElement(findBy = FindBy.ID, valueToFind="mpts_cardHolderPortal_button_submit")
	private MCWebElement cashRemittanceSubmitBtn;
	
	@PageElement(findBy = FindBy.ID, valueToFind="firstName")
	private MCWebElement beneficiaryFirstName;
	
	@PageElement(findBy = FindBy.ID, valueToFind="middleName")
	private MCWebElement beneficiaryMiddleName;
	
	@PageElement(findBy = FindBy.ID, valueToFind="lastName")
	private MCWebElement beneficiaryLastName;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind="//td[@class='sectionHead']/span")
	private MCWebElement isCashRemittanceAllowed;
	
	public boolean isCashRemittanceAllowedForAccount(){
	
		return 	isElementPresent(isCashRemittanceAllowed);
	}
	
	public void enterBeneficiaryFirstName(String firstName){
		enterText(beneficiaryFirstName, firstName);
	}
	
	public void enterBeneficiaryMiddleName(String middleName){
		enterText(beneficiaryMiddleName, middleName);
	}

	public void enterBeneficiaryLastName(String lastName){
		enterText(beneficiaryLastName, lastName);
	}
	
	public void enterBeneficiaryId(String beneficiaryId){
		enterText(beneficiaryNationalIdTxt, beneficiaryId);
	}
	
	public void enterBeneficiaryAddress1(String addressLineOne){
		enterText(address1Txt, addressLineOne);
	}
	
	public void enterBeneficiaryAddress2(String addressLineTwo){
		enterText(address2Txt, addressLineTwo);
	}
	
	public void enterBeneficiaryAddress3(String addressLineThree){
		enterText(address3Txt, addressLineThree);
	}
	
	public void enterBeneficiaryStateName(String beneficiaryStateName){
		SelectDropDownByText(selectedStateDDwn, beneficiaryStateName);
	}
	
	public void enterBeneficiaryCityName(String cityName){
		enterText(selectedCityTxt, cityName);
	}
	
	public void enterBeneficiaryZipCode(String zipCode){
		enterText(zipCodeTxt, zipCode);
	}
	
	public void enterBeneficiaryEmailAddress(String emailAddress){
		enterText(emailIdTxt, emailAddress);
	}
	
	public void enterBeneficiaryMobileNumber(String mobileNumber){
		enterText(mobileNumberTxt, mobileNumber);
		
	}

	public void verifyUiOperationStatus() {
		logger.info("Cash Remittance Booking");
		verifyTitleCardHolderPortal("Cash Remittance Booking");
		verifyWalletDetails();
		verifyDeviceDetails();
		verifyButton("Submit");
		verifyButton("Cancel");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.visibilityOf(masterDetailContentTitle), WebElementUtils.visibilityOf(availableBalanceLbl),
				WebElementUtils.visibilityOf(beneficiaryNationalIdTxt), WebElementUtils.visibilityOf(firstNameTxt),
				WebElementUtils.visibilityOf(middleNameTxt), WebElementUtils.visibilityOf(lastNameTxt), WebElementUtils.visibilityOf(address1Txt),
				WebElementUtils.visibilityOf(address2Txt), WebElementUtils.visibilityOf(address3Txt), WebElementUtils.visibilityOf(countryNameTxt),
				WebElementUtils.visibilityOf(selectedStateDDwn), WebElementUtils.visibilityOf(selectedCityTxt), WebElementUtils.visibilityOf(zipCodeTxt),
				WebElementUtils.visibilityOf(emailIdTxt), WebElementUtils.visibilityOf(mobileNumberTxt), WebElementUtils.visibilityOf(txnAmountTxt),
				WebElementUtils.visibilityOf(selectedTxnCurrencyDDwn));
	}
	
	public void enterRemittanceAmount(String remittanceAmount){
		enterText(txnAmountTxt, remittanceAmount);
	}
	
	public void enterRemittanceCurrency(String remittanceCurrency){
		enterText(selectedTxnCurrencyDDwn, remittanceCurrency);
	}
	
	public void submitRemittanceRequst(){
		ClickButton(cashRemittanceSubmitBtn);
	}
	


}
