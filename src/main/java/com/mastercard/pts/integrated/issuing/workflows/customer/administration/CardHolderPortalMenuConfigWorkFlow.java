package com.mastercard.pts.integrated.issuing.workflows.customer.administration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.mastercard.pts.integrated.issuing.pages.customer.administration.AdministrationCardHolderPortalPage;


@Component
public class CardHolderPortalMenuConfigWorkFlow {
	
	@Autowired
	AdministrationCardHolderPortalPage adminConfigPortal;
	
	
	public void addMenuOptionsToaccess(String deviceType,String programCode){
		adminConfigPortal.addMenusToAccessForCardHolderPortal(deviceType,programCode);
	}
	
	
	
}
