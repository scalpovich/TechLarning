package com.mastercard.pts.integrated.issuing.pages.collect.activity;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.AbstractModelPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = ActivityNav.TAB_ACTIVITY, treeMenuItems = { ActivityNav.L1_DEPOSIT_SCHEDULER })
public class DepositSchedulerPage extends AbstractModelPage {

	private static final Logger logger = LoggerFactory.getLogger(DepositSchedulerPage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=accountNo]")
	private MCWebElement accountNoTxt;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=recieptNbr]")
	private MCWebElement recieptNbrTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "payMode:input:dropdowncomponent")
	private MCWebElement paymentModeDDwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=chequeNo]")
	private MCWebElement chequeNoTxt;
	
	public void verifyUiOperationStatus() {
		logger.info("Deposit Scheduler");
		verifySearchButton("Search");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.elementToBeClickable(accountNoTxt), WebElementUtils.elementToBeClickable(paymentModeDDwn),
				WebElementUtils.elementToBeClickable(chequeNoTxt), WebElementUtils.elementToBeClickable(recieptNbrTxt));
	}
}