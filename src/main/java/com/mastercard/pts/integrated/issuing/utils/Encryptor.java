package com.mastercard.pts.integrated.issuing.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;

import com.mastercard.testing.utils.encryption.EncryptUtils;

public class Encryptor {

	private static final Logger logger = Logger.getLogger(Encryptor.class);

	private Encryptor() {
	}

	public static void main(String[] args){
		
		LocalDate localDate = LocalDate.now();
		logger.info("localDate date :"+localDate);
		LocalDate convertedDate = LocalDate.parse("10 Jul 2022 14:16:43", DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm:ss"));
		logger.info("Coverted Institution date :"+convertedDate);
		logger.info("Diffrence Days :"+ChronoUnit.DAYS.between(localDate, convertedDate));
	}

	private static String encrypt(String text) {
		try {
			return EncryptUtils.encrypt(text);
			
		} catch (Exception e) {
			logger.error("Fail to encrypt: " + e);
			MiscUtils.propagate(e);
			return null;
		}
	}
}
