package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.MiscUtils;

@Component
public class MCG {

	private String mcg;
	private String mCGCode;
	private String mccFrom;
	private String mccTo;
	private String description;
	private String mccName;
	
	private static final String MCG_DESCRIPTION = "MCG Additional auth hold plan";
	private static final String MCC_FROM = "MCC_FROM";
	private static final String MCC_TO = "MCC_TO";
	
	public static MCG getMCGDetails(KeyValueProvider provider) {
		MCG plan = new MCG();
		plan.setMCGCode(CustomUtils.randomNumbers(3));
		plan.setMCG(MCG_DESCRIPTION +" " + "[" + plan.getMCGCode() + "]");
		plan.setDescription(MCG_DESCRIPTION);
		plan.setMccFrom(provider.getString(MCC_FROM));
		plan.setMccTo(provider.getString(MCC_TO));
		return plan;
	}

	public String getMCG() {
		return mcg;
	}

	public void setMCG(String mcg) {
		this.mcg = mcg;
	}
	
	public String getMccFrom() {
		return mccFrom;
	}

	public void setMccFrom(String mccFrom) {
		this.mccFrom = mccFrom;
	}

	public String getMccTo() {
		return mccTo;
	}

	public void setMccTo(String mccTo) {
		this.mccTo = mccTo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMccName() {
		return mccName;
	}

	public void setMccName(String mccName) {
		this.mccName = mccName;
	}

	public String getMCGCode() {
		return mCGCode;
	}

	public void setMCGCode(String mCGCode) {
		this.mCGCode = mCGCode;
	}
     
	@Override
	public String toString() {
		return MiscUtils.toString(this);
	}
}
