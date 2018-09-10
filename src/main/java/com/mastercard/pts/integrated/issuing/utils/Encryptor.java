package com.mastercard.pts.integrated.issuing.utils;

import java.util.Arrays;

import org.apache.log4j.Logger;

import com.mastercard.testing.utils.encryption.EncryptUtils;

public class Encryptor {

	private static final Logger logger = Logger.getLogger(Encryptor.class);

	private Encryptor() {
	}

	public static void main(String[] args) {
		System.setProperty("institution", "AUTOBNG [303045]");
		String institutionCode = System.getProperty("institution").substring(System.getProperty("institution").indexOf('[')+1, System.getProperty("institution").length() - 1);
		System.out.println("Code :"+institutionCode);
		Arrays.stream(args).map(Encryptor::encrypt).forEach(logger::info);
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
