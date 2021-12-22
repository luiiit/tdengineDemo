package com.example.data_storage.controller;

import com.example.data_storage.bean.Meters;
import com.example.data_storage.service.MetersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author lujifa@jxtech
 * @version 1.0.0
 * @Description 测试接口
 * @createTime 2021年12月21日 11:56:00
 */
@RestController
@RequestMapping("/test")
public class TestOperationController {

    @Autowired
    private MetersService metersService;

    @RequestMapping("queryList")
    public List<Meters> queryList(){
        return metersService.queryList();
    }

    @RequestMapping("queryList2")
    public List<Meters> queryList2(){
        return metersService.queryList2();
    }

    @RequestMapping("insert")
    public Integer insert(){
       return metersService.insert();
    }

    @RequestMapping("queryCount")
    public Long queryCount(){
        return metersService.queryCount();

    }
}
