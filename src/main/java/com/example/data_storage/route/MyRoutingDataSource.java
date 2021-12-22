package com.example.data_storage.route;

import com.example.data_storage.holder.DBContextHolder;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.lang.Nullable;

/**
 * @author lujifa@jxtech
 * @version 1.0.0
 * @Description 路由
 * @createTime 2021年12月21日 11:44:00
 */
public class MyRoutingDataSource extends AbstractRoutingDataSource {


    @Nullable
    @Override
    protected Object determineCurrentLookupKey() {
        return DBContextHolder.get();
    }
}
