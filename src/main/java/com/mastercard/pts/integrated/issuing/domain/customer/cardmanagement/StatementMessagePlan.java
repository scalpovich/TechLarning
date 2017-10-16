package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

import com.mastercard.pts.integrated.issuing.utils.DateUtils;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;
import com.mastercard.pts.integrated.issuing.domain.HasCodeAndDescription;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.utils.MiscUtils;

@Component
public class StatementMessagePlan implements HasCodeAndDescription {

	private String statementMessagePlanCode;
	
	private String productType;
	
	private String description;
	public String EffectiveDate;
	public String EndDate;
	
	private List<StatementMessageDetails> statementMessageDetails = new ArrayList<>();

	public static StatementMessagePlan generateDynamicTestData() {
		StatementMessagePlan plan = new StatementMessagePlan();
		plan.setStatementMessagePlanCode(MiscUtils.generate10CharAlphaNumeric());
		plan.setDescription(ConstantData.GENERIC_DESCRIPTION);
		return plan;
	}
	
	@Override
	public String getCode() {
		return getStatementMessagePlanCode();
	}
	
	public String getStatementMessagePlanCode() {
		return statementMessagePlanCode;
	}

	public void setStatementMessagePlanCode(String statementMessagePlanCode) {
		this.statementMessagePlanCode = statementMessagePlanCode;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	@Override
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
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


	public List<StatementMessageDetails> getStatementMessageDetails() {
		return statementMessageDetails;
	}

	public void setStatementMessageDetails(List<StatementMessageDetails> statementMessageDetails) {
		this.statementMessageDetails = statementMessageDetails;
	}

	public static StatementMessagePlan StatementMessagePlanProvider() {
		StatementMessagePlan stmnt = new StatementMessagePlan();
		stmnt.setEffectiveDate(DateUtils.getDateinDDMMYYYY());
		stmnt.setEndDate(MapUtils.fnGetInputDataFromMap("EndDate"));
		return stmnt;
	}

	@Override
	public String toString() {
		return "StatementMessagePlan [planCode=" + statementMessagePlanCode + ", productType="
				+ productType + ", description=" + description + "]";
	}
}
