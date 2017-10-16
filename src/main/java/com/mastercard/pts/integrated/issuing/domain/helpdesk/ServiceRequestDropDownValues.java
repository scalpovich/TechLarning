package com.mastercard.pts.integrated.issuing.domain.helpdesk;

import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.utils.MiscUtils;

//TODO: Auto-generated Javadoc
/**
 * @author E070234, E074127 The Class ProductType.
 */
@Component
public class ServiceRequestDropDownValues {
	public static final String BLOCK_REASON_NAMES = "Lost [5]";
	public static final String FOUNDCRAD = "Found card [1]";
	public static final String CAPTURECARD = "capture card [2]";
	public static final String BANKDECISION = "Bank decision [3]";
	public static final String STOPLISTCARD = "Stoplist card [5]";
	public static final String OVERDUE = "Overdue card [4]";
	public static final String MISCELLANEOUS = "Miscellaneous [6]";
	public static final String REPLACEMNT_CANCEL = "Replacement Cancellation [8]";
	public static final String UNBLOCKED_CRARD = "Unblocked card [7]";
	public static final String LIFELONGACTIVATION = "Life Long Activation [Life Long Activate]";
	public static final String IMMEDIATEACTIVATION = "Immediate Activation for n Hrs [Immediate Activation for n Hrs]";
	public static final String ACTIVATIONINPERIOD = "Activation in Period [Activation in Period]";
	public static final String INTERNATIONALACTIVATE = "Activate [1]";
	public static final String INTERNATIONDEACTIVATE = "Deactivate [0]";
	public static final String BLOCKREASON = "Card Lost [5]";

	ServiceRequestDropDownValues() {

	}

	public static String fromShortName(String name) {
		return MiscUtils.getConstantStringFromClassByPefixMatch(
				ServiceRequestDropDownValues.class, name);
	}

}
