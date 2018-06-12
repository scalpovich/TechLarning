package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.customer.navigation.CardManagementNav;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_INSTITUTION_PARAMETER_SETUP, CardManagementNav.L2_MCG })
public class MCGPage extends AbstractBasePage {
	final Logger logger = LoggerFactory.getLogger(MCGPage.class);

	// ------------- Card Management > Institution Parameter Setup > Institution
	// Currency [ISSS05]

	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addMCG;

	@PageElement(findBy = FindBy.NAME, valueToFind = "mcgHeadPanel:mcgCode:input:inputTextField")
	private MCWebElement MCGCode;

	@PageElement(findBy = FindBy.NAME, valueToFind = "mcgHeadPanel:description:input:inputTextField")
	private MCWebElement Description;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement save;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cancel")
	private MCWebElement CancelBtn;

	public void clickaddMCG() {
		clickWhenClickable(addMCG);
		switchToAddMCGFrame();
	}

	public void switchToAddMCGFrame() {
		switchToIframe(Constants.ADD_MCG_FRAME);
	}

	public String enterMCGCode() {
		enterValueinTextBox(MCGCode, CustomUtils.randomNumbers(3));
		return MCGCode.getAttribute("value");

	}

	public String enterMCGDescription() {
		enterValueinTextBox(Description, "MCG Additional auth hold plan");
		return Description.getAttribute("value");
	}

	public void clickSaveButton() {
		clickWhenClickable(save);
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
			clickWhenClickable(CancelBtn);
			switchToDefaultFrame();
		}
	}

	public String addMCGDetails() {
		String mcgCode;
		String Description;
		mcgCode = enterMCGCode();
		Description = enterMCGDescription();
		clickSaveButton();
		return Description + " " + "[" + mcgCode + "]";
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return null;
	}

}
