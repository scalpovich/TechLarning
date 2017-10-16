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
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = { CardManagementNav.L1PROGRAM_SETUP,
		CardManagementNav.L2DEDUPE_PLAN })
public class DedupePlanPage extends AbstractBasePage {
	final Logger logger = LoggerFactory.getLogger(DedupePlanPage.class);

	// ------------- Card Management > Institution Parameter Setup > Institution
	// Currency [ISSS05]

	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addDedupePlan;

	@PageElement(findBy = FindBy.NAME, valueToFind = "tables:1:rows:1:cols:colspanMarkup:inputField:input:inputTextField")
	private MCWebElement DedupePlanCode;

	@PageElement(findBy = FindBy.NAME, valueToFind = "tables:1:rows:1:cols:nextCol:colspanMarkup:inputField:input:inputTextField")
	private MCWebElement Description;

	@PageElement(findBy = FindBy.NAME, valueToFind = "tables:2:rows:2:cols:colspanMarkup:inputField:checkBoxComponent")
	private MCWebElement PrimaryApplicationChkBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "tables:2:rows:2:cols:nextCol:colspanMarkup:inputField:checkBoxComponent")
	private MCWebElement AddOnApplicationChkBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "tables:3:rows:2:cols:colspanMarkup:inputField:checkBoxComponent")
	private MCWebElement FirstNameChkBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "tables:3:rows:2:cols:nextCol:colspanMarkup:inputField:checkBoxComponent")
	private MCWebElement MiddleName1ChkBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "tables:3:rows:3:cols:colspanMarkup:inputField:checkBoxComponent")
	private MCWebElement MiddleName2ChkBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "tables:3:rows:3:cols:nextCol:colspanMarkup:inputField:checkBoxComponent")
	private MCWebElement BirthDateChkBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "tables:3:rows:4:cols:colspanMarkup:inputField:checkBoxComponent")
	private MCWebElement RegMobileNoChkBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "tables:3:rows:4:cols:nextCol:colspanMarkup:inputField:checkBoxComponent")
	private MCWebElement RegEmailIdChkBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "tables:3:rows:5:cols:colspanMarkup:inputField:checkBoxComponent")
	private MCWebElement LastNameChkBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "tables:3:rows:5:cols:nextCol:colspanMarkup:inputField:checkBoxComponent")
	private MCWebElement LegalIDChkBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement save;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cancel")
	private MCWebElement CancelBtn;

	public void clickaddDedupePlan() {
		clickWhenClickable(addDedupePlan);
		switchToAddDedupePlanFrame();
	}

	public void switchToAddDedupePlanFrame() {
		switchToIframe(Constants.ADD_DEDUPE_PLAN_FRAME);
	}

	public String enterDedupeCode() {
		enterValueinTextBox(DedupePlanCode, CustomUtils.randomNumbers(5));
		return DedupePlanCode.getAttribute("value");
	}

	public String enterDedupeDescription() {
		enterValueinTextBox(Description, "HDFC dedupe plan all customer");
		return Description.getAttribute("value");
	}

	public void clickPrimaryApplication() {
		ClickCheckBox(PrimaryApplicationChkBx, true);
	}

	public void clickAddOnApplicatin() {
		ClickCheckBox(AddOnApplicationChkBx, true);
	}

	public void clickFirstName() {
		ClickCheckBox(FirstNameChkBx, true);
	}

	public void clickMiddleName1() {
		ClickCheckBox(MiddleName1ChkBx, true);
	}

	public void clickMiddleName2() {
		ClickCheckBox(MiddleName2ChkBx, true);
	}

	public void clickBirthDate() {
		ClickCheckBox(BirthDateChkBx, true);
	}

	public void clickRegisteredMobile() {
		ClickCheckBox(RegMobileNoChkBx, true);
	}

	public void clickRegisteredEmail() {
		ClickCheckBox(RegEmailIdChkBx, true);
	}

	public void clickLastName() {
		ClickCheckBox(LastNameChkBx, true);
	}

	public void clickLegalId() {
		ClickCheckBox(LegalIDChkBx, true);
	}

	public void clickSaveButton() {
		clickWhenClickable(save);
	}

	public boolean verifyErrorsOnDedupePlanPage() {
		return publishErrorOnPage();
	}

	public void verifyNewDedupePlanSuccess() {
		if (!verifyErrorsOnDedupePlanPage()) {
			logger.info("Dedupe Plan Added Successfully");
			SwitchToDefaultFrame();
		} else {
			logger.info("Error in Record Addition");
			clickWhenClickable(CancelBtn);
			SwitchToDefaultFrame();
		}
	}

	public String addDedupeDetails() {
		String dedupecode;
		String dedupeDesc;
		dedupecode = enterDedupeCode();
		dedupeDesc = enterDedupeDescription();
		return dedupeDesc + " " + "[" + dedupecode + "]";
	}

	public void activityCheckForDetails() {
		clickPrimaryApplication();
		clickAddOnApplicatin();
	}

	public void DedupeParameters() {
		clickFirstName();
		clickMiddleName1();
		clickMiddleName2();
		clickLastName();
		clickBirthDate();
		clickRegisteredMobile();
		clickRegisteredEmail();
		clickLegalId();

	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return null;
	}

}
