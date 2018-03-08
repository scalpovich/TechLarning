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
	private MCWebElement rupayNtkCode;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[contains(.,'06')]/following::a/img[@alt='Delete Recorkjmjuhuiuigd']")
	private MCWebElement deleteRupayNtkCode;

	@PageElement(findBy = FindBy.NAME, valueToFind = "networkLabel:input:inputTextField")
	private MCWebElement retworkDescTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement saveBtn;

	public MCWebElement getRupayNtkCode() {
		return rupayNtkCode;
	}

	public void editNetwork(String ntkCode, String networkdesc) {
		waitForElementVisible(processingcenter.getProcessingCenter());
		WebElement editRupayNtkCode = getFinder().getWebDriver().findElement(
				By.xpath("//td[contains(.,'" + ntkCode
						+ "')]/following::a[1]/img[@alt='Edit Record']"));
		waitForElementVisible(processingcenter.getProcessingCenter());
		retryUntilNoErrors(() -> editRupayNtkCode.click());
		switchToIframe(Constants.EDIT_NETWORK_FRAME);
		addWicketAjaxListeners(getFinder().getWebDriver());
		retworkDescTxt.clearField();
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(retworkDescTxt, networkdesc);
		addWicketAjaxListeners(getFinder().getWebDriver());
		ClickButton(saveBtn);
		SwitchToDefaultFrame();

	}
	

}
