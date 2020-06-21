package com.kshrd.articlerest_version2.rest.response;

public class ApiResponse<T> extends BaseResponse {

    private T data;

    public ApiResponse() {}

    public ApiResponse(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
