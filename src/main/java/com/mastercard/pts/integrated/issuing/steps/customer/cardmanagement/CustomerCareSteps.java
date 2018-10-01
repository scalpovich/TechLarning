package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import java.util.List;

import junit.framework.Assert;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CreditConstants;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.domain.helpdesk.HelpDeskCustomer;
import com.mastercard.pts.integrated.issuing.domain.helpdesk.ProductType;
import com.mastercard.pts.integrated.issuing.workflows.customer.helpdesk.CustomerCareWorkflow;

/**
 * @author e084017
 *
 */
@Component
public class CustomerCareSteps {
	
	@Autowired
	private TestContext context;
	
	@Autowired
	private CustomerCareWorkflow customerCareWorkflow;
	
	@Autowired
	HelpDeskCustomer helpDeskGetterSetter;
	
	@Given("User search for new application on customer care screen for $productType and validates the status as $NORMAL")
	@When("User search for new application on customer care screen for $productType and validates the status as $NORMAL")
	@Then("User search for new application on customer care screen for $productType and validates the status as $NORMAL")
	public void thenUserSearchForApplicationOnCustomerCareScreen(String productType, String status) {
		helpDeskGetterSetter.setProductType(ProductType.fromShortName(productType));
		String actualStatus = null;
		Device device=context.get(ContextConstants.DEVICE);

		if (Integer.parseInt(context.get(CreditConstants.QUANTITY_REQUESTED)) > 1) {
			List<String> devices = context.get(CreditConstants.DEVICE_NUMBER);
			for (String ele : devices) {
				helpDeskGetterSetter.setDeviceNumber(ele);
				actualStatus = customerCareWorkflow.searchForNewApplication(helpDeskGetterSetter);
			}
		} else {
			helpDeskGetterSetter.setDeviceNumber(context.get(CreditConstants.DEVICE_NUMBER));
			actualStatus = customerCareWorkflow.searchForNewApplication(helpDeskGetterSetter);
		}
		if (actualStatus.contains(status)) {
			customerCareWorkflow.getPartnerMemberShipNumber();
			Assert.assertEquals(device.getPartnerMembershipNumber(), context.get(CreditConstants.PARTNER_MEMBERSHIP_NUMBER));			
		} else {
			Assert.assertTrue("status of newly created device is not normal ", false);
		}
	}

}
