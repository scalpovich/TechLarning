package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import org.springframework.stereotype.Component;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.mastercard.pts.integrated.issuing.domain.HasCodeAndDescription;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.MiscUtils;
@Component
public class DedupePlan implements HasCodeAndDescription {

	private static final String DP_ACTIVATE_CHECK_FOR = "DP_ACTIVATE_CHECK_FOR";
	
	private static final String DP_PARAMETERS = "DP_PARAMETER";
	
	private String description;

	private String dedupePlanCode;
	
	private String activateCheckFor;
	
	private String dedupeParameters;

	public static DedupePlan generateDynamicTestData() {
		DedupePlan plan = new DedupePlan();
		String generateCode = MiscUtils.generate10CharAlphaNumeric();
		plan.setWalletPlanCode(generateCode);
		plan.setDescription(generateCode);
		return plan;
	}


	public String getDedupePlanCode() {
		return dedupePlanCode;
	}
	
	public static DedupePlan createWithProvider(KeyValueProvider provider) {
		DedupePlan plan = new DedupePlan();
		String generateCode = MiscUtils.generate10CharAlphaNumeric();
		plan.setWalletPlanCode(generateCode);
		plan.setDescription(generateCode);
		plan.setActivateCheckFor(provider.getString(DP_ACTIVATE_CHECK_FOR));
		plan.setDedupeParameters(provider.getString(DP_PARAMETERS));
		return plan;
	}
	
	@Override
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String getCode() {
		return getWalletPlanCode();
	}

	public String getWalletPlanCode() {
		return dedupePlanCode;
	}

	public void setDedupePlanCode(String dedupePlanCode) {
		this.dedupePlanCode = dedupePlanCode;
	}

	public void setWalletPlanCode(String walletPlanCode) {
		this.dedupePlanCode = walletPlanCode;
	}
	
	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

	public String getActivateCheckFor() {
		return activateCheckFor;
	}

	public void setActivateCheckFor(String activateCheckFor) {
		this.activateCheckFor = activateCheckFor;
	}

	public String getDedupeParameters() {
		return dedupeParameters;
	}

	public void setDedupeParameters(String dedupeParameters) {
		this.dedupeParameters = dedupeParameters;
	}
}
