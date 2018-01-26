package com.vyantech.androidutils.request.json;

import com.android.volley.Request;

import java.util.Map;

/**
 * Created by patrix on 18/10/17.
 */

public class GsonRequestBuilder<C> {
    private final String url;
    private final int requestMethod;

    private boolean shouldCache = false;
    private Class<C> expectedResponseType;
    private Map<String, String> headers;
    private ResponseListener<C> responseListener;
    private Object postBody;

    public GsonRequestBuilder(String url, RequestMethod method) {
        this.url = url;
        this.requestMethod = _mapMethod(method);
    }

    public String getUrl() {
        return url;
    }

    public int getRequestMethod() {
        return requestMethod;
    }

    public Class<C> getExpectedResponseType() {
        return expectedResponseType;
    }

    public GsonRequestBuilder<C> setExpectedResponseType(Class<C> expectedResponseType) {
        this.expectedResponseType = expectedResponseType;
        return this;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public GsonRequestBuilder<C> setHeaders(Map<String, String> headers) {
        this.headers = headers;
        return this;
    }

    public ResponseListener<C> getResponseListener() {
        return responseListener;
    }

    public GsonRequestBuilder<C> setResponseListener(ResponseListener<C> callback) {
        this.responseListener = callback;
        return this;
    }

    public GsonRequestBuilder<C> cachable(boolean shouldCache){
        this.shouldCache = shouldCache;
        return this;
    }

    public boolean isChachable(){
        return this.shouldCache;
    }


    public Object getBody() {
        return postBody;
    }

    public GsonRequestBuilder<C> setBody(Object postBody) {
        this.postBody = postBody;
        return this;
    }

    public GsonRequest<C> build() {
        GsonRequest<C> req = new GsonRequest<C>(this.requestMethod
                , this.url
                , this.postBody
                , this.headers
                , this.shouldCache
                , expectedResponseType
                , responseListener);

        return req;
    }

    private static int _mapMethod(RequestMethod method) {
        switch (method) {
            case GET:
                return Request.Method.GET;
            case PUT:
                return Request.Method.PUT;
            case POST:
                return Request.Method.POST;
            case DELETE:
                return Request.Method.DELETE;
        }
        return Request.Method.GET;
    }
}
