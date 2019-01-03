package com.yto.mdm.exception.user;

import com.yto.mdm.constant.Constant;
import com.yto.mdm.exception.BaseException;

public class UserParamException extends BaseException {

    public UserParamException(String msg){
        super(msg,Constant.USER_PARAM_NAME_INVALID);
    }

}
