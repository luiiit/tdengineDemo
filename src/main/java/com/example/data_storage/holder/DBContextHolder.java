package com.example.data_storage.holder;

import com.example.data_storage.enums.DBTypeEnum;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author lujifa@jxtech
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年12月21日 11:46:00
 */
@Slf4j
public class DBContextHolder {

    private static final ThreadLocal<DBTypeEnum> contextHolder = new ThreadLocal<>();

    private static final AtomicInteger counter = new AtomicInteger(-1);

    public static void set(DBTypeEnum dbType) {
        contextHolder.set(dbType);
    }

    public static DBTypeEnum get() {
        return contextHolder.get();
    }

    public static void master() {
        set(DBTypeEnum.MASTER);
        log.info("切换到master");
    }

    public static void slave() {
        set(DBTypeEnum.SLAVE1);
        log.info("切换到slave1");
    }
}
