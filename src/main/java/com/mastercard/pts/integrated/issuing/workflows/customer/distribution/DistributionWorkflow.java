package com.mastercard.pts.integrated.issuing.workflows.customer.distribution;

import org.springframework.beans.factory.annotation.Autowired;

import com.mastercard.pts.integrated.issuing.annotation.Workflow;
import com.mastercard.pts.integrated.issuing.domain.customer.distribution.Dispatch;
import com.mastercard.pts.integrated.issuing.pages.customer.distribution.DispatchPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Workflow
public class DistributionWorkflow {
	private DispatchPage dpage;
	
	@Autowired
	private Navigator navigator;

	public String dispatchOrder(Dispatch dispatch) {
		dpage = navigator.navigateToPage(DispatchPage.class);
		String lastCardPackId = dpage.dispatchOrder(dispatch);
		dispatch.setOrderNumber(lastCardPackId);
		return lastCardPackId;
	}
	
	public String getCardPackIdCreationMessage(){
		return dpage.getCardPackIdCreationMessage();
	}
}
