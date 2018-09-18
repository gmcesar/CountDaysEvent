
package com.cesargm.countdays;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author cesargm
 * InitCountDays Class that init the process and calculates the number of days between
 * the start and end dates of an event.
 */
public class InitCountDays {
	
	
	private static final Map<Integer, Integer> daysOfMonth = new HashMap<Integer, Integer>();
	
	static {
		daysOfMonth.put(1,31);
		daysOfMonth.put(2, 28);
		daysOfMonth.put(3, 31);
		daysOfMonth.put(4,30);
		daysOfMonth.put(5, 31);
		daysOfMonth.put(6, 30);
		daysOfMonth.put(7,31);
		daysOfMonth.put(8, 31);
		daysOfMonth.put(9, 30);
		daysOfMonth.put(10,31);
		daysOfMonth.put(11, 30);
		daysOfMonth.put(12, 31);
	}
	
	/**
	 * Calculates the number of Leap years of specific date following formula:
	 * days = year/4 - year/100 + year/400 if month>february
	 * This formula derives from Leapyear algorithm.
	 * @param date The date used to calculate the number of Leap years
	 */
	public static Integer calculateLeapYearsDays(DatesEvent date) {
		int numYears = date.getYear();
		if(date.getMonth().intValue() <= 2) {
			numYears--;
		}
		Integer days = (numYears/4) - (numYears/100) + (numYears/400);
		return days;
	}
	/**
	 * Calculates the number of days for the months in the year
	 * @param date The date used to calculate the number of days
	 */
	public static Integer calculateYearsDays(DatesEvent date) {
		Integer daysYears = 0;
		for(int i=1; i<date.getMonth(); i++) {
			daysYears += daysOfMonth.get(i);
		}
		return daysYears;
	}

	/**
	 * Calculates the total days before every date. From day 0 to date1 and from day 0 to date2.
	 * Then calculates the difference between number of days for date2 and number of days for date1.
	 * Subtract 1 to avoid consider the first and the last day.
	 * @param d1 Object with date1 data
	 * @param d2 Object with date2 data
	 */
	public static final Integer calculateDays(DatesEvent d1, DatesEvent d2) throws RuntimeException {
		Integer c1 = (d1.getYear()*365) + calculateLeapYearsDays(d1) + calculateYearsDays(d1) + d1.getDay();
		Integer c2 = (d2.getYear()*365) + calculateLeapYearsDays(d2) + calculateYearsDays(d2) + d2.getDay();
		
		return (c2-c1 == 0) ? 0 : c2-c1-1;
	}

	/**
	 * Start app
	 * @param args no arguments
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean flag = false;
		DatesEvent date1 = null;
		DatesEvent date2 = null;
		System.out.println("Calculate number days between dates: ");
		do {
			//String date1 = sc.nextLine();
			System.out.println("Enter Start Date (dd/mm/yyyy): ");
			try {
				date1 = new DatesEvent(sc.nextLine());
				System.out.println("Enter End Date (dd/mm/yyyy): ");
				//String date2 = sc.nextLine();
				date2 = new DatesEvent(sc.nextLine());
			} catch(RuntimeException r) {
				System.out.println("Error: Invalid Date. Try again");
				continue;
			}
			if((date1 != null) && (date2 != null)) {
				flag = true;
			}
		} while(!flag);
		sc.close();
		System.out.println("Total Days: " + calculateDays(date1, date2));
	}
}
