package com.mastercard.pts.integrated.issuing.pages.customer.dispute;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;

@Component
@Navigation(tabTitle = DisputeNav.TAB_DISPUTE, treeMenuItems = {
		DisputeNav.L1_SETUP, DisputeNav.L2_DISPUTE_REASON_CODE,
		DisputeNav.L3_RETRIEVAL_REQUEST_REASON_CODE}
)
public class RetrievalRequestReasonCodePage extends AbstractDisputePage {

	public void verifyUiOperationStatus() {
		verifyOperationStatus("Retrieval Request Reason Code");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(interchangeDDwn),
				WebElementUtils.elementToBeClickable(reasonCodeTxt));
	}
}
