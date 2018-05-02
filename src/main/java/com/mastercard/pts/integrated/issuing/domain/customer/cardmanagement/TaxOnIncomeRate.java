package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;

@Component
public class TaxOnIncomeRate {

	public String taxDescription;
	public String feeType;
	public String taxRate;
	public String status ;
	
	public String getTaxDescription() {
		return taxDescription;
	}

	public void setTaxDescription(String taxDescription) {
		this.taxDescription = taxDescription;
	}

	public String getFeeType() {
		return feeType;
	}

	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}

	public String getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(String taxRate) {
		this.taxRate = taxRate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public static TaxOnIncomeRate getTaxOnIncomeRateData()
	{
		TaxOnIncomeRate taxIncomeRateData=new TaxOnIncomeRate();
		taxIncomeRateData.setTaxDescription(CustomUtils.randomString(10).toUpperCase());
		taxIncomeRateData.setFeeType(MapUtils.fnGetInputDataFromMap("TaxOnIncomeFeeType"));
		taxIncomeRateData.setTaxRate(CustomUtils.randomNumbers(2));
		taxIncomeRateData.setStatus(MapUtils.fnGetInputDataFromMap("TaxOnIncomeStatus"));
		return taxIncomeRateData;
		
	}

}
