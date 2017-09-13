/**
 * 
 */
package com.mastercard.pts.integrated.issuing.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;


public class DateUtils {
	
	private static final int DEFAULT_KEY_LENGTH = 10;
	
    public static String currentDateddMMyyyy(){
    	Date date = new Date();
        String format = "dd/MM/yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }
	
	public static String getDateTimeDDMMYYYYHHMMSS() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyyHHmmss");
		return sdf.format(cal.getTime());
	}
	
	public static String getEffectiveDate(){
		Calendar c = Calendar.getInstance();   
		c.add(Calendar.MONTH, 1);   
		return new SimpleDateFormat("MM/dd/yyyy").format(c.getTime());
	} 
	
	public static String getDate() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyy");
		return sdf.format(cal.getTime());
	}

	public static String getDateMMDD() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("MMdd");
		return sdf.format(cal.getTime());
	}

	public static String getDateyyMMdd() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
		return sdf.format(cal.getTime());
	}

	public static String getDateddMMyyyy() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
		return sdf.format(cal.getTime());
	}

	public static String getDateddDashMMDashyyyy() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		return sdf.format(cal.getTime());
	}

	public String getDateyyyyMMdd() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		return sdf.format(cal.getTime());
	}

	public static String getDateyyyy() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		return sdf.format(cal.getTime());
	}

	public static String getDateMMyyyy() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("MMyyyy");
		return sdf.format(cal.getTime());
	}

	public static String getDateYYMM() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("YYMM");
		return sdf.format(cal.getTime());
	}

	public static String getTime() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
		return sdf.format(cal.getTime());
	}

	public static String getTimeSpecificFormat() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		return sdf.format(cal.getTime());
	}

	public static String addressLine(int number) {
		return org.apache.commons.lang.RandomStringUtils.random(number, false, true);
	}
	
	public static String generateStringWithUniqueKey(String text) {
		return generateStringWithUniqueKey(text, DEFAULT_KEY_LENGTH);
	}

	public static String generateStringWithUniqueKey(String text, int keyLength) {
		return text + generateUniqueKey(keyLength);
	}

	public static String generateUniqueKey() {
		return generateUniqueKey(DEFAULT_KEY_LENGTH);
	}

	public static String generateUniqueKey(int keyLength) {
		long ts = new Date().getTime();
		return StringUtils.right(Long.toString(ts), keyLength);
	}
}
