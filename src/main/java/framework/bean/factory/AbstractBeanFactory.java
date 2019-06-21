package framework.bean.factory;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author : xiaoheshang
 * @version: 2.0 版本新增
 * @time : 2019/6/19 - 1:48 PM
 * @Param :
 * @function : 默认容器实现类
 */
public abstract class AbstractBeanFactory implements BeanFactory {

    protected Map<Class<?>, Object> beanContainer = new ConcurrentHashMap<>();

    @Override
    public void initializeBean(List<Class<?>> classList) throws Exception {
        throw new Exception("AbstractDefaultBeanFactory not support initializeBean method，Require subclass support");
    }

    @Override
    public Object instantiationBean(Class<?> cls) throws Exception {
        throw new Exception("AbstractDefaultBeanFactory not support instantiationBean method，Require subclass support");
    }

    @Override
    public Object getBean(Class<?> cls) throws Exception {
        throw new Exception("AbstractDefaultBeanFactory not support getBean method，Require subclass support");
    }
}