package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.NetworkMembership;
import com.mastercard.pts.integrated.issuing.pages.AbstractModelPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_INSTITUTION_PARAMETER_SETUP,
		CardManagementNav.L2_NETWORK_MEMBERSHIP })
public class NetworkMembershipPage extends AbstractModelPage {
	
	private static final Logger logger = LoggerFactory
			.getLogger(NetworkMembershipPage.class);

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement interchangeDwn;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@id='networkCode']/select")
	private MCWebElement interchangePopupDwn;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn='presentmentTimeLimit']")
	private MCWebElement presentmentTimeLimitTxt;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@id='cutoverHrs']/select")
	private MCWebElement cutoverHoursDwn;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@id='cutoverMi']/select")
	private MCWebElement cutoverMinsDwn;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@id='settlementCurrency']/select")
	private MCWebElement settlementCurrencyDwn;
	
	public void verifyUiOperationStatus() {
		logger.info("Network Membership");
		verifyUiOperation("Add Network Membership");
		verifySearchButton("Search");
	}
	
	public void addNewNetworkMembership(List<NetworkMembership> networkMemeberList)
	{
		networkMemeberList.forEach(networkMember->{
		logger.info("create network member of interchange : {}",networkMember.getInterchange());
		clickAddNewButton();
		runWithinPopup(
				"Add Network Membership",
				() -> {
					addNetworkMember(networkMember);
						verifyNoErrors();
				});

		verifyOperationStatus();       
		});
	}
	
	private void addNetworkMember(NetworkMembership nm)
	{
			WebElementUtils.selectDropDownByVisibleText(interchangePopupDwn, nm.getInterchange());
			WebElementUtils.selectDropDownByVisibleText(cutoverHoursDwn, nm.getCutoverHours());
			WebElementUtils.selectDropDownByVisibleText(cutoverMinsDwn, nm.getCutoverMins());
			WebElementUtils.selectDropDownByVisibleText(settlementCurrencyDwn, nm.getsettlementCurrency());
			WebElementUtils.enterText(presentmentTimeLimitTxt, nm.getPresentmentTimeLimitDays());
			clickSaveButton();
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.elementToBeClickable(interchangeDwn));
	}
}
