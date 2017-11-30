/**
 * @author: e076168
 */
package com.mastercard.pts.integrated.issuing.pages.cardholder;

import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;


@Component
public class CardHolderLoginPage extends AbstractBasePage{

	
	@PageElement(findBy = FindBy.ID,valueToFind="useralias")
	private MCWebElement userIdInput;
	
	@PageElement(findBy = FindBy.ID,valueToFind="password")
	private MCWebElement passWordInput;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind="//a[contains(text(),'Forgot Password')]")
	private MCWebElement forgotPasswordLnk;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind="//a[contains(text(),'Unlock User')]")
	private MCWebElement unblockCardholderAccLnk;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind="//input[@id='useralias']")
	private MCWebElement forgotUserIDInput;
	
	@PageElement(findBy = FindBy.NAME, valueToFind="auth.common.button.label.submit")
	private MCWebElement forgotPassSubmitBtn;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind="//input[@id='securityAnswer1']")
	private MCWebElement forgotPassSequrityQst1Inpt;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind="//form[@class='loginform']/div/fieldset[1]/span")
	private MCWebElement forgotPassSequrityQst1Labl;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind="//input[@id='securityAnswer2']")
	private MCWebElement forgotPassSequrityQst2Inpt;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind="//form[@class='loginform']/div/fieldset[2]/span")
	private MCWebElement forgotPassSequrityQst2Labl;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind="//form[@class='loginform']/div/fieldset[1]/span")
	private MCWebElement unblockPassSequrityQst1Labl;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind="//input[@id='securityAnswer1']")
	private MCWebElement unblockSequrityQst1Inpt;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind="//form[@class='loginform']/div/fieldset[4]/span")
	private MCWebElement unblockPassSequrityQst2Labl;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind="//input[@id='securityAnswer2']")
	private MCWebElement unblockSequrityQst2Inpt;
	
	
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind="//a[contains(text(),'Unlock User')]")
	private MCWebElement unlockUserLnk;
	
	@PageElement(findBy = FindBy.ID,valueToFind="auth_common_button_label_login")
	private MCWebElement loginBtn;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind="//div[@class='credentials']/span/a")
	private MCWebElement changePassWordLnk;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind="//div[@class='credentials']/span/span/a")
	private MCWebElement createAliseLnk;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind="//div[@class='credentials']/span/span[2]/a")
	private MCWebElement changeSequrityQuestionsLnk;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind="//input[@name='passwordFlag'][1]")
	private MCWebElement loginPasswordRdo;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind="//input[@name='passwordFlag'][2]")
	private MCWebElement TransactionPasswordRdo;
	
	@PageElement(findBy = FindBy.ID, valueToFind="oldLoginPassword")
	private MCWebElement currenetPasswordInpt;
	
	@PageElement(findBy = FindBy.ID, valueToFind="newLoginPassword")
	private MCWebElement newPasswordInpt;
	
	@PageElement(findBy = FindBy.ID, valueToFind="oldTxnPassword")
	private MCWebElement oldTxnPasswordInpt;
	
	@PageElement(findBy = FindBy.ID, valueToFind="newTxnPassword")
	private MCWebElement newTxnPasswordInpt;
	
	@PageElement(findBy = FindBy.ID, valueToFind="confirmTxnPassword")
	private MCWebElement confirmTxnPasswordInpt;
	
	@PageElement(findBy = FindBy.ID, valueToFind="confirmLoginPassword")
	private MCWebElement confirmPasswordInpt;
	
	@PageElement(findBy = FindBy.ID, valueToFind="mpts_cardHolderPortal_button_submit")
	private MCWebElement passwordUpdateBtn;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind="//form[@name='CreateAlias']/table/tbody/tr[2]/td[2]")	
	private MCWebElement oldUserID;
	
	@PageElement(findBy = FindBy.ID, valueToFind="newUserID")
	private MCWebElement newUserIDInpt;
	
	@PageElement(findBy = FindBy.ID, valueToFind="mpts_cardHolderPortal_button_submit")
	private MCWebElement confirmAliseUpdateBtn;
	
	@PageElement(findBy = FindBy.ID, valueToFind="question")
	private MCWebElement firstSequrityQestionOpt;
	
	@PageElement(findBy = FindBy.ID, valueToFind="txtAnswer")
	private MCWebElement firstSequrityAnsrInpt;
	
	@PageElement(findBy = FindBy.ID, valueToFind="question2")
	private MCWebElement secondSequrityQestionOpt;
	
	@PageElement(findBy = FindBy.ID, valueToFind="txtAnswer2")
	private MCWebElement secondSequrityAnsrInpt;
	
	@PageElement(findBy = FindBy.ID, valueToFind="mpts_cardHolderPortal_button_submit")
	private MCWebElement udpateSequrityQstBtn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind="mpts.cardHolderPortal.button.reset")
	private MCWebElement updateSequrityRestBtn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind="mpts.cardHolderPortal.button.cancel")
	private MCWebElement cancelSequrityQstUpdateBtn;
	
	@PageElement(findBy= FindBy.X_PATH, valueToFind="//div[@class='repeat']/div/span/br[2]")
	private MCWebElement txnPasswordUpdateConfirmMsg;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind="//div[@class='repeat']/div/span/br[2]")
	private MCWebElement loginPasswordUpdateConfimMsg;
	
	public String getLoginUpdateConfirmMsg(){
		return getTextFromPage(txnPasswordUpdateConfirmMsg);
	}
	
	public String getTxnUpdateConfirmMsg(){
		return getTextFromPage(loginPasswordUpdateConfimMsg);
	}
	
	
	public void selectFirstSequrityQstOpt(String firstSeqQst){
		selectByVisibleText(firstSequrityQestionOpt, firstSeqQst);
	}
	
	public void enterFirstSequrityQstAnswer(String firstSequAns){
		enterText(firstSequrityAnsrInpt, firstSequAns);
	}
	
	public void selectSecondSequrityQstOpt(String secondSeqQst){
		selectByVisibleText(secondSequrityQestionOpt, secondSeqQst);
	}
	
	public void enterSecondSequrityQstAnswer(String firstSequAns){
		enterText(secondSequrityAnsrInpt, firstSequAns);
	}
	
	public void updateSequrityQuestionReq(){
		clickWhenClickable(udpateSequrityQstBtn);
	}
	
	public String getOldUSerID(){
		return getTextFromPage(oldUserID);
	}
	
	public void enterNewUserID(String newUserID){
		enterText(newUserIDInpt, newUserID);
	}	
	
	public void submitAliseUpdateRequest(){
		clickWhenClickable(confirmAliseUpdateBtn);
	}
	
	public void openChangePassword(){
		clickWhenClickable(changePassWordLnk);
	}
	
	public void openCreateAlise(){
		clickWhenClickable(createAliseLnk);
	}
	
	public void openChangeSequrityQuestion(){
		clickWhenClickable(changeSequrityQuestionsLnk);
	}
	
	public void enterCurrentPassword(String currentPass){
		enterText(currenetPasswordInpt, currentPass);
	}

	public void enterNewPass(String newPass){
		enterText(newPasswordInpt, newPass);
	}
	
	public void confirmNewPass(String confirmNewPass){
		enterText(confirmPasswordInpt, confirmNewPass);
	}
	
	public void submitPassWordUpdateRequest(){
		clickWhenClickable(passwordUpdateBtn);
	}
	public void selectTransactionPaswrdOptionRdo(){
		clickWhenClickable(TransactionPasswordRdo);
	}
	
	public void enterOldTxnPassword(String oldTxnPass){
		enterText(oldTxnPasswordInpt,oldTxnPass);
	}
	
	public void enterNewTxnPassword(String newTxnPassword){
	
		enterText(newTxnPasswordInpt,newTxnPassword);
	}
	
	public void enterConfirmTxnPasswordInpt(String confirmTxnPassword){
		enterText(confirmTxnPasswordInpt,confirmTxnPassword);
	}
	
	public void clickForgotPasswordLnk(){
		clickWhenClickable(forgotPasswordLnk);
	}
	
	public void enterUserID(String cardHolderUserID){
		enterText(forgotUserIDInput, cardHolderUserID);
	}
	
	public void submitRcoverPasswordReq(){
		clickWhenClickable(forgotPassSubmitBtn);
	}
	
	public void enterAnserForSequrityQst1(String questionAnswer){
		enterText(forgotPassSequrityQst1Inpt, questionAnswer);
	}
	
	public boolean checkFirstSequrityQst(String secondQuestion){
		if(getTextFromPage(forgotPassSequrityQst2Labl).contains(secondQuestion))
			return true;
		else
			return false;
	}
	
	public boolean checkSecondSequrityQst(String firstQuestion){
		
		if(getTextFromPage(forgotPassSequrityQst1Labl).contains(firstQuestion))
			return true;
		else
			return false;
	}
	
	public void enterAnserForSequrityQst2(String questionAnswer){
		enterText(forgotPassSequrityQst2Inpt, questionAnswer);
	}
	
	public void clickUnblockCardHolderLink(){
		clickWhenClickable(unblockCardholderAccLnk);
	}
	
	public String getUnblockFristSequrityQuestion(){
		return getTextFromPage(unblockPassSequrityQst1Labl);
	}
	
	public String getUnblockSecondSequrityQuestion(){
		return getTextFromPage(unblockPassSequrityQst2Labl);
	}
}


