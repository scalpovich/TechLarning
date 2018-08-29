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
		
		@Autowired
		private StoplistReasonPage stopListPage;
		public void addStopListReasonPlan(StopListReasonPlan stopListReasonPlan)
		{
			stopListPage=navigator.navigateToPage(StoplistReasonPage.class);
			stopListPage.addStopListReasonInStopListPage(stopListReasonPlan);
		}
}
