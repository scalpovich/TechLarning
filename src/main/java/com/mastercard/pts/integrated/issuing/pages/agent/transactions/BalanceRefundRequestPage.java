package com.mastercard.pts.integrated.issuing.pages.agent.transactions;

import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;

@Component
@Navigation(tabTitle = TransactionsNav.TAB_TRANSACTIONS,
	treeMenuItems = { TransactionsNav.L1_BALANCE_REFUND,TransactionsNav.L2_BALANCE_REFUND_REQUEST})
public class BalanceRefundRequestPage extends TransactionsAbstractPage {
 }