package com.example.data_storage.service.impl;

import com.example.data_storage.bean.Meters;
import com.example.data_storage.dao.MeterDao;
import com.example.data_storage.service.MetersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * @author lujifa@jxtech
 * @version 1.0.0
 * @Description 数据持久化类
 * @createTime 2021年12月20日 11:01:00
 */
@Service
public class MetersServiceImpl implements MetersService {

    @Autowired
    private MeterDao meterDao;

    @Override
    public List<Meters> queryList(){
        return meterDao.queryList();
    }

    @Override
    public List<Meters> queryList2(){
        return meterDao.queryList();
    }

    @Override
    public Integer insert(){
         return meterDao.insert();
    }

    @Override
    public Long queryCount(){
        return meterDao.queryCount();
    }

}
