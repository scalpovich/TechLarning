package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

public class TransactionRoutingPlan  {

	private String messageTypeDdwn;
	private String transactionTypeDdwn;
	private String routingCodeDdwn;
	private String actionDdwn;
	
	public String getMessageTypeDdwn() {
		return messageTypeDdwn;
	}

	public void setMessageTypeDdwn(String messageTypeDdwn) {
		this.messageTypeDdwn = messageTypeDdwn;
	}

	public String getTransactionTypeDdwn() {
		return transactionTypeDdwn;
	}

	public void setTransactionTypeDdwn(String transactionTypeDdwn) {
		this.transactionTypeDdwn = transactionTypeDdwn;
	}

	public String getRoutingCodeDdwn() {
		return routingCodeDdwn;
	}

	public void setRoutingCodeDdwn(String routingCodeDdwn) {
		this.routingCodeDdwn = routingCodeDdwn;
	}

	public String getActionDdwn() {
		return actionDdwn;
	}

	public void setActionDdwn(String actionDdwn) {
		this.actionDdwn = actionDdwn;
	}
	
}
