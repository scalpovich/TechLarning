package com.mastercard.pts.integrated.issuing.pages.customer.processingcenter;

import net.serenitybdd.core.annotations.findby.By;


import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
public class NetworkPage extends AbstractBasePage {
	@Autowired
	ProcessingCenterPage processingcenter;

	final Logger logger = LoggerFactory.getLogger(NetworkPage.class);

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//a/span[contains(text(),'06')]")
	private MCWebElement RupayNtkCode;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[contains(.,'06')]/following::a/img[@alt='Delete Recorkjmjuhuiuigd']")
	private MCWebElement DeleteRupayNtkCode;

	@PageElement(findBy = FindBy.NAME, valueToFind = "networkLabel:input:inputTextField")
	private MCWebElement NetworkDescTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement SaveBtn;

	public MCWebElement getRupayNtkCode() {
		return RupayNtkCode;
	}

	public void editNetwork(String ntkCode, String networkdesc) {
		waitForElementVisible(processingcenter.getProcessingCenter());
		WebElement EditRupayNtkCode = getFinder().getWebDriver().findElement(
				By.xpath("//td[contains(.,'" + ntkCode
						+ "')]/following::a[1]/img[@alt='Edit Record']"));
		waitForElementVisible(processingcenter.getProcessingCenter());
		retryUntilNoErrors(() -> EditRupayNtkCode.click());
		switchToIframe(Constants.EDIT_NETWORK_FRAME);
		addWicketAjaxListeners(getFinder().getWebDriver());
		NetworkDescTxt.clearField();
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(NetworkDescTxt, networkdesc);
		addWicketAjaxListeners(getFinder().getWebDriver());
		ClickButton(SaveBtn);
		SwitchToDefaultFrame();

	}
	
	public void isInterchagePresent(String interchangeText){
		
		
		System.out.println(getCellTextByColumnName(6, "Network Description"));
	}

}
