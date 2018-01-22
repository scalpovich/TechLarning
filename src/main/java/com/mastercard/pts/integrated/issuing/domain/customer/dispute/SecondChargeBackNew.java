package com.mastercard.pts.integrated.issuing.domain.customer.dispute;

public class SecondChargeBackNew {

	private String secondChargeBackAmount;
	private String secondChargeBackreasonCode;
	private String secondChargeBackDocumentation;
	private boolean secondChargeBackFees;
	private String text;
	private boolean isChargeBackDateGreater;
	private boolean isCopyRequestRequired;
	private boolean isDocumentRequired;
	private String arn;

	public String getSecondChargeBackAmount() {
		return secondChargeBackAmount;
	}

	public void setSecondChargeBackAmount(String secondChargeBackAmount) {
		this.secondChargeBackAmount = secondChargeBackAmount;
	}

	public String getSecondChargeBackReasonCode() {
		return secondChargeBackreasonCode;
	}

	public void setSecondChargeBackReasonCode(String secondChargeBackReasonCode) {
		this.secondChargeBackreasonCode = secondChargeBackReasonCode;
	}

	public String getDocumentation() {
		return secondChargeBackDocumentation;
	}

	public void setDocumentation(String secondChargeBackDocumentation) {
		this.secondChargeBackDocumentation = secondChargeBackDocumentation;
	}

	public boolean getFees() {
		return secondChargeBackFees;
	}

	public void setFees(boolean secondChargeBackFees) {
		this.secondChargeBackFees = secondChargeBackFees;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public boolean isChargeBackDateGreater() {
		return isChargeBackDateGreater;
	}

	public void setChargeBackDateGrater(boolean isChargeBackDateGreater) {
		this.isChargeBackDateGreater = isChargeBackDateGreater;
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
