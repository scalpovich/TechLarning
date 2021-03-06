package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import java.time.LocalDate;
import java.util.List;

import com.mastercard.pts.integrated.issuing.domain.provider.DataProvider;

public class BusinessCalendar {

	private LocalDate effectiveDate;
	private LocalDate futureDate;
	private boolean skipHoliday;
	private List<Boolean> nonWorkingDays;

	public LocalDate getFutureDate() {
		return futureDate;
	}

	public void setFutureDate(LocalDate futureDate) {
		this.futureDate = futureDate;
	}
	
	public LocalDate getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(LocalDate effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public boolean isSkipHoliday() {
		return skipHoliday;
	}

	public void setSkipHoliday(boolean skipHoliday) {
		this.skipHoliday = skipHoliday;
	}

	public List<Boolean> getNonWorkingDays() {
		return nonWorkingDays;
	}

	public void setNonWorkingDays(List<Boolean> nonWorkingDays) {
		this.nonWorkingDays = nonWorkingDays;
	}
	
	public static BusinessCalendar createWithProvider(DataProvider provider) {
		BusinessCalendar bc=provider.getDataBySimpleClassName(BusinessCalendar.class);
		bc.setEffectiveDate(LocalDate.now()); 
		bc.setFutureDate(LocalDate.now().plusDays(50));
		return bc;
	}
}
