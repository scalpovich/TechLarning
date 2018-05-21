package com.mastercard.pts.integrated.issuing.domain;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class CreditScore {
    
	public List<String> workFlowRuleFieldNames() {
		final List<String> workFlowRuleFieldNameList = new LinkedList<String>();
		workFlowRuleFieldNameList.add("Occupation [COMP_TYPE]");
		workFlowRuleFieldNameList.add("Customer Type [CUSTOMER_TYPE]");
		workFlowRuleFieldNameList.add("Education [EDUCATION]");
		workFlowRuleFieldNameList.add("Employer Name [EMPLOYER_NAME]");
		workFlowRuleFieldNameList.add("Employment Status [EMPLOYMENT_STATUS]");
		workFlowRuleFieldNameList.add("Designation [EMPL_DESIGNATION]");
		workFlowRuleFieldNameList.add("Dependents [NO_OF_DEPENDENTS]");
		workFlowRuleFieldNameList.add("Owned Vehicle Type [OWNED_VEHICLE_TYPE]");
		workFlowRuleFieldNameList.add("VIP Flag [VIP_FLAG]");
        return workFlowRuleFieldNameList;
	}
	
	public List<String>operators()
	{
		final List<String> workFlowRuleOperators = new LinkedList<String>();
		workFlowRuleOperators.add("= [=]");
		workFlowRuleOperators.add("< [<]");
		workFlowRuleOperators.add("> [>]");
		workFlowRuleOperators.add("<= [<=]");
		workFlowRuleOperators.add(">= [>=]");
		workFlowRuleOperators.add("BETWEEN [BETWEEN]");
		return workFlowRuleOperators;
	}
	
	public List<String>operator1Value(String FlowName)
	{
		List<String>workFlowRule=workFlowRuleFieldNames();
		List<String>subValues=new ArrayList<>();
		return workFlowRule;
	}
}
