package com.mastercard.pts.integrated.issuing.pages.collect.businesssetup;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

public class AbstractBusinessPage extends AbstractBasePage {

	private static final Logger logger = LoggerFactory.getLogger(BusinessSetupClassificationPage.class);
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=rlid]")
	protected MCWebElement rlidTxt;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=dscr]")
	protected MCWebElement dscrTxt;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:2:componentList:0:componentPanel:input:dropdowncomponent")
	protected MCWebElement statusDDwn;
	
	private void verifyUiOperationsStatus(String logMessage) {
		logger.info(logMessage);
		verifyUiOperation("Add Rule Master");
	}
	
	public void verifyOperationsStatus() {
		verifyUiOperationsStatus("Classification");
	}
	
	public void verifyOperationsStatus(String logMessage)
	{
		verifyUiOperationsStatus(logMessage);
	}
	
	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(rlidTxt),
				WebElementUtils.elementToBeClickable(dscrTxt),
				WebElementUtils.elementToBeClickable(statusDDwn)
				);
	}
}