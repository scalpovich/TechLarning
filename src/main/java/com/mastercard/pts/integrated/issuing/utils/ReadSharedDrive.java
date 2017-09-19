package com.mastercard.pts.integrated.issuing.utils;

import java.io.File;

import org.jbehave.core.annotations.Given;
import org.springframework.stereotype.Component;

@Component
public class ReadSharedDrive {

	@Given("user is able to read data from sharedDrive")
	public void givenUserIsAbleToReadDataFromSharedDrive() {

		File f = new File("S:\\UmeshKumar2\\Shared.txt");
		System.out.println("File reading status:"+f.canRead());
	}
}
