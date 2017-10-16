package com.mastercard.pts.integrated.issuing.domain;

public class BatchType {

	public static final String UPLOAD = "upload";
	public static final String DOWNLOAD = "download";
	public static final String SYSTEM_INTERNAL= "System internal";
	
	public static final String PENDING_STATUS = "PENDING [0]";
	public static final String INPROCESS_STATUS = "IN PROCESS [1]";
	public static final String SUCCESS_STATUS = "SUCCESS [2]";
	
	private BatchType() {}
}
