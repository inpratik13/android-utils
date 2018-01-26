package com.vyantech.androidutils.common;

import java.util.Collection;

/**
 * Created by patrix on 11/11/17.
 */

public class CollectionUtils {
    private CollectionUtils(){}

    public static boolean isEmpty(Collection col){
        return col == null || col.isEmpty();
    }
}
