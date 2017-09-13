package com.mastercard.pts.integrated.issuing.pages.agent.inventory;

import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;

@Component
@Navigation(tabTitle = InventoryNav.TAB_INVENTORY, treeMenuItems = { InventoryNav.L1_INVENTORY_STATUS })
public class InventoryStatusPage extends InventoryAbstractPage {
}