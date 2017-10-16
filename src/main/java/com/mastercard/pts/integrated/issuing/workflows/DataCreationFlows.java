package com.mastercard.pts.integrated.issuing.workflows;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.customer.administration.InstitutionCreationPage;
import com.mastercard.pts.integrated.issuing.pages.customer.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.pages.customer.navigation.PageObjectFactory;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;

@Component
public class DataCreationFlows extends MenuFlows {
	@Autowired
	private PageObjectFactory pageFactory;

	@Autowired
	private Navigator navigator;
	InstitutionCreationPage page;

	/**
	 * Creates the institution.
	 */
	public void createInstitution() {
		institutionCreationPage.createInstitute(getNewInstituteName(), getNewInstituteCode());

	}

	/**
	 * Gets the new institute name.
	 *
	 * @return the new institute name
	 */
	private String getNewInstituteName() {
		return CustomUtils.randomNumbers(6);
	}

	/**
	 * Gets the new institute code.
	 *
	 * @return the new institute code
	 */
	private String getNewInstituteCode() {

		return "AuTo" + CustomUtils.randomString(2);

	}

	/**
	 * Define user privileges.
	 */
	public void defineUserPrivileges() {
		page.setUserPrivileges();
	}

}
