package com.gy.daemon.dao;

import com.gy.daemon.dto.db.UserEntity;

/**
 * Created by yang_gao on 2017/10/2.
 */
public interface UserDao {
    UserEntity queryUserByUid(Integer uid);
}
