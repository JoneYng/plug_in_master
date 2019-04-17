package com.yunqi.product.core.base.bean;

/**
 * @Created by TOME .
 * @时间 2018/5/31 16:36
 * @描述 ${TODO}
 */

public class BaseObj<T> {

    public static final String SUCCESS = "200";

    private String code ;
    private String message ;
    private T data;
    private T result;

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code == null ? "" : code;
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

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
