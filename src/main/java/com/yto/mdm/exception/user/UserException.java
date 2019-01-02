package com.yto.mdm.exception.user;

import com.yto.mdm.constant.Constant;
import com.yto.mdm.exception.BaseException;

public class UserException extends BaseException {

    public UserException(String msg){
        super(msg,Constant.USER_INSERT_CONNECT_ERROR);
    }

}
