package com.gy.daemon.service;

/**
 * Created by yang_gao on 2017/10/1.
 */

import com.gy.daemon.lib.common.base.BaseTestCase;

/**
 * 管理TestCase的生命周期
 * create,query,update,delete
 */
public interface TestCaseService {
    int createTestCase(BaseTestCase baseTestCase);
    BaseTestCase getTestCase();

}
