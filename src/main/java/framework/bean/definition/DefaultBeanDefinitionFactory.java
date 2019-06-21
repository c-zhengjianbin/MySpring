package framework.bean.definition;

import framework.bean.v2.DefaultBeanFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : xiaoheshang
 *
 * @time : 2019/6/21 - 2:39 PM
 * @Param :
 * @function : BeanDefinitionFactory 工厂
 */
public class DefaultBeanDefinitionFactory extends DefaultBeanFactory {

    public void initializeBeandefinition(List<Class<?>> classList){
        Map<Class<?>, BeanDefinition> beanDefinitionMap = new HashMap<>();
        for(Class cls : classList){
            beanDefinitionMap.put(cls, loadDefinition(cls));
        }
        setBeanDefinitionMap(beanDefinitionMap);
    }

    private BeanDefinition loadDefinition(Class<?> cls){
        BeanDefinition definition = new BeanDefinition(cls, null);
        //TODO 配置注解处理有点问题，注解如何与注解处理器关联？
        return definition;
    }

}
