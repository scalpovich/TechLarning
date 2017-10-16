package com.mastercard.pts.integrated.issuing.pages.agent.channelmanagement;

import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
public class AgentPortalHomePage extends AbstractBasePage {
	final Logger logger = LoggerFactory.getLogger(AgentPortalHomePage.class);

	@PageElement(findBy = FindBy.NAME, valueToFind = "languageSelect")
	private MCWebElement languageSelect;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//div[@class='select-institute']/div")
	private MCWebElement institutionValue;

	private static final String HOME_TITLE = "Integrated Issuing prepaid :: Agent Portal";

	public void selectLangDropDown(String language) {
		languageSelect.getSelect().selectByValue(language);

	}

	public void verifyHomePage() {

		String page = getFinder().getWebDriver().getTitle();
		if (HOME_TITLE.contains(page)) {

			logger.info("Home page title is: " + page);
			Assert.assertTrue("Home page title is matched " + page, true);
		} else {
			logger.info("Home page title is: " + page);
			Assert.assertTrue("Home page title is not matched: " + page, false);
		}

	}

	public void verifyInstitution(String institution) {

		if ("Institution1".equals(institution)) {

			if (institutionValue.getText().contains(
					env.getProperty("portal.agent.Institution1"))) {
				Assert.assertTrue("Institution is matching: "
						+ institutionValue.getText(), true);
			} else {
				Assert.assertTrue("Institution is not matching: "
						+ institutionValue.getText(), false);
			}
		}

		else if ("Institution2".equals(institution)) {

			if (institutionValue.getText().contains(
					env.getProperty("portal.agent.Institution2"))) {
				Assert.assertTrue("Institution is matching: "
						+ institutionValue.getText(), true);
			} else {
				Assert.assertTrue("Institution is not matching: "
						+ institutionValue.getText(), false);
			}
		}

		else {
			if (institutionValue.getText().contains(institution)) {
				Assert.assertTrue("Institution is matching: "
						+ institutionValue.getText(), true);
			} else {
				Assert.assertTrue("Institution is not matching: "
						+ institutionValue.getText(), false);
			}
		}

	}

}
