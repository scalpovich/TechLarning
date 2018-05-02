package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.TransactionRoutingPlan;
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
		CardManagementNav.L2_ROUTING,
		CardManagementNav.L3_TRANSACTION_ROUTING
		})

public class TransactionRoutingPage extends AbstractBasePage {
	
	private static final Logger logger = LoggerFactory.getLogger(TransactionRoutingPage.class);

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement interfaceName;	
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:1:componentPanel:input:dropdowncomponent")
	private MCWebElement routingCode;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:2:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement transactionType;
	
	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addplanBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "svrMsg:input:dropdowncomponent")
	private MCWebElement messageTypeDdwn;	

	@PageElement(findBy = FindBy.NAME, valueToFind = "svrProcessingCod:input:dropdowncomponent")
	private MCWebElement transactionTypeDdwn;	

	@PageElement(findBy = FindBy.NAME, valueToFind = "svrRoutingCode:input:dropdowncomponent")
	private MCWebElement routingCodeDdwn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "svrServiceState:input:dropdowncomponent")
	private MCWebElement actionDdwn;	

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement saveBtn;

	public void verifyUiOperationStatus() {
		logger.info("Transaction Routing");
		verifyUiOperation("Add Transaction Routing");
	}
	
	public void clickAddcurrency(){
		clickWhenClickable(addplanBtn);
		switchToWindow(Constants.ADD_TRANSACTION_ROUTING);
	}
	
	public void switchToWindow(String screenName) {
		addWicketAjaxListeners(driver());
		switchToIframe(screenName);
	} 
	public void addRoutingDetails(TransactionRoutingPlan transRoutingPlan){
		selectByVisibleText(messageTypeDdwn,transRoutingPlan.getMessageTypeDdwn());
		selectByVisibleText(transactionTypeDdwn,transRoutingPlan.getTransactionTypeDdwn());	
		selectByVisibleText(routingCodeDdwn,transRoutingPlan.getRoutingCodeDdwn());
		selectByVisibleText(actionDdwn,transRoutingPlan.getActionDdwn());
		clickWhenClickable(saveBtn);
		waitForLoaderToDisappear();
		
		
	}
			
	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(interfaceName),
				WebElementUtils.elementToBeClickable(routingCode),
				WebElementUtils.elementToBeClickable(transactionType)
				);
	}
}