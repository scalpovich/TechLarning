package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.CreditLimitRulePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Component
public class CreditLimitWorkFlow {
	final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	Navigator navigator;
	private CreditLimitRulePage creditLimitRulePage;
	public boolean addCreditLimitRule(String fieldName)
	{
	    creditLimitRulePage = navigator.navigateToPage(CreditLimitRulePage.class);
		creditLimitRulePage.addProgramCode();
		creditLimitRulePage.selectProgramCode();
		creditLimitRulePage.selectFieldName(fieldName);
		creditLimitRulePage.selectOperator(2);
		creditLimitRulePage.enterValue();
		creditLimitRulePage.selectLimitType(1);
		creditLimitRulePage.enterCreditLimit();
		creditLimitRulePage.enterMaxCreditLimit();
		creditLimitRulePage.appendButtonClick();
		creditLimitRulePage.save();
		return creditLimitRulePage.successMessageDisplay();
		
	}
}
