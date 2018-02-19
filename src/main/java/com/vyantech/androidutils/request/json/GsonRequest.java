package com.vyantech.androidutils.request.json;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * Created by patrix on 17/10/17.
 */

public class GsonRequest<C> extends Request<Response<C>> {
    private static final String CONTENT_TYPE = "application/json";
    private static final Gson gson = new Gson();
    private final Class<C> clazz;
    private final Map<String, String> headers;
    private final ResponseListener<C> callback;
    private final Object postBody;

    GsonRequest(int method, String url, Object data, Map<String, String> reqHeaders,
                boolean cachable, Class<C> responseTypeClass, ResponseListener<C> callback) {

        super(method, url, new ErrorListener(callback));
        setShouldCache(cachable);


        this.clazz = responseTypeClass;
        this.headers = reqHeaders;
        this.callback = callback;
        this.postBody = data;
    }


    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        return headers != null ? headers : super.getHeaders();
    }

    @Override
    protected void deliverResponse(Response<C> response) {
        callback.onResponse(response);
    }

    @Override
    public String getBodyContentType() {
        return postBody != null ? CONTENT_TYPE : super.getBodyContentType();
    }

    public byte[] getBody() throws AuthFailureError {
        if (postBody == null) {
            return super.getBody();
        }

        String json = gson.toJson(postBody);
        return json.getBytes();
    }

    @Override
    protected com.android.volley.Response<Response<C>> parseNetworkResponse(NetworkResponse response) {
        try {
            String json = new String(
                    response.data,
                    HttpHeaderParser.parseCharset(response.headers));

            C obj = null;
            if (clazz != null && json != null && !json.trim().isEmpty()) {
                obj = gson.fromJson(json, clazz);
            }

            Response<C> res
                    = new Response<C>(obj, response.statusCode, readResponseHeaders(response));

            return com.android.volley.Response.success(res, HttpHeaderParser.parseCacheHeaders(response));

        } catch (UnsupportedEncodingException e) {
            return com.android.volley.Response.error(new ParseError(e));

        } catch (JsonSyntaxException e) {
            return com.android.volley.Response.error(new ParseError(e));

        }
    }

    private static Map<String, String> readResponseHeaders(NetworkResponse response){
        return response.headers;
    }

    private static class ErrorListener implements com.android.volley.Response.ErrorListener {
        private ResponseListener listener;

        private ErrorListener(ResponseListener listener) {
            this.listener = listener;
        }

        @Override
        public void onErrorResponse(VolleyError error) {
            ResponseError er = null;

            if (error.getCause() != null) {
                er = new ResponseError(error.getCause());
            } else {
                er = new ResponseError(error.getMessage());
            }

            int statusCode = Response.STATUS_UNEXPECTED_ERROR;
            if (error.networkResponse != null) {
                statusCode = error.networkResponse.statusCode;
            } else if (error.getCause() != null) {
                if (error.getCause() instanceof TimeoutError) {
                    statusCode = Response.STATUS_TIMEOUT;
                }
            }

            this.listener.onResponse(new Response(statusCode, er));
        }

    }
}