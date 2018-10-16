package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.MCG;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.customer.navigation.CardManagementNav;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = { CardManagementNav.L1_INSTITUTION_PARAMETER_SETUP, CardManagementNav.L2_MCG })
public class MCGPage extends AbstractBasePage {
	final Logger logger = LoggerFactory.getLogger(MCGPage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[name='mcgHeadPanel:mcgCode:input:inputTextField']")
	private MCWebElement mcgCodeTxt;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "input[name='searchDiv:rows:1:componentList:0:componentPanel:input:inputTextField']")
	private MCWebElement mcgCodeSearchTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[name='searchDiv:rows:1:componentList:1:componentPanel:input:inputTextField']")
	private MCWebElement descriptionTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement saveBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cancel")
	private MCWebElement cancelBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "mccSearchPanel:mccFrom:input:inputTextField")
	private MCWebElement mccFromTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "mccSearchPanel:mccTo:input:inputTextField")
	private MCWebElement mccToTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "mccSearchPanel:mccName:input:inputTextField")
	private MCWebElement mccNameTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "mccSearchPanel:mastercardMcg:input:dropdowncomponent")
	private MCWebElement mastercardMcgDdwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "table.dataview input.chkField")
	private MCWebElement mccSelectChkBx;

	private static final String FRAME_ADD_MCG = "Add MCG";

	public void switchToAddMCGFrame() {
		switchToIframe(Constants.ADD_MCG_FRAME);
	}

	public void enterMCGCode(MCG plan) {
		enterValueinTextBox(mcgCodeTxt, plan.getMCGCode());
	}

	public void enterMCGDescription(MCG plan) {
		enterValueinTextBox(descriptionTxt, plan.getDescription());
	}

	public void enterMCCFrom(MCG plan) {
		enterValueinTextBox(mccFromTxt, plan.getMccFrom());
	}

	public void enterMCCTo(MCG plan) {
		enterValueinTextBox(mccToTxt, plan.getMccTo());
	}

	public void enterMCCName(MCG plan) {
		enterValueinTextBox(mccNameTxt, plan.getMccName());
	}

	public void selectMCCCode() {
		clickWhenClickable(mccSelectChkBx);
	}

	public boolean verifyErrorsOnMCGPage() {
		return publishErrorOnPage();
	}

	public void verifyNewMCGSuccess() {
		if (!verifyErrorsOnMCGPage()) {
			logger.info("Record Added Successfully");
			switchToDefaultFrame();
		} else {
			logger.info("Error in Vendor Addition");
			clickWhenClickable(cancelBtn);
			switchToDefaultFrame();
		}
	}

	public void addMCGDetails(MCG plan) {
		clickAddNewButton();
		enterMCGCode(plan);
		enterMCGDescription(plan);
		clickSaveButton();
	}

	public void addMCGwithMCCDetails(MCG plan) {
		clickAddNewButton();
		runWithinPopup(FRAME_ADD_MCG, () -> {
			enterMCGCode(plan);
			enterMCGDescription(plan);
			enterMCCFrom(plan);
			enterMCCTo(plan);
			clickSearchButton();
			selectMCCCode();
			clickSaveButton();
			if (publishErrorOnPage()) {
				plan.setMCGCode(CustomUtils.randomNumbers(3));
				enterMCGCode(plan);
				clickSaveButton();
			}
		});
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.elementToBeClickable(mcgCodeSearchTxt));
	}
}