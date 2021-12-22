package com.example.data_storage.aspect;

import com.example.data_storage.holder.DBContextHolder;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


/**
 * @author lujifa@jxtech
 * @version 1.0.0
 * @Description 数据源切换切面配置
 * @createTime 2021年12月21日 11:48:00
 */
@Aspect
@Component
public class DataSourceAop {

    @Pointcut("!@annotation(com.example.data_storage.annotion.Master) " +
            "&& (execution(* com.example.data_storage.service..*.select*(..)) " +
            "|| execution(* com.example.data_storage.service..*.get*(..))" +
            "|| execution(* com.example.data_storage.service..*.find*(..))" +
            "|| execution(* com.example.data_storage.service..*.query*(..)))")
    public void readPointcut() {

    }

    @Pointcut("@annotation(com.example.data_storage.annotion.Master) " +
            "|| execution(* com.example.data_storage.service..*.insert*(..)) " +
            "|| execution(* com.example.data_storage.service..*.add*(..)) " +
            "|| execution(* com.example.data_storage.service..*.update*(..)) " +
            "|| execution(* com.example.data_storage.service..*.edit*(..)) " +
            "|| execution(* com.example.data_storage.service..*.create*(..)) " +
            "|| execution(* com.example.data_storage.service..*.remove*(..))")
    public void writePointcut() {

    }

    @Before("readPointcut()")
    public void read() {
        DBContextHolder.slave();
    }

    @Before("writePointcut()")
    public void write() {
        DBContextHolder.master();
    }
}