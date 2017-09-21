package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

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

public class AbstractCardManagementPage extends AbstractBasePage {

	private static final Logger logger = LoggerFactory.getLogger(VerifyPage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=applicationNumber]")
	protected MCWebElement applicationNumber;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=formNumber]")
	protected MCWebElement formNumber;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=firstName]")
	protected MCWebElement firstName;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=lastName]")
	protected MCWebElement lastName;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=fromDate]")
	protected MCWebElement fromDate;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=toDate]")
	protected MCWebElement toDate;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=deviceNumber]")
	protected MCWebElement deviceNumber;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=batchCreateNum]")
	protected MCWebElement batchCreateNum;

	public void verifyUiOperationStatus() {
		logger.info("Verify");
		verifySearchButton("Search");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(applicationNumber),
				WebElementUtils.elementToBeClickable(formNumber),
				WebElementUtils.elementToBeClickable(firstName),
				WebElementUtils.elementToBeClickable(lastName),
				WebElementUtils.elementToBeClickable(fromDate),
				WebElementUtils.elementToBeClickable(toDate));
	}
}