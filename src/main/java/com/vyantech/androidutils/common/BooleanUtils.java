package com.vyantech.androidutils.common;

/**
 * Created by patrix on 22/10/17.
 */

public class BooleanUtils {
    private BooleanUtils(){}

    public static boolean isTrue(Boolean bool){
        return bool != null && bool.booleanValue();
    }
}
