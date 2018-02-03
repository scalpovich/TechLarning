package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import org.springframework.stereotype.Component;

@Component
public class BatchJobHistory {

	public String BatchType;

	public String Batch;

	public String JobIdBatchJobHistory;

	public String Fromdate;

	public String ToDate;

	public String getBatchType() {
		return BatchType;
	}

	public void setBatchType(String batchType) {
		BatchType = batchType;
	}

	public String getBatch() {
		return Batch;
	}

	public void setBatch(String batch) {
		Batch = batch;
	}

	public String getJobIdBatchJobHistory() {
		return JobIdBatchJobHistory;
	}

	public void setJobIdBatchJobHistory(String jobIdBatchJobHistory) {
		JobIdBatchJobHistory = jobIdBatchJobHistory;
	}

	public String getFromdate() {
		return Fromdate;
	}

	public void setFromdate(String fromdate) {
		Fromdate = fromdate;
	}

	public String getToDate() {
		return ToDate;
	}

	public void setToDate(String toDate) {
		ToDate = toDate;
	}

}
