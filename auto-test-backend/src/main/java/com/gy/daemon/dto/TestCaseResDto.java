package com.gy.daemon.dto;

import com.gy.daemon.lib.common.base.BaseTestCase;

/**
 * Created by yang_gao on 2017/10/1.
 */
public class TestCaseResDto<T> extends BaseTestCase{
    String rspCode;
    String rspMessage;
    T responseBody;

    @Override
    public String toString() {
        return "TestCaseResDto{" +
                "rspCode='" + rspCode + '\'' +
                ", rspMessage='" + rspMessage + '\'' +
                ", responseBody=" + responseBody +
                "} " + super.toString();
    }
}
