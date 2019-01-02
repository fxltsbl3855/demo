package com.yto.mdm.exception;

import lombok.Data;

/**
 * 业务基础异常类
 */
@Data
public class BaseException extends RuntimeException {


    private int status = 200;


    public BaseException() {
    }

    public BaseException(String msg, int status) {
        super(msg);
        this.status = status;
    }

    public BaseException(String msg) {
        super(msg);
    }

    public BaseException(String msg, Throwable e) {
        super(msg, e);
    }

    public BaseException(Throwable e) {
        super(e);
    }

    public BaseException(String msg, Throwable e, boolean enableSuppression, boolean writableStackTrace) {
        super(msg, e, enableSuppression, writableStackTrace);
    }

}
