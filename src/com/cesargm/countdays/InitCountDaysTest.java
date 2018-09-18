/**
 * 
 */
package com.cesargm.countdays;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author cesargm
 * 
 */
public class InitCountDaysTest {
	//private CountDaysEvent classCountDaysEvent;

	@Before
	public void setUp() throws Exception {
		//classCountDaysEvent = new CountDaysEvent();
	}
	
	@After
	public void tearDown() throws Exception {
	}

	@Test(expected = RuntimeException.class)
	public final void whenInputHasNotFormatThenThrowsException() {
		InitCountDays.calculateDays("1982 11 14", "12 2900 23");
	}

	@Test(expected = RuntimeException.class)
	public void whenInputHasLettersThenThrowsException() {
		InitCountDays.calculateDays("11/09/198e", "a1/12/1999");
	}
	
	@Test(expected = RuntimeException.class)
	public void whenEmptyStringsThenThrowsException() {
		InitCountDays.calculateDays("", "");
	}
	
	@Test(expected = RuntimeException.class)
	public void whenInvalidDayThenThrowsException() {
		InitCountDays.calculateDays("32/11/1999", "-1/09/1999");
	}
	
	@Test(expected = RuntimeException.class)
	public void whenInvalidMonthThenThrowsException() {
		InitCountDays.calculateDays("02/222/2108", "12/0/2001");
	}
	
	@Test(expected = RuntimeException.class)
	public void whenInvalidYearThenThrowsException() {
		InitCountDays.calculateDays("03/12/50000", "18/10/-2018");
	}
	
	@Test(expected = RuntimeException.class)
	public void whenInvalidDateRangeThenThrowsException() {
		InitCountDays.calculateDays("05/06/1900", "23/04/2018");
	}
	
	@Test
	public void whenSameYearSameMonth() {
		Integer days = InitCountDays.calculateDays("02/06/1983", "22/06/1983");
		assertEquals(19, days.intValue());
	}
	
	@Test
	public void whenSameDates() {
		Integer days = InitCountDays.calculateDays("05/06/2018", "05/06/2018");
		assertEquals(0, days.intValue());
	}
	
	@Test
	public void whenNoFullyElapsedDays() {
		Integer days = InitCountDays.calculateDays("07/11/1972", "08/11/1972");
		assertEquals(0, days.intValue());
	}
	
	@Test
	public void whenSameYearDifferentMonth() {
		Integer days = InitCountDays.calculateDays("04/07/1984", "25/12/1984");
		assertEquals(173, days.intValue());
	}
	
	@Test
	public void whenSameMonthDifferentYear() {
		Integer days = InitCountDays.calculateDays("05/06/2017", "04/06/2018");
		assertEquals(363, days.intValue());
	}
	
	@Test
	public void whenDifferentValidYearMonthDay() {
		Integer days = InitCountDays.calculateDays("03/08/1983", "03/01/1989");
		assertEquals(1979, days.intValue());
	}
	
	@Test
	public void whenAllValidDates() {
		Integer days = InitCountDays.calculateDays("01/01/1901", "31/12/2999");
		assertEquals(401400, days.intValue());
	}
	
	@Test
	public void whenSameDaySameMonth() {
		Integer days = InitCountDays.calculateDays("01/02/2000", "01/02/2004");
		assertEquals(1460, days.intValue());
	}
}
