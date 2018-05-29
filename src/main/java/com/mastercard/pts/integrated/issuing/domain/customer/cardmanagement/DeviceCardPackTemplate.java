package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.utils.MapUtils;

@Component
public class DeviceCardPackTemplate {

	public String Field1;

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
		return Field1;
	}

	public void setField1(String field1) {
		Field1 = field1;
	}

	public String getField2() {
		return Field2;
	}

	public void setField2(String field2) {
		Field2 = field2;
	}

	public String getField3() {
		return Field3;
	}

	public void setField3(String field3) {
		Field3 = field3;
	}

	public String getField4() {
		return Field4;
	}

	public void setField4(String field4) {
		Field4 = field4;
	}

	public String getField5() {
		return Field5;
	}

	public void setField5(String field5) {
		Field5 = field5;
	}

	public String getLength1() {
		return Length1;
	}

	public void setLength1(String length1) {
		Length1 = length1;
	}

	public String getLength2() {
		return Length2;
	}

	public void setLength2(String length2) {
		Length2 = length2;
	}

	public String getLength3() {
		return Length3;
	}

	public void setLength3(String length3) {
		Length3 = length3;
	}

	public String getLength4() {
		return Length4;
	}

	public void setLength4(String length4) {
		Length4 = length4;
	}

	public String getLength5() {
		return Length5;
	}

	public void setLength5(String length5) {
		Length5 = length5;
	}

	public String Field2;
	public String Field3;
	public String Field4;
	public String Field5;
	public String Length1;
	public String Length2;
	public String Length3;
	public String Length4;
	public String Length5;
	public String Field6;
	public String Lengh12;
	public String firstCustomValue12;
	public String secondCustomValue12;
	
	public String getLengh12() {
		return Lengh12;
	}

	public void setLengh12(String Lengh12) {
		this.Lengh12 = Lengh12;
	}
	
	public String getfirstCustomValue12() {
		return firstCustomValue12;
	}

	public void setfirstCustomValue12(String firstCustomValue12) {
		this.firstCustomValue12 = firstCustomValue12;
	}
	
	public String getsecondCustomValue12() {
		return firstCustomValue12;
	}

	public void setsecondCustomValue12(String secondCustomValue12) {
		this.secondCustomValue12 = secondCustomValue12;
	}
	
	public String getField6() {
		return Field6;
	}

	public void setField6(String field6) {
		Field6 = field6;
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
		devicecardpacktemplate.setLengh12(MapUtils.fnGetInputDataFromMap("Lengh12"));
		devicecardpacktemplate.setfirstCustomValue12(MapUtils.fnGetInputDataFromMap("FirstCustomValue12"));
		devicecardpacktemplate.setsecondCustomValue12(MapUtils.fnGetInputDataFromMap("SecondCustomValue12"));
		return devicecardpacktemplate;
	}

}
