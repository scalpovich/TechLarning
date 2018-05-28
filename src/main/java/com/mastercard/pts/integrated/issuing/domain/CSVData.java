package com.mastercard.pts.integrated.issuing.domain;

import java.util.List;

public class CSVData {

	private List<String> headerRow;
	private List<List<String>> dataRows;

	public CSVData(List<String> headers, List<List<String>> data) {
		super();
		this.headerRow = headers;
		this.dataRows = data;
	}

	public List<String> getHeaderRow() {
		return headerRow;
	}

	public List<List<String>> getDataRows() {
		return dataRows;
	}

	@Override
	public String toString() {
		return "CSVData [headerRow=" + headerRow + ", dataRows=" + dataRows + "]";
	}
	
}