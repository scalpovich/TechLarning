package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.LoanAccountDetailsPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Component
public class LoanAccountDetailsWorkFlow {
	
	@Autowired
	private Navigator navigator;
	
	public List<Map<String,String>> verifyLoanAccountDetail(Device device){
		LoanAccountDetailsPage page = navigator.navigateToPage(LoanAccountDetailsPage.class);		

		return page.serachLoanAccountDetails(device);		
	
	}
	
	

}
