package framework.bean.factory;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author : zhengjianbin
 * @version: 2.0 版本新增
 * @time : 2019/6/19 - 1:48 PM
 * @Param :
 * @function : 默认容器类
 */
public abstract class AbstractBeanFactory implements BeanFactory {

    protected Map<Class<?>, Object> beanContainer = new ConcurrentHashMap<>();

    protected abstract Object createBean(Class<?> cls) throws Exception;

    @Override
    public Object getBean(Class<?> cls) {
       Object object  = beanContainer.get(cls);
       if(object == null){
           try {
               System.out.println("从容器中获取Bean:"+cls.getName() + " 失败！");
               object = createBean(cls);

           } catch (Exception e) {
               System.out.println("初始化Bean 失败！！！");
           }
       }else{
           System.out.println("从荣区中获取Bean:"+cls.getName()+ "成功！");
       }
       return object;
    }

    @Override
    public void setBean(Class<?> cls, Object object) throws Exception {
        beanContainer.put(cls, object);
    }
}
