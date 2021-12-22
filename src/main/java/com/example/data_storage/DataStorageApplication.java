package com.example.data_storage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.example.data_storage.dao")
public class DataStorageApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataStorageApplication.class, args);
    }

}
