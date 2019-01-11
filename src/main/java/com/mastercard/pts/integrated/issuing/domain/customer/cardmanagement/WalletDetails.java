package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;


public class WalletDetails {
	
	private String walletNumber;
	private String adminStatus;
	
	public static WalletDetails createWithProvider(){
		return  new WalletDetails();
	}
	
	public String getWalletNumber() {
		return walletNumber;
	}

	public void setWalletNumber(String walletNumber) {
		this.walletNumber = walletNumber;
	}
	
	public String getAdminStatus() {
		return adminStatus;
	}

	public void setAdminStatus(String adminStatus) {
		this.adminStatus = adminStatus;
	}
}
