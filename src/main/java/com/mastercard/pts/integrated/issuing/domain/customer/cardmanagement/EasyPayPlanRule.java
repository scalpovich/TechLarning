package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.utils.MapUtils;

@Component
public class EasyPayPlanRule {


	public String planCode;
	public String planDesc ;
	public String ruleCode ; 
	public String comparisonOperator ;
	public String ruleValue;

	public String getPlanCode() {
		return planCode;
	}

	public void setPlanCode(String planCode) {
		this.planCode = planCode;
	}

	public String getPlanDesc() {
		return planDesc;
	}

	public void setPlanDesc(String planDesc) {
		this.planDesc = planDesc;
	}

	public String getRuleCode() {
		return ruleCode;
	}

	public void setRuleCode(String ruleCode) {
		this.ruleCode = ruleCode;
	}

	public String getComparisonOperator() {
		return comparisonOperator;
	}

	public void setComparisonOperator(String comparisonOperator) {
		this.comparisonOperator = comparisonOperator;
	}

	public String getRuleValue() {
		return ruleValue;
	}

	public void setRuleValue(String ruleValue) {
		this.ruleValue = ruleValue;
	}

	public static EasyPayPlanRule createDataProvider() {
		EasyPayPlanRule testdataobj= new EasyPayPlanRule();
		testdataobj.setComparisonOperator(MapUtils.fnGetInputDataFromMap("comparisonOperator"));
		testdataobj.setRuleCode(MapUtils.fnGetInputDataFromMap("ruleCode"));	
		testdataobj.setRuleValue(MapUtils.fnGetInputDataFromMap("ruleValue"));
		return  testdataobj;
	}
}


