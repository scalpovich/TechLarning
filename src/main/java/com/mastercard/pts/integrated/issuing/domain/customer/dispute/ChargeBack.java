package com.mastercard.pts.integrated.issuing.domain.customer.dispute;

import com.mastercard.pts.integrated.issuing.domain.provider.DataProvider;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;

public class ChargeBack extends ChargeBackAbstractClass{
	
	
	public static ChargeBack getChargeBack(KeyValueProvider provider)
	{
		ChargeBack cb=new ChargeBack();
		cb.setChargeBackAmount(provider.getString("AMOUNT"));
		cb.setChargeBackDateGrater(true);
		cb.setCopyRequestRequired(true);
		cb.setDocumentRequired(true);
		cb.setDocumentation(provider.getString("DOCUMENTATION"));
		cb.setFees(true);
		cb.setReasonCode(provider.getString("CHARGEBACK_REASON"));
		cb.setText(provider.getString("TEXT"));
		return cb;
	}
	

	public static ChargeBack createWithProvider(DataProvider provider) {
		return provider.getDataBySimpleClassName(ChargeBack.class);
	}
}
