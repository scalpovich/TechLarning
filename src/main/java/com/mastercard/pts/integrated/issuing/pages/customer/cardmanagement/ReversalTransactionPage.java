package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import com.mastercard.pts.integrated.issuing.domain.customer.transaction.ReversalTransaction;
import com.mastercard.pts.integrated.issuing.pages.customer.dispute.AbstractDisputePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.utils.DateUtils;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.pts.integrated.issuing.utils.simulator.SimulatorUtilities;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = { CardManagementNav.L1_ACTIVITY, CardManagementNav.L2_TRANSACTION_MANAGEMENT, CardManagementNav.L3_TRANSACTION,
		CardManagementNav.L4_REVERSAL_TRANSACTION })
public class ReversalTransactionPage extends AbstractDisputePage {

	private static final Logger logger = LoggerFactory.getLogger(ReversalTransactionPage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=cardNumber]")
	private MCWebElement cardNumber;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=microfilmRefNumber]")
	private MCWebElement microfilmRefNumber;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@fld_fqn='fromDate']/..")
	private MCWebElement fromDate;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@fld_fqn='toDate']/..")
	private MCWebElement toDate;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=authorizationNumber]")
	private MCWebElement authorizationNumber;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=cancelAmount]")
	private MCWebElement cancelAmount;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "tables:2:rows:6:cols:colspanMarkup:inputField:input:dropdowncomponent")
	private MCWebElement reason;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = ".//*[@alt='Edit Record']")
	private MCWebElement editBtn;

	public void verifyUiOperationStatus() {
		logger.info("Reversal Transaction");
		verifySearchButton("Search");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.elementToBeClickable(cardNumber), WebElementUtils.elementToBeClickable(microfilmRefNumber), WebElementUtils.elementToBeClickable(fromDate),
				WebElementUtils.elementToBeClickable(toDate), WebElementUtils.elementToBeClickable(authorizationNumber));
	}

	public BigDecimal getTransactionReversalAmount(ReversalTransaction rt) {
		logger.info("Get Reversal Transaction Amount: {}", rt.getArn());
		WebElementUtils.enterText(microfilmRefNumber, rt.getArn());
		clickSearchButton();
		return new BigDecimal(getFirstRecordCellTextByColumnName("Transaction Amount"));
	}
	public void searchTransactionForReversal(String deviceNumber, LocalDate transactionDate) {
//		transactionDate = DateUtils.convertTransactionDateInLocalDateFormat("03/08/2023 12:34:23"); // comment out for E2E
		WebElementUtils.enterText(cardNumber, deviceNumber);
		WebElementUtils.pickDate(toDate, transactionDate);
		WebElementUtils.pickDate(fromDate, transactionDate);
		clickSearchButton();
	}
	
	public String addTransactionReversal(String amount, String reversalReason) {
		waitForElementVisible(editBtn);
		editBtn.click();
		SimulatorUtilities.wait(5000);
		runWithinPopup("Add Transaction Reversal", () -> {
			WebElementUtils.enterText(cancelAmount, amount);
			WebElementUtils.selectDropDownByVisibleText(reason, reversalReason);
			clickSaveButton();
			verifyNoErrors();
		});
		return getSuccessMessage();
	}
}