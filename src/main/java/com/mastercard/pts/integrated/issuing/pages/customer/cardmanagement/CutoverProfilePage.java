package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CutoverProfile;
import com.mastercard.pts.integrated.issuing.pages.AbstractModelPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_INSTITUTION_PARAMETER_SETUP,
		CardManagementNav.L2_CUTOVER_PROFILE })
public class CutoverProfilePage extends AbstractModelPage {

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
		verifyUiOperation("Add Cutover Profile");
	}

	public void addCutoverProfile(CutoverProfile cp) {
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

	private void addCutoverProfileRecord(CutoverProfile cp) {
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
