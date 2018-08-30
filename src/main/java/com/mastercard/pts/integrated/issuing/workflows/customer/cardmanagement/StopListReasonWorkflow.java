package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.StopListReasonPlan;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.StoplistReasonPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Component
public class StopListReasonWorkflow {
	 
		@Autowired
		private Navigator navigator;
		
		public void addStopListReasonPlan(StopListReasonPlan stopListReasonPlan)
		{
			StoplistReasonPage stopListPage=navigator.navigateToPage(StoplistReasonPage.class);
			stopListPage.addStopListReasonInStopListPage(stopListReasonPlan);
		}
}
