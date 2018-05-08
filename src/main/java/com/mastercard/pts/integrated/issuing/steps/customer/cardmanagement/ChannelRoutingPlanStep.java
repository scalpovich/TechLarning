package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.apache.commons.lang3.RandomStringUtils;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.AccountRangeRoutingPlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.ChannelRoutingPlan;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.AccountRangeRoutingFlows;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.ChannelRoutingFlows;

@Component
public class ChannelRoutingPlanStep  {

	@Autowired
	ChannelRoutingPlan channelrouting;
	@Autowired
	ChannelRoutingFlows  channelroutingflows;
	@Autowired
	AccountRangeRoutingPlan accountrangeroutingplan;
	
	@Autowired
	AccountRangeRoutingFlows  accountrangeroutingflows;
	
	@When("user creates channel Routing plan for $POS channel and $RACAL interface")
	public void userCreatesChannelRouting(@Named("channel") String channel,@Named("interface") String interfaceType) {
		channelrouting=ChannelRoutingPlan.channelRoutingPlanDataProvider();
		channelrouting.setChannel(channel);
		channelrouting.setInterfaceName(interfaceType);
		channelrouting.setPlanID(RandomStringUtils.randomNumeric(5));
		channelrouting.setDescription(interfaceType);
		channelroutingflows.addChannelRoutingPlan(channelrouting);
	}
	
	
	@When("user creates Acount Range Routing plan")
	public void userCreatesChannelRouting() {
		accountrangeroutingplan=AccountRangeRoutingPlan.channelRoutingPlanDataProvider();
		accountrangeroutingplan.setChannelRoutingPlan(channelrouting.getPlanID());
		accountrangeroutingflows.addChannelRoutingPlan(accountrangeroutingplan);
	}
	
	
}
