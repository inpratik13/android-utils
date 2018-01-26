package com.vyantech.androidutils.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import android.annotation.SuppressLint;

public class DateUtils {
	@SuppressLint("SimpleDateFormat")
	private static final SimpleDateFormat DF_FULL_DATE = new SimpleDateFormat("yyyy-MM-dd");

	@SuppressLint("SimpleDateFormat")
	private static final SimpleDateFormat DF_FULL_TIME_STAMP = new SimpleDateFormat("yyyy-MM-dd HH:mm");

	private DateUtils() {
	}

	public static String format(Date date) {
		return DF_FULL_DATE.format(date);
	}

	public static Date parse(String dateString) {
		try {
			return DF_FULL_DATE.parse(dateString);
		} catch (ParseException e) {
			return null;
		}
	}

	public static String formatTimestamp(Date date) {
        if(date == null){
            return null;
        }

		return DF_FULL_TIME_STAMP.format(date);
	}

	public static Date parseTimestamp(String dateString) {
        if(dateString == null){
            return null;
        }

		try {
			return DF_FULL_TIME_STAMP.parse(dateString);
		} catch (ParseException e) {
			return null;
		}
	}

	public static String getDayOfMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
	}

	@SuppressLint("SimpleDateFormat")
	public static String format(Date date, String pattern) {
		if (date == null) {
			return null;
		}

		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}

}
