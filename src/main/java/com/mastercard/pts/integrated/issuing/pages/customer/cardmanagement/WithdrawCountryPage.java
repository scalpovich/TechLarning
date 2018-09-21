package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceRange;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.WithdrawCountry;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_ACTIVITY, CardManagementNav.L2_STOP_LIST,
		CardManagementNav.L3_WITHDRAW_COUNTRY })
public class WithdrawCountryPage extends AbstractBasePage {

	private static final Logger logger = LoggerFactory
			.getLogger(WithdrawCountryPage.class);

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement country;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@type='submit']//..//..//..//select[@class='selectf']")
	private MCWebElement countryDDwn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "withdrawalReasonCode:input:dropdowncomponent")
	private MCWebElement withdrawalReasonCodeDDwn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "withdrawalDescription:input:textAreaComponent")
	private MCWebElement withdrawalDescriptionTxt;
	
	
	public void verifyUiOperationStatus() {
		logger.info("Withdraw Country");
		verifySearchButton("Search");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.elementToBeClickable(country));
	}
	
	public void withdrawCountry(WithdrawCountry withdrawCountry,DeviceRange deviceRange){
		selectCountry(withdrawCountry.getWithdrawCountry());
		clickSearchButton();
		editFirstRecord();
		runWithinPopup("Edit Withdraw Country", ()->{
			waitForElementVisible(withdrawalReasonCodeDDwn);
			selectReasonCode(withdrawCountry.getWithdrawReason());
			enterDescription(withdrawCountry.getWithdrawDescription());
			clickSaveButton();
		});
		verifyOperationStatus();
	}
	
	public void selectCountry(String country){
		selectDropDownByText(countryDDwn, country);
	}
	
	public void selectReasonCode(String reasonCode){
		selectDropDownByText(withdrawalReasonCodeDDwn, reasonCode);
	}
	
	public void enterDescription(String description){
		enterText(withdrawalDescriptionTxt, description);
	}
}