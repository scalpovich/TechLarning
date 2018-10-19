package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.AuthorizationRequest;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.pts.integrated.issuing.utils.simulator.SimulatorUtilities;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT,
treeMenuItems = { CardManagementNav.L1_ACTIVITY, CardManagementNav.L2_AUTHORIZATION, CardManagementNav.L3_REQUEST})

public class AuthorizationRequestPage extends AbstractBasePage{

	private static final Logger logger = LoggerFactory.getLogger(AuthorizationRequestPage.class);

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:0:componentPanel:input:inputTextField")
	private MCWebElement deviceNumberSearchTxt;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "cardNumber:input:inputTextField")
	private MCWebElement deviceNumberTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "transactionCurrency:input:dropdowncomponent")
	private MCWebElement transactionCurrencyDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "transactionAmount:input:inputAmountField")
	private MCWebElement transactionAmountTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cardAcceptorActivity:input:dropdowncomponent")
	private MCWebElement mccDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "memo:input:textAreaComponent")
	private MCWebElement memoTxt;

	private String successMessage = null;
	
	public String addAuthorizationRequest(AuthorizationRequest request){
		logger.info("Authorization Request: {}", request.getDeviceNumber());
		clickAddNewButton();
		runWithinPopup("Add Request", () -> {
			WebElementUtils.enterText(deviceNumberTxt, request.getDeviceNumber());
			WebElementUtils.selectDropDownByVisibleText(transactionCurrencyDDwn, request.getTransactionCurrency());
			WebElementUtils.enterText(transactionAmountTxt, request.getTransactionAmount());
			WebElementUtils.selectDropDownByVisibleText(mccDDwn, request.getMcc());
			WebElementUtils.enterText(transactionAmountTxt, request.getTransactionAmount());
			WebElementUtils.enterText(memoTxt, request.getMemo());
			clickSaveButton();
			SimulatorUtilities.wait(40000);
			successMessage = getMessageFromFeedbackPanel();
			logger.info("Success Meesage: " + successMessage);
			clickOkButton();
		});
		
		return successMessage;
	}
	
	public void verifyUiOperationStatus() {
	logger.info("Request");
	verifySearchButton("Search");
}
	
	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(deviceNumberSearchTxt));
	}

}
