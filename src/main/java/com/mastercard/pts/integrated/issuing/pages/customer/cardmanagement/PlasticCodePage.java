package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.PlasticCode;
import com.mastercard.pts.integrated.issuing.pages.AbstractModelPage;
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
	
	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addPlasticCode;

	@PageElement(findBy = FindBy.NAME, valueToFind = "tables:1:rows:1:cols:colspanMarkup:inputField:input:inputTextField")
	private MCWebElement PlasticCode;

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

	public void clickaddPlasticCode() {
		waitForElementVisible(addPlasticCode);
		addPlasticCode.click();
	}

	public void switchToAddPlasticCodeFrame() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		switchToIframe(Constants.ADD_PLASTIC_CODE_FRAME);
	}

	public String enterPlasticCode() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(PlasticCode, CustomUtils.randomNumbers(3));
		return PlasticCode.getAttribute("value");

	}

	public String enterDescription() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(Description, plasticcodeDataprovider().getDescription());
		return Description.getAttribute("value");
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

	public void addplasticcode() {
		addPlasticCode.click();
		CustomUtils.ThreadDotSleep(2000);
		getFinder().getWebDriver().switchTo().frame("_wicket_window_3");

		// PlasticCode.sendKeys(env.getProperty("is.dinners.plasticcode.code"));
		PlasticCode.sendKeys(CustomUtils.randomNumbers(3));
		CustomUtils.ThreadDotSleep(1000);
		Description.sendKeys(env.getProperty("is.dinners.plasticcode.description"));

		save.click();
		CustomUtils.ThreadDotSleep(2000);
		getFinder().getWebDriver().switchTo().defaultContent();

	}
	public void verifyUiOperationStatus() {
		logger.info("Plastic Code");
		verifyUiOperation("Add Plastic Code");
	}

	
	public void addPictureCode(PlasticCode pc)
	{
		performSearchOperationOnMainScreen(pc);
		if(isNoRecordsFoundInTable())
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
	}
	
	private void addCode(PlasticCode pc) {
		WebElementUtils.enterText(plasticIdPoupTxt, pc.getPlasticCodeNumber());
		WebElementUtils.enterText(descriptionPopupTxt, pc.getDescription());
		clickSaveButton();
	}	

	private void performSearchOperationOnMainScreen(PlasticCode pc)
	{
		WebElementUtils.enterText(plasticId, pc.getPlasticCodeNumber());
		clickSearchButton();
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(plasticId),
				WebElementUtils.elementToBeClickable(description)				
				);
	}

}
