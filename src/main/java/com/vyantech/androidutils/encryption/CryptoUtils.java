package com.vyantech.androidutils.encryption;

import android.util.Base64;

public class CryptoUtils {
	
	public static String encodeBase64(String plainString) {
		if (plainString == null)
			return null;

		return encodeBase64(plainString.getBytes());
	}
	
	public static String encodeBase64(byte[] bytes) {
		if (bytes == null)
			return null;

		return new String(Base64.encode(bytes, Base64.DEFAULT));
	}

	public static String decodeBase64(String encodedString) {
		return new String(Base64.decode(encodedString, Base64.DEFAULT));
	}
}
