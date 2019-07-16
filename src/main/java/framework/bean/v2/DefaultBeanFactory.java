package framework.bean.v2;

import framework.annotation.bean.Autowired;
import framework.bean.definition.BeanDefinition;
import framework.bean.factory.AbstractBeanFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : zhengjianbin
 * @version: 2.0
 * @time : 2019/6/13 - 2:03 PM
 * @Param :
 * @function : 实例化Bean 工厂，Bean 的依赖注入由第一次获取Bean 时触发
 */
public class DefaultBeanFactory extends AbstractBeanFactory {

    protected Map<Class<?>, BeanDefinition> beanDefinitionMap;

    public static final Map<String, Method> URL_AND_METHOD = new HashMap();

    @Override
    protected Object createBean(Class<?> cls) throws Exception {
        Object objcet = instantiationBean(cls);
        initializeBeanDi(cls,objcet);
        return objcet;
    }

    /**
     * @author : zhengjianbin
     * @version: 2.0
     * @time : 2019/6/19 - 1:50 PM
     * @Param :
     * @function :  实例化Bean
     */
    private Object instantiationBean(Class<?> cls) throws Exception{
        System.out.println("实例化Bean："+cls.getName());
        Object o = null;
        try {
            o = cls.newInstance();
            setBean(cls, o);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(o == null){
            throw new Exception("cls 初始化失败，请检查！！！");
        }
        return o;
    }

    /**
     * @author : zhengjianbin
     * @version: 2.0
     * @time : 2019/6/19 - 1:50 PM
     * @Param :
     * @function :  设置Bean 的依赖关系
     */
    private void initializeBeanDi( Class<?> cls, Object object){
        System.out.println("设置Bean 的依赖关系："+cls.getName());
        Field[] fields = cls.getDeclaredFields();
        for(Field field: fields){
            if(field.isAnnotationPresent(Autowired.class)){
                Class<?> fieldClass = field.getType();
                try {
                    Object diObject = getBean(fieldClass);
                    field.setAccessible(true);
                    field.set(object, diObject);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void setBeanDefinitionMap(Map<Class<?>, BeanDefinition> beanDefinitionMap) {
        this.beanDefinitionMap = beanDefinitionMap;
    }

    public void registerHandler(String url, Method method){
        URL_AND_METHOD.put(url, method);
        System.out.println("设置URL："+url+"--Method:"+method.getName());
    }

    public static Method getMethodByUrl(String url) throws Exception{
        Method handler = URL_AND_METHOD.get(url);
        if(handler == null){
            System.out.println("通过Url 获取Handler，Url 为："+url);
            throw new Exception("根据Url 获取Handler 出错......");
        }
        return handler;
    }

}
