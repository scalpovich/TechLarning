package com.mastercard.pts.integrated.issuing.pages.processingcenter;

import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.utils.MPTSBasePage;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
public class ProcessingCenterPage extends MPTSBasePage {
	
	
	// ------------- For 'Processing Center' Login
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//div[3]/div[2]/ul/div[2]/li/a/span")
	private MCWebElement processingCenter;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//div[3]/div[3]/ul/li[1]")
	private MCWebElement setup;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//div[3]/div[3]/ul/li[1]/ul/li[2]")
	private MCWebElement masterParameters;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//div[3]/div[3]/ul/li/ul/li[2]/ul/li[1]/a")
	private MCWebElement institution;


	
	public void clickProcessingCenterTab(){
		waitForElementVisible(processingCenter);
		processingCenter.click();
	}
	
	public void clickSetupMenu(){
		waitForElementVisible(setup);
		setup.click();
	}
	
	public void clickMasterParametersMenu(){
		waitForElementVisible(masterParameters);
		masterParameters.click();
	}
	
	public void clickInstitutionMenu(){
		waitForElementVisible(institution);
		institution.click();
	}
	
}
