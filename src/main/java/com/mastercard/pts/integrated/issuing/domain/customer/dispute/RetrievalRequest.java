package com.mastercard.pts.integrated.issuing.domain.customer.dispute;

import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;

public class RetrievalRequest {

	private static final String REQUEST_RESPONSE_CODE = "REQUEST_RESPONSE_CODE";
	private static final String REASON_CODE = "REASON_CODE";
	private static final String APPLY_FEE = "APPLY_FEE";
	
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
	
	public static RetrievalRequest createWithProvider(KeyValueProvider provider) {
		RetrievalRequest request = new RetrievalRequest();
		request.setRequestResonCode(provider.getString(REQUEST_RESPONSE_CODE));
		request.setReasonCode(provider.getString(REASON_CODE));
		request.setApplyFee(true);
		return request;
	}
}
