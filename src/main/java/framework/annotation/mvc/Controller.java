package framework.annotation.mvc;

import java.lang.annotation.*;

/**
 * @author : xiaoheshang
 *
 * @time : 2019/6/12 - 1:48 PM
 * @Param :
 * @function : 控制器注解，功能类似于Spring @Controller
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Controller {
}
