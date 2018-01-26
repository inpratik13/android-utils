package com.vyantech.androidutils.common;

import java.text.NumberFormat;
import java.util.Locale;

public class NumberUtils {
	private static final NumberFormat NUMBER_FORMAT = NumberFormat.getInstance(Locale.getDefault());
	private static final String DECIMAL_FORMAT = "%.1f";

	static {
		NUMBER_FORMAT.setMinimumFractionDigits(Constants.ONE);
		NUMBER_FORMAT.setMaximumFractionDigits(Constants.ONE);
	}

	public static String format(double d) {
		return NUMBER_FORMAT.format(d);
	}

	public static String formatPlain(double d) {
		return String.format(DECIMAL_FORMAT, d);
	}

	public static Integer toInteger(String str){
		if(StringUtils.isEmpty(str)){
			return null;
		}

		try{
			return Integer.parseInt(str);
		} catch(NumberFormatException nex){
			return null;
		}
	}
}
