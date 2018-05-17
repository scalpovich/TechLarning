package com.mastercard.pts.integrated.issuing.pages.customer.administration;

import java.util.Collection;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
public class CustomerPortalHomePage extends AbstractBasePage {

	final Logger logger = LoggerFactory.getLogger(CustomerPortalHomePage.class);

	@PageElement(findBy = FindBy.NAME, valueToFind = "institutionCode:input:dropdowncomponent")
	private MCWebElement institutionSelect;

	@PageElement(findBy = FindBy.NAME, valueToFind = "confirm")
	private MCWebElement btnConfirm;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@id='institution']")
	private MCWebElement institutionValue;

	private static final String HOME_TITLE = "Customer Portal EIS";

	public void selectInstitution(String institution) {

		String institutionName = institution;
		if ("Institution1".equals(institutionName)) {
			institutionName = env.getProperty("portal.customer.Institution1");
			institutionSelect.getSelect().selectByVisibleText(institutionName);
		}

		else if ("Institution2".equals(institutionName)) {
			institutionName = env.getProperty("portal.customer.Institution2");
			institutionSelect.getSelect().selectByVisibleText(institutionName);
		}

		else {
			institutionSelect.getSelect().selectByVisibleText(institutionName);
		}
		Constants.variable.put("customerPortalInstitute", institutionName);

		btnConfirm.click();
	}

	public void verifyHomePage() {

		String page = getFinder().getWebDriver().getTitle();
		if (HOME_TITLE.equalsIgnoreCase(page)) {

			log.info("Home page title is: " + page);
			Assert.assertTrue("Home page title is matched " + page, true);
		} else {
			log.info("Home page title is: " + page);
			Assert.assertTrue("Home page title is not matched: " + page, false);
		}

	}

	public void verifyInstitution(String institution) {
		String Institution_Is = "Institution is: ";
		String Institution_Is_Matching = "Institution is matching: ";
		String Institution_Is_Not_Matching = "Institution is not matching: ";

		String[] institutionName = institution.split(" ");

		if ("Institution1".contains(institutionName[0])) {

			if (institutionValue.getText().contains(
					env.getProperty("portal.customer.Institution1"))) {

				logger.info(Institution_Is + institutionValue.getText());
				Assert.assertTrue(
						Institution_Is_Matching + institutionValue.getText(),
						true);
			} else {
				logger.info(Institution_Is + institutionValue.getText());
				Assert.assertTrue(Institution_Is_Not_Matching
						+ institutionValue.getText(), false);
			}
		}

		else if ("Institution2".contains(institutionName[0])) {

			if (institutionValue.getText().contains(
					env.getProperty("portal.customer.Institution2"))) {
				logger.info(Institution_Is + institutionValue.getText());
				Assert.assertTrue(
						Institution_Is_Matching + institutionValue.getText(),
						true);
			} else {
				logger.info(Institution_Is + institutionValue.getText());
				Assert.assertTrue(Institution_Is_Not_Matching
						+ institutionValue.getText(), false);
			}
		}

		else {

			if (institutionValue.getText().contains(institutionName[0])) {

				logger.info(Institution_Is + institutionValue.getText());
				Assert.assertTrue(
						Institution_Is_Matching + institutionValue.getText(),
						true);
			} else {
				logger.info(Institution_Is + institutionValue.getText());
				Assert.assertTrue(Institution_Is_Not_Matching
						+ institutionValue.getText(), false);
			}
		}

	}

	public void selectInstitutionFromDropdown(String institutionName) {
		institutionValue.getSelect().selectByVisibleText(institutionName);
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return null;
	}

}
