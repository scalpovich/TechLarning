package com.mastercard.pts.integrated.issuing.domain;

import com.mastercard.pts.integrated.issuing.utils.MiscUtils;

public class ProductType {

	public static final String PREPAID = "Prepaid [P]";
	public static final String Prepaid = "Prepaid";
	public static final String CREDIT = "Credit [C]";
	public static final String DEBIT = "Debit [D]";
	public static final String Debit = "Debit";
	public static final String Credit = "Credit";
	public static final String CORPORATE = "Corporate [1]";
	public static final String INDIVIDUAL = "Individual [0]";
	public static final String Corporate = "Corporate [1]";
	public static final String Individual = "Individual [0]";

	private ProductType() {
	}

	/**
	 * @param name
	 *            of product, e.g. "credit" or "Prepaid"
	 * @return product type in application format, e.g. "Prepaid [P]"
	 */
	public static String fromShortName(String name) {
		return MiscUtils.getConstantStringFromClassByPefixMatch(ProductType.class, name);
	}
}
