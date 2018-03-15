package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

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

	public void verifyUiOperationStatus() {
		logger.info("Authorization Search");
		verifySearchButton("Search");
	}

	public void inputDeviceNumber(String deviceNumber) {
		WebElementUtils.enterText(cardNumber, deviceNumber);
	}

	public void inputFromDate(LocalDate date) {
		WebElementUtils.pickDate(fromDate, date);
	}

	public void inputToDate(LocalDate date) {
		WebElementUtils.pickDate(toDate, date);
	}

	public void viewDeviceDetails() {
		viewFirstRecord();
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

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.elementToBeClickable(cardNumber), WebElementUtils.elementToBeClickable(referenceNumber), WebElementUtils.elementToBeClickable(authorizationCode),
				WebElementUtils.elementToBeClickable(productType), WebElementUtils.elementToBeClickable(fromDate), WebElementUtils.elementToBeClickable(toDate),
				WebElementUtils.elementToBeClickable(invalid), WebElementUtils.elementToBeClickable(branchRefNumber));
	}

}