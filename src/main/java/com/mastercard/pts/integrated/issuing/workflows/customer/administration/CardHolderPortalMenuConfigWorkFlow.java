package com.mastercard.pts.integrated.issuing.workflows.customer.administration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.mastercard.pts.integrated.issuing.pages.customer.administration.AdministrationCardHolderPortalPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;


@Component
public class CardHolderPortalMenuConfigWorkFlow {
	
	@Autowired
	AdministrationCardHolderPortalPage adminConfigPortal;
	
	@Autowired
	Navigator navigator;
	
	public void navigateToCardHolderPortalPage(){
		navigator.navigateToPage(AdministrationCardHolderPortalPage.class);
		
	}
	
	public void addMenuOptionsToaccess(String deviceType,String programCode){
		adminConfigPortal.addMenusToAccessForCardHolderPortal(deviceType,programCode);
	}
	
	
	
}
