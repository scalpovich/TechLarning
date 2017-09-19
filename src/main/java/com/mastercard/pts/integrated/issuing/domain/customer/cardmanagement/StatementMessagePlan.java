package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;

import com.mastercard.pts.integrated.issuing.domain.HasCodeAndDescription;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.utils.MiscUtils;
@Component
public class StatementMessagePlan implements HasCodeAndDescription {

	private String statementMessagePlanCode;
	public String StatementMessagePlan;
	
	private String productType;
	
	private String description;
	
	private List<StatementMessageDetails> statementMessageDetails = new ArrayList<>();

	public String getStatementMessagePlan() {
		return StatementMessagePlan;
	}

	public void setStatementMessagePlan(String statementMessagePlan) {
		StatementMessagePlan = statementMessagePlan;
	}

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

	public List<StatementMessageDetails> getStatementMessageDetails() {
		return statementMessageDetails;
	}

	public void setStatementMessageDetails(List<StatementMessageDetails> statementMessageDetails) {
		this.statementMessageDetails = statementMessageDetails;
	}

	@Override
	public String toString() {
		return "StatementMessagePlan [planCode=" + statementMessagePlanCode + ", productType="
				+ productType + ", description=" + description + "]";
	}
}
