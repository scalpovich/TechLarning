package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import java.time.LocalDate;

import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;

public class StatementMessageDetails {

	private static final String SMD_BALANCE_STATUS = "SMD_BALANCE_STATUS";

	private static final String SMD_ADMIN_STATUS = "SMD_ADMIN_STATUS";

	private static final String SMD_UNPAID_STATUS = "SMD_UNPAID_STATUS";

	private static final String KEY_BRANCH = "BRANCH";
	
	private static final String SMD_EFFECTIVE_DATE = "SMD_EFFECTIVE_DATE";
	
	private static final String SMD_END_DATE = "SMD_END_DATE";

	private String branch;
	
	private LocalDate effectiveDate;
	
	private LocalDate endDate;
	
	private String unpaidStatus;
	
	private String adminStatus;
	
	private String balanceStatus;
	
	private String messageLabel;
	
	private String message;

	public static StatementMessageDetails createWithProvider(KeyValueProvider provider) {
		StatementMessageDetails details = new StatementMessageDetails();
		details.setBranch(provider.getString(KEY_BRANCH));
		details.setEffectiveDate(LocalDate.now().plusDays(1));
		details.setEndDate(details.getEffectiveDate().plusDays(5));
		details.setMessageLabel(ConstantData.GENERIC_DESCRIPTION);
		details.setMessage(ConstantData.GENERIC_DESCRIPTION);
		// for Credit product type
		details.setUnpaidStatus(provider.getString(SMD_UNPAID_STATUS));
		details.setAdminStatus(provider.getString(SMD_ADMIN_STATUS));
		details.setBalanceStatus(provider.getString(SMD_BALANCE_STATUS));
		return details;
	}

	public static StatementMessageDetails createWithProviderForDates(KeyValueProvider provider) {
		StatementMessageDetails details = new StatementMessageDetails();
		details.setEffectiveDate(LocalDate.now().plusDays(Integer.valueOf(provider.getString(SMD_EFFECTIVE_DATE))));
		details.setEndDate(details.getEffectiveDate().plusDays(Integer.valueOf(provider.getString(SMD_END_DATE))));
		return details;
	}
	
	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public LocalDate getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(LocalDate effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public String getUnpaidStatus() {
		return unpaidStatus;
	}

	public void setUnpaidStatus(String unpaidStatus) {
		this.unpaidStatus = unpaidStatus;
	}

	public String getAdminStatus() {
		return adminStatus;
	}

	public void setAdminStatus(String adminStatus) {
		this.adminStatus = adminStatus;
	}

	public String getBalanceStatus() {
		return balanceStatus;
	}

	public void setBalanceStatus(String balanceStatus) {
		this.balanceStatus = balanceStatus;
	}

	public String getMessageLabel() {
		return messageLabel;
	}

	public void setMessageLabel(String messageLabel) {
		this.messageLabel = messageLabel;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "StatementMessageDetails [branch=" + branch + ", effectiveDate="
				+ effectiveDate + ", endDate=" + endDate + ", unpaidStatus="
				+ unpaidStatus + ", admintatus=" + adminStatus
				+ ", balanceStatus=" + balanceStatus + ", messageLabel="
				+ messageLabel + ", message=" + message + "]";
	}
}
