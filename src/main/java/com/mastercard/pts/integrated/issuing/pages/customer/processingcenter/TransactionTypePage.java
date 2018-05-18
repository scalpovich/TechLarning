package com.mastercard.pts.integrated.issuing.pages.customer.processingcenter;

import org.jbehave.core.model.ExamplesTable;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
public class TransactionTypePage extends AbstractBasePage {
	final Logger logger = LoggerFactory.getLogger(NetworkPage.class);

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:4:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement interchangeTypeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:1:componentPanel:input:inputTextField")
	private MCWebElement descriptionSearchTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:4:buttonPanel:buttonCol:searchButton")
	private MCWebElement searchBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "orgFromAtm:checkBoxComponent")
	private MCWebElement originatedFromATMChkBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "orgFromApi:checkBoxComponent")
	private MCWebElement originatedFromAPIChkBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "orgFromCardPortal:checkBoxComponent")
	private MCWebElement originatedFromCardPortalChkBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "orgFromCustPortal:checkBoxComponent")
	private MCWebElement originatedFromCustPortalChkBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "orgFromAgentPortal:checkBoxComponent")
	private MCWebElement originatedFromAgentPortalChkBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "orgFromPos:checkBoxComponent")
	private MCWebElement originatedFromPOSChkBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "orgFromEcom:checkBoxComponent")
	private MCWebElement originatedFromEcomChkBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cancel")
	private MCWebElement closeBtn;

	public void listTransactiontypes(String interchange) {
		selectDropDownByText(interchangeTypeDDwn, interchange);
		addWicketAjaxListeners(getFinder().getWebDriver());
		ClickButton(searchBtn);
	}

	public void viewTransactiontype(ExamplesTable transactiontype)
			throws InterruptedException {
		String DropDownValue = null;
		String transactionTypeCode = null;
		for (int i = 0; i < transactiontype.getRows().size(); i++) {
			DropDownValue = transactiontype.getRow(i).get(
					transactiontype.getHeaders().get(0));
			enterText(descriptionSearchTxt, DropDownValue);
			ClickButton(searchBtn);
			getFinder()
					.getWebDriver()
					.findElement(
							By.xpath("//td[contains(.,'" + DropDownValue
									+ "')]/preceding::a[1]/span")).click();
			addWicketAjaxListeners(getFinder().getWebDriver());
			WebElement transCode = getFinder().getWebDriver().findElement(
					By.xpath("//td[contains(.,'" + DropDownValue
							+ "')]/preceding::a[1]/span"));
			transactionTypeCode = transCode.getText();
			switchToIframe(Constants.VIEW_TRANSACTION_TYPE_FRAME);
			logger.info("Details for the transaction type :- " + DropDownValue
					+ "   and transaction code:- " + transactionTypeCode);
			verifyOptionsSelected(transactionTypeCode);
			ClickButton(closeBtn);
			SwitchToDefaultFrame();

		}

	}

	public void verifyOptionsSelected(String transcode) {
		Assert.assertEquals(true, originatedFromAPIChkBx.isSelected());
		Assert.assertEquals(true, originatedFromCustPortalChkBx.isSelected());
		if (transcode.equals("31")) {
			Assert.assertEquals(true,
					originatedFromAgentPortalChkBx.isSelected());
			Assert.assertEquals(true,
					originatedFromCardPortalChkBx.isSelected());
		}
		if (transcode.equals("01")) {
			Assert.assertEquals(true, originatedFromPOSChkBx.isSelected());
			Assert.assertEquals(true, originatedFromEcomChkBx.isSelected());
		}
		if (!transcode.equals("01")) {
			Assert.assertEquals(true, originatedFromATMChkBx.isSelected());
		}

	}

}
