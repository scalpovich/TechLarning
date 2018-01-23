package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;
import com.thoughtworks.selenium.webdriven.commands.GetBodyText;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = { CardManagementNav.L1_SEARCH, CardManagementNav.L2_SEARCH_WALLET,
		CardManagementNav.L3_WALLET_DETAILS })
public class WalletDetailsPage extends AbstractBasePage {

	private static final Logger logger = LoggerFactory.getLogger(WalletDetailsPage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=walletNumber]")
	private MCWebElement walletNumberTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=deviceNumber]")
	private MCWebElement deviceNumberTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=clientCode]")
	private MCWebElement clientCodeTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=registeredMobileNumber]")
	private MCWebElement registeredMobileNumberTxt;
	
	@PageElement(findBy = FindBy.CLASS, valueToFind = "btn_or_sbt")
	private MCWebElement searchBtn;
	
	private String xPath="//th[@class='wicket_orderNone']//..//..//..//tbody/tr/td/span/a";
	
	public void verifyUiOperationStatus() {
		logger.info("Wallet Details");
		verifySearchButton("Search");
	}
	
	public List<String> getWalletDetails(Device device){
		WebElementUtils.enterText(deviceNumberTxt, device.getDeviceNumber());
		WebElementUtils.elementToBeClickable(searchBtn);
		clickWhenClickable(searchBtn);
		waitForLoaderToDisappear();
		return getListOfElements(xPath);
	}
	

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.elementToBeClickable(walletNumberTxt), WebElementUtils.elementToBeClickable(deviceNumberTxt),
				WebElementUtils.elementToBeClickable(clientCodeTxt), WebElementUtils.elementToBeClickable(registeredMobileNumberTxt));
	}
	
}