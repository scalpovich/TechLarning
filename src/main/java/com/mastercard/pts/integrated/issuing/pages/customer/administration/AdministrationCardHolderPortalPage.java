package com.mastercard.pts.integrated.issuing.pages.customer.administration;

import com.mastercard.pts.integrated.issuing.domain.ProductType;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.WalletFeePlan;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
@Navigation(tabTitle = AdministrationNav.TAB_ADMINISTRATION, treeMenuItems = {
		AdministrationNav.L1_SETUP,
		AdministrationNav.L2_CARD_HOLDER_CONFIG
		})
public class AdministrationCardHolderPortalPage  extends AbstractBasePage{

	private static final Logger logger = LoggerFactory.getLogger(AdministrationCardHolderPortalPage.class);
	
	
	@Autowired
	Navigator navigator;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind="//a[@class='addR']")
	private MCWebElement addProgramConfig; 
	
	@PageElement(findBy = FindBy.NAME, valueToFind="productType:input:dropdowncomponent")
	private MCWebElement selectProductType;
	
	@PageElement(findBy = FindBy.NAME, valueToFind="programCode:input:dropdowncomponent")
	private MCWebElement selectProgramCode;	
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "select[name^=menuPalette]")
	private MCWebElement availableMenusLstBx;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "button.add")
	private MCWebElement addMenuOpts;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind="//input[@value='Save']")
	private MCWebElement saveMenuBtn;
	
	
	public void clickAddMenuConfig(){
		clickWhenClickable(addProgramConfig);
	}
	
	public void navigateToCardHolderConfigPage(){
		navigator.navigateToPage(AdministrationCardHolderPortalPage.class);
	}
	
	public void selectProductByType(String productType){	
		WebElementUtils.selectDropDownByVisibleText(selectProductType, productType);		
	}
	
	public void selectProgramByCode(String productCode){	
		logger.info("Program Code: {}", productCode);
		waitForElementVisible(selectProgramCode);
		WebElementUtils.selectDropDownByVisibleText(selectProgramCode, productCode);
	}
	
	public void selectMenuOptions(MCWebElement availableMenusLstBx){
		WebElementUtils.selectAllOptionsInListBox(availableMenusLstBx);
	}
	
	public void addSelectedMenus(){
		clickWhenClickable(addMenuOpts);
	}
	
	public void saveMenuAccess(){
		clickWhenClickable(saveMenuBtn);
	}
	//Method to add menus
	public void addMenusToAccessForCardHolderPortal(String productType,String programCode){
		logger.info("Add menus for program: {}", programCode);
		clickAddMenuConfig();
		
		runWithinPopup(
				"Add", 
				() ->{
					selectProductByType(productType);
					selectProgramByCode(programCode);
					selectMenuOptions(availableMenusLstBx);
					addSelectedMenus();
					saveMenuAccess();
				});
				
		
	}
}
