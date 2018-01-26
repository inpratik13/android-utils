package com.vyantech.androidutils.encryption;

import android.support.annotation.NonNull;

import com.vyantech.androidutils.common.Constants;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by iCon on 2/25/2017.
 */

public class HashUtils {
    private static final String SHA1_ALGO = "SHA-1";
    private HashUtils() {
    }

    private static String convertToHex(byte[] data) {
        StringBuilder buf = new StringBuilder();
        for (byte b : data) {
            int halfbyte = (b >>> 4) & 0x0F;
            int two_halfs = Constants.ZERO;
            do {
                buf.append((Constants.ZERO <= halfbyte) && (halfbyte <= 9) ? (char) ('0' + halfbyte) : (char) ('a' + (halfbyte - 10)));
                halfbyte = b & 0x0F;
            } while (two_halfs++ < Constants.ONE);
        }
        return buf.toString();
    }

    public static String sha1(String text) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md = MessageDigest.getInstance(SHA1_ALGO);
        byte[] textBytes = text.getBytes(Constants.ENCODING_UTF_8);
        md.update(textBytes, Constants.ZERO, textBytes.length);
        byte[] sha1hash = md.digest();
        return convertToHex(sha1hash);
    }
}
