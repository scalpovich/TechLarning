package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import org.springframework.stereotype.Component;

@Component
public class AccountType {

	public String Accounttype;

	public String getAccounttype() {
		return Accounttype;
	}

	public void setAccounttype(String accounttype) {
		Accounttype = accounttype;
	}

}
