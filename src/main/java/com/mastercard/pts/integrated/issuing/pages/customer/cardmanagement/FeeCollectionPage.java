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
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_ACTIVITY, CardManagementNav.L2_MASTERCARD,
		CardManagementNav.L3_FEE_COLLECTION })
public class FeeCollectionPage extends AbstractModelPage {

	private static final Logger logger = LoggerFactory
			.getLogger(FeeCollectionPage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=ifdReasonCodeNum]")
	private MCWebElement ifdReasonCodeNum;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=ifdArnCd]")
	private MCWebElement ifdArnCd;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=ifdPanCd]")
	private MCWebElement ifdPanCd;

	public void verifyUiOperationStatus() {
		logger.info("MasterCard Fee");
		verifyUiOperation("Add MasterCard Fee");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(ifdReasonCodeNum),
				WebElementUtils.elementToBeClickable(ifdArnCd),
				WebElementUtils.elementToBeClickable(ifdPanCd));
	}
}