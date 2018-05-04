
package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;
@Component
public class LoanType {
	
	private String loanType;
	private String description ;
	private String draftNeeded ;
	private String creditLimit ;
	private String cashLimit;
	
	public String getLoanType() {
		return loanType;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDraftNeeded() {
		return draftNeeded;
	}

	public void setDraftNeeded(String draftNeeded) {
		this.draftNeeded = draftNeeded;
	}

	public String getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(String creditLimit) {
		this.creditLimit = creditLimit;
	}

	public String getCashLimit() {
		return cashLimit;
	}

	public void setCashLimit(String cashLimit) {
		this.cashLimit = cashLimit;
	}
	
	public static LoanType getLoanTypeData() {
		LoanType loanType = new LoanType();
		loanType.setLoanType(MapUtils.fnGetInputDataFromMap("LoanType"));
		loanType.setDescription(CustomUtils.randomString(10).toUpperCase());
		return loanType;
	}
	
}
