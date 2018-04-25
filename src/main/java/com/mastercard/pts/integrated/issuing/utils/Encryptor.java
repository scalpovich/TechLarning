package com.mastercard.pts.integrated.issuing.utils;

import java.util.Arrays;

import org.apache.log4j.Logger;

import com.mastercard.testing.utils.encryption.EncryptUtils;

public class Encryptor {

	private static final Logger logger = Logger.getLogger(Encryptor.class);

	private Encryptor() {
	}

	public static void main(String[] args) {
		Arrays.stream(args).map(Encryptor::encrypt).forEach(logger::info);
		encrypt("");
	}

	private static String encrypt(String text) {
		try {
			System.out.println(EncryptUtils.decrypt("bakWjTx+z+KRux09xkfnXQ=="));
			return EncryptUtils.decrypt("bakWjTx+z+KRux09xkfnXQ==");
			
		} catch (Exception e) {
			logger.error("Fail to encrypt: " + e);
			MiscUtils.propagate(e);
			return null;
		}
	}
}
