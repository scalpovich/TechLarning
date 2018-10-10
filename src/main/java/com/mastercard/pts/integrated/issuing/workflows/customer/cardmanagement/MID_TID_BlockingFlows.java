package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;
import org.springframework.beans.factory.annotation.Autowired;

import com.mastercard.pts.integrated.issuing.annotation.Workflow;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.MID_TID_Blocking;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.MID_TID_BlockingPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.workflows.MenuFlows;

@Workflow
public class MID_TID_BlockingFlows extends MenuFlows {
	
	@Autowired
	private Navigator navigator;

	public void addMID_TID_Blocking(String combination, MID_TID_Blocking details) {
		MID_TID_BlockingPage page = navigator.navigateToPage(MID_TID_BlockingPage.class);
		page.addBlockingMID_TID(combination, details);
	}
	
	public void deleteMID_TID_Blocking(String combination, MID_TID_Blocking details) {
		MID_TID_BlockingPage page = navigator.navigateToPage(MID_TID_BlockingPage.class);
		page.deleteRecord(combination,details);
	}
}