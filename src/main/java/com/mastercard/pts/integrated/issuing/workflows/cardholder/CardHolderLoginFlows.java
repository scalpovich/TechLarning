package com.mastercard.pts.integrated.issuing.workflows.cardholder;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.mastercard.pts.integrated.issuing.workflows.AbstractBaseFlows;
import com.mastercard.pts.integrated.issuing.pages.cardholder.CardHolderLoginPage;


@Component
public class CardHolderLoginFlows extends AbstractBaseFlows{

	@Autowired
	CardHolderLoginPage cardHolderPage;
	
	public void updateCardHolderLoginPassword(String oldPassWord, String newPassWord){
		cardHolderPage.openChangePassword();
		cardHolderPage.enterCurrentPassword(oldPassWord);
		cardHolderPage.enterNewPass(newPassWord);		
		cardHolderPage.confirmNewPass(newPassWord);
		cardHolderPage.submitPassWordUpdateRequest();
		
	}
	
	public void udpateCardHolderTransPassword(String oldTransactionPass, String newTransactionPass){
		cardHolderPage.openChangePassword();
		cardHolderPage.enterOldTxnPassword(oldTransactionPass);
		cardHolderPage.enterNewTxnPassword(newTransactionPass);
		cardHolderPage.enterConfirmTxnPasswordInpt(newTransactionPass);
		cardHolderPage.submitPassWordUpdateRequest();		
	}
	
	
	public void updateCardHolderSequrityQuestionS(String question1, String ans1,String question2,String ans2){
		cardHolderPage.selectFirstSequrityQstOpt(question1);
		cardHolderPage.enterFirstSequrityQstAnswer(ans1);		
		cardHolderPage.selectSecondSequrityQstOpt(question2);
		cardHolderPage.enterSecondSequrityQstAnswer(ans1);	
		cardHolderPage.updateSequrityQuestionReq();
	}

	public void updateCardHolderUserUserID(String newUserID){
		cardHolderPage.openCreateAlise();
		cardHolderPage.enterNewUserID(newUserID);
		cardHolderPage.submitAliseUpdateRequest();
	}
	
	public void recoverForgtCardHolderPass(String cardHolderUserID){
		cardHolderPage.clickForgotPasswordLnk();
		cardHolderPage.enterUserID(cardHolderUserID);
		cardHolderPage.submitRcoverPasswordReq();
		Assert.assertTrue("Wrong sequrity question is displayed", checkSequrityQuestions("question1","question2"));
		cardHolderPage.submitRcoverPasswordReq();
	}
	
	public boolean checkSequrityQuestions(String question1,String question2){
		
		 if(cardHolderPage.checkFirstSequrityQst(question1)){
			 cardHolderPage.checkSecondSequrityQst(question2);
			 return true;
		 }else{
			 return false;
		 }
	}
	
	public void unblockCardHolderAccount(String cardHolderUserId){
		cardHolderPage.clickUnblockCardHolderLink();
		cardHolderPage.enterUserID(cardHolderUserId);
		cardHolderPage.submitRcoverPasswordReq();
	}
	
	
}
