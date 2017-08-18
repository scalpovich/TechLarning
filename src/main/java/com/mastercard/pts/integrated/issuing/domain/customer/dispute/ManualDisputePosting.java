package com.mastercard.pts.integrated.issuing.domain.customer.dispute;

public class ManualDisputePosting {
private String arn;
private String disputeType;
public String getArn() {
	return arn;
}
public void setArn(String arn) {
	this.arn = arn;
}
public String getDisputeType() {
	return disputeType;
}
public void setDisputeType(String disputeType) {
	this.disputeType = disputeType;
}

}
