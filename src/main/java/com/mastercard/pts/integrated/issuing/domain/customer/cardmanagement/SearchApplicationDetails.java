package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;


public class SearchApplicationDetails extends AbstractBasePage{
	
	public String fromDate;	
	public String ToDate;
	public String formNumber; 
	public String firstName;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String lastName;
	
	public String getFromDate() {
		return fromDate;
	}
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	public String getToDate() {
		return ToDate;
	}
	public void setToDate(String toDate) {
		ToDate = toDate;
	}
	public String getFormNumber() {
		return formNumber;
	}
	public void setFormNumber(String formNumber) {
		this.formNumber = formNumber;
	}
	
   public static SearchApplicationDetails getSearchApplicationData(){
	   SearchApplicationDetails search = new SearchApplicationDetails();
	   search.setFromDate("September/1/2017");
	   search.setToDate("September/1/2017");
	   search.setFormNumber("12345678");
	   search.setFirstName("Vishwas");
	   search.setLastName("P");
	return search;
   }
		
}
