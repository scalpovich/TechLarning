package com.mastercard.pts.integrated.issuing.domain.customer.dispute;

//import java.util.Arrays;
//import java.util.Collection;

//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedCondition;
import org.springframework.stereotype.Component;


//import com.mastercard.pts.integrated.issuing.domain.customer.dispute.ChargeBack;
//import com.mastercard.pts.integrated.issuing.domain.customer.dispute.ChargeBackAbstractClass;
import com.mastercard.pts.integrated.issuing.domain.customer.dispute.SecondChargeBackNew;
import com.mastercard.pts.integrated.issuing.domain.provider.DataProvider;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;

//import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;

@Component
public class SecondChargeBack extends SecondChargeBackNew {

	public static SecondChargeBack getSecondChargeBack(KeyValueProvider provider) {
		SecondChargeBack sb = new SecondChargeBack();
		sb.setSecondChargeBackAmount(provider
				.getString("SECONDCHARGEBACKAMOUNT"));
		sb.setChargeBackDateGrater(true);
		sb.setCopyRequestRequired(true);
		sb.setDocumentRequired(true);
		sb.setDocumentation(provider.getString("DOCUMENTATION"));
		sb.setFees(true);
		sb.setSecondChargeBackReasonCode(provider.getString("SECONDCHARGEBACK_REASON"));
		sb.setText(provider.getString("TEXT"));
		return sb;
	}

	public static SecondChargeBack createWithProvider(DataProvider provider) {
		return provider.getDataBySimpleClassName(SecondChargeBack.class);
	}
	// public void verifyUiOperationStatus() {
	// verifyOperationStatus("Second Chargeback New");
	// }
	//
	// @Override
	// protected Collection<ExpectedCondition<WebElement>> isLoadedConditions()
	// {
	// return Arrays.asList(
	// WebElementUtils.elementToBeClickable(interDDwn),
	// WebElementUtils.elementToBeClickable(transactionDateDpkr),
	// WebElementUtils.elementToBeClickable(microfilmRefNumber),
	// WebElementUtils.elementToBeClickable(cardNumber));
	// }
}
