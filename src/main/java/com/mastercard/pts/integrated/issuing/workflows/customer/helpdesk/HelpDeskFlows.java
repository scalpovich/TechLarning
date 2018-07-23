package com.mastercard.pts.integrated.issuing.workflows.customer.helpdesk;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceCreation;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.NewDevice;
import com.mastercard.pts.integrated.issuing.domain.helpdesk.ChangeAddressRequest;
import com.mastercard.pts.integrated.issuing.domain.helpdesk.EventAndAlerts;
import com.mastercard.pts.integrated.issuing.domain.helpdesk.HelpDeskGeneral;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.customer.helpdesk.GeneralPage;
import com.mastercard.pts.integrated.issuing.pages.customer.helpdesk.SearchPanelHelpdeskPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

// TODO: Auto-generated Javadoc
/**
 * @author E070234, E074127 The Class AccountHeadFlows.
 */
@Component
public class HelpDeskFlows extends AbstractBasePage {

	final Logger logger = LoggerFactory.getLogger(HelpDeskFlows.class);

	@Autowired
	private Navigator navigator;

	@Autowired
	GeneralPage generalPage;

	@Autowired
	SearchPanelHelpdeskPage searchpanelhelpdesk;

	NewDevice newDevice;
	
	@Autowired
	TestContext context;

	/**
	 * Navigate to general option.
	 */
	public void navigateToGeneralTab() {
		generalPage = navigator.navigateToPage(GeneralPage.class);
	}

	public void searchForDevice(HelpDeskGeneral helpdeskgettersetter) {
		searchpanelhelpdesk.searchDevice(helpdeskgettersetter.getProductType(), helpdeskgettersetter.getDeviceNumber());
		searchpanelhelpdesk.clickEditBtn();
	}

	public void selectServiceCode(HelpDeskGeneral helpdeskgettersetter) {
		generalPage.selectServiceCode(helpdeskgettersetter.getServiceCode());
	}

	public boolean verifyActivateAccountEventGenerated() {
		// navigate to Card Management Search page
		return false;
	}

	public void activateDeviceHelpDeskFlows(HelpDeskGeneral helpdeskgettersetter) {
		generalPage.activateDeviceHelpDesk(helpdeskgettersetter.getNoteText());
	}

	public void switchToNoteWindow(HelpDeskGeneral helpdeskgettersetter) {
		switchToIframe(helpdeskgettersetter.getEventsIFrameName());
	}

	public void endCallFlow() {
		generalPage.endCall();
	}

	public void selelctEmailAddressIndicatorFlow(HelpDeskGeneral helpdeskgettersetter) {
		generalPage.selectEmailAddressIndicator(helpdeskgettersetter.getEmailIndicator());
	}

	public void addReasonForStopListing(HelpDeskGeneral helpdeskgettersetter) {
		generalPage.selectReasonForStopListing(helpdeskgettersetter.getEventsIFrameName(),
				helpdeskgettersetter.getStopListReason());
	}

	public void emailSMSAlertChangeFlows(String type, String status, HelpDeskGeneral helpdeskgettersetter) {
		generalPage.emailSMSAlertChange(type, status, helpdeskgettersetter.getNoteText());
	}

	public void linkCardQueryHelpDeskFlows(HelpDeskGeneral helpdeskgettersetter) {
		generalPage.linkCardQuery(helpdeskgettersetter.getNoteText());
	}

	public void addCardToDoNotCallRegisterFlows(HelpDeskGeneral helpdeskgettersetter) {
		generalPage.addCardToDoNotCallRegister(helpdeskgettersetter.getNoteText());
	}

	public void addCallNotesFlows(HelpDeskGeneral helpdeskgettersetter) {
		generalPage.addCallNotes(helpdeskgettersetter.getNoteText());
	}

	public void addOnCardFlows(EventAndAlerts eventAndAlerts) {
		generalPage.addOnCardRequest(eventAndAlerts);
	}

	public void changeAddressRequestFlows(ChangeAddressRequest changeAddressRequest) {
		generalPage.changeAddressRequest(changeAddressRequest);
	}

	public void editServiceCodeForNoteWindow(HelpDeskGeneral helpdeskgettersetter) {
		switchToIframe(helpdeskgettersetter.getEventsIFrameName().replaceAll("^\"|\"$", ""));
		generalPage.addNotes(helpdeskgettersetter.getNoteText());
	}

	public void activateECommFlows(EventAndAlerts eventAndAlerts) {
		generalPage.activateEComm(eventAndAlerts);
	}

	public void deactivateEcommerceFlows(EventAndAlerts eventAndAlerts) {
		generalPage.deactivatingEComm(eventAndAlerts);
	}

	public void selectMultiWallet(HelpDeskGeneral helpdeskgettersetter, DeviceCreation deviceCreation) {
		navigateToGeneralTab();
		searchpanelhelpdesk.searchDevice(helpdeskgettersetter.getProductType(), newDevice.getDeviceNumber());
		searchpanelhelpdesk.clickEditBtn();
		selectServiceCode(helpdeskgettersetter);
		generalPage.switchToCurrencySetupFrame();
		generalPage.selectMultiWalletSingleCurrency(deviceCreation.getCurrency());
		generalPage.addNotes(helpdeskgettersetter.getNoteText());

	}

	public void checkNoOfWallets(HelpDeskGeneral helpdeskgettersetter) {
		if (((helpdeskgettersetter.getNoOfWallets()).equals(generalPage.CheckNoOfWalletsAdded()))) {
			logger.info("Multiple wallets added succesfully");
		}
		generalPage.endCall();
	}

	public String searchForDevicePrepaid(HelpDeskGeneral helpdeskgettersetter) {
		generalPage = navigator.navigateToPage(GeneralPage.class);
		String status = searchpanelhelpdesk.searchDeviceUsingName(helpdeskgettersetter.getProductType(),
				helpdeskgettersetter.getFirstName()/*context.get(ContextConstants.DEVICE_NUMBER)*/);
		searchpanelhelpdesk.clickSearchBtn();
		return status;
	}
	public String searchForNewDevice(HelpDeskGeneral helpdeskgettersetter) {
		generalPage = navigator.navigateToPage(GeneralPage.class);
        String status=searchpanelhelpdesk.searchNewDevice(helpdeskgettersetter.getProductType(),helpdeskgettersetter.getDeviceNumber());
		searchpanelhelpdesk.clickSearchBtn();
		return status;
	}
	
	public String searchForNewApplication(HelpDeskGeneral helpdeskgettersetter) {
		
		generalPage = navigator.navigateToPage(GeneralPage.class);
		String status = searchpanelhelpdesk.searchNewDevice(helpdeskgettersetter.getProductType(),helpdeskgettersetter.getDeviceNumber());
		return status;
	}

	public void verifyExpiryDate() {
		generalPage.CalculateExpiryDate();
		generalPage.endCall();
	}

	public void VerifyPairedDeviceStatus() {
		generalPage.checkNoAndStatusOfCards();
		generalPage.endCall();
	}

}