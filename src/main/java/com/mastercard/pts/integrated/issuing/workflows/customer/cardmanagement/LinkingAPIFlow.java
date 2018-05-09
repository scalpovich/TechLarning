package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.LinkingAPIToInstitution;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.LinkingAPIToInstitutionPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;


@Component
public class LinkingAPIFlow{
 
	@Autowired
	Navigator navigator;

	 
	public void addLinkingAPIDetails(LinkingAPIToInstitution linkinAPIToInstitution) {
		LinkingAPIToInstitutionPage page = navigator.navigateToPage(LinkingAPIToInstitutionPage.class);
		page.addLinkingDetails(linkinAPIToInstitution);
		
	}

}