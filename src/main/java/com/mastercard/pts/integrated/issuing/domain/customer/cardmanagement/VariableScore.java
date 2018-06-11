package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import org.springframework.stereotype.Component;

@Component
public class VariableScore {

	private String program;
	private String fieldName;
	private String rangeStartValue;
	private String rangeEndValue;
	private String score;
	public String getProgram() {
		return program;
	}
	public void setProgram(String program) {
		this.program = program;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public String getRangeStartValue() {
		return rangeStartValue;
	}
	public void setRangeStartValue(String rangeStartValue) {
		this.rangeStartValue = rangeStartValue;
	}
	public String getRangeEndValue() {
		return rangeEndValue;
	}
	public void setRangeEndValue(String rangeEndValue) {
		this.rangeEndValue = rangeEndValue;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	
	
}
