package com.mastercard.pts.integrated.issuing.pages.agent.inventory;

import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;

@Component
@Navigation(tabTitle = InventoryNav.TAB_INVENTORY, treeMenuItems = { InventoryNav.L1_STOCK_RETURN })
public class StockReturnPage extends InventoryAbstractPage {
}