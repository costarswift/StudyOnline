package com.xuecheng.base.exception;

import java.io.Serializable;

/**
 * @author Costar
 * @version 1.0
 * @description 本项目自定义异常类型
 * @date 2023/5/21 19:32
 */
public class RestErrorResponse implements Serializable {

    private String errMessage;

    public RestErrorResponse(String errMessage) {
        this.errMessage = errMessage;
    }

    public String getErrMessage() {
        return errMessage;
    }

    public void setErrMessage(String errMessage) {
        this.errMessage = errMessage;
    }
}
