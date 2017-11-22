package com.mastercard.pts.integrated.issuing.workflows.cardholder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.mastercard.pts.integrated.issuing.pages.cardholder.virtualcard.VirtualPrepaidCardRequestPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.workflows.AbstractBaseFlows;
import junit.framework.Assert;

@Component
public class CardHolderVirtualCardFlows extends AbstractBaseFlows{

	@Autowired
	Navigator navigate;
	
	@Autowired
	VirtualPrepaidCardRequestPage virtualPrpdCardReqstPage;
	
	public void openVirtualCardPage(){
		VirtualPrepaidCardRequestPage page = navigate.navigateToPage(VirtualPrepaidCardRequestPage.class);
	}
	
	public void sbmtRreqForVirtualPrepardCard(){
		virtualPrpdCardReqstPage.submitRequestforVirtualCrd();
	}
	
	public void verifyVirtualCardRequestStatus(){
		Assert.assertEquals("Static virtual device is not created ", virtualPrpdCardReqstPage.getVirtualCardRequesResponse().contains("Static Virtual device created successfully"));
	}
} 
