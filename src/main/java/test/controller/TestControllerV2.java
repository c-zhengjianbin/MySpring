package test.controller;

import framework.annotation.bean.Autowired;
import framework.annotation.mvc.Controller;
import framework.annotation.mvc.RequestMapping;
import test.service.UserService;
import test.service.UserServiceV2;

/**
 * Created by zhengjianbin on 2019/7/8.
 */
@Controller
@RequestMapping("/testControllerV2")
public class TestControllerV2 {

    @Autowired
    private UserServiceV2 userServiceV2;

    @Autowired
    private UserService userService;

    @RequestMapping("/testV2Ioc")
    public String testV2Ioc(){
       return userServiceV2.printV2("");
    }

}
