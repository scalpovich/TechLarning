package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import java.time.LocalDate;

import com.mastercard.pts.integrated.issuing.domain.provider.DataProvider;

public class HolidayConfiguration {
	
	private LocalDate calendarDate;
	private String description;
	private String holidayType;
	
	public LocalDate getCalendarDate() {
		return calendarDate;
	}
	public void setCalendarDate(LocalDate calendarDate) {
		this.calendarDate = calendarDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getHolidayType() {
		return holidayType;
	}
	public void setHolidayType(String holidayType) {
		this.holidayType = holidayType;
	}
	
	public static HolidayConfiguration createWithProvider(DataProvider provider) {
		HolidayConfiguration hc = provider.getDataBySimpleClassName(HolidayConfiguration.class);
		hc.setCalendarDate(LocalDate.now().plusDays(1));
		return hc;
	}
	
}
