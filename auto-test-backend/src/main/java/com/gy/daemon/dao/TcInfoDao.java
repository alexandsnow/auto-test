package com.gy.daemon.dao;

import com.gy.daemon.dto.db.TcInfoEntity;

import java.util.List;

public interface TcInfoDao {





    List<TcInfoEntity> queryTcByAppId(String appId);

    TcInfoEntity queryTcByTcId(Integer tcId);

    List<TcInfoEntity> queryAllTc();

    int insert(TcInfoEntity record);

    int updateByTcId(TcInfoEntity record);

    int deleteByTcId(Integer id);
}