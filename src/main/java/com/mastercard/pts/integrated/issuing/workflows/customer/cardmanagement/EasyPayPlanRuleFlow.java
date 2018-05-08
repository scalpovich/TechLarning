package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.EasyPayPlanRule;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.EasyPayPlanRulePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

/**
 * @author e076177
 *
 */
@Component
public class EasyPayPlanRuleFlow {
	@Autowired
	private Navigator navigator;
	@Autowired
	EasyPayPlanRulePage easypayplanrule;
	public void adddetails(EasyPayPlanRule easypayplanrule) {
		EasyPayPlanRulePage page = navigator.navigateToPage(EasyPayPlanRulePage.class);
		page.addDetails(easypayplanrule);
		
	}
}
