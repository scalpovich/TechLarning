package com.mastercard.pts.integrated.issuing.pages.customer.loyalty;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.loyalty.EventBasedLoyaltyPlan;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = LoyaltyNav.TAB_LOYALTY, treeMenuItems = {
		LoyaltyNav.L1_LOYALTY_SETUP,
		LoyaltyNav.L2_EVENT_BASED_LOYALTY_POINTS
		})
public class EventBasedLoyaltyPointsPage extends AbstractBasePage{

	private static final Logger logger = LoggerFactory
			.getLogger(EventBasedLoyaltyPointsPage.class);
	
	private static final String ADD_EVENT_BASED_LOYALTY_POINTS = "Add Event Based Loyalty Points";

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:0:componentPanel:input:inputTextField")
	private MCWebElement eventCodeTxt;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@id='lyeEventCode']/input")
	private MCWebElement txtEventCode;
	
	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement iconEventBasedLoyaltyPointsAdd;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@id='lyeProductType']/select")
	private MCWebElement productTypeDdwn;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@id='lyeCrDrIndicator']/select")
	private MCWebElement crDrTypeDdwn;	
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@id='lyeEventDescription']/input")
	private MCWebElement descriptionTxt;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@id='lyePointsAlloted']/input")
	private MCWebElement pointsTxt;

	public void verifyUiOperationStatus() {
		logger.info("Event Based Loyalty Points ");
		verifyUiOperation("Add Event Based Loyalty Points");
	}

	public void addEventBasedLoyaltyPoints(EventBasedLoyaltyPlan plan){
		clickAddNewButton();
		runWithinPopup(ADD_EVENT_BASED_LOYALTY_POINTS, () -> {
		WebElementUtils.enterText(txtEventCode, plan.getEventCode());
		WebElementUtils.selectDropDownByVisibleText(productTypeDdwn, plan.getProductType());
		WebElementUtils.enterText(descriptionTxt, plan.getEventDescription());
		if(plan.getType().contains("Debit")){
			WebElementUtils.enterText(pointsTxt, plan.getEventPointsTobeDebited());	
		}else{
			WebElementUtils.enterText(pointsTxt, plan.getEventPoints());
		}
		WebElementUtils.selectDropDownByVisibleText(crDrTypeDdwn, plan.getType());
		clickSaveButton();
		});
	}
	
		
	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.elementToBeClickable(eventCodeTxt));
	}
}
