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
	private MCWebElement minAccountRangeTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=maxAccountRange]")
	private MCWebElement maxAccountRangeTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "minAccountRange:input:inputTextField")
	private MCWebElement minAccountNumberTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "maxAccountRange:input:inputTextField")
	private MCWebElement maxAccountNumberTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "componentName:input:dropdowncomponent")
	private MCWebElement channelRoutingPlanDdwn;

	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addplanBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement saveBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cancel")
	private MCWebElement cancelBtn;

	public void clickAddChannelRouting(){
		clickWhenClickable(addplanBtn);
		switchToIframe(Constants.ADD_ACCOUNT_ROUTING_PLAN);
	}

	public void addRoutingDetails(AccountRangeRoutingPlan accountRangeRoutingPlan){
		clickAddChannelRouting();
		enterText(minAccountNumberTxt ,accountRangeRoutingPlan.getFromAccount());		
		enterText(maxAccountRangeTxt, accountRangeRoutingPlan.getToAccount());
		selectByVisibleText(channelRoutingPlanDdwn,accountRangeRoutingPlan.getChannelRoutingPlan());
		clickWhenClickable(saveBtn);
		waitForLoaderToDisappear();	
		if (!publishErrorOnPage()) {			
			SwitchToDefaultFrame();
			verifyNewChannelRoutingSuccess();
		} else {
			logger.info("Error in record Addition");
			clickWhenClickable(cancelBtn);
			SwitchToDefaultFrame();

		}
		
		
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
				WebElementUtils.elementToBeClickable(minAccountRangeTxt),
				WebElementUtils.elementToBeClickable(maxAccountRangeTxt)
				);
	}
}