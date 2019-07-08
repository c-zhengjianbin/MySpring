package test.service;

import framework.annotation.bean.Bean;

/**
 * Created by zhengjianbin on 2019/7/8.
 */
@Bean
public class UserServiceV2 {

    public String printV2(String name){
        System.out.println("this UserServiceV2 printV2 Method");
        return "this UserServiceV2 printV2 Method";
    }

}
