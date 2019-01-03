package com.yto.mdm.exception;

/**
 * 业务基础异常类
 */
public class BaseException extends RuntimeException {
    public BaseException() {
    }

    public BaseException(String msg, int status) {
        super(msg);
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
