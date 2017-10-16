package com.mastercard.pts.integrated.issuing.pages;

import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.MPTSBasePage;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
public class NetworkMembershipPage extends MPTSBasePage {

	// ------------- Card Management > Institution Parameter Setup > Network
	// Membership [ISSS04]

	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addNetworkMembership;

	@PageElement(findBy = FindBy.NAME, valueToFind = "tables:1:rows:1:cols:colspanMarkup:inputField:input:dropdowncomponent")
	private MCWebElement Interchange;

	@PageElement(findBy = FindBy.NAME, valueToFind = "tables:1:rows:1:cols:nextCol:colspanMarkup:inputField:input:inputTextField")
	private MCWebElement PresentmentTimeLimit;

	@PageElement(findBy = FindBy.NAME, valueToFind = "tables:1:rows:2:cols:colspanMarkup:inputField:input:dropdowncomponent")
	private MCWebElement CutoverHours;

	@PageElement(findBy = FindBy.NAME, valueToFind = "tables:1:rows:2:cols:nextCol:colspanMarkup:inputField:input:dropdowncomponent")
	private MCWebElement CutoverMins;

	@PageElement(findBy = FindBy.NAME, valueToFind = "tables:1:rows:3:cols:colspanMarkup:inputField:input:dropdowncomponent")
	private MCWebElement SettlementCurrency;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement save;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@class = 'feedbackPanelERROR']")
	private MCWebElement PanelError;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cancel")
	private MCWebElement cancel;

	public void addnetworkmembership(String interchangeType, String presentTimelimit, String settlementCurrency) {
		addNetworkMembership.click();
		addWicketAjaxListeners(getFinder().getWebDriver());
		switchToIframe(Constants.ADD_NETWORK_MEMBERSHIP_FRAME);
		SelectDropDownByText(Interchange, interchangeType);
		enterText(PresentmentTimeLimit, presentTimelimit);
		SelectDropDownByIndex(CutoverHours, 1);
		SelectDropDownByIndex(CutoverMins, 1);
		SelectDropDownByText(SettlementCurrency, settlementCurrency);
		ClickButton(save);
		addWicketAjaxListeners(getFinder().getWebDriver());
		try {
			if (PanelError.isVisible()) {
				System.out.println("inside error pannel");
				cancel.click();
			}
		} catch (Exception e) {
			System.out.println("error pannel not present");
		}
		SwitchToDefaultFrame();
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		// TODO Auto-generated method stub
		return null;
	}

}
