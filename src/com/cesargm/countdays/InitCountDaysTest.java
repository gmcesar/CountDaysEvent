
package com.cesargm.countdays;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author cesargm
 * InitCountDaysTest Class with all test cases
 */
public class InitCountDaysTest {
	//private CountDaysEvent classCountDaysEvent;
	private DatesEvent date1;
	private DatesEvent date2;

	@Before
	public void setUp() throws Exception {
		//classCountDaysEvent = new CountDaysEvent();
	}
	
	@After
	public void tearDown() throws Exception {
		date1 = null;
		date2 = null;
	}

	@Test(expected = RuntimeException.class)
	public final void whenInputHasNotFormatThenThrowsException() {
		date1 = new DatesEvent("1982 11 14");
		date2 = new DatesEvent("12 2900 23");
	}

	@Test(expected = RuntimeException.class)
	public void whenInputHasLettersThenThrowsException() {
		date1 = new DatesEvent("11/09/198e");
		date2 = new DatesEvent("a1/12/1999");
	}
	
	@Test(expected = RuntimeException.class)
	public void whenEmptyStringsThenThrowsException() {
		date1 = new DatesEvent("");
		date2 = new DatesEvent("");
	}
	
	@Test(expected = RuntimeException.class)
	public void whenInvalidDayThenThrowsException() {
		date1 = new DatesEvent("32/11/1999");
		date2 = new DatesEvent("-1/09/1999");
	}
	
	@Test(expected = RuntimeException.class)
	public void whenInvalidMonthThenThrowsException() {
		date1 = new DatesEvent("02/222/2108");
		date2 = new DatesEvent("12/0/2001");
	}
	
	@Test(expected = RuntimeException.class)
	public void whenInvalidYearThenThrowsException() {
		date1 = new DatesEvent("03/12/50000");
		date2 = new DatesEvent("18/10/-2018");
	}
	
	@Test(expected = RuntimeException.class)
	public void whenInvalidDateRangeThenThrowsException() {
		date1 = new DatesEvent("05/06/1900");
		date2 = new DatesEvent("23/04/2018");
	}
	
	@Test
	public void whenSameYearSameMonth() {
		date1 = new DatesEvent("02/06/1983");
		date2 = new DatesEvent("22/06/1983");
		Integer days = InitCountDays.calculateDays(date1, date2);
		assertEquals(19, days.intValue());
	}
	
	@Test
	public void whenSameDates() {
		date1 = new DatesEvent("05/06/2018");
		date2 = new DatesEvent("05/06/2018");
		Integer days = InitCountDays.calculateDays(date1, date2);
		assertEquals(0, days.intValue());
	}
	
	@Test
	public void whenNoFullyElapsedDays() {
		date1 = new DatesEvent("07/11/1972");
		date2 = new DatesEvent("08/11/1972");
		Integer days = InitCountDays.calculateDays(date1, date2);
		assertEquals(0, days.intValue());
	}
	
	@Test
	public void whenSameYearDifferentMonth() {
		date1 = new DatesEvent("04/07/1984");
		date2 = new DatesEvent("25/12/1984");
		Integer days = InitCountDays.calculateDays(date1, date2);
		assertEquals(173, days.intValue());
	}
	
	@Test
	public void whenSameMonthDifferentYear() {
		date1 = new DatesEvent("05/06/2017");
		date2 = new DatesEvent("04/06/2018");
		Integer days = InitCountDays.calculateDays(date1, date2);
		assertEquals(363, days.intValue());
	}
	
	@Test
	public void whenDifferentValidYearMonthDay() {
		date1 = new DatesEvent("03/08/1983");
		date2 = new DatesEvent("03/01/1989");
		Integer days = InitCountDays.calculateDays(date1, date2);
		assertEquals(1979, days.intValue());
	}
	
	@Test
	public void whenAllValidDates() {
		date1 = new DatesEvent("01/01/1901");
		date2 = new DatesEvent("31/12/2999");
		Integer days = InitCountDays.calculateDays(date1, date2);
		assertEquals(401400, days.intValue());
	}
	
	@Test
	public void whenSameDaySameMonth() {
		date1 = new DatesEvent("01/02/2000");
		date2 = new DatesEvent("01/02/2004");
		Integer days = InitCountDays.calculateDays(date1, date2);
		assertEquals(1460, days.intValue());
	}
}
