package com.mastercard.pts.integrated.issuing.workflows.customer.administration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.customer.administration.AdministrationCardHolderPortalPage;
import com.mastercard.pts.integrated.issuing.workflows.AbstractBaseFlows;

@Component
public class CardHolderPortalMenuConfigWorkFlow {
	
	@Autowired
	AdministrationCardHolderPortalPage adminConfigPortal;
	
	public void navigateToCardHolderPortalPage(){
		adminConfigPortal.navigateToCardHolderConfigPage();
		
	}
	
	public void addMenuOptionsToaccess(String deviceType,String programCode){
		adminConfigPortal.addMenusToAccessForCardHolderPortal(deviceType,programCode);
	}
	
	
	
}
