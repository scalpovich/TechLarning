package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

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
	
	//@Value("${institution}")
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
		institution = System.getProperty("institution").toString();
		return institution.substring(institution.indexOf('[') + 1, institution.indexOf(']'));
	}

	public void updateInstituteDateToGivenDays(String date, String noOfDays) {
		daysDifference = DateUtils.getNextDate(date);
		logger.info("Diffrence Days : " + daysDifference);
		daysDifference = daysDifference + Integer.parseInt(noOfDays);
		String queryString = "update system_codes set short_name='-" + daysDifference
				+ "'  WHERE TYPE_ID = 'SYS_PARAM' AND code = 'BACK_DAY' AND bank_code = '" + getInstitutionCode() + "'";
		dbUtil.executeUpdate(queryString);

	}
	
	public void updateLoyaltyExpiryDate(String expiryDate, String cardNumber) {
		String queryString = "update lyt_pts_earned set LPE_EXPIRY_DATE='" + expiryDate + "' where CARD_NUMBER='" + cardNumber + "'";
		dbUtil.executeUpdate(queryString);
	}

	public void addAdjustmentTransaction(String deviceNo, String bankCode, String amnt) {
		String queryString = "update wallet set balance='" + amnt + "' where bank_code='" + bankCode + "' and wallet_number=(select wallet_number from DEVICE_WALLET_LINK where device_number='" + deviceNo + "' and bank_code='" + bankCode + "')";
		dbUtil.executeUpdate(queryString);
	}
	
	public void activateLoyaltyPlan(String planCode, String bankCode) {
		String queryString = "update LYT_PLAN_DEF set LYT_EXPIRY_FLG='A' where BANK_CODE='" + bankCode + "' and LYT_PLAN_CODE='" + planCode + "'";
		dbUtil.executeUpdate(queryString);
	}

	public void updatePromotionExpiryDate(String expiryDate, String promoCode, String instiCode) {
		String queryString = "update Lyt_Promotion_Def set LYP_EXPIRY_DTTM='" + expiryDate + "' where LYP_PROMOTION_CODE='" + promoCode + "' and bank_code='" + instiCode + "'";
		dbUtil.executeUpdate(queryString);
	}
}
