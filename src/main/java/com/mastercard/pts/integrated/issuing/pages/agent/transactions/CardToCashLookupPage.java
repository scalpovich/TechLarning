package com.mastercard.pts.integrated.issuing.pages.agent.transactions;

import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;

@Component
@Navigation(tabTitle = TransactionsNav.TAB_TRANSACTIONS,
	treeMenuItems = { TransactionsNav.L1_CARD_TO_CASH, TransactionsNav.L2_CARD_TO_CASH_LOOKUP})
public class CardToCashLookupPage extends TransactionsAbstractPage {
 }