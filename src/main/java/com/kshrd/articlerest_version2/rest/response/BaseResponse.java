package com.kshrd.articlerest_version2.rest.response;

import java.sql.Timestamp;

public class BaseResponse {

    private boolean success;
    private int statusCode;
    private String message;
    private Timestamp time;

    public BaseResponse() {
    }

    public BaseResponse(boolean success, int statusCode, String message, Timestamp time) {
        this.success = success;
        this.statusCode = statusCode;
        this.message = message;
        this.time = time;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

}
