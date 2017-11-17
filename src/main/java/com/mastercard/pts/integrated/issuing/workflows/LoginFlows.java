package com.mastercard.pts.integrated.issuing.workflows;

import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.configuration.Portal;

@Component
public class LoginFlows extends AbstractBaseFlows {

	public void loginAsAgentUser() {
		loginAgentPage.loginAsUser();
	}

	public void loginAsAgentAdminUser() {
		loginAgentPage.loginAsAdmin();
	}

	public void loginAsAgentUser(String uName, String pwd) {
		loginAgentPage.login(uName, pwd);
	}

	public void loginAsCorporateUser(String uName, String pwd) {
		loginPage.loginTo(uName, pwd);
	}
	
	public boolean loginAsCardholderUser(String userName,String passWord){
		return loginPage.loginToCardholder(userName, passWord);
	}
	
	public void loginAsCardholderUserAfterSignUp(String userName,String passWord){
		loginPage.loginToCardholderAfterSignUp(userName, passWord);
	}
	
	public void signUpCardHolderUser(String loginPass,String trnPass,String firstSequrityQst,String firstSequerAnswer,String secondSequrityQst,String secondSequerAnswer){
		loginPage.singUpCardHolderUser(loginPass,trnPass,firstSequrityQst,firstSequerAnswer,secondSequrityQst,secondSequerAnswer);	
		acceptSuccessfullCardholderSignUp();
	}
	
	public void acceptSuccessfullCardholderSignUp(){
		getFinder().getWebDriver().switchTo().alert().accept();
	}
	
	public void openCardHolderApplication(){
		loginPage.loadAppURL();
	}
	public void Login(Portal portal, String userType) {
		getFinder().getWebDriver().get(portal.getUrl());
/*		if (userType.equalsIgnoreCase("CustomerUser")) {
			loginPage.login(Portal.getTypeCustomer(),
					portal.getCustomerUserName(),
					portal.getCustomerUserPassword());
			institutionSelectionPage.selectInstitution();
		} else if (userType.equalsIgnoreCase("CustomerAdmin")) {
			loginPage.login(Portal.getTypeCustomer(),
					portal.getCustomerAdminUser(),
					portal.getCustomerAdminPassword());
			institutionSelectionPage.selectAdminInstitution();
		} 		
		else if ("BankAdmin".equalsIgnoreCase(userType)) {
			loginPage.login(Portal.getTypeCustomer(),
					portal.getCustomerAdminUser(),
					portal.getCustomerAdminPassword());
			institutionSelectionPage.selectBankAdminInstitution();
		}else if (userType.equalsIgnoreCase("AgencyUser"))
			loginPage.login(Portal.getTypeAgent(), portal.getAgencyUserName(),
					portal.getAgencyUserPassword());
		else if (userType.equalsIgnoreCase("AgentUser"))
			loginPage.login(Portal.getTypeAgent(), portal.getAgentUserName(),
					portal.getAgentUserPassword());*/
	}
	public void LoginWithNewUser(Portal portal){
		getFinder().getWebDriver().navigate().to(portal.getUrl());				
			/*loginPage.login(Portal.getTypeCustomer(),
					portal.userDataProvider().getUser(),
					portal.getCustomerUserPassword());*/
			institutionSelectionPage.selectInstitution();
		
	}

}
