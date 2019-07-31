package com.algo;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class DaysBetween {

	static long until(LocalDate endDate) {
		return LocalDate.now().until(endDate, ChronoUnit.DAYS);
	}
	
	static long until(LocalDate startDate, LocalDate endDate) {
		return startDate.until(endDate, ChronoUnit.DAYS);
	}
	
	static long cafait(LocalDate startDate) {
		return startDate.until(LocalDate.now(), ChronoUnit.DAYS);
	}
	
	public static void main(String[] args) {
		LocalDate start = LocalDate.of(2018, Month.NOVEMBER, 11);
		LocalDate end = LocalDate.of(2019, Month.JULY, 1);
		System.out.println(cafait(start));
		System.out.println(until(start,end));
	}

}
