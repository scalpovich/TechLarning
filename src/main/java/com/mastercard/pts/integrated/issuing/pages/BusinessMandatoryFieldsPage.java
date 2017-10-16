package com.mastercard.pts.integrated.issuing.pages;

import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.MPTSBasePage;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
public class BusinessMandatoryFieldsPage extends MPTSBasePage {
	final Logger logger = LoggerFactory.getLogger(EmbossingPriorityPassPage.class);

	// ------------- Card Management > Institution Parameter Setup > Institution
	// Currency [ISSS05]

	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addBusinessMandatoryFields;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@class = 'feedbackPanelERROR']")
	private MCWebElement PanelError;

	@PageElement(findBy = FindBy.NAME, valueToFind = "productType:input:dropdowncomponent")
	private MCWebElement ProductType;

	@PageElement(findBy = FindBy.NAME, valueToFind = "customerType:input:dropdowncomponent")
	private MCWebElement CustomerType;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement AddDetails;

	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addSubDetails;

	@PageElement(findBy = FindBy.NAME, valueToFind = "fieldName:input:dropdowncomponent")
	private MCWebElement FieldName;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement save;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cancel")
	private MCWebElement cancel;

	public void addbusinessmandatoryfields(String product) {
		addBusinessMandatoryFields.click();
		addWicketAjaxListeners(getFinder().getWebDriver());
		switchToIframe(Constants.ADD_BUSINESS_MANDATORY_FRAME);
		SelectDropDownByText(ProductType, product);
		SelectDropDownByIndex(CustomerType, 1);
		addWicketAjaxListeners(getFinder().getWebDriver());
		ClickButton(save);
		addWicketAjaxListeners(getFinder().getWebDriver());

		try {
			if (PanelError.isVisible()) {
				logger.info("inside error pannel");
				cancel.click();
			}
		} catch (Exception e) {
			logger.info("error pannel not present");
			addBusinessMandFieldDetails();
			// addWicketAjaxListeners(getFinder().getWebDriver());

			SwitchToDefaultFrame();
			addWicketAjaxListeners(getFinder().getWebDriver());
			switchToIframe(Constants.ADD_BUSINESS_MANDATORY_FRAME);
			addWicketAjaxListeners(getFinder().getWebDriver());
			ClickButton(save);
		}
		SwitchToDefaultFrame();

	}

	public void addBusinessMandFieldDetails() {
		addSubDetails.click();
		addWicketAjaxListeners(getFinder().getWebDriver());
		SwitchToDefaultFrame();
		switchToIframe(Constants.ADD_BUSINESS_MANDATORY_DETAILS_FRAME);
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByIndex(FieldName, 1);
		ClickButton(save);

	}

	public void addbusinessmandatoryfieldsprepaid() {
		addBusinessMandatoryFields.click();
		CustomUtils.ThreadDotSleep(2000);
		getFinder().getWebDriver().switchTo().frame("_wicket_window_3");

		ProductType.getSelect()
				.selectByVisibleText(env.getProperty("is.dinners.businessmandatoryfieldspr.ProductType"));
		CustomUtils.ThreadDotSleep(1000);
		CustomerType.getSelect()
				.selectByVisibleText(env.getProperty("is.dinners.businessmandatoryfieldspr.CustomerType"));
		CustomUtils.ThreadDotSleep(1000);

		save.click();
		CustomUtils.ThreadDotSleep(2000);

		// Adding child records

		try {
			if (PanelError.isVisible()) {
				System.out.println("inside error pannel");
				cancel.click();
			}
		} catch (Exception e) {
			System.out.println("error pannel not present");
			addSubDetails.click();
			CustomUtils.ThreadDotSleep(2000);
			getFinder().getWebDriver().switchTo().defaultContent();
			CustomUtils.ThreadDotSleep(2000);
			getFinder().getWebDriver().switchTo().frame("_wicket_window_16");
			CustomUtils.ThreadDotSleep(2000);

			FieldName.getSelect()
					.selectByVisibleText(env.getProperty("is.dinners.businessmandatoryfieldspr.FieldName"));

			save.click();
			CustomUtils.ThreadDotSleep(2000);
			getFinder().getWebDriver().switchTo().defaultContent();

			getFinder().getWebDriver().switchTo().frame("_wicket_window_3");
			CustomUtils.ThreadDotSleep(2000);
			save.click();
			CustomUtils.ThreadDotSleep(2000);

		}

		getFinder().getWebDriver().switchTo().defaultContent();

	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		// TODO Auto-generated method stub
		return null;
	}

}
