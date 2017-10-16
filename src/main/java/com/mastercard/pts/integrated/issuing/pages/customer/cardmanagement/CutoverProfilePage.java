package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CutOverProfile;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.customer.navigation.CardManagementNav;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.DatePicker;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1INSTITUTION_PARAMETER_SETUP, CardManagementNav.L2CUTOVERPROFILE })
@Component
public class CutoverProfilePage extends AbstractBasePage {
	final Logger logger = LoggerFactory.getLogger(CutoverProfilePage.class);

	// ------------- Card Management > Institution Parameter Setup > Cutover
	// Profile [ISSS03]

	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addCutoverProfileBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "tables:2:rows:2:cols:colspanMarkup:inputField:input:dropdowncomponent")
	private MCWebElement CutoverHoursDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "tables:2:rows:2:cols:nextCol:colspanMarkup:inputField:input:dropdowncomponent")
	private MCWebElement CutoverMinsDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement saveBtn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@class = 'feedbackPanelERROR']")
	private MCWebElement PanelError;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cancel")
	private MCWebElement cancelBtn;

	@Autowired
	DatePicker date;

	public void ClickAddcutoverprofile() {
		clickWhenClickable(addCutoverProfileBtn);
		switchToCutoverProfileFrame();
	}

	public void switchToCutoverProfileFrame() {
		switchToIframe(Constants.ADD_CUTOVER_PROFILE_FRAME);
	}

	public void selectBusinessDate(CutOverProfile cutover) {
		date.setDate(cutover.getCutOverEffectiveDate());
	}

	public void selectCutoverHours(CutOverProfile cutover) {
		selectByVisibleText(CutoverHoursDDwn, cutover.getCutoverHours());
	}

	public void selectCutoverMinutes(CutOverProfile cutover) {
		selectByVisibleText(CutoverMinsDDwn, cutover.getCutoverMins());
	}

	public void clickSaveBtn() {
		waitForElementVisible(saveBtn);
		ClickButton(saveBtn);
		try {
			if (PanelError.isVisible()) {
				logger.info("inside error pannel");
				cancelBtn.click();
			}
		} catch (Exception e) {
			logger.error(e.toString());
			logger.info("error pannel not present");
		}
		SwitchToDefaultFrame();
	}

	public boolean verifyErrorsOnCutoverprofilePage() {
		return publishErrorOnPage();
	}

	public void verifyNewCutoverProfileSuccess() {
		if (!verifyErrorsOnCutoverprofilePage()) {
			logger.info("Cutover profile Added Successfully");
			SwitchToDefaultFrame();
		} else {
			logger.info("Error in record Addition");
			clickWhenClickable(cancelBtn);
			SwitchToDefaultFrame();

		}
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return null;
	}

}
