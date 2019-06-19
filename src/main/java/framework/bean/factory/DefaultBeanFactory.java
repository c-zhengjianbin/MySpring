package framework.bean.factory;

import java.util.List;

/**
 * @author : xiaoheshang
 * @version: 2.0 版本新增
 * @time : 2019/6/19 - 1:48 PM
 * @Param :
 * @function :
 */
public interface DefaultBeanFactory {

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
    * @function : 初始化实例
    */
   void initializeBean(List<Class<?>> classList) throws Exception;

   /**
    * @author : xiaoheshang
    * @version: 2.0
    * @time : 2019/6/19 - 2:04 PM
    * @Param :
    * @function :
    */
   Object instantiationBean(Class<?> cls) throws Exception;

}
