package com.mastercard.pts.integrated.issuing.domain.customer.dispute;

import com.mastercard.pts.integrated.issuing.domain.provider.DataProvider;

public class RetrievalRequest {

	private String requestResonCode;
	private String reasonCode;
	private boolean applyFee;
	private String arn;
	
	public String getRequestResonCode() {
		return requestResonCode;
	}
	public void setRequestResonCode(String requestResonCode) {
		this.requestResonCode = requestResonCode;
	}
	public String getReasonCode() {
		return reasonCode;
	}
	public void setReasonCode(String reasonCode) {
		this.reasonCode = reasonCode;
	}
	public boolean isApplyFee() {
		return applyFee;
	}
	public void setApplyFee(boolean applyFee) {
		this.applyFee = applyFee;
	}
	public String getArn() {
		return arn;
	}
	public void setArn(String arn) {
		this.arn = arn;
	}
	
	public static RetrievalRequest createWithProvider(DataProvider provider) {
		return provider.getDataBySimpleClassName(RetrievalRequest.class);
	}
}
