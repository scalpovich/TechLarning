package com.mastercard.pts.integrated.issuing.domain.customer.dispute;

import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.dispute.SecondChargeBackNew;
import com.mastercard.pts.integrated.issuing.domain.provider.DataProvider;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;

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
		sb.setSecondChargeBackReasonCode(provider
				.getString("SECONDCHARGEBACK_REASON"));
		sb.setText(provider.getString("TEXT"));
		return sb;
	}

	public static SecondChargeBack createWithProvider(DataProvider provider) {
		return provider.getDataBySimpleClassName(SecondChargeBack.class);
	}

}
