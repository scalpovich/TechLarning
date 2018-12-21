package com.mastercard.pts.integrated.issuing.pages.customer.loyalty;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.loyalty.LoyaltyPromotionMapping;
import com.mastercard.pts.integrated.issuing.domain.customer.loyalty.NewLoyaltyPlan;
import com.mastercard.pts.integrated.issuing.domain.customer.loyalty.PromotionPlan;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = LoyaltyNav.TAB_LOYALTY, treeMenuItems = { LoyaltyNav.L1_LOYALTY_SETUP,
		LoyaltyNav.L2_LOYALTY_PLAN_PROMOTION_MAPPING })
public class LoyaltyPlanPromotionMappingPage extends AbstractBasePage {
	@Autowired
	NewLoyaltyPlan newLoyaltyPlan;
	@Autowired
	PromotionPlan promotionPlan;
	private static final Logger logger = LoggerFactory.getLogger(LoyaltyPlanPromotionMappingPage.class);

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[contains(.,'Loyalty Plan')]//following::select")
	private MCWebElement loyaltyPlanDDwn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[contains(.,'Promotion Plan')]//following::select")
	private MCWebElement promotionPlanDDwn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@id='lytPlanCode']/select")
	private MCWebElement ddwnLoyaltyPlanMapping;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@id='lypPromotionCode']/select")
	private MCWebElement ddwnPromotionPlanMapping;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@name='tables:1:rows:3:cols:colspanMarkup:inputField:input:inputAmountField']")
	private MCWebElement priorityTxt;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//table[@class='btn_alignment']//input[@class='btn_or_sbt' and @value='Save']")
	private MCWebElement btnSave;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//table[@class='btn_alignment']//input[@class='btn_or_sbt' and @value='Cancel']")
	private MCWebElement btnCancel;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//li[@class='feedbackPanelINFO']/span")
	private MCWebElement iconSuccessMessage;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[text()='Promotion Plan Code already exists.']")
	private MCWebElement iconErrorMessage;
	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement iconLoyaltyPromotionAdd;

	public void verifyUiOperationStatus(LoyaltyPromotionMapping loyaltypromotionmapping) {
		logger.info("Loyalty Plan  Promotion Mapping");
		verifyUiOperation("Add Loyalty Plan & Promotion Mapping");
		addWicketAjaxListeners(getFinder().getWebDriver());
		clickWhenClickable(iconLoyaltyPromotionAdd);
		switchToIframe(Constants.ADD_LOYALTY_PROMOTION_MAPPING);
		selectLoyaltyPlanMappingDropDown(loyaltypromotionmapping);
		selectPromotionPlanMappingDropDown(loyaltypromotionmapping);
		enterPriority(loyaltypromotionmapping);
		clickSaveButton();
		Assert.assertTrue("LoyaltyPlan Mapping success message is not proper", messageSuccess());
	}

	public void deleteLoyaltyPromotionMapping(LoyaltyPromotionMapping loyaltypromotionmapping) {
		WebElementUtils.selectDropDownByVisibleText(loyaltyPlanDDwn,
				loyaltypromotionmapping.getMappingLoyaltyPlanddwn());
		WebElementUtils.selectDropDownByVisibleText(promotionPlanDDwn,
				loyaltypromotionmapping.getMappingPromotionPlanddwn());
		deleteRecord();

	}

	public void deleteRecord() {
		if (isDeleteColumnPresent()) {
			deleteFirstRecord();
			Alert alert = driver().switchTo().alert();
			String actualAlertText = null;
			boolean isAlertPresent = alert != null;
			if (isAlertPresent) {
				actualAlertText = alert.getText();
				Assert.assertTrue(actualAlertText.contains("Are you sure you want to delete the highlighted record?"));
				alert.accept();
			}
		}
	}

	public boolean messageSuccess() {
		if (iconSuccessMessage.isVisible()) {
			return true;

		}
		return false;
	}

	public void newLoyaltyPromotionPlanMappingAdd() {
		clickWhenClickable(iconLoyaltyPromotionAdd);
	}

	public void selectLoyaltyPlanMappingDropDown(LoyaltyPromotionMapping loyaltypromotionmapping) {
		WebElementUtils.selectDropDownByVisibleText(ddwnLoyaltyPlanMapping,
				loyaltypromotionmapping.getMappingLoyaltyPlanddwn());
	}

	public void selectPromotionPlanMappingDropDown(LoyaltyPromotionMapping loyaltypromotionmapping) {
		WebElementUtils.selectDropDownByVisibleText(ddwnPromotionPlanMapping,
				loyaltypromotionmapping.getMappingPromotionPlanddwn());
	}

	public void enterPriority(LoyaltyPromotionMapping loyaltypromotionmapping) {
		WebElementUtils.enterText(priorityTxt, loyaltypromotionmapping.getPriority());
	}

	@Override
	public void clickSaveButton() {

		clickWhenClickableDoNotWaitForWicket(btnSave);
	}

	@Override
	public void clickCancelButton() {
		clickWhenClickable(btnCancel);
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.elementToBeClickable(loyaltyPlanDDwn));
	}
}
