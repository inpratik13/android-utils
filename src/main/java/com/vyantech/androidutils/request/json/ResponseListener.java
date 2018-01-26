package com.vyantech.androidutils.request.json;

/**
 * Created by patrix on 17/10/17.
 */

public interface ResponseListener<T> {
    public void onResponse(Response<T> res);
}
