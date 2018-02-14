package com.mastercard.pts.integrated.issuing.domain.customer.admin;

import org.springframework.stereotype.Component;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;

@Component
public class AuditReport {
	private String reportName;
	private String operation;
	private String userId;
	private String screenName;
	private String fileType;
	private String reportGenerationMode;
	
	public String getReportName() {
		return reportName;
	}


	public void setReportName(String reportName) {
		this.reportName = reportName;
	}


	public String getOperation() {
		return operation;
	}


	public void setOperation(String operation) {
		this.operation = operation;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getScreenName() {
		return screenName;
	}


	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}


	public String getFileType() {
		return fileType;
	}


	public void setFileType(String fileType) {
		this.fileType = fileType;
	}


	public String getReportGenerationMode() {
		return reportGenerationMode;
	}


	public void setReportGenerationMode(String reportGenerationMode) {
		this.reportGenerationMode = reportGenerationMode;
	}

	public static AuditReport getAuditReportData() {
		AuditReport auditreport = new AuditReport();
		auditreport.setReportName(MapUtils
				.fnGetInputDataFromMap("ReportName"));
		auditreport.setOperation(MapUtils
				.fnGetInputDataFromMap("Operation"));
		auditreport.setUserId(MapUtils
				.fnGetInputDataFromMap("UserID"));
		auditreport.setScreenName(MapUtils
				.fnGetInputDataFromMap("ScreenName"));
		auditreport.setFileType(MapUtils
				.fnGetInputDataFromMap("FileType"));
		auditreport.setReportGenerationMode(MapUtils
				.fnGetInputDataFromMap("ReportGenerationMode"));
		return auditreport;
	}
	
	

}
