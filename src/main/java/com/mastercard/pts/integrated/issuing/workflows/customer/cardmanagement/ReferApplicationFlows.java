package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.ReferPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Component
public class ReferApplicationFlows {
	@Autowired
	Navigator navigator;
	
	public String referCreditApplication()
	{
		ReferPage referPage = navigator.navigateToPage(ReferPage.class);
		referPage.referApplication();
		String message=referPage.editAndVerifyApplication();
		return message;
	}
}
