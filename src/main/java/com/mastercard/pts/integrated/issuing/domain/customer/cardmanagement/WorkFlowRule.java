package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import org.springframework.stereotype.Component;

@Component
public class WorkFlowRule {

	private String fieldName;
	private String operator1;
	private String operator1Value1;
	private String operator1Value2;
	private String operator2;
	private String operator2Value1;
	private String operator2Value2;
	private String insert;
	private String priority;
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public String getOperator1() {
		return operator1;
	}
	public void setOperator1(String operator1) {
		this.operator1 = operator1;
	}
	public String getOperator1Value1() {
		return operator1Value1;
	}
	public void setOperator1Value1(String operator1Value1) {
		this.operator1Value1 = operator1Value1;
	}
	public String getOperator1Value2() {
		return operator1Value2;
	}
	public void setOperator1Value2(String operator1Value2) {
		this.operator1Value2 = operator1Value2;
	}
	public String getOperator2() {
		return operator2;
	}
	public void setOperator2(String operator2) {
		this.operator2 = operator2;
	}
	public String getOperator2Value1() {
		return operator2Value1;
	}
	public void setOperator2Value1(String operator2Value1) {
		this.operator2Value1 = operator2Value1;
	}
	public String getOperator2Value2() {
		return operator2Value2;
	}
	public void setOperator2Value2(String operator2Value2) {
		this.operator2Value2 = operator2Value2;
	}
	public String getInsert() {
		return insert;
	}
	public void setInsert(String insert) {
		this.insert = insert;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	
	
}
