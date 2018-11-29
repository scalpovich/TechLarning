package com.mastercard.pts.integrated.issuing.workflows.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.customer.QuickJumpPage;

@Component
public class QuickJumpFlows {
	@Autowired
	private QuickJumpPage quickJumpPage;
	
	public void quickJumpToPage(String pageCode) {
		quickJumpPage.quickJump(pageCode);
	}
	
	public String getPageName() {
		return quickJumpPage.getPageName();
	}	

}
