package com.xuecheng.base.exception;

import java.io.Serializable;

/**
 * @author Costar
 * @version 1.0
 * @description 本项目自定义异常类型
 * @date 2023年5月24日 12点56分
 */
public class BaseException extends RuntimeException implements Serializable {
    private Integer errCdoe;
    private String errMessage;

    public BaseException() {
    }

    public BaseException(Integer errCdoe, String errMessage) {
        this.errCdoe = errCdoe;
        this.errMessage = errMessage;
    }

    public Integer geterrCdoe() {
        return errCdoe;
    }

    public void seterrCdoe(Integer errCdoe) {
        this.errCdoe = errCdoe;
    }

    public String getErrMessage() {
        return errMessage;
    }

    public void setErrMessage(String errMessage) {
        this.errMessage = errMessage;
    }
}
