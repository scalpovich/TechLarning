package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.NetworkMembership;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.NetworkMembershipFlows;

@Component
public class NetworkMembershipSteps {

	public NetworkMembership ntk;

	@Autowired
	NetworkMembershipFlows networkmembershipflows;

	@When("user creates a Network MemberShip for $network")
	public void whenUserCreatesANetworkMemberShip(@Named("network") String network) {
		ntk = NetworkMembership.NetworkMembershipDataProvider();
		ntk.setInterchange(network);
		networkmembershipflows.CreateNetworkMemberShipFlows(ntk);
	}
}