package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.ThreeDECommerceSecurityParameters;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.ThreeDECommerceSecurityParametersPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Component
public class ThreeDECommerceSecurityParametersFlows {
	
	@Autowired
	private Navigator navigator;
	public void add3DEcommerceSecurityParameters(ThreeDECommerceSecurityParameters eCommerceSecurityParameters){
		ThreeDECommerceSecurityParametersPage page = navigator.navigateToPage(ThreeDECommerceSecurityParametersPage.class);
		page.add3DECommerceSecurityParameters(eCommerceSecurityParameters);
	}

}
