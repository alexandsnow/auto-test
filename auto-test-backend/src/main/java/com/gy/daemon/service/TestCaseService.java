package com.gy.daemon.service;

/**
 * Created by yang_gao on 2017/10/1.
 */

import com.gy.daemon.dto.db.TcInfoEntity;

import java.util.List;

/**
 * 管理TestCase的生命周期
 * create,query,update,delete
 */
public interface TestCaseService{

    List<TcInfoEntity> getAllTestCase() throws Exception;

    List<TcInfoEntity> getTestCaseByAppId(String appId) throws Exception;

    TcInfoEntity getTestCaseByTcId(Integer tcId) throws Exception;

    int insertTc(TcInfoEntity tcInfoEntity) throws Exception;

    int updateTc(TcInfoEntity tcInfoEntity) throws Exception;

}
