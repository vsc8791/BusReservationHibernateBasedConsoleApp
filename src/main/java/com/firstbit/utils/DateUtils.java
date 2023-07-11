package com.firstbit.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import com.firstbit.constants.ReservationConstants;

public class DateUtils {

	public static String getCurrentDate() {
		Date date = Calendar.getInstance().getTime();
		DateFormat formatter = new SimpleDateFormat(ReservationConstants.dateFormat);
		String today = formatter.format(date);
		return today;
	}

	public static void main(String[] args) {
		System.out.println(getCurrentDate());
	}

	public static String getDate() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Date Of Journey (Mandatory Format : dd-MM-yyyy):-> ");
		String dateOfJourney = scanner.next();
		return dateOfJourney;
	}

}
