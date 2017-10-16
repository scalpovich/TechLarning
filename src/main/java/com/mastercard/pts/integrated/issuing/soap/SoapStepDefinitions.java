package com.mastercard.pts.integrated.issuing.soap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.xml.sax.SAXException;

import com.mastercard.pts.integrated.issuing.workflows.AbstractBaseFlows;
import com.mastercard.pts.integrated.issuing.workflows.LoadReLoadFlows;

/**
 * The Class SoapStepDefinitions.
 */
@Component
public class SoapStepDefinitions extends AbstractBaseFlows {

	/** The xml utilities. */
	@Autowired
	XMLUtilities xmlUtilities;

	/** The test parameters. */
	@Autowired
	SoapRequestParameters testParameters;

	/** The Load Reload Flows **/
	@Autowired
	LoadReLoadFlows loadReloadFlows;

	/**
	 * Read request xml.
	 *
	 * @param xmlFileName
	 *            the xml file name
	 */
	@Given("I have a valid web service request $xml")
	@Then("I have a valid web service request $xml")
	@When("I have a valid web service request $xml")
	public void readRequestXml(@Named("xml") String xmlFileName) {

		testParameters.setRequestXml(xmlUtilities.readXml(xmlFileName));
	}

	/**
	 * Store session key.
	 */
	@When("I need to save sessionKey for future steps")
	@Then("I need to save sessionKey for future steps")
	public void storeSessionKey() {
		testParameters.setSessionKey(xmlUtilities.getTagValueFromResponse(
				"sessionKey", testParameters.getResponseString()));
		assertNotNull(testParameters.getSessionKey());

	}

	/**
	 * Update request xml.
	 *
	 * @param tagTable
	 *            the tag table
	 */
	@When("I update xml for below tags:$tagTable")
	@Then("I update xml for below tags:$tagTable")
	public void updateRequestXml(ExamplesTable tagTable) {
		assertNotNull(testParameters.getSessionKey());
		testParameters.setRequestXml(xmlUtilities.updateXmlForTags(
				testParameters.getRequestXml(), tagTable,
				testParameters.getSessionKey()));

	}

	/**
	 * Update request xml.
	 *
	 * @param tagTable
	 *            the tag table
	 */
	@When("I update login xml for below tags:$tagTable")
	@Then("I update login xml for below tags:$tagTable")
	public void updateLoginRequestXml(ExamplesTable tagTable) {
		testParameters.setRequestXml(xmlUtilities.updateXmlForTags(
				testParameters.getRequestXml(), tagTable));

	}

	/**
	 * Send web service request.
	 */
	@When("I send the request")
	@Then("I send the request")
	public void sendWebServiceRequest() {
		testParameters.setResponseString(xmlUtilities
				.sendRequest(testParameters.getRequestXml()));
	}

	/**
	 * Check response.
	 *
	 * @param tagTable
	 *            the tag table
	 * @throws ParserConfigurationException
	 *             the parser configuration exception
	 * @throws SAXException
	 *             the SAX exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	@Then("I check response for below tags:$tagTable")
	public void checkResponse(ExamplesTable tagTable)
			throws ParserConfigurationException, SAXException, IOException {

		for (int i = 0; i < tagTable.getRows().size(); i++) {

			String tagName = tagTable.getRow(i).get(
					tagTable.getHeaders().get(0));
			String expTagvalue = tagTable.getRow(i).get(
					tagTable.getHeaders().get(1));
			String acttagValue = xmlUtilities.getTagValueFromResponse(tagName,
					testParameters.getResponseString());
			assertNotNull(acttagValue);

			assertEquals(acttagValue, expTagvalue);

		}

	}

	/**
	 * Implement this function to delete all institution load currency
	 */
	@When("User Delete all institution currency")
	public void userDeleteAllInstitutionLoadCurrency() {

		selectInstitute();
		menuSubMenuPage.clickMenuSubOption(
				menuSubMenuPage.getInstitutionParameterSetup(),
				menuSubMenuPage.getInstitutionLoadCurrency());
		loadReloadFlows.deleteAllLoadInstitutionCurrency();

	}

	/**
	 * 
	 * @param currency
	 *            - which needs to be deleted
	 */

	@When("User Delete the institution currency $currency")
	public void userDeleteInstitutionLoadCurrency(
			@Named("currency") String currency) {
		selectInstitute();
		menuSubMenuPage.clickMenuSubOption(
				menuSubMenuPage.getInstitutionParameterSetup(),
				menuSubMenuPage.getInstitutionLoadCurrency());
		loadReloadFlows.deleteLoadInstitutionCurrency(currency);

	}

	/**
	 * 
	 * @param currency
	 *            - which is required to set
	 */
	@When("User set the institution $currency")
	public void userSetInstitutionLoadCurrency(
			@Named("currency") String currency) {
		selectInstitute();
		menuSubMenuPage.clickMenuSubOption(
				menuSubMenuPage.getInstitutionParameterSetup(),
				menuSubMenuPage.getInstitutionLoadCurrency());

		loadReloadFlows.createLoadInstitutionCurrency(currency);

	}

}
