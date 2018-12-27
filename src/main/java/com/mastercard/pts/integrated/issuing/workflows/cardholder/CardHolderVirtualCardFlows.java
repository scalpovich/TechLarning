package com.mastercard.pts.integrated.issuing.workflows.cardholder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.mastercard.pts.integrated.issuing.domain.cardholder.CardholderServices;
import com.mastercard.pts.integrated.issuing.pages.cardholder.virtualcard.LimitedValidityVirtualCardCancelPage;
import com.mastercard.pts.integrated.issuing.pages.cardholder.virtualcard.RequestForLimitedValidityVirtualCardPage;
import com.mastercard.pts.integrated.issuing.pages.cardholder.virtualcard.VirtualPrepaidCardRequestPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.workflows.AbstractBaseFlows;

@Component
public class CardHolderVirtualCardFlows extends AbstractBaseFlows{
	
	private static final Logger logger = LoggerFactory.getLogger(CardHolderVirtualCardFlows.class);
	
	@Autowired
	Navigator navigate;
	
	RequestForLimitedValidityVirtualCardPage virtualPrpdCardReqstPage;
	
	LimitedValidityVirtualCardCancelPage cancelVirtualLimitValidityCard;	
			
	public String sbmtReqForVirtualPrepaidCard(CardholderServices cardholderService){
		virtualPrpdCardReqstPage = navigate.navigateToPage(RequestForLimitedValidityVirtualCardPage.class);
		return virtualPrpdCardReqstPage.submitRequestForVirtualCard(cardholderService);
	}
	
	public String requestStaticVirtualPrepaidCard(CardholderServices cardholderService){
		VirtualPrepaidCardRequestPage page = navigate.navigateToPage(VirtualPrepaidCardRequestPage.class);
		return page.submitRequestForVirtualCard(cardholderService);
	}
	
	public void sbmtCancelRequstForLimitedVirtualCard(){
		if(cancelVirtualLimitValidityCard.verifyPermissionCardholder()){
			logger.info("Limited validity virtual device is not requested");
		}
	}
	
	public String verifyVirtualCardRequestStatus(){
		return virtualPrpdCardReqstPage.getVirtualCardRequestResponse();
	}
	
	public String cancelLvvcRequest(){
		LimitedValidityVirtualCardCancelPage page = navigate.navigateToPage(LimitedValidityVirtualCardCancelPage.class);
		return page.cancelLvccRequest();
	}
} 
