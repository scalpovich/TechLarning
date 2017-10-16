package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;

public class ProcessBatches extends AbstractBasePage {

	private String joBID;
	private String batchName;
	private String batchType;
	private String fileType;
	private String generatedFilename;

	public String getBatchName() {
		return batchName;
	}

	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}

	public String getJoBID() {
		return joBID;
	}

	public void setJoBID(String joBID) {
		this.joBID = joBID;
	}

	public String getBatchType() {
		return batchType;
	}

	public void setBatchType(String batchType) {
		this.batchType = batchType;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getGeneratedFilename() {
		return generatedFilename;
	}

	public void setGeneratedFilename(String generatedFilename) {
		this.generatedFilename = generatedFilename;
	}

	public String getProgramDataValuefromExcel() {
		return MapUtils.fnGetInputDataFromMap("Program");
	}
}