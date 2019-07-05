package framework.bean.factory;

import java.util.List;

/**
 * @author : xiaoheshang
 * @version: 2.0 版本新增
 * @time : 2019/6/19 - 1:48 PM
 * @Param :
 * @function :
 */
public interface BeanFactory {

   /**
    * @author : xiaoheshang
    * @version: 2.0
    * @time : 2019/6/19 - 1:50 PM
    * @Param :
    * @function : 从容器中获取Bean
    */
   Object getBean(Class<?> cls) throws Exception;

   /**
    * @author : xiaoheshang
    * @version: 2.0
    * @time : 2019/6/19 - 1:50 PM
    * @Param :
    * @function : 设置Bean 到容器中
    */
   void setBean(Class<?> cls, Object object) throws Exception;

}
