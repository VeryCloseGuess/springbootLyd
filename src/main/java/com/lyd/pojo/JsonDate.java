package com.lyd.pojo;

import java.io.Serializable;

/**
 * @Author:Lyd
 * @Date 2019/12/19 10:03
 * @Description 接口请求消息统一格式
 */
public class JsonDate implements Serializable {
    private String code;
    private Object data;
    private String message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public JsonDate(String code, Object data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }
}
