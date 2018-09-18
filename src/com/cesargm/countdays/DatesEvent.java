
package com.cesargm.countdays;

/**
 * @author cesargm
 * DatesEvent Class that define date data. Receives a String with the date.
 */
public class DatesEvent {
	
	private final Integer day;
	private final Integer month;
	private final Integer year;
	
	/**
	 * Creates a new Immutable object with date information
	 * @param dateEvent date in dd/mm/yyyy format
	 */
	public DatesEvent(String dateEvent) {
		String[] d = dateEvent.split("/");
		this.day = Integer.valueOf(d[0]);
		this.month = Integer.valueOf(d[1]);
		this.year = Integer.valueOf(d[2]);
		validateDates();
	}

	public Integer getDay() {
		return day;
	}
	
	public Integer getMonth() {
		return month;
	}
	
	public Integer getYear() {
		return year;
	}
	
	/*
	 * Validates day, month and year
	 */
	public void validateDates() {
		if(day<1 || day>31) {
			throw new RuntimeException("Invalid Day");
		} else if(month<1 || month>12) {
			throw new RuntimeException("Invalid Month");
		} else if (year<1901 || year>2999) {
			throw new RuntimeException("Invalid Year");
		}
	}
}
