package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
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
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_INSTITUTION_PARAMETER_SETUP,
		CardManagementNav.L2_CUTOVERPROFILE })
public class CutoverProfilePage extends AbstractBasePage {

	private static final Logger logger = LoggerFactory
			.getLogger(CutoverProfilePage.class);

	@PageElement(findBy = FindBy.X_PATH,valueToFind = "//a[@class='exportCSV']")
	private MCWebElement exportLink;
	
	@PageElement(findBy =FindBy.CSS, valueToFind="#businessDate")
	private MCWebElement businessDateDPkr;

	@PageElement(findBy = FindBy.X_PATH ,valueToFind= "//span[@id='cutoverHrs']/select")
	private MCWebElement cutoverHrsDwn;
	
	@PageElement(findBy = FindBy.X_PATH,valueToFind = "//span[@id='cutoverMi']/select")
	private MCWebElement cutoverMiDwn;

	public void verifyUiOperationStatus() {
		logger.info("Cutover Profile");
		verifyUiOperationNoEdit("Add Cutover Profile");
	}

	public void addCutoverProfile(CutOverProfile cp) {
		logger.info("create CutoverProfile on date : {}",
				cp.getBusinessDate());
		if(isNoRecordsFoundInTable())
		{
			clickAddNewButton();
	
			runWithinPopup(
					"Add Cutover Profile",
					() -> {
						addCutoverProfileRecord(cp);
							verifyNoErrors();
					});
	
			verifyOperationStatus();  
		}
	}
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
		switchToDefaultFrame();
	}

	public boolean verifyErrorsOnCutoverprofilePage() {
		return publishErrorOnPage();
	}

	public void verifyNewCutoverProfileSuccess() {
		if (!verifyErrorsOnCutoverprofilePage()) {
			logger.info("Cutover profile Added Successfully");
			switchToDefaultFrame();
		} else {
			logger.info("Error in record Addition");
			clickWhenClickable(cancelBtn);
			switchToDefaultFrame();

		}
	}
	private void addCutoverProfileRecord(CutOverProfile cp) {
		WebElementUtils.pickDate(businessDateDPkr, cp.getBusinessDate());
		WebElementUtils.selectDropDownByVisibleText(cutoverHrsDwn, cp.getCutoverHours());
		WebElementUtils.selectDropDownByVisibleText(cutoverMiDwn, cp.getCutoverMins());
		clickSaveButton();
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.elementToBeClickable(exportLink));
	}
}
