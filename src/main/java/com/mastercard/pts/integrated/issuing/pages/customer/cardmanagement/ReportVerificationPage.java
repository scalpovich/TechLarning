package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.GenericReport;

public interface ReportVerificationPage {

	String generateReport(GenericReport report);

}