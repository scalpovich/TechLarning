package com.mastercard.pts.integrated.issuing.domain;

import java.util.Map;

import org.springframework.stereotype.Component;

/**
 * @author e076177
 *
 */
@Component
public class CreditCardPlan {
private Map<String,String>mandatoryValuesWithLabels;
public Map<String, String> getMandatoryValuesWithLabels() {
	return mandatoryValuesWithLabels;
}

public void setMandatoryValuesWithLabels(Map<String, String> mandatoryValuesWithLabels) {
	this.mandatoryValuesWithLabels = mandatoryValuesWithLabels;
}
}
