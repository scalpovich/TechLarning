package com.mastercard.pts.integrated.issuing.domain.customer.dispute;

public class SecondChargeBackNew {

	private String SecondchargeBackAmount;
	private String SecondchargeBackreasonCode;
	private String SecondChargeBackdocumentation;
	private boolean SecondChargeBackfees;
	private String text;
	private boolean isChargeBackDateGrater;
	private boolean isCopyRequestRequired;
	private boolean isDocumentRequired;
	private String arn;

	public String getSecondChargeBackAmount() {
		return SecondchargeBackAmount;
	}

	public void setSecondChargeBackAmount(String SecondchargeBackAmount) {
		this.SecondchargeBackAmount = SecondchargeBackAmount;
	}

	public String getSecondChargeBackReasonCode() {
		return SecondchargeBackreasonCode;
	}

	public void setSecondChargeBackReasonCode(String SecondchargeBackreasonCode) {
		this.SecondchargeBackreasonCode = SecondchargeBackreasonCode;
	}

	public String getDocumentation() {
		return SecondChargeBackdocumentation;
	}

	public void setDocumentation(String SecondChargeBackdocumentation) {
		this.SecondChargeBackdocumentation = SecondChargeBackdocumentation;
	}

	public boolean isFees() {
		return SecondChargeBackfees;
	}

	public void setFees(boolean SecondChargeBackfees) {
		this.SecondChargeBackfees = SecondChargeBackfees;
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

}
