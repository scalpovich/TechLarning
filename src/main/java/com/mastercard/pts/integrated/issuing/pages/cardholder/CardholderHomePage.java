package com.mastercard.pts.integrated.issuing.pages.cardholder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardholderHomeNav.TAB_HOME)
public class CardholderHomePage extends AbstractBasePage {

	private static final Logger logger = LoggerFactory.getLogger(CardholderHomePage.class);

	public static final String TITLE = "Integrated Issuing :: Card Holder Portal";

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[contains(text(), 'Wallet Number')]/following-sibling::*")
	private MCWebElement walletNumberRow;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[contains(text(), 'Device Number')]/following-sibling::*")
	private MCWebElement deviceNumberRow;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[contains(text(), 'Wallet Number')]/following-sibling::td[1]")
	private MCWebElement walletNumber;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[contains(text(), 'Device Number')]/following-sibling::td[1]")
	private MCWebElement deviceNumber;




	

}
