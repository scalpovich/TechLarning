package com.mastercard.pts.integrated.issuing.pages.cardholder.enquiry;

import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.EnquiryNav;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = EnquiryNav.TAB_ENQUIRY, treeMenuItems = { EnquiryNav.L1_CASH_REMITTANCES })
public class CashRemittancesPage extends AbstractBasePage{
	private static final Logger logger = LoggerFactory.getLogger(CashRemittancesPage.class);

	@PageElement(findBy = FindBy.ID, valueToFind = "FetchFlag1")
	private MCWebElement dateRangeRbtn;

	@PageElement(findBy = FindBy.ID, valueToFind = "FetchFlag0")
	private MCWebElement remittanceNumberRbtn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "div .Title")
	private MCWebElement masterDetailContentTitle;

	@PageElement(findBy = FindBy.ID, valueToFind = "fromDate")
	private MCWebElement fromDateDPkr;

	@PageElement(findBy = FindBy.ID, valueToFind = "toDate")
	private MCWebElement toDateDPkr;



}
