package com.gy.daemon.portal.service;

import com.gy.daemon.lib.common.base.TestCaseBaseDto;

import java.util.List;

/**
 * Created by yang_gao on 2017/10/4.
 */
public interface TestCaseService {
    List<TestCaseBaseDto> getAllTestCase() throws Exception;

    List<TestCaseBaseDto> getTestCaseByAppId(String appId);

    TestCaseBaseDto getTestCaseById();
}
