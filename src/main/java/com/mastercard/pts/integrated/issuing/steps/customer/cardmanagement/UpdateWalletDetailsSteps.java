package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.WalletDetails;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.UpdateWalletDetailsWorkflow;



@Component
public class UpdateWalletDetailsSteps {

	@Autowired
	private TestContext context;

	@Autowired
	private UpdateWalletDetailsWorkflow updateWalletDetailsWorkflow;

	@When("user updates the wallet admin status to $adminStatus")
	public void updateAdminStatusSteps(@Named("adminStatus") String adminStatus){
		Device device = context.get(ContextConstants.DEVICE);
		WalletDetails updateWalletDetails = WalletDetails.createWithProvider();
		updateWalletDetails.setWalletNumber(device.getWalletNumber());
		updateWalletDetails.setAdminStatus(adminStatus);
		updateWalletDetailsWorkflow.updateDeviceDetails(updateWalletDetails);
	}	
}