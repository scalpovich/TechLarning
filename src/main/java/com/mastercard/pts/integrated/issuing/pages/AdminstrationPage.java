package com.mastercard.pts.integrated.issuing.pages;

import org.springframework.stereotype.Component;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
public class AdminstrationPage extends AbstractBasePage {
	@PageElement(findBy = FindBy.X_PATH, valueToFind = ".//ul[@class='tabs']/li[2]/a[contains(.,'Card Management')]")
	private MCWebElement CardManagement;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = ".//*[@id='panelContainer']/tbody/tr[3]/td[2]")
	private MCWebElement RupaySettlement;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = ".//span/input[@value='save']")
	private MCWebElement SaveButton;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = ".//*[@id='save']/input[@name='save']")
	private MCWebElement SaveButtonPopUp;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = ".//*[@id='searchbatchType']/select")
	private MCWebElement BatchType;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = ".//*[@id='batchId']/select")
	private MCWebElement BatchId;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = ".//input[@type='submit' and @value='Search']")
	private MCWebElement SearchButton;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = ".//input[@name='encryptionFlag:checkBoxComponent']")
	private MCWebElement EncryReqCheckbox;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = ".//*[@id='publicKey']/span/input[@type='password']")
	private MCWebElement PublicKey;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = ".//*[@id='confPublicKey']/span/input[@type='password']")
	private MCWebElement PublicKeyConfirm;

	public MCWebElement getSaveButtonPopup() {
		return SaveButtonPopUp;
	}

	public MCWebElement getPublicKey() {
		return PublicKey;
	}

	public MCWebElement getConfirmPublicKey() {
		return PublicKeyConfirm;
	}

	public MCWebElement getEncrReqCheckbox() {
		return EncryReqCheckbox;
	}

	public MCWebElement getSearchButton() {
		return SearchButton;
	}

	public MCWebElement getBatchType() {
		return BatchType;
	}

	public MCWebElement getBatchId() {
		return BatchId;
	}

	public MCWebElement getCardManagement() {
		return CardManagement;
	}

	public MCWebElement getRupaySettlement() {
		return RupaySettlement;
	}

	public MCWebElement getSaveButton() {
		// TODO Auto-generated method stub
		return SaveButton;
	}

	public void checkEncryptionRequired() {
		ClickCheckBox(EncryReqCheckbox, true);
	}

	public void selectBatchType_Id(String BatchType, String BatchId) {
		waitForElementVisible(getBatchType());
		SelectDropDownByText(getBatchType(), BatchType);
		waitForElementVisible(getBatchId());
		/*
		 * WebDriverWait wait = new
		 * WebDriverWait(getFinder().getWebDriver(),20);
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='batchId']/select")));
		 */
		// getBatchId().click();
		SelectDropDownByIndex(getBatchId(), 10);

	}

	public void swithToFrame(String FrameName) {
		switchToIframe(FrameName);
	}
}