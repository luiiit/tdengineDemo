package com.example.data_storage.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * @author lujifa@jxtech
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年12月21日 14:44:00
 */
@Configuration
public class MyBatisConfig {

    @Resource(name = "myRoutingDataSource")
    private DataSource myRoutingDataSource;

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(myRoutingDataSource);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }
}