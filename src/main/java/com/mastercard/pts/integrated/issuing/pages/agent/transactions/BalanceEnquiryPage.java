package com.mastercard.pts.integrated.issuing.pages.agent.transactions;

import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;

@Component
@Navigation(tabTitle = TransactionsNav.TAB_TRANSACTIONS, treeMenuItems = { TransactionsNav.L1_OTHERS, TransactionsNav.L2_OTHERS_BALANCE_ENQUIRY })
public class BalanceEnquiryPage extends TransactionsAbstractPage {
}