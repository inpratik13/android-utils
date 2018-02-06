package com.vyantech.androidutils.common;

/**
 * Created by iCon on 2/25/2017.
 */

public class StringUtils {
    private StringUtils(){}

    public static boolean isEmpty(String s){
        return s == null || s.trim().isEmpty();
    }

    public static boolean isValidEmail(String email){
        if(isEmpty(email)){
            return false;
        }

        return email.matches("(?i:^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$)");
    }

    public static boolean minLength(String str, int length){
        return str != null && str.length() >= 6;
    }


    public static String toString(Integer num){
        if(num == null){
            return null;
        }

        return num.toString();
    }

    public static String blankIfNull(String str){
        return str == null ? "" : str;
    }
}
