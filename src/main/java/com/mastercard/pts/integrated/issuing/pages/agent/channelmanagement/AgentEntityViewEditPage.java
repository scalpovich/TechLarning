package com.mastercard.pts.integrated.issuing.pages.agent.channelmanagement;

import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;

@Component
@Navigation(tabTitle = ChannelManagementNav.TAB_CHANNEL_MANAGEMENT, treeMenuItems = { ChannelManagementNav.L1_AGENT, ChannelManagementNav.L2_AGENT_ENTITY,
		ChannelManagementNav.L3_AGENT_ENTITY_VIEW_EDIT })
public class AgentEntityViewEditPage extends AgentAbstractPage {
}