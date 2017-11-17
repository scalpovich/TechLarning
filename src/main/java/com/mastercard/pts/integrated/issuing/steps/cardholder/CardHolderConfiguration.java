package com.mastercard.pts.integrated.issuing.steps.cardholder;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.workflows.AbstractBaseFlows;
import com.mastercard.pts.integrated.issuing.workflows.cardholder.CardHolderLoginFlows;

@Component
public class CardHolderConfiguration extends AbstractBaseFlows{
	
	@Autowired
	CardHolderLoginFlows cardHolderLoginFlow;
	
	@Then ("update cardholder $passwordOpt password")
	public void updateCardHolderPassword(@Named("passwordOpt")String passwordOpt){
		if(passwordOpt.contains("login")){
			cardHolderLoginFlow.updateCardHolderLoginPassword(passwordOpt,"newPassword");
			
		}else if(passwordOpt.contains("transaction")){
			cardHolderLoginFlow.udpateCardHolderTransPassword(passwordOpt,"newTxnPassword");
		}
	}
	
	@Then ("update cardholder user sequrity questions")
	public void updateCardHolderPortalSequrityQuestion(){
		cardHolderLoginFlow.updateCardHolderSequrityQuestionS("", "", "question2", "ans2");
	}
	
	@Then ("update cardholder user's userID with $newUserId")
	public void updateCardholderUserID(@Named("newUserId")String newUserId){
		cardHolderLoginFlow.updateCardHolderUserUserID(newUserId);
		
	}
	
	@Then ("recover forgotes password for user with &userId")
	public void recoverForgotPass(@Named("userId")String userId){
		cardHolderLoginFlow.recoverForgtCardHolderPass(userId);
	}

	
	@Then ("unblock cardholder account and userID is $userId")
	public void unblockCardHolderAccount(@Named("userId")String userId){
		cardHolderLoginFlow.unblockCardHolderAccount(userId);
	}
}
