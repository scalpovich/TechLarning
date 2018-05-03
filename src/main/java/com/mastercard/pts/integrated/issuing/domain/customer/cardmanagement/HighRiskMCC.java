package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;

@Component
public class HighRiskMCC {

	public String mccCode;

	public String getMccCode() {
		return mccCode;
	}

	public void setMccCode(String mccCode) {
		this.mccCode = mccCode;
	}

	public static HighRiskMCC getHighRiskMCCData()
	{
		HighRiskMCC highRiskMCCData=new HighRiskMCC();
		highRiskMCCData.setMccCode(MapUtils.fnGetInputDataFromMap("MccCode"));
		return highRiskMCCData;
		
	}

}
