package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.PictureCode;
import com.mastercard.pts.integrated.issuing.pages.AbstractModelPage;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.customer.navigation.CardManagementNav;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
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

	// ------------- Card Management > Institution Parameter Setup > Institution
	// Currency [ISSS05]

	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addPictureCode;

	@PageElement(findBy = FindBy.NAME, valueToFind = "tables:1:rows:1:cols:colspanMarkup:inputField:input:inputTextField")
	private MCWebElement PictureCode;

	@PageElement(findBy = FindBy.NAME, valueToFind = "tables:1:rows:2:cols:colspanMarkup:inputField:input:inputTextField")
	private MCWebElement Description;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement save;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@class = 'feedbackPanelINFO']")
	private MCWebElement PanelInfo;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@class = 'feedbackPanelERROR']")
	private MCWebElement PanelError;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cancel")
	private MCWebElement cancel;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=pictureCode]")
	private MCWebElement pictureCode;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=description]")
	private MCWebElement description;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn=pictureCode]")
	private MCWebElement pictureCodePopupTxt;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn=description]")
	private MCWebElement descriptionPopupTxt;
	
	
	public void clickaddPictureCode() {
		waitForElementVisible(addPictureCode);
		addPictureCode.click();
	}

	public void switchToAddPictureCodeFrame() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		switchToIframe(Constants.ADD_PICTURE_CODE_FRAME);
	}

	public String enterPictureCode() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(PictureCode, CustomUtils.randomNumbers(3));
		return PictureCode.getAttribute("value");
	}

	public void clickSaveButton() {
		waitForElementVisible(save);
		ClickButton(save);
		try {
			if (PanelInfo.isVisible()) {
				Assert.assertEquals(PanelInfo.getText(), Constants.Record_Added_Successfully);
			}
		} catch (Exception e) {
			logger.error(e.toString());
			try {
				if (PanelError.isVisible()) {
					logger.info("inside error pannel");
					cancel.click();
				}
			} catch (Exception e1) {
				logger.error(e1.toString());
				logger.info("error pannel not present");
			}
		}
		SwitchToDefaultFrame();
	}

	public String enterPictureDescription() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(Description, "Picture code");
		return Description.getAttribute("value");
	}
	public void verifyUiOperationStatus() {
		logger.info("Picture Code");
		verifyUiOperation("Add Picture Code");
	}
	
	public void addpicturecode() {
		addPictureCode.click();
		CustomUtils.ThreadDotSleep(2000);
		getFinder().getWebDriver().switchTo().frame("_wicket_window_3");

		// PictureCode.sendKeys(env.getProperty("is.dinners.picturecode.code"));
		PictureCode.sendKeys(CustomUtils.randomNumbers(3));
		CustomUtils.ThreadDotSleep(1000);
		Description.sendKeys(env.getProperty("is.dinners.picturecode.description"));
		save.click();
		CustomUtils.ThreadDotSleep(2000);
		getFinder().getWebDriver().switchTo().defaultContent();

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
