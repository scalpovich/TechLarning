package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.SearchApplicationDetails;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.SearchApplicationDetailsPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Component
public class SearchApplicationDetailsFlows {

	@Autowired
	public Navigator navigator;

	public SearchApplicationDetailsPage searchpage;

	public void searchApplication(SearchApplicationDetails search) {
		searchpage = navigator
				.navigateToPage(SearchApplicationDetailsPage.class);
		searchpage.searchNewApplication(search);
	}

	public void verifyApplicationUploadSuccess(SearchApplicationDetails search) {
		searchApplication(search);
		searchpage.verifyNewApplication();
	}
}
