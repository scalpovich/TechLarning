package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.utils.MapUtils;

@Component
public class PrepaidStatementPlan {

	public String PrepaidStatementPlan;

	public String ToLot;

	public String PrintDay;

	public String getToLot() {
		return ToLot;
	}

	public void setToLot(String toLot) {
		ToLot = toLot;
	}

	public String getPrintDay() {
		return PrintDay;
	}

	public void setPrintDay(String printDay) {
		PrintDay = printDay;
	}

	public String getPrepaidStatementPlan() {
		return PrepaidStatementPlan;
	}

	public void setPrepaidStatementPlan(String prepaidStatementPlan) {
		PrepaidStatementPlan = prepaidStatementPlan;
	}

	public static PrepaidStatementPlan prepaidstatementDataprovider() {
		PrepaidStatementPlan prepaidstmt = new PrepaidStatementPlan();
		prepaidstmt.setToLot(MapUtils.fnGetInputDataFromMap("ToLot"));
		prepaidstmt.setPrintDay(MapUtils.fnGetInputDataFromMap("PrintDay"));
		return prepaidstmt;

	}
}
