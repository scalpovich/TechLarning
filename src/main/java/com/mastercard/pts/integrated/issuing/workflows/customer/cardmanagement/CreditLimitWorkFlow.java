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
	
	public void addCreditLimit()
	{
		CreditLimitRulePage creditLimitRulePage = navigator.navigateToPage(CreditLimitRulePage.class);
		creditLimitRulePage.addProgramCode();
		creditLimitRulePage.selectProgramCode();
		creditLimitRulePage.selectFieldName();
		creditLimitRulePage.selectOperator();
		creditLimitRulePage.selectValue();
		creditLimitRulePage.selectLimitType();
		creditLimitRulePage.enterCreditLimit();
		creditLimitRulePage.enterMaxCreditLimit();
		creditLimitRulePage.appendButtonClick();
		creditLimitRulePage.save();
		
	}
}
