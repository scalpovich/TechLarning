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
private boolean errorStatus;


public boolean getErrorStatus() {
	return errorStatus;
}

public void setErrorStatus(boolean errorStatus) {
	this.errorStatus = errorStatus;
}

public Map<String, String> getMandatoryValuesWithLabels() {
	return mandatoryValuesWithLabels;
}

public void setMandatoryValuesWithLabels(Map<String, String> mandatoryValuesWithLabels) {
	this.mandatoryValuesWithLabels = mandatoryValuesWithLabels;
}
}
