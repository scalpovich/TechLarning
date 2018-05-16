
package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;
@Component
public class LoanType {
	
	private String addLoanType;
	private String description ;
	private String draftNeeded ;

	public String getAddLoanType() {
		return addLoanType;
	}

	public void setAddLoanType(String addLoanType) {
		this.addLoanType = addLoanType;
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
	
	public static LoanType getLoanTypeData() {
		LoanType loanType = new LoanType();
		loanType.setAddLoanType(MapUtils.fnGetInputDataFromMap("LoanType"));
		loanType.setDescription(CustomUtils.randomString(10).toUpperCase());
		return loanType;
	}
	
}
