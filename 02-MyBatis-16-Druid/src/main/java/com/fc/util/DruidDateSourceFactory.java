package com.fc.util;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.datasource.pooled.PooledDataSourceFactory;

public class DruidDateSourceFactory extends PooledDataSourceFactory {
    public DruidDateSourceFactory() {
        //替换数据源
        this.dataSource = new DruidDataSource();
    }
}
