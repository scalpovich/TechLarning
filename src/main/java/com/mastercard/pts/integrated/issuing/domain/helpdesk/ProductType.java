package com.mastercard.pts.integrated.issuing.domain.helpdesk;

import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.utils.MiscUtils;

//TODO: Auto-generated Javadoc
/**
 * @author E070234, E074127 The Class ProductType.
 */
@Component
public class ProductType {
	public static final String PREPAID = "Prepaid [P]";
	public static final String CREDIT = "Credit [C]";
	public static final String DEBIT = "Debit [D]";

	private ProductType() {
	}

	public static String fromShortName(String name) {
		return MiscUtils.getConstantStringFromClassByPefixMatch(
				ProductType.class, name);
	}
}
