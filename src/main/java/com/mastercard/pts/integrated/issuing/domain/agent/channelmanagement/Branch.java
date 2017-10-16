package com.mastercard.pts.integrated.issuing.domain.agent.channelmanagement;

import com.mastercard.pts.integrated.issuing.domain.provider.DataProvider;

public class Branch extends Agency{
	
	private String branchId;
	private String branchName;
	public String getBranchId() {
		return branchId;
	}
	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	
	public static Branch createWithProvider(DataProvider provider) {
		return provider.getDataBySimpleClassName(Branch.class);
	}
}
