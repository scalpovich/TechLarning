package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_PROGRAM_SETUP,
		CardManagementNav.L2_CREDIT_CARD_BILLING,
		CardManagementNav.L3_LATE_PAYMENT_FEE_PLAN})
public class LatePaymentFeePlanPage extends AbstractBasePage {

	private static final Logger logger = LoggerFactory.getLogger(LatePaymentFeePlanPage.class);
    private static final String addLatePaymentFeePlanFrame="Add Late Payment Fee Plan";
    private static final String addLatePaymentFeePlanDetails="Add Late Payment Fee Plan Details";
	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=lpcPlanCode]")
	private MCWebElement lpcPlanCode;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=description]")
	private MCWebElement description;
	
	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addBtn;
	@PageElement(findBy = FindBy.NAME, valueToFind = "lpcPlanCode:input:inputTextField")
	private MCWebElement latePaymentFeePlanCodeTxt;
	@PageElement(findBy = FindBy.NAME, valueToFind = "description:input:inputTextField")
	private MCWebElement descriptionTxt;
	@PageElement(findBy = FindBy.NAME, valueToFind = "lpcChargeDate:input:dropdowncomponent")
	private MCWebElement chargeLPCOnDdwn;
	@PageElement(findBy = FindBy.NAME, valueToFind = "lpcValueDate:input:dropdowncomponent")
	private MCWebElement latePaymentFeeValueDateDdwn;
	@PageElement(findBy = FindBy.NAME, valueToFind = "currencyCode:input:dropdowncomponent")
	private MCWebElement currencyDdwn;
	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement addDetailsBtn;
	@PageElement(findBy = FindBy.NAME, valueToFind = "lpcRangeAmount:input:inputAmountField")
	private MCWebElement maximumRangeAmountTxt;
	@PageElement(findBy = FindBy.NAME, valueToFind = "lpcLimitFixed:input:inputAmountField")
	private MCWebElement fixedTxt;
	
	public void verifyUiOperationStatus() {
		logger.info("Late Payment Fee Plan");
		verifyUiOperation("Add Late Payment Fee Plan");
	}
	public void addLatePaymentFeePlan() {
		clickWhenClickable(addBtn);
		switchToIframe(addLatePaymentFeePlanFrame);
		getFinder().getWebDriver().switchTo().frame("_wicket_window_12");
		WebElementUtils.enterText(lpcPlanCode,CustomUtils.RandomNumbers(3));
		WebElementUtils.enterText(description, CustomUtils.RandomAlphabet().toUpperCase());
		WebElementUtils.selectDropDownByIndex(chargeLPCOnDdwn,1);
		WebElementUtils.selectDropDownByIndex(latePaymentFeeValueDateDdwn,1);
		WebElementUtils.selectDropDownByIndex(currencyDdwn,1);
		clickWhenClickable(addDetailsBtn);
		clickWhenClickable(addBtn);
		SwitchToDefaultFrame();
		switchToIframe(addLatePaymentFeePlanDetails);
		WebElementUtils.enterText(maximumRangeAmountTxt,CustomUtils.RandomNumbers(9));
		WebElementUtils.enterText(fixedTxt, CustomUtils.RandomNumbers(5));
		clickWhenClickable(addDetailsBtn);
		clickWhenClickable(addDetailsBtn);
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(lpcPlanCode),
				WebElementUtils.elementToBeClickable(description)
				);
	}
}
