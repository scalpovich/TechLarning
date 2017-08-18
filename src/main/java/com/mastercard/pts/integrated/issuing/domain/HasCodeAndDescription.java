package com.mastercard.pts.integrated.issuing.domain;

public interface HasCodeAndDescription {

	String getCode();
	
	String getDescription();
	
	default String buildDescriptionAndCode() {
		return String.format("%s [%s]", getDescription(), getCode());
	}
}
