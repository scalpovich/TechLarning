package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DevicePlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.MCCRulePlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Program;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.pts.integrated.issuing.utils.simulator.SimulatorUtilities;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = { CardManagementNav.L1_PROGRAM_SETUP,
		CardManagementNav.L2_MCC_RULES })
public class MCCRulePlanPage extends AbstractBasePage {

	private static final Logger logger = LoggerFactory.getLogger(MCCRulePlanPage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn=mccRulePlanCode]")
	private MCWebElement planCodeSearchTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#mccRulePlanCode input")
	private MCWebElement planCodeTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#description input")
	private MCWebElement descriptionTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#productType select")
	private MCWebElement productTypeDDwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn=fromMccCode]")
	private MCWebElement fromMccCodeTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn=toMccCode]")
	private MCWebElement toMccCodeTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn=selectAllDom]")
	private MCWebElement selectAllDomCheckBox;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn=selectAllInt]")
	private MCWebElement selectAllIntCheckBox;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn=presentmentTimeLimit]")
	private MCWebElement txtPresentmentTimeLimit;

	public static int clearPresentment = 0;

	public void verifyUiOperationStatus() {
		logger.info("MCC Rule");
		verifySearchButton("Search");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.visibilityOf(planCodeSearchTxt));
	}

	public void createMCCRulePlanPage(MCCRulePlan plan) {
		logger.info("Create MCC Rule Plan {}", plan.getMccRulePlanCode());
		clickAddNewButton();

		runWithinPopup("Add MCC Rule Plan", () -> {
			SimulatorUtilities.wait(1500);
			WebElementUtils.elementToBeClickable(planCodeTxt);
			WebElementUtils.enterText(planCodeTxt, plan.getMccRulePlanCode());
			SimulatorUtilities.wait(100);
			WebElementUtils.elementToBeClickable(descriptionTxt);
			WebElementUtils.enterText(descriptionTxt, plan.getDescription());
			WebElementUtils.selectDropDownByVisibleText(productTypeDDwn, plan.getProductType());
			WebElementUtils.scrollDown(driver(), 0, 250);
			clickSaveButton();
			verifyNoErrors();
			SimulatorUtilities.wait(4000);
		});
		verifyOperationStatus();
	}

	public void editMCCRulePlanPage(MCCRulePlan plan) {
		logger.info("Edit MCC Rule Plan {}", plan.getMccRulePlanCode());
		WebElementUtils.enterText(planCodeSearchTxt, plan.getMccRulePlanCode());
		clickSearchButton();
		editFirstRecord();

		runWithinPopup("Edit MCC Rule Plan", () -> {
			fillMCCRulePlan(plan.getFromMccCode(), plan.getToMccCode());
			clickApproveCheckBox(plan.getOrigin());
			WebElementUtils.scrollDown(driver(), 0, 250);
			clickSaveButton();
			verifyNoErrors();
			SimulatorUtilities.wait(4000);
		});
		verifyOperationStatus();
	}

	private void clickApproveCheckBox(String origin) {
		if (origin.equalsIgnoreCase(ContextConstants.INTERNATIONAL))
			clickWhenClickable(selectAllIntCheckBox);
		else
			clickWhenClickable(selectAllDomCheckBox);
	}

	public void editPresentmentTimeLimitInMCCRulePlan(DevicePlan device, Program program) {
		logger.info("Edit MCC Rule Plan {}", program.getMccRulePlan().substring(12, 21));
		WebElementUtils.enterText(planCodeSearchTxt, program.getMccRulePlan().substring(12, 21));
		clickSearchButton();
		editFirstRecord();
		runWithinPopup("Edit MCC Rule Plan", () -> {
			fillMCCRulePlan(device.getMerchantCode(), device.getMerchantCode());
			txtPresentmentTimeLimit.clearField();
			if (clearPresentment == 0) {
				enterValueinTextBox(txtPresentmentTimeLimit, device.getTransSetPresentmentTimeLimit());
			}
			clickSaveButton();
			SimulatorUtilities.wait(4000);
		});
		verifyOperationStatus();
		clearPresentment++;
	}

	private void fillMCCRulePlan(String fromMcc, String toMcc) {
		SimulatorUtilities.wait(1500);
		WebElementUtils.elementToBeClickable(fromMccCodeTxt);
		WebElementUtils.enterText(fromMccCodeTxt, fromMcc);
		SimulatorUtilities.wait(100);
		WebElementUtils.enterText(toMccCodeTxt, toMcc);
		clickSearchButton();
		waitForPageToLoad(driver());
		SimulatorUtilities.wait(4000);

	}
}