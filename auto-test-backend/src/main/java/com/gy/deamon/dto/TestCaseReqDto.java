package com.gy.deamon.dto;

import com.gy.deamon.lib.common.base.BaseTestCase;

/**
 * Created by yang_gao on 2017/10/1.
 */
public class TestCaseReqDto<T> extends BaseTestCase{
    String requestMethod;
    T requestParam;

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    public T getRequestParam() {
        return requestParam;
    }

    public void setRequestParam(T requestParam) {
        this.requestParam = requestParam;
    }

    @Override
    public String toString() {
        return "TestCaseReqDto{" +
                "requestMethod='" + requestMethod + '\'' +
                ", requestParam=" + requestParam +
                "} " + super.toString();
    }
}
