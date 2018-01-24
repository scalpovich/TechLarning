package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.admin.InstitutionCreation;
import com.mastercard.pts.integrated.issuing.domain.customer.admin.UserCreation;
import com.mastercard.pts.integrated.issuing.pages.customer.administration.UserPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Component
public class UserCreationFlows {

	@Autowired
	public Navigator navigator;

	UserPage userPage;

	public void createUser(UserCreation user) {
		userPage = navigator.navigateToPage(UserPage.class);
		userPage.addNewuser();
		userPage.provideUserDetails(user);
		userPage.mapInstituteToUser(user);
		userPage.save();
	}

	public void userCreationSuccess(UserCreation user) {
		userPage.verifyNewUserCreationSuccess(user);
	}

}
