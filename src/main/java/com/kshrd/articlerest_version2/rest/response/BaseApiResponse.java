package com.kshrd.articlerest_version2.rest.response;

import org.springframework.http.HttpStatus;

import java.sql.Timestamp;

public class BaseApiResponse<T> {

    private boolean success;
    private String message;
    private T data;
    private HttpStatus status;
    private Timestamp time;

    public BaseApiResponse() {}

    public BaseApiResponse(boolean success, String message, T data, HttpStatus status, Timestamp time) {
        this.success = success;
        this.message = message;
        this.data = data;
        this.status = status;
        this.time = time;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "BaseApiResponse{" +
                "message='" + message + '\'' +
                ", data=" + data +
                ", status=" + status +
                ", time=" + time +
                '}';
    }

}
