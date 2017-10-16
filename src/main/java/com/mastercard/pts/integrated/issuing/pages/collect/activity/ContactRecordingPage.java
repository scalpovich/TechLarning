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
@Navigation(tabTitle = ActivityNav.TAB_ACTIVITY, treeMenuItems = { ActivityNav.L1_CONTACT_RECORDING })
public class ContactRecordingPage extends AbstractModelPage {

	private static final Logger logger = LoggerFactory.getLogger(ContactRecordingPage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=accountNo]")
	private MCWebElement accountNoTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=accHldrname]")
	private MCWebElement accHldrnameTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=birthDate]")
	private MCWebElement birthDateDPkr;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=hmPhone]")
	private MCWebElement hmPhoneTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=ofPhone]")
	private MCWebElement ofPhoneTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=mobPhone]")
	private MCWebElement mobPhoneTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:4:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement branchDDwn;

	public void verifyUiOperationStatus() {
		logger.info("Contact Recording");
		verifySearchButton("Search");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.elementToBeClickable(accountNoTxt), WebElementUtils.elementToBeClickable(accHldrnameTxt),
				WebElementUtils.elementToBeClickable(birthDateDPkr), WebElementUtils.elementToBeClickable(hmPhoneTxt),
				WebElementUtils.elementToBeClickable(ofPhoneTxt), WebElementUtils.elementToBeClickable(mobPhoneTxt),
				WebElementUtils.elementToBeClickable(branchDDwn));
	}
}