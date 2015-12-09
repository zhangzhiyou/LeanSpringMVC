package com.you;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Created by zhiyou on 15-12-9.
 */

/**
 * 说明这是个切面
 * */
@Aspect

/**
 * 该注解初始化切面本身
 * */
@Component

public class Commont {
    /**
     * 该注解
     * 在执行com.you.dao.UserDao.check()方法之前执行本类的execute()方法
     * 并且可以带参数
     * */
    @Before("execution(* com.you.dao.UserDao.check(String))")
    public void execute(){
        System.out.println("-----这是普通类----");
    }
}
