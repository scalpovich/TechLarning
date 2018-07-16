package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.utils.MapUtils;

@Component
public class DeviceCardPackTemplate {

	public String field1;

	public String cardpackID;

	public String DeviceNumberFromQuery;

	public String PreGeneratedCardFlag;

	public String getPreGeneratedCardFlag() {
		return PreGeneratedCardFlag;
	}

	public void setPreGeneratedCardFlag(String preGeneratedCardFlag) {
		PreGeneratedCardFlag = preGeneratedCardFlag;
	}

	public String getDeviceNumberFromQuery() {
		return DeviceNumberFromQuery;
	}

	public void setDeviceNumberFromQuery(String deviceNumberFromQuery) {
		DeviceNumberFromQuery = deviceNumberFromQuery;
	}

	public String getCardpackID() {
		return cardpackID;
	}

	public void setCardpackID(String cardpackID) {
		this.cardpackID = cardpackID;
	}

	public String getField1() {
		return field1;
	}

	public void setField1(String field1) {
		this.field1 = field1;
	}

	public String getField2() {
		return field2;
	}

	public void setField2(String field2) {
		this.field2 = field2;
	}

	public String getField3() {
		return field3;
	}

	public void setField3(String field3) {
		this.field3 = field3;
	}

	public String getField4() {
		return field4;
	}

	public void setField4(String field4) {
		this.field4 = field4;
	}

	public String getField5() {
		return field5;
	}

	public void setField5(String field5) {
		this.field5 = field5;
	}

	public String getLength1() {
		return length1;
	}

	public void setLength1(String length1) {
		this.length1 = length1;
	}

	public String getLength2() {
		return length2;
	}

	public void setLength2(String length2) {
		this.length2 = length2;
	}

	public String getLength3() {
		return length3;
	}

	public void setLength3(String length3) {
		this.length3 = length3;
	}

	public String getLength4() {
		return length4;
	}

	public void setLength4(String length4) {
		this.length4 = length4;
	}

	public String getLength5() {
		return length5;
	}

	public void setLength5(String length5) {
		this.length5 = length5;
	}

	public String field2;
	public String field3;
	public String field4;
	public String field5;
	public String length1;
	public String length2;
	public String length3;
	public String length4;
	public String length5;
	public String field6;
	public String length12;
	public String firstCustomValue12;
	public String secondCustomValue12;
	
	public String getLength12() {
		return length12;
	}

	public void setLength12(String length12) {
		this.length12 = length12;
	}
	
	public String getFirstCustomValue12() {
		return firstCustomValue12;
	}

	public void setFirstCustomValue12(String firstCustomValue12) {
		this.firstCustomValue12 = firstCustomValue12;
	}
	
	public String getSecondCustomValue12() {
		return firstCustomValue12;
	}

	public void setSecondCustomValue12(String secondCustomValue12) {
		this.secondCustomValue12 = secondCustomValue12;
	}
	
	public String getField6() {
		return field6;
	}

	public void setField6(String field6) {
		this.field6 = field6;
	}

	public static DeviceCardPackTemplate deviceCardPackTemplateDataProvider() {
		DeviceCardPackTemplate devicecardpacktemplate = new DeviceCardPackTemplate();
		devicecardpacktemplate.setField1(MapUtils.fnGetInputDataFromMap("Field1"));
		devicecardpacktemplate.setField2(MapUtils.fnGetInputDataFromMap("Field2"));
		devicecardpacktemplate.setField3(MapUtils.fnGetInputDataFromMap("Field3"));
		devicecardpacktemplate.setField4(MapUtils.fnGetInputDataFromMap("Field4"));
		devicecardpacktemplate.setLength1(MapUtils.fnGetInputDataFromMap("Length1"));
		devicecardpacktemplate.setLength2(MapUtils.fnGetInputDataFromMap("Length2"));
		devicecardpacktemplate.setLength3(MapUtils.fnGetInputDataFromMap("Length3"));
		devicecardpacktemplate.setLength4(MapUtils.fnGetInputDataFromMap("Length4"));
		devicecardpacktemplate.setField5(MapUtils.fnGetInputDataFromMap("Field5"));
		devicecardpacktemplate.setLength5(MapUtils.fnGetInputDataFromMap("Length5"));
		devicecardpacktemplate.setField6(MapUtils.fnGetInputDataFromMap("Field6"));
		devicecardpacktemplate.setLength12(MapUtils.fnGetInputDataFromMap("Length12"));
		devicecardpacktemplate.setFirstCustomValue12(MapUtils.fnGetInputDataFromMap("FirstCustomValue12"));
		devicecardpacktemplate.setSecondCustomValue12(MapUtils.fnGetInputDataFromMap("SecondCustomValue12"));
		return devicecardpacktemplate;
	}

}
