package com.mastercard.pts.integrated.issuing.pages.customer.loyalty;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.loyalty.EventBasedLoyaltyPlan;
import com.mastercard.pts.integrated.issuing.domain.customer.loyalty.EventBasedLoyaltyPointsPosting;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = LoyaltyNav.TAB_LOYALTY, treeMenuItems = {
		LoyaltyNav.L1_ACTIVITY,
		LoyaltyNav.L2_EVENT_BASED_LOYALTY_POINTS_POSTING
		})
public class EventBasedLoyaltyPointsPostingPage extends AbstractBasePage{

	private static final Logger logger = LoggerFactory
			.getLogger(EventBasedLoyaltyPointsPostingPage.class);
	
	private static final String ADD_EVENT_BASED_LOYALTY_POINTS_POSTING = "Add Event Based Loyalty Points Posting";

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:0:componentPanel:input:inputTextField")
	private MCWebElement transactionIdTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cardNumber:input:inputTextField")
	private MCWebElement deviceNumberTxt;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "productType:input:dropdowncomponent")
	private MCWebElement productTypeDdwn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "lyeEventCode:input:dropdowncomponent")
	private MCWebElement eventNameDdwn;	
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "memo:input:textAreaComponent")
	private MCWebElement memoTxt;
	
	
	
	public void verifyUiOperationStatus() {
		logger.info("Event Based Loyalty Points Posting");
		verifyUiOperation("Add Event Based Loyalty Points Posting");
	}
	
	public void addEventBasedLoyaltyPointsPosting(EventBasedLoyaltyPointsPosting plan){
		clickAddNewButton();
		runWithinPopup(ADD_EVENT_BASED_LOYALTY_POINTS_POSTING, () -> {
		WebElementUtils.enterText(deviceNumberTxt, plan.getDeviceNumber());
		WebElementUtils.selectDropDownByVisibleText(productTypeDdwn, plan.getProductType());
		WebElementUtils.selectDropDownByVisibleText(eventNameDdwn, plan.getEventName());		
		WebElementUtils.enterText(memoTxt, plan.getMemo());		
		clickSaveButton();
		});
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.elementToBeClickable(transactionIdTxt));
	}
}
