package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.StopListReasonPlan;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.StoplistReasonPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Component
public class StopListReasonWorkflow {
	 
		@Autowired
		Navigator navigator;
		StoplistReasonPage stopListPage;
		public boolean addStopListReasonPlan(StopListReasonPlan stopListReasonPlan, String stopListReason)
		{
			stopListPage=navigator.navigateToPage(StoplistReasonPage.class);
			return stopListPage.addStopListReasonInStopListPage(stopListReasonPlan,stopListReason);
		}
}
