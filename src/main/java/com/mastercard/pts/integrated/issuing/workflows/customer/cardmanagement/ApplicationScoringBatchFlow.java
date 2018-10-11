package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;

import com.mastercard.pts.integrated.issuing.annotation.Workflow;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.ApplicationScoringPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Workflow
public class ApplicationScoringBatchFlow {

	@Autowired
	Navigator navigator;
	
	private ApplicationScoringPage applicationScoringPage;
	
	public void processApplicationScoringBatch(){
		applicationScoringPage=navigator.navigateToPage(ApplicationScoringPage.class);
		applicationScoringPage.processAllApplicationScoring();
		applicationScoringPage.clickProcessALL();
	}
}
