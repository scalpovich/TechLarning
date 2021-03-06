package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Value;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;


public class InstitutionSelection {
	
	@Value("${Customer.portal.admin.institutionName}")	
	private static String customerAdminInstitution;
	
	@Value("${app.user.institutionselection}")
	private static String institutionName;
	
	@Value("${app.user.Bankinstitutionselection}")
	private static String bankInstitutionName;
	
	private String instiution;	
	private String adminInstiutionName;
	private String bankInstitution;
	
	
	public String getBankInstitution() {
		return bankInstitution;
	}
	public void setBankInstitution(String bankInstitution) {
		this.bankInstitution = bankInstitution;
	}
	public String getInstiution() {
		return instiution;
	}
	public void setInstiution(String instiution) {
		this.instiution = instiution;
	}
	public String getAdminInstiutionName() {
		return adminInstiutionName;
	}
	public void setAdminInstiutionName(String adminInstiutionName) {
		this.adminInstiutionName = adminInstiutionName;
	}
	
	public static InstitutionSelection IntitutionDataProvider(){
		InstitutionSelection institute = new InstitutionSelection();		
		institute.setInstiution(institutionName);
		institute.setAdminInstiutionName(customerAdminInstitution);
		institute.setBankInstitution(bankInstitutionName);
		
		return institute;
	}
	
	
	

}
