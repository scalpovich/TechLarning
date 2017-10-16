package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceCreation;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceJoiningMembershipFeePlan;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.DeviceJoiningFlows;

@Component
public class DeviceJoiningMemberShipFeePlanSteps {

	@Autowired
	DeviceCreation deviceCreation;

	public DeviceJoiningMembershipFeePlan devicejoiningmembershipfeeplan;

	@Autowired
	DeviceJoiningFlows devicejoiningflows;

	@When("user creates $feeplanType Fee plan for $product")
	public void whenUserCreatesDeviceJoiningAndMembershipFeePlanForPrepaid(@Named("feeplanType") String feeplanType,
			@Named("product") String product) {
		devicejoiningmembershipfeeplan = DeviceJoiningMembershipFeePlan.devicejoiningmembershipfeeplanDataProvider();
		deviceCreation.setProduct(product);
		devicejoiningmembershipfeeplan.setFeeType(feeplanType);
		if (feeplanType.contains("Joining")) {
			devicejoiningflows.addDeviceJoiningFeePlan(deviceCreation, devicejoiningmembershipfeeplan);
		}
		if (feeplanType.contains("Membership")) {
			devicejoiningflows.addDeviceMembershipFeePlan(deviceCreation, devicejoiningmembershipfeeplan);
		}
	}
}