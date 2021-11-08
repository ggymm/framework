package com.cloud.framework.api.common.dto;

import lombok.Data;

import java.io.Serializable;

import static com.cloud.framework.constants.Common.SC_INTERNAL_SERVER_ERROR_500;
import static com.cloud.framework.constants.Common.SC_OK_200;

/**
 * @author gongym
 * @version 创建时间: 2021-11-05 11:56
 */
@Data
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 成功标识
     */
    private boolean success;

    /**
     * 消息
     */
    private String message;

    /**
     * 代码
     */
    private Integer code;

    /**
     * 数据对象 data
     */
    private T data;

    /**
     * 当前时间戳
     */
    private long timestamp = System.currentTimeMillis();

    public static <T> Result<T> OK() {
        Result<T> r = new Result<>();
        r.setSuccess(true);
        r.setCode(SC_OK_200);
        return r;
    }

    public static <T> Result<T> OK(T data) {
        Result<T> r = new Result<>();
        r.setSuccess(true);
        r.setCode(SC_OK_200);
        r.setData(data);
        return r;
    }

    public static <T> Result<T> OK(String msg, T data) {
        Result<T> r = new Result<>();
        r.setSuccess(true);
        r.setCode(SC_OK_200);
        r.setMessage(msg);
        r.setData(data);
        return r;
    }

    public static <T> Result<T> error(String msg, T data) {
        Result<T> r = new Result<>();
        r.setSuccess(false);
        r.setCode(SC_INTERNAL_SERVER_ERROR_500);
        r.setMessage(msg);
        r.setData(data);
        return r;
    }

    public static Result<Object> error(int code, String msg) {
        Result<Object> r = new Result<>();
        r.setCode(code);
        r.setMessage(msg);
        r.setSuccess(false);
        return r;
    }

    public Result<T> success(String message) {
        this.message = message;
        this.code = SC_OK_200;
        this.success = true;
        return this;
    }

    public Result<T> error500(String message) {
        Result<Object> r = new Result<>();
        r.setCode(SC_INTERNAL_SERVER_ERROR_500);
        r.setMessage(message);
        r.setSuccess(false);
        return this;
    }
}
