package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.ApplicationBusinessMandatoryFields;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.pts.integrated.issuing.utils.simulator.SimulatorUtilities;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = { CardManagementNav.L1_PROGRAM_SETUP, CardManagementNav.L2_APPLICATION, CardManagementNav.L3_BUSINESS_MANDATORY_FIELDS })
public class ApplicationBusinessMandatoryFieldsPage extends AbstractBasePage {

	private static final Logger logger = LoggerFactory.getLogger(ApplicationBusinessMandatoryFieldsPage.class);

	@Value("${default.wait.timeout_in_sec}")
	private long timeoutInSec;

	@PageElement(findBy = FindBy.CSS, valueToFind = "select[name^=productType]")
	private MCWebElement productTypeDDwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "select[name^=customerType]")
	private MCWebElement customerTypeDDwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "select[name^=fieldName]")
	private MCWebElement fieldNameDDwn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[text()='Product Type']/following-sibling::td//select")
	private MCWebElement productTypeDDwnOnMainScreen;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[text()='Customer Type']/following-sibling::td//select")
	private MCWebElement customerTypeDDwnOnMainScreen;

	@PageElement(findBy = FindBy.CSS, valueToFind = "select[name^=programCode]")
	private MCWebElement programCodeDDwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[name^=bmfmSearchPanel]")
	private MCWebElement searchBtn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[name^='childPanels:1:childdataPanel:inlineTable:container:dataList:0:colList:colHeaders:2:inputField:checkBoxComponent']")
	private MCWebElement checkBoxOneChk;

	@PageElement(findBy = FindBy.NAME, valueToFind = "selectAllFields:checkBoxComponent")
	private MCWebElement selectAllFieldsChkBx;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//div[@class='TransScrollY']//table[@class='dataview']//tr")
	private MCWebElement mandatoryFieldsTable;

	public void verifyUiOperationStatus() {
		logger.info("Program Setup > Application > Business Mandatory Fields");
		verifySearchButton("Search");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.visibilityOf(customerTypeDDwnOnMainScreen), WebElementUtils.visibilityOf(productTypeDDwnOnMainScreen));
	}

	public void selectMandatoryFields(String lst) {
		int rowCount = driver().findElements(By.xpath("//div[@class='TransScrollY']//table[@class='dataview']//tr")).size();
		if (rowCount > 0) {
			String[] fields = lst.trim().split(",");
			for (int i = 0; i < fields.length; i++) {
				for (int j = 2; j <= rowCount; j++) {
					if (driver().findElement(By.xpath("//div[@class='TransScrollY']//table[@class='dataview']//tr[" + j + "]/td[1]")).getText().equalsIgnoreCase(fields[i].trim())) {
						driver().findElement(By.xpath("//div[@class='TransScrollY']//table[@class='dataview']//tr[" + j + "]/td[3]//input")).click();
						break;
					}

				}
			}
		}
	}

	public void addBusinessMandatoryFields(ApplicationBusinessMandatoryFields applicationBusinessMandatoryFields) {
		logger.info("Add Business Mandatory Fields: {}", applicationBusinessMandatoryFields);

		clickAddNewButton();
		runWithinPopup("Add Business Mandatory Fields", () -> {
			WebElementUtils.selectDropDownByVisibleText(productTypeDDwn, applicationBusinessMandatoryFields.getProductType());
			SimulatorUtilities.wait(2000);	
			WebElementUtils.selectDropDownByValue(customerTypeDDwn, applicationBusinessMandatoryFields.getCustomerType());
			SimulatorUtilities.wait(3000);
			WebElementUtils.selectDropDownByVisibleText(programCodeDDwn, applicationBusinessMandatoryFields.getProgramCode());
			clickSearchButton();
			SimulatorUtilities.wait(2000);
			selectMandatoryFields(applicationBusinessMandatoryFields.getMandatoryFields());
			clickSaveButton();

			verifyNoErrors();
		});
		verifyOperationStatus();
	}

	public Optional<String> getLabelMessage(WebElement ele) {
		return getFinder().getWebDriver().findElements((By) ele).stream().map(WebElement::getText).findFirst();
	}

	private void clickOnElementWhenClickable(MCWebElement element) {
		new WebDriverWait(driver(), timeoutInSec).until(WebElementUtils.elementToBeClickable(element)).click();
		waitForWicket();
	}
}
