package com.mastercard.pts.integrated.issuing.domain.customer.dispute;

import com.mastercard.pts.integrated.issuing.domain.provider.DataProvider;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;

public class ChargeBackReversal extends ChargeBackAbstractClass {
	
	public static ChargeBackReversal getChargeBackReversal(KeyValueProvider provider)
	{
		ChargeBackReversal cb=new ChargeBackReversal();
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
	
	public static ChargeBackReversal createWithProvider(DataProvider provider) {
		return provider.getDataBySimpleClassName(ChargeBackReversal.class);
	}
	
}
