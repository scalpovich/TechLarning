package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;

import com.mastercard.pts.integrated.issuing.domain.HasCodeAndDescription;
import com.mastercard.pts.integrated.issuing.utils.MiscUtils;
public class DedupePlan extends AbstractBasePage {
//need to check why we need implements HasCodeAndDescription
//public class DedupePlan implements HasCodeAndDescription {
	public String DedupePlanCode;

	public String getDedupePlanCode() {
		return DedupePlanCode;
	}
	private String description;

	private String dedupePlanCode;

	public static DedupePlan generateDynamicTestData() {
		DedupePlan plan = new DedupePlan();
		String generateCode = MiscUtils.generate10CharAlphaNumeric();
		plan.setWalletPlanCode(generateCode);
		plan.setDescription(generateCode);
		return plan;
	}
	
	@Override
	public String getDescription() {
		return description;

	public void setDescription(String description) {
		this.description = description;
	}
	public void setDedupePlanCode(String dedupePlanCode) {
		DedupePlanCode = dedupePlanCode;
	}
	@Override
	public String getCode() {
		return getWalletPlanCode();
	}

	public String getWalletPlanCode() {
		return dedupePlanCode;
	}

	public void setWalletPlanCode(String walletPlanCode) {
		this.dedupePlanCode = walletPlanCode;
	}
	
	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
