package com.example.data_storage.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.example.data_storage.enums.DBTypeEnum;
import com.example.data_storage.route.MyRoutingDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * @author lujifa@jxtech
 * @version 1.0.0
 * @Description 数据源配置
 * @createTime 2021年12月21日 11:42:00
 */
@Configuration
public class DataSourceConfig {

    @Bean
    @ConfigurationProperties("spring.datasource.master")
    public DataSource masterDataSource() {
        DruidDataSource dataSource = DruidDataSourceBuilder.create().build();
        dataSource.setValidationQuery("select server_status();");
        return dataSource;
    }

    @Bean
    @ConfigurationProperties("spring.datasource.slave1")
    public DataSource slave1DataSource() {
        DruidDataSource dataSource = DruidDataSourceBuilder.create().build();
        dataSource.setValidationQuery("select server_status();");
        return dataSource;
    }

    @Bean
    public DataSource myRoutingDataSource(@Qualifier("masterDataSource") DataSource masterDataSource,
                                          @Qualifier("slave1DataSource") DataSource slave1DataSource) {
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put(DBTypeEnum.MASTER, masterDataSource);
        targetDataSources.put(DBTypeEnum.SLAVE1, slave1DataSource);
        MyRoutingDataSource myRoutingDataSource = new MyRoutingDataSource();
        myRoutingDataSource.setDefaultTargetDataSource(masterDataSource);
        myRoutingDataSource.setTargetDataSources(targetDataSources);
        return myRoutingDataSource;
    }

}
