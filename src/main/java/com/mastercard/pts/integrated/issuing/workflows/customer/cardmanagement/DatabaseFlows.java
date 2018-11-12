package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.pages.customer.helpdesk.HelpdeskGeneralPage;
import com.mastercard.pts.integrated.issuing.utils.DBUtility;
import com.mastercard.pts.integrated.issuing.utils.DateUtils;

@Component
public class DatabaseFlows {
	private static final Logger logger = LoggerFactory.getLogger(DatabaseFlows.class);
	String columnValue;
	
	private static final String COLUMN_STATUS_NULL = "NULL";
	private static final String COLUMN_STATUS_NON_NULL = "NON_NULL";
	
	@Autowired
	private DBUtility dbUtil;	
	
	@Value("${institution}")
	private String institution;

	private static int daysDifference;
	public void updateInstituteDateToFirstOfNextMonth(String date) {

		daysDifference=DateUtils.getNextMonthFirstDayDifference(date);
		logger.info("Difference Days : "+daysDifference);
		String queryString = "update system_codes set short_name='-" + daysDifference
				+ "'  WHERE TYPE_ID = 'SYS_PARAM' AND code = 'BACK_DAY' AND bank_code = '" + getInstitutionCode() + "'";
		dbUtil.executeUpdate(queryString);
	}

	public void assertColumnStatus(Device device, String columnName, String expectedColumnValue) {
		String queryString = "Select " + columnName + " from CARD_SCRIPT_QUEUE where device_number = '" + device.getDeviceNumber() + "'";
		columnValue = dbUtil.getSingleRecordColumnValueFromDB(queryString, columnName);
		logger.info("Applicaton Block Value is :- {}" + columnValue);
		if (expectedColumnValue.equalsIgnoreCase(COLUMN_STATUS_NULL)) {
			if (columnValue == null) {
				assertTrue("Application Block/Unblock Value is" + columnValue, true);
			} else {
				assertTrue("Application Block/Unblock Value is" + columnValue, false);
			}
		}
		if (expectedColumnValue.equalsIgnoreCase(COLUMN_STATUS_NON_NULL)) {
			if (columnValue != null) {
				assertTrue("Application Block/Unblock Value is" + columnValue, true);
			} else {
				assertTrue("Application Block/Unblock Value is" + columnValue, false);
			}
		}

	}

	public String getInstitutionCode() {
		return institution.substring(institution.indexOf('[') + 1, institution.indexOf(']'));
	}

	public void updateInstituteDateToGivenDays(String date, String noOfDays) {
		daysDifference = DateUtils.getNextDate(date);
		logger.info("Diffrence Days : " + daysDifference);
		if (noOfDays.equalsIgnoreCase("next") || noOfDays.equalsIgnoreCase("one")) {
			daysDifference = daysDifference + 1;
		} else if (noOfDays.equalsIgnoreCase("three")) {
			daysDifference = daysDifference + 3;
		} else if (noOfDays.equalsIgnoreCase("21")) {
			daysDifference = daysDifference + 20;
		}else {
			daysDifference = daysDifference + Integer.parseInt(noOfDays);
}

		logger.info("Diffrence Days : " + daysDifference);
		String queryString = "update system_codes set short_name='-" + daysDifference
				+ "'  WHERE TYPE_ID = 'SYS_PARAM' AND code = 'BACK_DAY' AND bank_code = '" + getInstitutionCode() + "'";
		dbUtil.executeUpdate(queryString);

	}
}
