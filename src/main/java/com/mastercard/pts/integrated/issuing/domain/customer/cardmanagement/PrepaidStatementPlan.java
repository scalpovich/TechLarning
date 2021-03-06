package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.HasCodeAndDescription;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;
import com.mastercard.pts.integrated.issuing.utils.MiscUtils;
@Component
public class PrepaidStatementPlan implements HasCodeAndDescription {

	private static final String PSP_SUPPRESS_IF_NO_ACTIVITY = "PSP_SUPPRESS_IF_NO_ACTIVITY";

	private static final String PSP_PERIOD = "PSP_PERIOD";

	private String statementPlanCode;
	
	private String description;
	
	private String period;
	public String PrepaidStatementPlan;

	public String ToLot;

	public String PrintDay;
	
	private boolean suppressIfNoActivity;
	
	private List<PrepaidStatementPlanDetails> prepaidStatementPlanDetails = new ArrayList<>();
	
	public static PrepaidStatementPlan createWithProvider(KeyValueProvider provider) {
		PrepaidStatementPlan plan = new PrepaidStatementPlan();
		plan.setStatementPlanCode(MiscUtils.generate10CharAlphaNumeric());
		plan.setDescription(ConstantData.GENERIC_DESCRIPTION);
		plan.setPeriod(provider.getString(PSP_PERIOD));
		plan.setSuppressIfNoActivity(provider.getBoolean(PSP_SUPPRESS_IF_NO_ACTIVITY));
		return plan;
	}

	public String getStatementPlanCode() {
		return statementPlanCode;
	}

	public void setStatementPlanCode(String statementPlanCode) {
		this.statementPlanCode = statementPlanCode;
	}
	
	@Override
	public String getCode() {
		return getStatementPlanCode();
	}

	@Override
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public boolean isSuppressIfNoActivity() {
		return suppressIfNoActivity;
	}

	public void setSuppressIfNoActivity(boolean suppressIfNoActivity) {
		this.suppressIfNoActivity = suppressIfNoActivity;
	}

	public List<PrepaidStatementPlanDetails> getPrepaidStatementPlanDetails() {
		return prepaidStatementPlanDetails;
	}

	public void setPrepaidStatementPlanDetails(
			List<PrepaidStatementPlanDetails> prepaidStatementPlanDetails) {
		this.prepaidStatementPlanDetails = prepaidStatementPlanDetails;
	}
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

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
