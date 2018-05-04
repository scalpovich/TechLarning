package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.apache.commons.lang3.RandomStringUtils;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.ChannelRoutingPlan;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.ChannelRoutingFlows;

@Component
public class ChannelRoutingPlanStep  {

	@Autowired
	ChannelRoutingPlan channelrouting;
	@Autowired
	ChannelRoutingFlows  channelroutingflows;
	
	@When("user creates channel Routing plan for $POS channel and $RACAL interface")
	public void userCreatesChannelRouting(@Named("channel") String channel,@Named("interface") String interfaceType) {
		channelrouting=ChannelRoutingPlan.channelRoutingPlanDataProvider();
		channelrouting.setChannel(channel);
		channelrouting.setInterfaceName(interfaceType);
		channelrouting.setPlanID(channel+RandomStringUtils.randomNumeric(3));
		channelrouting.setDescription(interfaceType);
		channelroutingflows.addChannelRoutingPlan(channelrouting);
	}

	
}
