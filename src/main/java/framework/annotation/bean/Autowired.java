package framework.annotation.bean;

import java.lang.annotation.*;

/**
 * @author : xiaoheshang
 *
 * @time : 2019/6/13 - 1:52 PM
 * @Param :
 * @function : 标记需要注入的域
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Autowired {
}
