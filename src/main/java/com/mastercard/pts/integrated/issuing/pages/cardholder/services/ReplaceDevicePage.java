package com.mastercard.pts.integrated.issuing.pages.cardholder.services;

import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.ServicesNav;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;

@Component
@Navigation(tabTitle = ServicesNav.TAB_SERVICES, treeMenuItems = { ServicesNav.L1_REPLACE_DEVICE })
public class ReplaceDevicePage extends AbstractBasePage {

	
}