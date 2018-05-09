package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.AggregateLoadLimit;
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
		CardManagementNav.L2_AGGREGATE_LOAD_LIMIT
})
public class AggregateLoadLimitPage extends AbstractBasePage {

	private static final Logger logger = LoggerFactory.getLogger(AggregateLoadLimitPage.class);

	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addplanBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement saveBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cancel")
	private MCWebElement cancelBtn;
	@PageElement(findBy = FindBy.NAME, valueToFind = "planStartDate:input:dateTextField")
	private MCWebElement planStartDate;

	@PageElement(findBy = FindBy.NAME, valueToFind = "planEndDate:input:dateTextField")
	private MCWebElement plansEndDate;
	@PageElement(findBy = FindBy.NAME, valueToFind = "monthlyAggregateLoadLimits:input:inputAmountField")
	private MCWebElement monthlyLimitTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "monthlyAggregateLoadVelocity:input:inputTextField")
	private MCWebElement monthlyVelocityTxt;
	@PageElement(findBy = FindBy.NAME, valueToFind = "yearlyAggregateLoadLimits:input:inputAmountField")
	private MCWebElement yearlyLimitTxt;
	@PageElement(findBy = FindBy.NAME, valueToFind = "yearlyAggregateLoadVelocity:input:inputTextField")
	private MCWebElement yearlyVelocityTxt;
	@PageElement(findBy = FindBy.NAME, valueToFind = "currencyCode:input:dropdowncomponent")
	private MCWebElement currencyCodeTxt;

	@PageElement(findBy = FindBy.ID, valueToFind = "planStartDate")
	private MCWebElement startDateDPkr;

	@PageElement(findBy = FindBy.ID, valueToFind = "planEndDate")
	private MCWebElement endDateDPkr;


	public void clickAddChannelRouting(){
		clickWhenClickable(addplanBtn);
		switchToIframe(Constants.ADD_AGGREGAT_LOAD_LIMIT);
	}


	public void addAggregateLoadDetails(AggregateLoadLimit aggregateLimit){
		clickAddChannelRouting();
		waitForElementVisible(startDateDPkr);
		WebElementUtils.pickDate(startDateDPkr, futureDate);
		waitForElementVisible(endDateDPkr);
		WebElementUtils.pickDate(endDateDPkr, futureEndDate);
		enterText(monthlyLimitTxt ,aggregateLimit.getMonthlyLimit());		
		enterText(monthlyVelocityTxt, aggregateLimit.getMonthlyVelocity());
		enterText(yearlyLimitTxt ,aggregateLimit.getYearlyLimit());		
		enterText(yearlyVelocityTxt, aggregateLimit.getYearlyVelocity());
		selectByVisibleText(currencyCodeTxt,aggregateLimit.getCurrencyCode());
		clickWhenClickable(saveBtn);
		waitForLoaderToDisappear();	
		SwitchToDefaultFrame();
		verifySuccess();
	}	
	public void verifySuccess() {
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


}