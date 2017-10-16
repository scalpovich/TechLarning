package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.PlasticCode;
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
		CardManagementNav.L1INSTITUTION_PARAMETER_SETUP, CardManagementNav.L2PLASTICCODE })
public class PlasticCodePage extends AbstractBasePage {
	final Logger logger = LoggerFactory.getLogger(EmbossingPriorityPassPage.class);

	// ------------- Card Management > Institution Parameter Setup > Institution
	// Currency [ISSS05]

	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addPlasticCodeBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "tables:1:rows:1:cols:colspanMarkup:inputField:input:inputTextField")
	private MCWebElement PlasticCodeTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "tables:1:rows:2:cols:colspanMarkup:inputField:input:inputTextField")
	private MCWebElement DescriptionTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement saveBtn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@class = 'feedbackPanelINFO']")
	private MCWebElement PanelInfo;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@class = 'feedbackPanelERROR']")
	private MCWebElement PanelError;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cancel")
	private MCWebElement cancelBtn;

	public void clickaddPlasticCode() {
		clickWhenClickable(addPlasticCodeBtn);
		switchToAddPlasticCodeFrame();
	}

	public void switchToAddPlasticCodeFrame() {
		switchToIframe(Constants.ADD_PLASTIC_CODE_FRAME);
	}

	public String enterPlasticCode() {
		enterValueinTextBox(PlasticCodeTxt, CustomUtils.randomNumbers(3));
		return PlasticCodeTxt.getAttribute("value");

	}

	public String enterDescription(PlasticCode plasticcode) {
		enterValueinTextBox(DescriptionTxt, plasticcode.getDescription());
		return DescriptionTxt.getAttribute("value");
	}

	public void Save() {
		clickWhenClickable(saveBtn);
	}

	public String addPLasticCodeDetails(PlasticCode plasticcode) {
		String plasticCode;
		String Description;
		plasticCode = enterPlasticCode();
		Description = enterDescription(plasticcode);
		Save();
		return Description + " " + "[" + plasticCode + "]";
	}

	public boolean verifyErrorsOnPlasticCodePage() {
		return publishErrorOnPage();
	}

	public void verifyPlasticSuccess() {
		if (!verifyErrorsOnPlasticCodePage()) {
			logger.info("Vendor Added Successfully");
			SwitchToDefaultFrame();
		} else {
			logger.info("Error in Vendor Addition");
			clickWhenClickable(cancelBtn);
			SwitchToDefaultFrame();
		}
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return null;
	}

}
