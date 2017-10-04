package com.gy.daemon.service.impl;

import com.gy.daemon.dao.TcInfoDao;
import com.gy.daemon.dto.db.TcInfoEntity;
import com.gy.daemon.lib.common.base.BaseTestCase;
import com.gy.daemon.service.TestCaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yang_gao on 2017/10/1.
 */
@Service
public class TestCaseServiceImpl implements TestCaseService{

    private static final Logger logger = LoggerFactory.getLogger(TestCaseServiceImpl.class);

    @Autowired
    TcInfoDao tcInfoDao;

    @Override
    public List<TcInfoEntity> getAllTestCase() throws Exception {
        return tcInfoDao.queryAllTc();
    }

    @Override
    public List<TcInfoEntity> getTestCaseByAppId(String appId) throws Exception {
        return tcInfoDao.queryTcByAppId(appId);
    }

    @Override
    public TcInfoEntity getTestCaseByTcId(Integer tcId) throws Exception  {
        return tcInfoDao.queryTcByTcId(tcId);
    }

    @Override
    public int insertTc(TcInfoEntity tcInfoEntity) throws Exception {
        try{
            int i = tcInfoDao.insert(tcInfoEntity);
            return i;
        }catch(Exception e){
            throw e;
        }
    }

    @Override
    public int updateTc(TcInfoEntity tcInfoEntity) throws Exception {
        try{
            int i = tcInfoDao.updateByTcId(tcInfoEntity);
            return i;
        }catch(Exception e){
            throw e;
        }
    }


}
