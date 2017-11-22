package com.mastercard.pts.integrated.issuing.steps.cardholder;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.mastercard.pts.integrated.issuing.steps.AbstractBaseSteps;
import com.mastercard.pts.integrated.issuing.workflows.cardholder.CardHolderVirtualCardFlows;

@Component
public class CardHolderVirtualCardSteps extends AbstractBaseSteps{
	
	@Autowired
	CardHolderVirtualCardFlows chpVirtualCardFlow;
	
	@When ("create virtual prepaid card request")
	public void createVirtualPrepaidCardReq(){
		chpVirtualCardFlow.openVirtualCardPage();
	}
	
	@Then ("verify virtual prepaid card request status")
	public void verifyVirtualCardRequestStatus(){
		chpVirtualCardFlow.verifyVirtualCardRequestStatus();
	}
	
	@When ("request limited validity virtual card")
	public void requestLimitedValidityVirtualCard(){
		
	}
	
	@Then ("verify request status for limited validity virtual card")
	public void vrfRqstStatusForLimitValidityVirtualCrd(){
		
	}
}
