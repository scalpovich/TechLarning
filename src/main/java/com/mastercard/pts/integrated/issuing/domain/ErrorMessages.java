package com.mastercard.pts.integrated.issuing.domain;

import java.util.Arrays;
import java.util.Map;

import org.hamcrest.StringDescription;
import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.ErrorValMsgProvider;
import com.mastercard.pts.integrated.issuing.utils.SoftAssert;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;

import net.serenitybdd.core.annotations.findby.By;

@Component
public class ErrorMessages extends AbstractBasePage {

	@Autowired
	private WebDriverProvider driverProvider;
	public static String thisFieldIsReq;

	public static String NA = "";

	@Value("${mandatory.field.message}")
	public void setthisFieldIsReq(String s) {
		thisFieldIsReq = s;
	}

	public static String alphaNumStartEnd;

	@Value("${alphaNumStart&End.field.message}")
	public void setalphaNumStartEnd(String s) {
		alphaNumStartEnd = s;
	}

	public static String wholeNo;

	@Value("${wholeNo.field.message}")
	public void setWholeNo(String s) {
		wholeNo = s;
	}

	@Value("${textBox.xpath}")
	public String TXTBXXPATH;
	@Value("${errMsgBox.xpath}")
	public String ERRMSGXPATH;

	String[] alphaNumErrData = { "onlyalpha", "abc232", "$%*&" };
	String[] wholeNoData = { "rom", "a12", "*&^" };

	public StringDescription decideErrorValMethod(String fieldName, String errMsg, MCWebElement submitBtn,
			SoftAssert softAssert) {

		if (errMsg.equals(alphaNumStartEnd)) {
			return errorTextBoxVal(errMsg, fieldName, submitBtn, alphaNumErrData, softAssert);
		} else if (errMsg.equals(wholeNo)) {
			return errorTextBoxVal(errMsg, fieldName, submitBtn, wholeNoData, softAssert);
		} else {
			return softAssert.getDescription();
		}
	}

	private StringDescription errorTextBoxVal(String errMsg, String fieldName, MCWebElement submitBtn, String[] errData,
			SoftAssert softAssert) {
		String txtBxXpath = String.format(TXTBXXPATH, fieldName);
		String errMsgXpath = String.format(ERRMSGXPATH, fieldName);

		for (String data : errData) {

			enterText(getElement(txtBxXpath), data);
			Scrolldown(submitBtn);
			submitBtn.click();
			softAssert.andThat(errMsg, getElement(errMsgXpath).getText(), fieldName);
			getElement(txtBxXpath).clear();
		}
		return validate(softAssert.getDescription(), Arrays.toString(errData));
	}

	private WebElement getElement(String xpath) {

		org.openqa.selenium.By locator = By.xpath(xpath);
		return fluentWait(() -> driverProvider.get().findElement(locator));
	}

	private StringDescription validate(StringDescription stringDescription, String errData) {
		if (!stringDescription.toString().isEmpty() && stringDescription != null) {
			stringDescription.appendText("\nfor data: ");
			stringDescription.appendValue(errData);
		}
		return stringDescription;

	}

	public <T extends Enum<T> & ErrorValMsgProvider> void doFieldValidation(Class<T> feildValdiations,
			MCWebElement submitBtn) {
		try {
			SoftAssert sa = new SoftAssert();
			for (T c : feildValdiations.getEnumConstants()) {
				String[] val = c.getFieldsVal();
				String fieldName = val[0];
				String errMsg = val[2];
				if (!"NA".equals(errMsg)) {
					decideErrorValMethod(fieldName, errMsg, submitBtn, sa);
				}
			}
			sa.assertAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public <T extends Enum<T> & ErrorValMsgProvider> void doManDatoryErrorValidation(Map<String, String> pageError,
			Class<T> feildValdiations) {
		try {
			SoftAssert sa = new SoftAssert();
			for (T c : feildValdiations.getEnumConstants()) {
				String[] val = c.getFieldsVal();
				String fieldName = val[0];
				String errMsg = val[1];
				sa.andThat(pageError.get(fieldName), errMsg, fieldName);
			}
			sa.assertAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
