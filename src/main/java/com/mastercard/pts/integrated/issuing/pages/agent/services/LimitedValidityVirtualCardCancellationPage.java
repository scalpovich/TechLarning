package com.mastercard.pts.integrated.issuing.pages.agent.services;

import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;

@Component
@Navigation(tabTitle = ServicesNav.TAB_SERVICES, treeMenuItems = { ServicesNav.L1_LIMITED_VALIDITY_VIRTUAL_CARD_CANCELLATION })
public class LimitedValidityVirtualCardCancellationPage extends ServicesAbstractPage {
}