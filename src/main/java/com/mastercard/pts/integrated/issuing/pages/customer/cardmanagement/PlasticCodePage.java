package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.PlasticCode;
import com.mastercard.pts.integrated.issuing.pages.AbstractModelPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_INSTITUTION_PARAMETER_SETUP,
		CardManagementNav.L2_PLASTIC_CODE })
public class PlasticCodePage extends AbstractModelPage {
	
	private static final Logger logger = LoggerFactory
			.getLogger(PlasticCodePage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=plasticId]")
	private MCWebElement plasticId;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=description]")
	private MCWebElement description;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn=plasticId]")
	private MCWebElement plasticIdPoupTxt;
	
	@PageElement(findBy = FindBy.CSS, valueToFind =  "input[fld_fqn=description]")
	private MCWebElement descriptionPopupTxt;
	
	
	public void verifyUiOperationStatus() {
		logger.info("Plastic Code");
		verifyUiOperation("Add Plastic Code");
	}

	
	public void addPictureCode(PlasticCode pc)
	{
		logger.info("create new plastic code : {}",pc.getPlasticCodeNumber());
		clickAddNewButton();

		runWithinPopup(
				"Add Plastic Code",
				() -> {
						addCode(pc);
						verifyNoErrors();
				});

		verifyOperationStatus();
	}
	
	private void addCode(PlasticCode pc) {
		WebElementUtils.enterText(plasticIdPoupTxt, pc.getPlasticCodeNumber());
		WebElementUtils.enterText(descriptionPopupTxt, pc.getDescription());
		clickSaveButton();
	}	
	
	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(plasticId),
				WebElementUtils.elementToBeClickable(description)				
				);
	}
}
