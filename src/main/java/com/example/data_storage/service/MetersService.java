package com.example.data_storage.service;

import com.example.data_storage.bean.Meters;

import java.util.List;

/**
 * @author lujifa@jxtech
 * @version 1.0.0
 * @Description 查询服务
 * @createTime 2021年12月21日 14:21:00
 */
public interface MetersService {
    List<Meters> queryList();

    List<Meters> queryList2();

    Integer insert();

    Long queryCount();
}
