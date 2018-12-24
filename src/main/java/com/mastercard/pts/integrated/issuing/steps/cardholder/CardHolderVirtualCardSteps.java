package com.mastercard.pts.integrated.issuing.steps.cardholder;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.mastercard.pts.integrated.issuing.domain.cardholder.CardholderServices;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.steps.AbstractBaseSteps;
import com.mastercard.pts.integrated.issuing.workflows.cardholder.CardHolderVirtualCardFlows;

@Component
public class CardHolderVirtualCardSteps extends AbstractBaseSteps{
	
	@Autowired
	CardHolderVirtualCardFlows chpVirtualCardFlow;
	
	@Autowired
	KeyValueProvider provider;
	@When ("create virtual prepaid card request")
	@Then ("create virtual prepaid card request")
	public void createVirtualPrepaidCardReq(){
		CardholderServices cardholderService = CardholderServices.cardholderServicesDataProvider();
		Assert.assertTrue("Virtual device creation failed",chpVirtualCardFlow.sbmtRreqForVirtualPrepardCard(cardholderService).contains("Successfully"));
	}
	
	@When ("request limited validity virtual card")
	@Then ("request limited validity virtual card")
	public void requestLimitedValidityVirtualCard(){
		CardholderServices cardholderService = CardholderServices.cardholderServicesDataProvider();		
		Assert.assertTrue("Virtual device creation failed",chpVirtualCardFlow.sbmtRreqForVirtualPrepardCard(cardholderService).contains("Successfully"));
	}
	
	@Then ("service request to create $cardType")
	public void ServiceRequestLimitedValidityVirtualCard(String cardType){
		CardholderServices cardholderService = CardholderServices.cardholderServicesDataProvider(provider);
		cardholderService.setVirtualCardType(cardType);
		Assert.assertTrue("Virtual device creation failed", chpVirtualCardFlow.sbmtRreqForVirtualPrepardCard(cardholderService).toLowerCase().contains("successfully"));
	}
	
	@When ("cancel limited validity virtual card request")
	@Then ("cancel limited validity virtual card request")
	public void cancelReqstLimitedValidityVirtCard(){
		chpVirtualCardFlow.cancelLvvcRequest();	
		Assert.assertTrue("Limited validity virtual device cancel request failed", chpVirtualCardFlow.cancelLvvcRequest().toLowerCase().contains("successfully"));
	}
	
	@Then ("verify virtual prepaid card request status")
	public void verifyVirtualCardRequestStatus(){ 
		Assert.assertTrue("Virtual device creation failed", chpVirtualCardFlow.verifyVirtualCardRequestStatus().contains("Successfully"));
	}
	
	@Then ("service request for static virtual Card")
	public void serviceRequestForStaticVirtualCard(){
		CardholderServices cardholderService = CardholderServices.cardholderServicesDataProvider(provider);
		Assert.assertTrue("Virtual device creation failed", chpVirtualCardFlow.requestStaticVirtualPrepaidCard(cardholderService).toLowerCase().contains("successfully"));
	}	
}
