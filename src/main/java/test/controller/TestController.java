package test.controller;

import framework.annotation.bean.Autowired;
import framework.annotation.mvc.Controller;
import framework.annotation.mvc.RequestMapping;
import framework.annotation.mvc.RequestParam;
import test.service.UserService;

/**
 * Created by zhengjianbin on 2019/6/12.
 */
@Controller
public class TestController {

    @Autowired
    private UserService service;

    @RequestMapping("/helloWorld")
    public String helloWorld(@RequestParam("name") String name){
        return service.getInfo(name);
    }

}
