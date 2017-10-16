package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import com.mastercard.pts.integrated.issuing.domain.HasCodeAndDescription;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;

public class DevicePriorityPassIDAndCardPackIDTemplate implements HasCodeAndDescription {
	private static final String TEMPLATE_TYPE_CARDPACKID = "TEMPLATE_TYPE_CARDPACKID";
	private static final String TEMPLATE_TYPE_DEVICE = "TEMPLATE_TYPE_DEVICE";
	private static final String TEMPLATE_TYPE_PRIORITY_PASSID = "TEMPLATE_TYPE_PRIORITY_PASSID";
	private static final String TEMPLATE_LENGTH = "TEMPLATE_LENGTH";
	private static final String SEQUENTIAL_INDICATOR = "SEQUENTIAL_INDICATOR";
	private static final String TABLE_FIRST_RECORD_FIELD = "TABLE_FIRST_RECORD_FIELD";
	private static final String TABLE_FIRST_RECORD_FIELD_CARDPACKID_TEMPLATE = "TABLE_FIRST_RECORD_FIELD_CARDPACKID_TEMPLATE";
	private static final String TABLE_FIRST_RECORD_LENGTH = "TABLE_FIRST_RECORD_LENGTH";
	private static final String TABLE_SECOND_RECORD_FIELD = "TABLE_SECOND_RECORD_FIELD";
	private static final String TABLE_SECOND_RECORD_LENGTH = "TABLE_SECOND_RECORD_LENGTH";
	private static final String TABLE_LAST_RECORD_LENGTH= "TABLE_LAST_RECORD_LENGTH";
	private static final String TABLE_LAST_RECORD_CUSTOM_FIELD_VALUE_1 = "TABLE_LAST_RECORD_CUSTOM_FIELD_VALUE_1";
	private static final String TABLE_LAST_RECORD_CUSTOM_FIELD_VALUE_2 = "TABLE_LAST_RECORD_CUSTOM_FIELD_VALUE_2";

	private String code;
	private String templateType;
	private String templateLength;
	private String indicator;
	private String checkDigit;
	private String tableFirstRecordField;
	private String tableFirstRecordLength;
	private String tableSecondRecordField;
	private String tableSecondRecordLength;
	private String tableLastRecordLength;
	private String tableLastRecordCustomFeildValue1;
	private String tableLastRecordCustomFeildValue2;
	private String description;
	
	public static DevicePriorityPassIDAndCardPackIDTemplate createWithProviderCardPackIDTemplate(KeyValueProvider provider) {
		DevicePriorityPassIDAndCardPackIDTemplate plan = new DevicePriorityPassIDAndCardPackIDTemplate();
		plan.setDescription(ConstantData.GENERIC_DESCRIPTION);
		plan.setTemplateType(provider.getString(TEMPLATE_TYPE_CARDPACKID));
		plan.setTemplateLength(provider.getString(TEMPLATE_LENGTH));
		plan.setTableFirstRecordField(provider.getString(TABLE_FIRST_RECORD_FIELD_CARDPACKID_TEMPLATE));
		return plan;
	}
	
	public static DevicePriorityPassIDAndCardPackIDTemplate createWithProviderDeviceTemplate(KeyValueProvider provider) {
		DevicePriorityPassIDAndCardPackIDTemplate plan = new DevicePriorityPassIDAndCardPackIDTemplate();
		plan.setDescription(ConstantData.GENERIC_DESCRIPTION);
		plan.setTemplateType(provider.getString(TEMPLATE_TYPE_DEVICE));
		plan.setTemplateLength(provider.getString(TEMPLATE_LENGTH));
		plan.setIndicator(provider.getString(SEQUENTIAL_INDICATOR));
		plan.setTableFirstRecordLength(provider.getString(TABLE_FIRST_RECORD_LENGTH));
		plan.setTableSecondRecordField(provider.getString(TABLE_SECOND_RECORD_FIELD));
		plan.setTableSecondRecordLength(provider.getString(TABLE_SECOND_RECORD_LENGTH));
		return plan;
	}
	
	public static DevicePriorityPassIDAndCardPackIDTemplate createWithProviderDevicePriorityPassID(KeyValueProvider provider) {
		DevicePriorityPassIDAndCardPackIDTemplate plan = new DevicePriorityPassIDAndCardPackIDTemplate();
		plan.setDescription(ConstantData.GENERIC_DESCRIPTION);
		plan.setTemplateType(provider.getString(TEMPLATE_TYPE_PRIORITY_PASSID));
		plan.setTemplateLength(provider.getString(TEMPLATE_LENGTH));
		plan.setTableFirstRecordField(provider.getString(TABLE_FIRST_RECORD_FIELD));
		plan.setTableFirstRecordLength(provider.getString(TABLE_FIRST_RECORD_LENGTH));
		plan.setTableLastRecordLength(provider.getString(TABLE_LAST_RECORD_LENGTH));
		plan.setTableLastRecordCustomFeildValue1(provider.getString(TABLE_LAST_RECORD_CUSTOM_FIELD_VALUE_1));
		plan.setTableLastRecordCustomFeildValue2(provider.getString(TABLE_LAST_RECORD_CUSTOM_FIELD_VALUE_2));
		return plan;
	}
	
	@Override
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTemplateType() {
		return templateType;
	}
	public void setTemplateType(String templateType) {
		this.templateType = templateType;
	}
	public String getTemplateLength() {
		return templateLength;
	}
	public void setTemplateLength(String templateLength) {
		this.templateLength = templateLength;
	}
	public String getIndicator() {
		return indicator;
	}
	public void setIndicator(String indicator) {
		this.indicator = indicator;
	}
	public String getCheckDigit() {
		return checkDigit;
	}
	public void setCheckDigit(String checkDigit) {
		this.checkDigit = checkDigit;
	}
	public String getTableFirstRecordField() {
		return tableFirstRecordField;
	}
	public void setTableFirstRecordField(String tableFirstRecordField) {
		this.tableFirstRecordField = tableFirstRecordField;
	}
	public String getTableFirstRecordLength() {
		return tableFirstRecordLength;
	}
	public void setTableFirstRecordLength(String tableFirstRecordLength) {
		this.tableFirstRecordLength = tableFirstRecordLength;
	}
	public String getTableSecondRecordField() {
		return tableSecondRecordField;
	}
	public void setTableSecondRecordField(String tableSecondRecordField) {
		this.tableSecondRecordField = tableSecondRecordField;
	}
	public String getTableSecondRecordLength() {
		return tableSecondRecordLength;
	}
	public void setTableSecondRecordLength(String tableSecondRecordLength) {
		this.tableSecondRecordLength = tableSecondRecordLength;
	}
	public String getTableLastRecordLength() {
		return tableLastRecordLength;
	}
	public void setTableLastRecordLength(String tableLastRecordLength) {
		this.tableLastRecordLength = tableLastRecordLength;
	}
	public String getTableLastRecordCustomFeildValue1() {
		return tableLastRecordCustomFeildValue1;
	}
	public void setTableLastRecordCustomFeildValue1(
			String tableLastRecordCustomFeildValue1) {
		this.tableLastRecordCustomFeildValue1 = tableLastRecordCustomFeildValue1;
	}
	public String getTableLastRecordCustomFeildValue2() {
		return tableLastRecordCustomFeildValue2;
	}
	public void setTableLastRecordCustomFeildValue2(
			String tableLastRecordCustomFeildValue2) {
		this.tableLastRecordCustomFeildValue2 = tableLastRecordCustomFeildValue2;
	}

	@Override
	public String toString() {
		return "DevicePriorityPassIDAndCardPackIDTemplate [code=" + code + ", templateType="
				+ templateType + ", templateLength=" + templateLength + ", indicator=" + indicator
				+ ", checkDigit=" + checkDigit + ", tableFirstRecordField=" + tableFirstRecordField
				+ ", tableFirstRecordLength=" + tableFirstRecordLength
				+ ", tableSecondRecordField=" + tableSecondRecordField
				+ ", tableSecondRecordLength=" + tableSecondRecordLength
				+ ", tableLastRecordLength=" + tableLastRecordLength
				+ ", tableLastRecordCustomFeildValue1=" + tableLastRecordCustomFeildValue1
				+ ", tableLastRecordCustomFeildValue2=" + tableLastRecordCustomFeildValue2
				+ ", description=" + description + "]";
	}
}
