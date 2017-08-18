package com.mastercard.pts.integrated.issuing.utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;

public class FileCreation {
	private static final Logger logger = LoggerFactory.getLogger(FileCreation.class);
	private static final String INSTITUTION_CODE = "INSTITUTION_CODE";

	private static final String BILLING_AMOUNT = "BILLING_AMOUNT";

	private static final String BILLING_CURRENCY = "BILLING_CURRENCY";

	private static final String TRANSACTION_AMOUNT = "TRANSACTION_AMOUNT";

	private static final String TRANSACTION_CURRENCY = "TRANSACTION_CURRENCY";

	private String filename;

	private String header;

	private String footer;

	private String transactionLine;

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getFooter() {
		return footer;
	}

	public void setFooter(String footer) {
		this.footer = footer;
	}

	public String getTransactionLine() {
		return transactionLine;
	}

	public static String createTransactionLine(String deviceNumber, String walletNumber, KeyValueProvider provider){
		return deviceNumber + "|" + walletNumber + "|0|" + DateUtils.getDateddMMyyyy() + "|U1|" + provider.getString(TRANSACTION_AMOUNT) 
				+ "|" + provider.getString(TRANSACTION_CURRENCY) + "|" + provider.getString(BILLING_AMOUNT) + "|" + provider.getString(BILLING_CURRENCY)
				+ "|" + ConstantData.GENERIC_DESCRIPTION + "|" + "00000000";
	}

	public static String getFileContents(String file) throws IOException
	{
		String content = null;
		FileInputStream inputStream = new FileInputStream(file);
		try {
		    content = IOUtils.toString(inputStream);
		} catch (IOException e) {
			logger.debug(ConstantData.EXCEPTION, e);
			MiscUtils.propagate(e);
		} finally {
		    inputStream.close();
		}
		return content;
	}
	
	public void setTransactionLine(String transactionLine) {
		this.transactionLine = transactionLine;
	}

	public static FileCreation createFile(KeyValueProvider provider){
		FileCreation file = new FileCreation();
		file.setFilename("TXU" + provider.getString(INSTITUTION_CODE) + DateUtils.getDate() + DateUtils.getTime() + ".DAT");
		file.setHeader("HD" + provider.getString(INSTITUTION_CODE) + DateUtils.getDateTimeDDMMYYYYHHMMSS() + "2.0");
		file.setFooter("FT" + "000000001");		
		return file;
	}

}
