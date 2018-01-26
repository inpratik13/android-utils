package com.vyantech.androidutils.common;

import java.util.Date;

import android.database.Cursor;

public class DBUtils {
	private DBUtils(){}
	
	/**
	 * Get value of {@code columnName} column from Cursor c.
	 * 
	 * @param c
	 * @param columnName
	 * @return		value from column, or null if column doesn't exists
	 */
	public static String getString(Cursor c, String columnName) {
		int columnIndex = c.getColumnIndex(columnName);
		if (columnIndex == Constants.MINUS_ONE) {
			return null;
		}

		return c.getString(columnIndex);
	}

	/**
	 * Get value of {@code columnName} column from Cursor c.
	 * 
	 * @param c
	 * @param columnName
	 * @return		value from column, or null if column doesn't exists
	 */
	public static Double getDouble(Cursor c, String columnName) {
		int columnIndex = c.getColumnIndex(columnName);
		if (columnIndex == Constants.MINUS_ONE) {
			return null;
		}

		return c.getDouble(c.getColumnIndex(columnName));
	}

	public static boolean getBoolean(Cursor c, String columnName) {
		return c.getInt(c.getColumnIndex(columnName)) == Constants.ONE;
	}

	/**
	 * Get value of {@code columnName} column from Cursor c.
	 * 
	 * @param c
	 * @param columnName
	 * @return		value from column, or null if column doesn't exists
	 */
	public static Long getLong(Cursor c, String columnName) {
		int columnIndex = c.getColumnIndex(columnName);
		if (columnIndex == Constants.MINUS_ONE) {
			return null;
		}

		return c.getLong(c.getColumnIndex(columnName));
	}

	public static int getInt(Cursor c, String columnName) {
		return c.getInt(c.getColumnIndex(columnName));
	}

	public static Date getTimestamp(Cursor c, String columnName) {
		return DateUtils.parseTimestamp(getString(c, columnName));
	}

	public static String toTimestampString(Date date){
		return DateUtils.formatTimestamp(date);
	}

	public static Date getDate(Cursor c, String columnName) {
		String dateString = getString(c, columnName);
		return dateString == null ? null : DateUtils.parse(dateString);
	}

}
