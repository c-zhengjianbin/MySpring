package framework.annotation.bean;

import java.lang.annotation.*;

/**
 * @author : xiaoheshang
 *
 * @time : 2019/6/13 - 1:54 PM
 * @Param :
 * @function : 实例化Bean
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Bean {
}
