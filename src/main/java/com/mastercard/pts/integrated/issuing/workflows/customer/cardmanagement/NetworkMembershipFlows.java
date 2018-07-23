package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import java.io.FileNotFoundException;

import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.NetworkMembership;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.NetworkMembershipPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;
import com.mastercard.pts.integrated.issuing.workflows.MenuFlows;

/**
 * @author E060549
 * 
 *
 */

@Component
public class NetworkMembershipFlows extends MenuFlows {

	@Autowired
	Navigator navigator;

	final Logger logger = LoggerFactory.getLogger(NetworkMembershipFlows.class);

	public void CreateNetworkMemberShipFlows(NetworkMembership ntk) {
		waitForElementVisible(menusubmenuPage.getCardManagement());
		NetworkMembershipPage networkMembershipPage = navigator.navigateToPage(NetworkMembershipPage.class);
		networkMembershipPage.clickAddNetworkMemberShip();
		networkMembershipPage.selectInterchangeType(ntk);
		networkMembershipPage.fillPresentTime(ntk);
		networkMembershipPage.selectCutoverHours();
		networkMembershipPage.selectCutoverMinutes();
		networkMembershipPage.selectSettlementCurrency(ntk);
		networkMembershipPage.clickSaveBtn();
		waitForPageToLoad(getFinder().getWebDriver());
		networkMembershipPage.verifyNewNetworkSuccess();
	}

	public void verfifyNtkMembership() {
		waitForElementVisible(menusubmenuPage.getCardManagement());
		clickMenuSubOption(menuSubMenuPage.getInstitutionParameterSetup(), menuSubMenuPage.getNetworkMembership());
		waitForElementVisible(networkMembershipPage.getAddNetworkMembership());
		Boolean network = networkMembershipPage
				.verifyNetworkMembership(MapUtils.fnGetInputDataFromMap("InterchangeType"));
		Assert.assertEquals("Interchange is present :", true, network);

	}

	public void editNtkMembership() {
		waitForElementVisible(menusubmenuPage.getCardManagement());
		clickMenuSubOption(menuSubMenuPage.getInstitutionParameterSetup(), menuSubMenuPage.getNetworkMembership());
		networkMembershipPage.editnetworkmembership("06");
	}

	public void deleteNtkMembership() {
		waitForElementVisible(menusubmenuPage.getCardManagement());
		clickMenuSubOption(menuSubMenuPage.getInstitutionParameterSetup(), menuSubMenuPage.getNetworkMembership());
		networkMembershipPage.deletenetworkmembership("06");
	}

	public void verifyMessage(String operation, String message) {

		String Message = networkMembershipPage.getConfirmationMessage();
		try {
			String errorMsg = networkMembershipPage.checkErrormessage();
			if (errorMsg.equalsIgnoreCase(Constants.Record_Cannot_Be_Added_NetworkMemberShip)) {
				logger.info(Constants.Record_Cannot_Be_Added_NetworkMemberShip);
			}
		} catch (Exception e) {
			Assert.assertEquals("operation performed is :- " + operation, message, Message);
		}

	}

	@Override
	public void verifyErrorMessage() {
		String errorMsg = networkMembershipPage.checkErrormessage();
		Assert.assertEquals("succesfully added", Constants.Record_Cannot_Be_deleted, errorMsg);
	}

	public void downloadList() throws FileNotFoundException {
		waitForElementVisible(menusubmenuPage.getCardManagement());
		clickMenuSubOption(menuSubMenuPage.getInstitutionParameterSetup(), menuSubMenuPage.getNetworkMembership());
		networkMembershipPage.downloadlists();
	}

}
