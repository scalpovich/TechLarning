package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.PictureCode;
import com.mastercard.pts.integrated.issuing.pages.AbstractModelPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_INSTITUTION_PARAMETER_SETUP,
		CardManagementNav.L2_PICTURE_CODE })
public class PictureCodePage extends AbstractModelPage {
	
	private static final Logger logger = LoggerFactory
			.getLogger(PictureCodePage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=pictureCode]")
	private MCWebElement pictureCode;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=description]")
	private MCWebElement description;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn=pictureCode]")
	private MCWebElement pictureCodePopupTxt;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn=description]")
	private MCWebElement descriptionPopupTxt;
	
	
	public void verifyUiOperationStatus() {
		logger.info("Picture Code");
		verifyUiOperation("Add Picture Code");
	}
	
	public void addPictureCode(PictureCode pc)
	{
		performSearchOperationOnMainScreen(pc);
		if(isNoRecordsFoundInTable())
		{
			logger.info("create new picture code : {}",pc.getPictureCodeNumber());
			clickAddNewButton();
	
			runWithinPopup(
					"Add Picture Code",
					() -> {
							addCode(pc);
							verifyNoErrors();
					});
	
			verifyOperationStatus();
		}
	}
	
	private void addCode(PictureCode pc) {
		WebElementUtils.enterText(pictureCodePopupTxt, pc.getPictureCodeNumber());
		WebElementUtils.enterText(descriptionPopupTxt, pc.getDescription());
		clickSaveButton();
	}	

	private void performSearchOperationOnMainScreen(PictureCode pc)
	{
		WebElementUtils.enterText(pictureCode, pc.getPictureCodeNumber());
		clickSearchButton();
	}
	
	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(pictureCode),
				WebElementUtils.elementToBeClickable(description)				
				);
	}
}
