package com.gy.daemon.lib.common.base;

/**
 * Created by yang_gao on 2017/10/1.
 */
public class BaseResponse<T> {

    String resultCode;
    String resultMessage;
    T responseBody;

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public T getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(T responseBody) {
        this.responseBody = responseBody;
    }

    @Override
    public String toString() {
        return "BaseResponse{" +
                "resultCode='" + resultCode + '\'' +
                ", resultMessage='" + resultMessage + '\'' +
                ", responseBody=" + responseBody +
                '}';
    }
}
