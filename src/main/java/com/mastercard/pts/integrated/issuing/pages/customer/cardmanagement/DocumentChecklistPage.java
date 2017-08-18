package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

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
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_PROGRAM_SETUP, CardManagementNav.L2_APPLICATION,
		CardManagementNav.L3_DOCUMENT_CHECKLIST })
public class DocumentChecklistPage extends AbstractModelPage {

	private static final Logger logger = LoggerFactory
			.getLogger(DocumentChecklistPage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=documentPlanCode]")
	private MCWebElement documentPlanCode;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=description]")
	private MCWebElement description;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:2:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement productType;

	public void verifyUiOperationStatus() {
		logger.info("Document Checklist");
		verifyUiOperation("Add Document Checklist");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(documentPlanCode),
				WebElementUtils.elementToBeClickable(description),
				WebElementUtils.elementToBeClickable(productType));
	}
}
