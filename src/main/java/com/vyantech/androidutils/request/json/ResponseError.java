package com.vyantech.androidutils.request.json;

/**
 * Created by patrix on 17/10/17.
 */

public class ResponseError extends Throwable{

    ResponseError(String message) {
        super(message);
    }

    public ResponseError(Throwable cause) {
        super(cause);
    }
}
