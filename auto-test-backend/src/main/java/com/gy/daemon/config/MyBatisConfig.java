package com.gy.daemon.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by yang_gao on 2017/10/2.
 */

@Configuration
@MapperScan(basePackages = {"com.gy.daemon.dao"})
public class MyBatisConfig {
}
