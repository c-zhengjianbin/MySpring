package framework.bean.v2;

import framework.bean.definition.BeanDefinition;
import framework.bean.factory.AbstractDefaultBeanFactory;

import java.beans.ExceptionListener;
import java.util.List;

/**
 * @author : xiaoheshang
 * @version: 2.0 ，Bean 的依赖注入由第一次获取Bean 时触发
 * @time : 2019/6/13 - 2:03 PM
 * @Param :
 * @function : 实例化Bean 工厂，
 */
public class BeanFactory extends AbstractDefaultBeanFactory {

    @Override
    public Object getBean(Class<?> cls) {
        Object object = beanContainer.get(cls);
        if(object == null){
            //触发Bean 实例化以及依赖注入
            try {
                object = instantiationBean(cls);
            } catch (Exception e) {
                //TODO 日志功能有待完善
                System.out.println();
                e.printStackTrace();
            }
        }
        return object;
    }

    @Override
    public Object instantiationBean(Class<?> cls) throws Exception {
        BeanDefinition beanDefinition = getBeanDefinition(cls);
        Object bean = beanDefinition.getAnntionTypeAndProcessor().resolveObject();
        return bean;
    }
}
