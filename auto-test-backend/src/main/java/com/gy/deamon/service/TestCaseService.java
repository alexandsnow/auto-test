package com.gy.deamon.service;

/**
 * Created by yang_gao on 2017/10/1.
 */

import com.gy.deamon.lib.common.base.BaseTestCase;

/**
 * 管理TestCase的生命周期
 * create,query,update,delete
 */
public interface TestCaseService {
    int createTestCase(BaseTestCase baseTestCase);
    BaseTestCase getTestCase();

}
