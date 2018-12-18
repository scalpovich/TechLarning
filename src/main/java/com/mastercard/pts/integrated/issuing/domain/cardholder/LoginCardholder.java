package com.mastercard.pts.integrated.issuing.domain.cardholder;

import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;

public class LoginCardholder {
	
	public static String CHP_USERNAME = "CHP_USERNAME";
	public static String CHP_PASSWORD = "CHP_PASSWORD";
	public static String CHP_NEW_PASSWORD = "CHP_NEW_PASSWORD";
	public static String CHP_TRANSACTION_PASSWORD = "CHP_TRANSACTION_PASSWORD";
	public static String FIRST_QUESTION = "FIRST_QUESTION";
	public static String FIRST_ANSWER = "FIRST_ANSWER";
	public static String SECOND_QUESTION = "SECOND_QUESTION";
	public static String SECOND_ANSWER = "SECOND_ANSWER";	
	
	String userName;
	String passWord;
	String newPassword;
	String cardHolderTransPassword;	
	String FirstSecurityQst;
	String FirstSecurityAnsw;
	String SecondSecurityQst;
	String SecondSequrityAnsw;	
	
	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getCardHolderTransPassword() {
		return cardHolderTransPassword;
	}

	public void setCardHolderTransPassword(String cardHolderTransPassword) {
		this.cardHolderTransPassword = cardHolderTransPassword;
	}

	public String getFirstSecurityQst() {
		return FirstSecurityQst;
	}

	public void setFirstSecurityQst(String firstSequrityQst) {
		FirstSecurityQst = firstSequrityQst;
	}

	public String getFirstSecurityAnsw() {
		return FirstSecurityAnsw;
	}

	public void setFirstSecurityAnsw(String firstSequrityAnsw) {
		FirstSecurityAnsw = firstSequrityAnsw;
	}

	public String getSecondSecurityQst() {
		return SecondSecurityQst;
	}

	public void setSecondSecurityQst(String secondSequrityQst) {
		SecondSecurityQst = secondSequrityQst;
	}

	public String getSecondSecurityAnsw() {
		return SecondSequrityAnsw;
	}

	public void setSecondSequrityAnsw(String secondSequrityAnsw) {
		SecondSequrityAnsw = secondSequrityAnsw;
	}

	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
	public static LoginCardholder loginCardholderDataProvider(){
		LoginCardholder loginCardHolder = new LoginCardholder();
		loginCardHolder.setPassWord(MapUtils.fnGetInputDataFromMap("Password"));
		loginCardHolder.setUserName(MapUtils.fnGetInputDataFromMap("UserId"));
		loginCardHolder.setNewPassword(MapUtils.fnGetInputDataFromMap("newPassword"));
		loginCardHolder.setCardHolderTransPassword(MapUtils.fnGetInputDataFromMap("CardHolderTransPassword"));
		loginCardHolder.setFirstSecurityQst(MapUtils.fnGetInputDataFromMap("FirstSequrityQuestion"));
		loginCardHolder.setFirstSecurityAnsw(MapUtils.fnGetInputDataFromMap("FirstSequrityAnswer"));
		loginCardHolder.setSecondSecurityQst(MapUtils.fnGetInputDataFromMap("SecondSequrityQuestion"));
		loginCardHolder.setSecondSequrityAnsw(MapUtils.fnGetInputDataFromMap("SecondSequrityAnswer"));		
		return loginCardHolder;
	}
	
	public static LoginCardholder loginCardholderProvider(KeyValueProvider provider){
		LoginCardholder loginCardHolder = new LoginCardholder();
		loginCardHolder.setPassWord(provider.getString(CHP_PASSWORD));
		loginCardHolder.setUserName(provider.getString(CHP_USERNAME));
		loginCardHolder.setNewPassword(provider.getString(CHP_NEW_PASSWORD));
		loginCardHolder.setCardHolderTransPassword(provider.getString(CHP_TRANSACTION_PASSWORD));
		loginCardHolder.setFirstSecurityQst(provider.getString(FIRST_QUESTION));
		loginCardHolder.setFirstSecurityAnsw(provider.getString(FIRST_ANSWER));
		loginCardHolder.setSecondSecurityQst(provider.getString(SECOND_QUESTION));
		loginCardHolder.setSecondSequrityAnsw(provider.getString(SECOND_ANSWER));		
		return loginCardHolder;
	}
}
