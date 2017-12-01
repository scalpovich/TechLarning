/**
 * @author e076168
 */
package com.mastercard.pts.integrated.issuing.domain.cardholder;

import com.mastercard.pts.integrated.issuing.utils.MapUtils;

public class LoginCardholder {
	
	String userName;
	String passWord;
	String newPassword;
	String cardHolderTransPassword;	
	String FirstSequrityQst;
	String FirstSequrityAnsw;
	String SecondSequrityQst;
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

	public String getFirstSequrityQst() {
		return FirstSequrityQst;
	}

	public void setFirstSequrityQst(String firstSequrityQst) {
		FirstSequrityQst = firstSequrityQst;
	}

	public String getFirstSequrityAnsw() {
		return FirstSequrityAnsw;
	}

	public void setFirstSequrityAnsw(String firstSequrityAnsw) {
		FirstSequrityAnsw = firstSequrityAnsw;
	}

	public String getSecondSequrityQst() {
		return SecondSequrityQst;
	}

	public void setSecondSequrityQst(String secondSequrityQst) {
		SecondSequrityQst = secondSequrityQst;
	}

	public String getSecondSequrityAnsw() {
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
		loginCardHolder.setFirstSequrityQst(MapUtils.fnGetInputDataFromMap("FirstSequrityQuestion"));
		loginCardHolder.setFirstSequrityAnsw(MapUtils.fnGetInputDataFromMap("FirstSequrityAnswer"));
		loginCardHolder.setSecondSequrityQst(MapUtils.fnGetInputDataFromMap("SecondSequrityQuestion"));
		loginCardHolder.setSecondSequrityAnsw(MapUtils.fnGetInputDataFromMap("SecondSequrityAnswer"));
		
		return loginCardHolder;
	}
	

}
