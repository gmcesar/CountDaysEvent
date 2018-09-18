/**
 * 
 */
package com.cesargm.countdays;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author cesargm
 *
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
	
	public static Integer calculateLeapYearsDays(DatesEvent date) {
		int numYears = date.getYear();
		if(date.getMonth().intValue() <= 2) {
			numYears--;
		}
		Integer days = (numYears/4) - (numYears/100) + (numYears/400);
		return days;
	}
	
	public static Integer calculateYearsDays(DatesEvent date) {
		Integer daysYears = 0;
		for(int i=1; i<date.getMonth(); i++) {
			daysYears += daysOfMonth.get(i);
		}
		return daysYears;
	}

	/**
	 * 
	 */
	public static final Integer calculateDays(String date1, String date2) throws RuntimeException {
		DatesEvent d1= new DatesEvent(date1);
		DatesEvent d2 = new DatesEvent(date2);
		
		Integer c1 = (d1.getYear()*365) + calculateLeapYearsDays(d1) + calculateYearsDays(d1) + d1.getDay();
		Integer c2 = (d2.getYear()*365) + calculateLeapYearsDays(d2) + calculateYearsDays(d2) + d2.getDay();
		
		return (c2-c1 == 0) ? 0 : c2-c1-1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Calculate number days");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Start Date (dd/mm/yyyy): ");
		String date1 = sc.nextLine();
		System.out.println("Enter End Date (dd/mm/yyyy): ");
		String date2 = sc.nextLine();
		sc.close();
		System.out.println("Total Days: " + calculateDays(date1, date2));
	}
}
