package com.mastercard.pts.integrated.issuing.workflows.customer.helpdesk;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.mastercard.pts.integrated.issuing.annotation.Workflow;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CreditConstants;
import com.mastercard.pts.integrated.issuing.domain.helpdesk.HelpDeskCustomer;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.customer.helpdesk.CustomerCarePage;
import com.mastercard.pts.integrated.issuing.pages.customer.helpdesk.SearchPanelHelpdeskPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.utils.simulator.SimulatorUtilities;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

/**
 * @author e084017
 *
 */
@Workflow
public class CustomerCareWorkflow extends AbstractBasePage {

	final Logger logger = LoggerFactory.getLogger(CustomerCareWorkflow.class);
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[.//*[text()='Partner Membership Number :']]/following-sibling::td[1]//*[@class='labeltextf']")
	private MCWebElement partnerMembershipNumber;
	
	@Autowired
	private Navigator navigator;
	
	@Autowired
	CustomerCarePage customerPage;
	
	@Autowired
	SearchPanelHelpdeskPage searchpanelhelpdesk;
	
	@Autowired
	TestContext context;
	
	private String activePartnerMSNumber;
	
	public String searchForNewApplication(HelpDeskCustomer helpdeskgettersetter) {		
		customerPage = navigator.navigateToPage(CustomerCarePage.class);
		return searchpanelhelpdesk.searchNewDevice(helpdeskgettersetter.getProductType(),helpdeskgettersetter.getDeviceNumber());		
	}
	
	public void getPartnerMemberShipNumber() {
		viewFirstRecord();
		SimulatorUtilities.wait(500);
		runWithinPopup("View Customer Care", () -> {
			context.put(CreditConstants.PARTNER_MEMBERSHIP_NUMBER, partnerMembershipNumber.getText());
			activePartnerMSNumber = context.get(CreditConstants.PARTNER_MEMBERSHIP_NUMBER);
			logger.info(" Partner Membership Number : {}", activePartnerMSNumber);
			clickCloseButton();
		});
	}
}
