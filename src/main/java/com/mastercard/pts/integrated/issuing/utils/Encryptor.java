package com.mastercard.pts.integrated.issuing.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.apache.log4j.Logger;

import com.mastercard.testing.utils.encryption.EncryptUtils;

public class Encryptor {

	private static final Logger logger = Logger.getLogger(Encryptor.class);

	private Encryptor() {
	}

	public static void main(String[] args) {
		Arrays.stream(args).map(Encryptor::encrypt).forEach(logger::info);
	}

	private static String encrypt(String text) {
		try {
			DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
			Date date = new Date();
			String localDate= dateFormat.format(date).toString();
			System.out.println(localDate.subSequence(0, 6));
			return EncryptUtils.encrypt(text);
			
		} catch (Exception e) {
			logger.error("Fail to encrypt: " + e);
			MiscUtils.propagate(e);
			return null;
		}
	}
}
