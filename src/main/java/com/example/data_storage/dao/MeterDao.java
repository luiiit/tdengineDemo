package com.example.data_storage.dao;

import com.example.data_storage.bean.Meters;

import java.util.List;

/**
 * @author lujifa@jxtech
 * @version 1.0.0
 * @Description 查询dto
 * @createTime 2021年12月21日 14:13:00
 */
public interface MeterDao {

    List<Meters> queryList();

    Integer insert();

    Long queryCount();
}
