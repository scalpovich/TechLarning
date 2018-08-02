package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.apache.commons.lang3.RandomStringUtils;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.AccountRangeRoutingPlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.ChannelRoutingPlan;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.MiscUtils;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.AccountRangeRoutingFlows;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.ChannelRoutingFlows;

@Component
public class ChannelRoutingPlanStep  {

	@Autowired
	ChannelRoutingPlan channelRouting;
	@Autowired
	ChannelRoutingFlows  channelRoutingFlows;
	@Autowired
	AccountRangeRoutingPlan accountRangeRoutingPlan;
	@Autowired
	AccountRangeRoutingFlows  accountRangeRoutingFlows;
	@Autowired
	private TestContext context;
	
	private final String channelNamePlan1 = "CBS1 [CBS1]" ;
	private final String channelNamePlan2 = "CBS2 [CBS2]" ;


	@When("user creates channel Routing plan for $channelName channel and $interfaceName interface")
	public void userCreatesChannelRouting(@Named("channelName") String channel,@Named("interfaceName") String interfaceType) {
		channelRouting=ChannelRoutingPlan.channelRoutingPlanDataProvider();
		channelRouting.setChannel(channel);
		channelRouting.setInterfaceName(interfaceType);
		channelRouting.setPlanID(RandomStringUtils.randomNumeric(5));
		channelRouting.setDescription(interfaceType);
		channelRoutingFlows.addChannelRoutingPlan(channelRouting);
	}


	@When("user creates Acount Range Routing plan")
	public void userCreatesChannelRouting() {
		accountRangeRoutingPlan=AccountRangeRoutingPlan.channelRoutingPlanDataProvider();
		accountRangeRoutingPlan.setChannelRoutingPlan(channelRouting.getPlanID());
		accountRangeRoutingFlows.addChannelRoutingPlan(accountRangeRoutingPlan);
	}

	@When("user creates Account Range for Routing for $channelName channel")
	public void userCreatesChannelRoutingForUserDefineChannel(String channelName) {
		accountRangeRoutingPlan=AccountRangeRoutingPlan.channelRoutingPlanDataProvider(context.get(ContextConstants.DEVICE));
		//Environment change is temporary fix as we are migrating on CBS2
		if(channelNamePlan1.contains(channelName)&& !MiscUtils.getEnvironment().equalsIgnoreCase(Constants.ENV_STAGESA)){
			accountRangeRoutingPlan.setChannelRoutingPlan(channelNamePlan1);
		}
		else{
			accountRangeRoutingPlan.setChannelRoutingPlan(channelNamePlan2);
		}
		accountRangeRoutingFlows.addChannelRoutingPlan(accountRangeRoutingPlan);
	}
}
