package com.mastercard.pts.integrated.issuing.domain.customer.dispute;

import com.mastercard.pts.integrated.issuing.domain.provider.DataProvider;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;

public class ChargeBackReversal {

	private String chargeBackAmount;
	private String reasonCode;
	private String documentation;
	private boolean fees;
	private String text;
	private boolean isChargeBackDateGrater;
	private boolean isCopyRequestRequired;
	private boolean isDocumentRequired;
	private String arn;
	
	public String getChargeBackAmount() {
		return chargeBackAmount;
	}
	public void setChargeBackAmount(String chargeBackAmount) {
		this.chargeBackAmount = chargeBackAmount;
	}
	public String getReasonCode() {
		return reasonCode;
	}
	public void setReasonCode(String reasonCode) {
		this.reasonCode = reasonCode;
	}
	public String getDocumentation() {
		return documentation;
	}
	public void setDocumentation(String documentation) {
		this.documentation = documentation;
	}
	public boolean isFees() {
		return fees;
	}
	public void setFees(boolean fees) {
		this.fees = fees;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public boolean isChargeBackDateGrater() {
		return isChargeBackDateGrater;
	}
	public void setChargeBackDateGrater(boolean isChargeBackDateGrater) {
		this.isChargeBackDateGrater = isChargeBackDateGrater;
	}
	public boolean isCopyRequestRequired() {
		return isCopyRequestRequired;
	}
	public void setCopyRequestRequired(boolean isCopyRequestRequired) {
		this.isCopyRequestRequired = isCopyRequestRequired;
	}
	public boolean isDocumentRequired() {
		return isDocumentRequired;
	}
	public void setDocumentRequired(boolean isDocumentRequired) {
		this.isDocumentRequired = isDocumentRequired;
	}
	public String getArn() {
		return arn;
	}
	public void setArn(String arn) {
		this.arn = arn;
	}
	
	public static ChargeBackReversal getChargeBackReversal(KeyValueProvider provider)
	{
		ChargeBackReversal cb=new ChargeBackReversal();
		cb.setChargeBackAmount(provider.getString("AMOUNT"));
		cb.setChargeBackDateGrater(true);
		cb.setCopyRequestRequired(true);
		cb.setDocumentRequired(true);
		cb.setDocumentation(provider.getString("DOCUMENTATION"));
		cb.setFees(true);
		cb.setReasonCode(provider.getString("CHARGEBACK_REASON"));
		cb.setText(provider.getString("TEXT"));
		return cb;
	}
	
	public static ChargeBackReversal createWithProvider(DataProvider provider) {
		return provider.getDataBySimpleClassName(ChargeBackReversal.class);
	}
	
}
