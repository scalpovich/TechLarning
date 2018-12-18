package com.mastercard.pts.integrated.issuing.workflows;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.configuration.Portal;
import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.cardholder.LoginCardholder;

@Component
public class LoginFlows extends AbstractBaseFlows {

	@Autowired
	private TestContext context;

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

	public boolean loginAsCardholderUser(String userName, String passWord) {
		return loginPage.loginToCardholder(userName, passWord);
	}

	public void loginAsCardholderUserAfterSignUp(String userName,String passWord) {
		loginPage.loginToCardholderAfterSignUp(userName, passWord);
	}

	public void signUpCardHolderUser(LoginCardholder loginCardHolderProvider) {
		Device device = context.get(ContextConstants.DEVICE);
		device.setTransactionPassword(loginCardHolderProvider.getCardHolderTransPassword());
		loginAsCardholderUserAfterSignUp(device.getClientCode(), device.getClientCode());
		loginPage.signUpCardHolderUser(loginCardHolderProvider);		
		loginAsCardholderUserAfterSignUp(device.getClientCode(),loginCardHolderProvider.getPassWord());
		device.setNewTransPassword(loginCardHolderProvider.getPassWord());
	}

	public void signUpCardHolderPortal(Device device) {
		loginPage.createTransPassword(device);
	}

	public void openCardHolderApplication() {
		loginPage.loadAppURL();
	}

	public void Login(Portal portal, String userType) {
		getFinder().getWebDriver().get(portal.getUrl());
		/*
		 * if (userType.equalsIgnoreCase("CustomerUser")) {
		 * loginPage.login(Portal.getTypeCustomer(),
		 * portal.getCustomerUserName(), portal.getCustomerUserPassword());
		 * institutionSelectionPage.selectInstitution(); } else if
		 * (userType.equalsIgnoreCase("CustomerAdmin")) {
		 * loginPage.login(Portal.getTypeCustomer(),
		 * portal.getCustomerAdminUser(), portal.getCustomerAdminPassword());
		 * institutionSelectionPage.selectAdminInstitution(); } else if
		 * ("BankAdmin".equalsIgnoreCase(userType)) {
		 * loginPage.login(Portal.getTypeCustomer(),
		 * portal.getCustomerAdminUser(), portal.getCustomerAdminPassword());
		 * institutionSelectionPage.selectBankAdminInstitution(); }else if
		 * (userType.equalsIgnoreCase("AgencyUser"))
		 * loginPage.login(Portal.getTypeAgent(), portal.getAgencyUserName(),
		 * portal.getAgencyUserPassword()); else if
		 * (userType.equalsIgnoreCase("AgentUser"))
		 * loginPage.login(Portal.getTypeAgent(), portal.getAgentUserName(),
		 * portal.getAgentUserPassword());
		 */
	}

	public void LoginWithNewUser(Portal portal) {
		getFinder().getWebDriver().navigate().to(portal.getUrl());
		institutionSelectionPage.selectInstitution();
	}

	public void selectNewInstitutionFlows(String institute) {
		selectInstitute(institute);
	}
	
	public void selectDeviceForOperation(Device device){
		loginPage.selectWalletForDevice(device);
	}
}
