package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.ReferPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

/**
 * @author e084017
 *
 */
@Component
public class ReferCreditApplicationFlows {
	@Autowired
	Navigator navigator;

	public String referCreditApplication() {
		ReferPage referPage = navigator.navigateToPage(ReferPage.class);
		return referPage.editAndReferApplication();
	}

	public void referCreditApplicationFileUpload() {
		ReferPage referCreditPage = navigator.navigateToPage(ReferPage.class);
		referCreditPage.referApplicationFileUpload();
	}

}
