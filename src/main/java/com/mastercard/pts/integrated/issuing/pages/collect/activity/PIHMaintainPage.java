package com.mastercard.pts.integrated.issuing.pages.collect.activity;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = ActivityNav.TAB_ACTIVITY, treeMenuItems = { ActivityNav.L1_PIH_MAINTAIN })
public class PIHMaintainPage extends AbstractBasePage {

	private static final Logger logger = LoggerFactory.getLogger(PIHMaintainPage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=fromDate]")
	private MCWebElement fromDateDPkr;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=toDate]")
	private MCWebElement toDateDPkr;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=accountNo]")
	private MCWebElement accountNoTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=chequeNo]")
	private MCWebElement chequeNoTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=recieptNbr]")
	private MCWebElement recieptNbrTxt;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:2:componentList:1:componentPanel:input:dropdowncomponent")
	private MCWebElement paymentModeDDwn;

	public void verifyUiOperationStatus() {
		logger.info("PIH Maintain");
		verifySearchButton("Search");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.elementToBeClickable(accountNoTxt), WebElementUtils.elementToBeClickable(paymentModeDDwn),
				WebElementUtils.elementToBeClickable(chequeNoTxt), WebElementUtils.elementToBeClickable(recieptNbrTxt),
				WebElementUtils.elementToBeClickable(fromDateDPkr), WebElementUtils.elementToBeClickable(toDateDPkr));
	}
}