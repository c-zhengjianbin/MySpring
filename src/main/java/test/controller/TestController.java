package test.controller;

import framework.annotation.mvc.Controller;
import framework.annotation.mvc.RequestMapping;
import framework.annotation.mvc.RequestParam;

/**
 * Created by zhengjianbin on 2019/6/12.
 */
@Controller
public class TestController {

    @RequestMapping("/helloWorld")
    public String helloWorld(@RequestParam("name") String name){
        System.out.println("执行");
        return "Hellow World My Controller";
    }

}
