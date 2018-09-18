/**
 * 
 */
package com.cesargm.countdays;

/**
 * @author cesargm
 *
 */
public class DatesEvent {
	
	private final Integer day;
	private final Integer month;
	private final Integer year;
	
	
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
	 * Validate day, month and year
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
