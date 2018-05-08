package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.AccountRangeRoutingPlan;
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
		CardManagementNav.L3_ACCOUNT_RANGE_ROUTING
		})

public class AccountRangeRoutingPage extends AbstractBasePage {
	
	private static final Logger logger = LoggerFactory.getLogger(AccountRangeRoutingPage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=minAccountRange]")
	private MCWebElement minAccountRange;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=maxAccountRange]")
	private MCWebElement maxAccountRange;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "minAccountRange:input:inputTextField")
	private MCWebElement minAccountNumber;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "maxAccountRange:input:inputTextField")
	private MCWebElement maxAccountNumber;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "componentName:input:dropdowncomponent")
	private MCWebElement channelRoutingPlan;
	
	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addplanBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement saveBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cancel")
	private MCWebElement cancelBtn;

	public void clickAddChannelRouting(){
		clickWhenClickable(addplanBtn);
		switchToWindow(Constants.ADD_ACCOUNT_ROUTING_PLAN);
	}
	
	public void switchToWindow(String screenName) {
		addWicketAjaxListeners(driver());
		switchToIframe(screenName);
	} 
	public void addRoutingDetails(AccountRangeRoutingPlan accountrangeroutingplan){
		clickAddChannelRouting();
		 	enterText(minAccountNumber ,accountrangeroutingplan.getFromAccount());		
			enterText(maxAccountRange, accountrangeroutingplan.getToAccount());
			selectByVisibleText(channelRoutingPlan,accountrangeroutingplan.getChannelRoutingPlan());
		 clickWhenClickable(saveBtn);
		waitForLoaderToDisappear();	
		SwitchToDefaultFrame();
		verifyNewChannelRoutingSuccess();
		
	}
	public void verifyNewChannelRoutingSuccess() {
		if (!publishErrorOnPage()) {
			logger.info("Record Added Successfully.");
			SwitchToDefaultFrame();
		} else {
			logger.info("Error in record Addition");
			clickWhenClickable(cancelBtn);
			SwitchToDefaultFrame();

		}
	}
	
	
	
	public void verifyUiOperationStatus() {
		logger.info("Account Range Routing");
		verifyUiOperation("Add Account Range Routing");
	}
	
	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(minAccountRange),
				WebElementUtils.elementToBeClickable(maxAccountRange)
				);
	}
}