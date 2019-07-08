package framework.annotation.mvc;

import java.lang.annotation.*;

/**
 * @author : zhengjianbin
 * @version : 1.0
 * @time : 2019/6/12 - 1:55 PM
 * @Param :
 * @function : RequestPara 注解，功能类似于Spring RequestParam
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
public @interface RequestParam {

    String value();

}
