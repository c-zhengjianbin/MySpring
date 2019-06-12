package framework.annotation.mvc;


import java.lang.annotation.*;

/**
 * @author : xiaoheshang
 *
 * @time : 2019/6/12 - 1:50 PM
 * @Param :
 * @function : RequestMapping 注解，类似于Spring @RequestMapping
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface RequestMapping {

    String value();

}
