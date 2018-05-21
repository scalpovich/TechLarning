package com.mastercard.pts.integrated.issuing.pages;

import org.springframework.stereotype.Component;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
public class MemberFundCollectionPage extends AbstractBasePage {

	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addMemberFundCollection;

	@PageElement(findBy = FindBy.NAME, valueToFind = "functionCode:input:dropdowncomponent")
	private MCWebElement transactionCodeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "acquirerReferenceData:input:inputTextField")
	private MCWebElement arnTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "transactionAmount:input:inputAmountField")
	private MCWebElement transactionAmountTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "messageReasonCode:input:dropdowncomponent")
	private MCWebElement messageReasonCodeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement saveBtn;

	public void addMemberFundCollectionDisbursement() {
		// public static void main(){
		String[] ARN = { "70000240657777878532225", "10000171797180151457053",
				"70000240657777878532034", "70000240657777878531515",
				"10000171797179105156761" };
		for (int k = 0; k <= ARN.length; k++) {
			for (int i = 1; i <= 2; i++) {
				for (int j = 1; j <= 7; j++) {
					retryUntilNoErrors(() -> ClickButton(addMemberFundCollection));
					addWicketAjaxListeners(getFinder().getWebDriver());
					switchToIframe(Constants.ADD_MEMBER_FUND_FRAME);
					selectDropDownByIndex(transactionCodeDDwn, i);
					addWicketAjaxListeners(getFinder().getWebDriver());
					enterText(arnTxt, ARN[k]);
					addWicketAjaxListeners(getFinder().getWebDriver());
					transactionAmountTxt.click();
					addWicketAjaxListeners(getFinder().getWebDriver());
					selectDropDownByIndex(messageReasonCodeDDwn, j);
					addWicketAjaxListeners(getFinder().getWebDriver());
					ClickButton(saveBtn);
					SwitchToDefaultFrame();

				}

			}
		}

		// for (int k = 0; k <= 7; k++) {
		// retryUntilNoErrors(() -> ClickButton(addMemberFundCollection));
		// addWicketAjaxListeners(getFinder().getWebDriver());
		// switchToIframe(Constants.ADD_MEMBER_FUND_FRAME);
		// List<WebElement> transcodeLength =
		// transactionCodeDDwn.getSelect().getAllSelectedOptions();
		// List<WebElement> messageReasonCodeLength =
		// messageReasonCodeDDwn.getSelect().getAllSelectedOptions();
		// for (int i = 1; i <= transcodeLength.size(); i++) {
		// for (int j = 1; j <= messageReasonCodeLength.size(); j++) {
		// SelectDropDownByIndex(transactionCodeDDwn, i);
		// addWicketAjaxListeners(getFinder().getWebDriver());
		// enterText(arnTxt, "10000171797180151457053");
		// addWicketAjaxListeners(getFinder().getWebDriver());
		// transactionAmountTxt.click();
		// addWicketAjaxListeners(getFinder().getWebDriver());
		// SelectDropDownByIndex(messageReasonCodeDDwn, j);
		// addWicketAjaxListeners(getFinder().getWebDriver());
		// ClickButton(saveBtn);
		// break;
		//
		// }
		// }
		// }
	}

}
