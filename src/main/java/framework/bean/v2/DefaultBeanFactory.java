package framework.bean.v2;

import framework.bean.definition.BeanDefinition;
import framework.bean.factory.AbstractBeanFactory;

import java.util.Map;

/**
 * @author : xiaoheshang
 * @version: 2.0 ，Bean 的依赖注入由第一次获取Bean 时触发
 * @time : 2019/6/13 - 2:03 PM
 * @Param :
 * @function : 实例化Bean 工厂，
 */
public class DefaultBeanFactory extends AbstractBeanFactory {

    protected Map<Class<?>, BeanDefinition> beanDefinitionMap;

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
        if(!beanDefinitionMap.containsKey(cls)){
            throw new Exception("not found object :" + cls.getName());
        }
        BeanDefinition beanDefinition = beanDefinitionMap.get(cls);
        Object bean = beanDefinition.getAnntionTypeAndProcessor().resolveObject();
        return bean;
    }

    public void setBeanDefinitionMap(Map<Class<?>, BeanDefinition> beanDefinitionMap) {
        this.beanDefinitionMap = beanDefinitionMap;
    }

}
