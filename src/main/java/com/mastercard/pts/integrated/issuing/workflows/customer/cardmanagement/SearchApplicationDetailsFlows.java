package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CreditConstants;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.SearchApplicationDetails;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.SearchApplicationDetailsPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Component
public class SearchApplicationDetailsFlows {

	@Autowired
	public Navigator navigator;
	
	@Autowired
	TestContext context;

	public SearchApplicationDetailsPage searchPage;

	public void searchApplication(SearchApplicationDetails search) {
		searchPage = navigator
				.navigateToPage(SearchApplicationDetailsPage.class);
		searchPage.searchNewApplication(search);
	}

	public void verifyApplicationUploadSuccess(SearchApplicationDetails search) {
		searchApplication(search);
		searchPage.verifyNewApplication();
	}
	
	public void searchApplicationDetails() {
		searchPage = navigator.navigateToPage(SearchApplicationDetailsPage.class);		
		context.put(CreditConstants.NEW_APPLICATION_BATCH, searchPage.searchApplicationNumber());		
	}
	
	public void searchApplicationDetailsForFileUpload() {
		searchPage = navigator.navigateToPage(SearchApplicationDetailsPage.class);
		searchPage.searchApplicationNumberForFileUpload();
		
	}
}
