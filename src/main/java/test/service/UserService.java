package test.service;

import framework.annotation.bean.Bean;

/**
 * Created by zhengjianbin on 2019/6/13.
 */
@Bean
public class UserService {

    public String getInfo(String name){
        System.out.println("这是UserService 的getInfo 方法");
        return "这是UserService 的getInfo 方法";
    }



}
