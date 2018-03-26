package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.VerifyCreditPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Component
public class VerifyCreditApplicationFlows {
	@Autowired
	Navigator navigator;
	
	public String verifyCreditApplication()
	{
		VerifyCreditPage verifyCreditPage = navigator.navigateToPage(VerifyCreditPage.class);
		verifyCreditPage.verifyapplication();
		String message=verifyCreditPage.editAndVerifyApplication();
		return message;
	}
	
	public /*String*/void verifyCreditApplicationFileUpload()
	{
		VerifyCreditPage verifyCreditPage = navigator.navigateToPage(VerifyCreditPage.class);
		verifyCreditPage.verifyApplicationFileUpload();
		/*String message=verifyCreditPage.editAndVerifyApplication();
		return message;*/
	}
}
