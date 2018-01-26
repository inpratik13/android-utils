package com.vyantech.androidutils.common;

import java.util.Currency;
import java.util.Locale;

import android.annotation.SuppressLint;
import android.content.Context;
import android.telephony.TelephonyManager;

public class CurrencyUtils {

	public static String lookupSymbol(String currencyIso) {
		try {
			Currency cur = Currency.getInstance(currencyIso);
			String symbol = null;

			if (cur != null) {
				symbol = cur.getSymbol();
			}

			if (symbol == null) {
				symbol = currencyIso;
			}

			return symbol;
		} catch (Exception ex) {
			return currencyIso;
		}
	}

	@SuppressLint("DefaultLocale")
	private static String getCurrencyByTelephony(Context context) {
		TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
		if (tm == null) {
			return null;
		}

		String code = null;
		String country = null;

		try {
			country = tm.getSimCountryIso().toUpperCase();
			code = Currency.getInstance(new Locale("", country)).getCurrencyCode();
		} catch (Exception ex) {}

		if (code == null) {
			try {
				country = tm.getNetworkCountryIso().toUpperCase();
				code = Currency.getInstance(new Locale("", country)).getCurrencyCode();
			} catch (Exception ex) {}
		}

		return code;
	}

}
