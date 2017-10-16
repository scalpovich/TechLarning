package com.mastercard.pts.integrated.issuing.workflows;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.utils.FileCreation;
import com.mastercard.pts.integrated.issuing.utils.UploadFile;

@Component
public class RupayClearingFlows {
	@Autowired
	public UploadFile upload;

	public void rupayClearingFileCreation() {
		System.out.println("When statement executed...FLOWS...");
		// xmlReader.createXMLFile();
	}

	public void rupayClearingFileTransfer(FileCreation FileName) {
		try {
			upload.createTransactionUploadFile(FileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
