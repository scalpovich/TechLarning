package com.mastercard.pts.integrated.issuing.workflows.cardholder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.cardholder.virtualcard.VirtualCardLimitedValidityVirtualCardCancellationPage;
import com.mastercard.pts.integrated.issuing.pages.cardholder.virtualcard.VirtualPrepaidCardRequestPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.workflows.AbstractBaseFlows;
import junit.framework.Assert;

@Component
public class CardHolderVirtualCardFlows extends AbstractBaseFlows{
	
	private static final Logger logger = LoggerFactory.getLogger(CardHolderVirtualCardFlows.class);
	
	@Autowired
	Navigator navigate;
	
	@Autowired
	VirtualPrepaidCardRequestPage virtualPrpdCardReqstPage;
	
	@Autowired
	VirtualCardLimitedValidityVirtualCardCancellationPage cancelVirtualLimitValidityCard;
	
	public void openVirtualCardPage(){
		VirtualPrepaidCardRequestPage page = navigate.navigateToPage(VirtualPrepaidCardRequestPage.class);
	}
	
	public void openCancellationCardRequstPage(){
		VirtualCardLimitedValidityVirtualCardCancellationPage page = navigate.navigateToPage(VirtualCardLimitedValidityVirtualCardCancellationPage.class);
	}
	
	
	public void sbmtRreqForVirtualPrepardCard(){
		if(virtualPrpdCardReqstPage.verifyPermissionCardholder()){
			
			logger.info("Limited validity virtual device is not permitted");
			
		}else{
			
			virtualPrpdCardReqstPage.submitRequestforVirtualCrd();
		}
	}
	
	public void sbmtCancelRequstForLimitedVirtualCard(){
		if(cancelVirtualLimitValidityCard.verifyPermissionCardholder()){
			logger.info("Limited validity virtual device is not requested");
		}else{
			
		}
		
	}
	
	public void verifyVirtualCardRequestStatus(){
		Assert.assertEquals("Static virtual device is not created ", virtualPrpdCardReqstPage.getVirtualCardRequesResponse().contains("Static Virtual device created successfully"));
	}
} 
