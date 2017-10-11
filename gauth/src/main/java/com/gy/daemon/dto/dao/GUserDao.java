package com.gy.daemon.dto.dao;

import com.gy.daemon.dto.db.GUserDto;

public interface GUserDao {
    GUserDto selectByUserName(String userId);
}