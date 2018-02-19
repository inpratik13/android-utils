package com.vyantech.androidutils.request.json;

import java.util.Collections;
import java.util.Map;

/**
 * Created by patrix on 17/10/17.
 */

public class Response<T> {
    public static final int
            STATUS_TIMEOUT = -1,
            STATUS_UNEXPECTED_ERROR = 0,
            STATUS_OK = 200,
            STATUS_CREATED = 201,
            STATUS_CONFLICT = 409,
            STATUS_BAD_REQUEST = 400,
            STATUS_NOT_FOUND = 404,
            STATUS_UNAUTHORIZED = 401;

    private final T data;
    private final int code;
    private final ResponseError error;
    private Map<String, String> headers;

    Response(T data, int statuscode) {
        this.data = data;
        this.code = statuscode;
        headers = null;
        this.error = null;
    }

    Response(T data, int statuscode, Map<String, String> headers) {
        this.data = data;
        this.code = statuscode;
        this.headers = Collections.unmodifiableMap(headers);;
        this.error = null;
    }

    Response(int statuscode, ResponseError error) {
        this.data = null;
        this.code = statuscode;
        this.error = error;
    }

    public T getData() {
        return data;
    }

    public int getCode() {
        return code;
    }

    public ResponseError getError() {
        return error;
    }

    public Map<String, String> getHeaders(){
        return headers;
    }
}
