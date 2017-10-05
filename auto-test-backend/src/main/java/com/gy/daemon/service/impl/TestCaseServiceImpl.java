package com.gy.daemon.service.impl;

import com.gy.daemon.dao.TcInfoDao;
import com.gy.daemon.dto.db.TcInfoEntity;
import com.gy.daemon.lib.common.base.BaseTestCase;
import com.gy.daemon.lib.util.StringUtil;
import com.gy.daemon.service.TestCaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by yang_gao on 2017/10/1.
 */
@Service
public class TestCaseServiceImpl implements TestCaseService {

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
    public TcInfoEntity getTestCaseByTcId(String tcId) throws Exception {
        return tcInfoDao.queryTcByTcId(tcId);
    }

    @Override
    public TcInfoEntity insertTc(TcInfoEntity tcInfoEntity) throws Exception {

        tcInfoEntity.setId(StringUtil.makeUUID());
        Date now = new Date();
        tcInfoEntity.setCreateTime(now);
        tcInfoEntity.setModifyTime(now);
        int i = tcInfoDao.insert(tcInfoEntity);
        if (i > 0) {
            return tcInfoEntity;
        } else {
            return null;
        }
    }

    @Override
    public TcInfoEntity updateTc(TcInfoEntity tcInfoEntity) throws Exception {
        tcInfoEntity.setModifyTime(new Date());
        if(tcInfoDao.updateByTcId(tcInfoEntity)>0){
            return tcInfoEntity;
        }else{
            return null;
        }
    }

    @Override
    public int deleteTC(String tcId) throws Exception {
        return tcInfoDao.deleteByTcId(tcId);
    }
}
