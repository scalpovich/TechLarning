package com.mastercard.pts.integrated.issuing.pages.agent.services;

import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;

@Component
@Navigation(tabTitle = ServicesNav.TAB_SERVICES, treeMenuItems = { ServicesNav.L1_DEVICE_SALE_ISSUANCE, ServicesNav.L2_KYC_UPDATE })
public class KYCUpdatePage extends ServicesAbstractPage {

}