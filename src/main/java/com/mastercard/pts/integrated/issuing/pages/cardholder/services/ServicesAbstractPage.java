package com.mastercard.pts.integrated.issuing.pages.cardholder.services;

import java.util.Collection;
import java.util.Collections;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

public class ServicesAbstractPage extends AbstractBasePage {
	protected static final Logger logger = LoggerFactory.getLogger(ServicesAbstractPage.class);

	@PageElement(findBy = FindBy.ID, valueToFind = "reasonCode")
	protected MCWebElement reasonCodeDDwn;

	@PageElement(findBy = FindBy.ID, valueToFind = "remarks")
	protected MCWebElement remarksTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "div .Title")
	protected MCWebElement masterDetailContentTitle;

	@PageElement(findBy = FindBy.ID, valueToFind = "ActivateTypeImmediate Activation for n Hrs")
	protected MCWebElement activateTypeImmediateActivationForNHrsRbtn;

	@PageElement(findBy = FindBy.ID, valueToFind = "EcomInput1")
	protected MCWebElement ecomInput1Rbtn;

	@PageElement(findBy = FindBy.ID, valueToFind = "EcomInput0")
	protected MCWebElement ecomInput0Rbtn;

	@PageElement(findBy = FindBy.ID, valueToFind = "ActivateTypeActivation in Period")
	protected MCWebElement activateTypeActivationInPeriodRbtn;

	@PageElement(findBy = FindBy.ID, valueToFind = "ActivateTypeLife Long Activate")
	protected MCWebElement activateTypeLifeLongActivateRbtn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[contains(text(), 'Wallet Status')]/following-sibling::td[1]")
	protected MCWebElement walletStatusLbl;



}