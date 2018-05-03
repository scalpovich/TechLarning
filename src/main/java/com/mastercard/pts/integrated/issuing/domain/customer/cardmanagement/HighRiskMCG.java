package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.utils.MapUtils;

@Component
public class HighRiskMCG {

	public String mcgCode;

	public static HighRiskMCG getHighRiskMCGData()
	{
		HighRiskMCG highRiskMCGData=new HighRiskMCG();
		highRiskMCGData.setMcgCode(MapUtils.fnGetInputDataFromMap("MccCode"));
		return highRiskMCGData;
		
	}

	public String getMcgCode() {
		return mcgCode;
	}

	public void setMcgCode(String mcgCode) {
		this.mcgCode = mcgCode;
	}

}
