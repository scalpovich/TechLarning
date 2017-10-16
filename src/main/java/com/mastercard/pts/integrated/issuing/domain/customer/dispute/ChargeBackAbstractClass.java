package com.mastercard.pts.integrated.issuing.domain.customer.dispute;

public class ChargeBackAbstractClass {
	
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

}
