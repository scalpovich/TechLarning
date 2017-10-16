package com.mastercard.pts.integrated.issuing.pages.agent.transactions;


public class TransactionsNav {
	public static final String TAB_TRANSACTIONS = "Transactions";
	
	public static final String L1_LOAD_BALANCE = "cardreloadli";
	
	public static final String L2_LOAD_BALANCE_REQUEST = "CardReloadByMaker";
	public static final String L2_LOAD_BALANCE_VIEW_PENDING_REQUESTS = "ViewCardReloadByMaker";
	public static final String L2_LOAD_BALANCE_APPROVE = "CardReloadByChecker";
		
	public static final String L1_BALANCE_REFUND= "cardrefundli";
	
	public static final String L2_BALANCE_REFUND_REQUEST = "CancelWalletRequestLi";
	public static final String L2_BALANCE_REFUND_APPROVE = "CancelWalletApproveLi";
	
	public static final String L1_CARD_TO_CASH = "moneytransferli";
	
	public static final String L2_CARD_TO_CASH_TRANSACTION = "Remittance";
	public static final String L2_CARD_TO_CASH_LOOKUP = "RemLookup";
	public static final String L2_CANCEL_CARD_TO_CASH = "RemCancel";
	public static final String L2_CASH_REMITTANCE_PAYOUT = "RemPayout";
	
	public static final String L1_OTHERS = "txnothersli";
	
	public static final String L2_OTHERS_TRANSFER_FUNDS = "TransferFunds";
	public static final String L2_OTHERS_VIEW_CHARGES = "ViewCharges";
	public static final String L2_OTHERS_TRANSACTION_HISTORY = "TransactionHistoryLi";
	public static final String L2_OTHERS_BALANCE_ENQUIRY = "BalanceEnquiryLi";
					
	
	private TransactionsNav() {}
}
