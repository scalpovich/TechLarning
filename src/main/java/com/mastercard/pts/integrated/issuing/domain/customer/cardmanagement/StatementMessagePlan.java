package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.utils.DateUtils;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;

@Component
public class StatementMessagePlan {

	public String StatementMessagePlan;

	public String EffectiveDate;

	public String EndDate;

	public String getEffectiveDate() {
		return EffectiveDate;
	}

	public void setEffectiveDate(String effectiveDate) {
		EffectiveDate = effectiveDate;
	}

	public String getEndDate() {
		return EndDate;
	}

	public void setEndDate(String endDate) {
		EndDate = endDate;
	}

	public String getStatementMessagePlan() {
		return StatementMessagePlan;
	}

	public void setStatementMessagePlan(String statementMessagePlan) {
		StatementMessagePlan = statementMessagePlan;
	}

	public static StatementMessagePlan StatementMessagePlanProvider() {
		StatementMessagePlan stmnt = new StatementMessagePlan();
		stmnt.setEffectiveDate(DateUtils.getDateinDDMMYYYY());
		stmnt.setEndDate(MapUtils.fnGetInputDataFromMap("EndDate"));
		return stmnt;
	}

}
