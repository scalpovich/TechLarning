package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.IncompleteApplicationPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

/**
 * @author e084017
 *
 */
@Component
public class IncompleteApplicationFlows {
	@Autowired
	Navigator navigator;

	public String incompleteCreditApplication() {
		IncompleteApplicationPage incompleteApplicationPage = navigator.navigateToPage(IncompleteApplicationPage.class);
		return incompleteApplicationPage.editAndSaveIncompleteApplication();
	}

	public void incompleteCreditApplicationFileUpload() {
		IncompleteApplicationPage incompleteApplicationPage = navigator.navigateToPage(IncompleteApplicationPage.class);
		incompleteApplicationPage.incompleteApplicationFileUpload();
	}
	
	public String incompleteCreditApplicationWithExistingData() {
		IncompleteApplicationPage incompleteApplicationPage = navigator.navigateToPage(IncompleteApplicationPage.class);
		return incompleteApplicationPage.incompleteApplicationWithExistingData();
	}

}
