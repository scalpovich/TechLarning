package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

public class TransactionRoutingPlan  {

	private String messageType;
	private String transactionType;
	private String routingCode;
	private String action;
	
	public String getMessageTypeDdwn() {
		return messageType;
	}

	public void setMessageTypeDdwn(String messageTypeDdwn) {
		this.messageType = messageTypeDdwn;
	}

	public String getTransactionTypeDdwn() {
		return transactionType;
	}

	public void setTransactionTypeDdwn(String transactionTypeDdwn) {
		this.transactionType = transactionTypeDdwn;
	}

	public String getRoutingCodeDdwn() {
		return routingCode;
	}

	public void setRoutingCodeDdwn(String routingCodeDdwn) {
		this.routingCode = routingCodeDdwn;
	}

	public String getActionDdwn() {
		return action;
	}

	public void setActionDdwn(String actionDdwn) {
		this.action = actionDdwn;
	}
	
}
