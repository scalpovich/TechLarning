package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.math.BigDecimal;
import java.math.MathContext;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.AvailableBalance;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = { CardManagementNav.L1_SEARCH, CardManagementNav.L2_SEARCH_AUTHORIZATION, CardManagementNav.L3_AUTHORIZATION_SEARCH })
public class AuthorizationSearchPage extends AbstractBasePage {

	private static final Logger logger = LoggerFactory.getLogger(AuthorizationSearchPage.class);

	List<String> txnFeesFields = new ArrayList<>();
	
	BigDecimal availableBalanceAterReversal;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=cardNumber]")
	private MCWebElement cardNumber;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=referenceNumber]")
	private MCWebElement referenceNumber;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=authorizationCode]")
	private MCWebElement authorizationCode;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:2:componentList:1:componentPanel:input:dropdowncomponent")
	private MCWebElement productType;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@fld_fqn='fromDate']/..")
	private MCWebElement fromDate;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@fld_fqn='toDate']/..")
	private MCWebElement toDate;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=invalid]")
	private MCWebElement invalid;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=branchRefNumber]")
	private MCWebElement branchRefNumber;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[.//*[text()='Transaction Fee :']]/.//span[@class='labeltextr']")
	private MCWebElement fixedTransactionFee;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//div[@class='tab_content']//span[contains(text(),'Transaction Fee')]/../following-sibling::td//span[@class='labeltextr']")
	private MCWebElement serviceTaxFees;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//div[@id='tab1']//span[contains(text(),'Transaction Amount :')]/..//span[@class='labeltextr']")
	private MCWebElement txnAmount;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//div[@id='tab1']//span[contains(text(),'Billing Amount')]/..//span[@class='labeltextr']")
	private MCWebElement billingAmount;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[.//*[text()='Markup Fee :']]/.//span[@class='labeltextr']")
	private MCWebElement markupFee;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//div[@class='tab_content']//span[contains(text(),'Markup Fee')]/../following-sibling::td//span[@class='labeltextr']")
	private MCWebElement markupFeeTax;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//div[@class='tab_content']//span[contains(text(),'Transaction Currency :')]/following-sibling::span//span[@class='labelselectf']")
	private MCWebElement sourceCurrency;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//div[@class='tab_content']//span[contains(text(),'Billing Currency :')]/following-sibling::span//span[@class='labelselectf']")
	private MCWebElement billingCurrency;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//table[@class='modelFormClass']//span[contains(text(),'Response')]/../following-sibling::td/span/span")
	private MCWebElement responseLbl;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//table[@class='modelFormClass']//span[contains(text(),'Auth Decline Description')]/../following-sibling::td/span/span")
	private MCWebElement authDeclineDescriptionLbl;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//table[@class='modelFormClass']//span[contains(text(),'Auth Decline Code')]/../following-sibling::td[1]/span/span")
	private MCWebElement authDeclineCodeLbl;
	
	@PageElement(findBy=FindBy.X_PATH, valueToFind = "//td[contains(text(),'Available Balance')]/following-sibling::td[1]/span/span")
	private MCWebElement availableBalanceTxt;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "span.time>label+label")
	private MCWebElement institutionDateTxt;
	
	private String amountTypes = "Billing Amount:Transaction Fee:Service Tax:Markup Fee:Markup Service Tax";
	
	public void verifyUiOperationStatus() {
		logger.info("Authorization Search");
		verifySearchButton("Search");
	}

	public void inputDeviceNumber(String deviceNumber) {
		WebElementUtils.enterText(cardNumber, deviceNumber);
	}

	public void inputFromDate(LocalDate date) {
		date = LocalDate.parse(getTextFromPage(institutionDateTxt), DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm:ss")).minusDays(1);
		WebElementUtils.pickDate(fromDate, date);
	}

	public void inputToDate(LocalDate date) {
		date = LocalDate.parse(getTextFromPage(institutionDateTxt), DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm:ss"));
		WebElementUtils.pickDate(toDate, date);
	}

	public void viewDeviceDetails() {
		viewFirstRecord();
	}

	public void authCheckTransactionFee(String deviceNumber) {
		inputDeviceNumber(deviceNumber);
		inputFromDate(LocalDate.now().minusDays(1));
		inputToDate(LocalDate.now());
		waitAndSearchForRecordToAppear();
		viewDeviceDetails();
	}

	public void authCheckMarkUpFee(String deviceNumber) {
		inputDeviceNumber(deviceNumber);
		inputFromDate(LocalDate.now().minusDays(1));
		inputToDate(LocalDate.now());
		waitAndSearchForRecordToAppear();
		viewDeviceDetails();
	}

	public List<String> checkFixedTransactionFee() {
		runWithinPopup("View Authorization", () -> {
			txnFeesFields.add(fixedTransactionFee.getText());
			txnFeesFields.add(serviceTaxFees.getText());
			txnFeesFields.add(txnAmount.getText());
			txnFeesFields.add(billingAmount.getText());
			clickCloseButton();
		});
		return txnFeesFields;
	}

	public List<String> getMarkUpFeeDetails() {
		List<String> markupFeeDetails = new ArrayList<>();
		runWithinPopup("View Authorization", () -> {
			markupFeeDetails.add(billingAmount.getText()); 
			markupFeeDetails.add(markupFee.getText());
			markupFeeDetails.add(markupFeeTax.getText());
			markupFeeDetails.add(billingCurrency.getText());
			markupFeeDetails.add(sourceCurrency.getText());
			clickCloseButton();
		});
		return markupFeeDetails;
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.elementToBeClickable(cardNumber), WebElementUtils.elementToBeClickable(referenceNumber), WebElementUtils.elementToBeClickable(authorizationCode),
				WebElementUtils.elementToBeClickable(productType), WebElementUtils.elementToBeClickable(fromDate), WebElementUtils.elementToBeClickable(toDate),
				WebElementUtils.elementToBeClickable(invalid), WebElementUtils.elementToBeClickable(branchRefNumber));
	}

	public List<String> verifyState(String deviceNumber) {
		List<String> fieldsForAssertion = new ArrayList<>();
		inputDeviceNumber(deviceNumber);
		inputFromDate(LocalDate.now().minusDays(1));
		inputToDate(LocalDate.now());
		clickSearchButton();
		viewFirstRecord();
		runWithinPopup("View Authorization", () -> {
			fieldsForAssertion.add(responseLbl.getText());
			fieldsForAssertion.add(authDeclineCodeLbl.getText());
			fieldsForAssertion.add(authDeclineDescriptionLbl.getText());
			clickCloseButton();
		});
		return fieldsForAssertion;
	}
	
	public BigDecimal viewAvailableBalanceAfterReversalTransaction(String deviceNumber) {
		inputDeviceNumber(deviceNumber);
		inputFromDate(LocalDate.now().minusDays(1));
		inputToDate(LocalDate.now());
		clickSearchButton();
		viewFirstRecord();
		runWithinPopup("View Authorization", () -> {
		availableBalanceAterReversal = new BigDecimal(availableBalanceTxt.getText());
			clickCloseButton();
		});
		return availableBalanceAterReversal;
	}
	
	public AvailableBalance getAvailableBalance(){
		String[] amountType = amountTypes.split(":");
		AvailableBalance availBal = new AvailableBalance();
		runWithinPopup("View Authorization", () -> {
			BigDecimal sum =  new BigDecimal(0)   ;
			for(String str : amountType){
				String value = Element("//span[contains(text(),'"+str+"')]/../span[2]/span").getText();
				logger.info("value of " + str + " = "+  value);
				sum = sum.add(new BigDecimal(value),  new MathContext(5));
			}
			availBal.setSum(sum);
			availBal.setAvailableBal(new BigDecimal(getTextFromPage(availableBalanceTxt)));			
			clickCloseButton();
		});
		return availBal;
	}
}