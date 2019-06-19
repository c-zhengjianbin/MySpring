package framework.bean.definition;

import framework.annotation.processor.support.DefaultAbstractAnnotationProcessor;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author : xiaoheshang
 * @version: 2.0 版本引入
 * @time : 2019/6/19 - 2:18 PM
 * @Param :
 * @function : 用来描述实例信息
 */
public class BeanDefinition {

    private Class<?> instance;

    private DefaultAbstractAnnotationProcessor anntionTypeAndProcessor;

    public BeanDefinition(Class<?> instance, DefaultAbstractAnnotationProcessor anntionTypeAndProcessor) {
        this.instance = instance;
        this.anntionTypeAndProcessor = anntionTypeAndProcessor;
    }

    public Class<?> getInstance() {
        return instance;
    }

    public void setInstance(Class<?> instance) {
        this.instance = instance;
    }

    public DefaultAbstractAnnotationProcessor getAnntionTypeAndProcessor() {
        return anntionTypeAndProcessor;
    }

    public void setAnntionTypeAndProcessor(DefaultAbstractAnnotationProcessor anntionTypeAndProcessor) {
        this.anntionTypeAndProcessor = anntionTypeAndProcessor;
    }
}
