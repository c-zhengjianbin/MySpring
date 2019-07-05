package framework.bean.v2;

import framework.annotation.bean.Autowired;
import framework.bean.definition.BeanDefinition;
import framework.bean.factory.AbstractBeanFactory;

import java.lang.reflect.Field;
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
    protected Object createBean(Class<?> cls) throws Exception {
        Object objcet = instantiationBean(cls);
        initializeBeanDi(cls,objcet);
        return objcet;
    }

    /**
     * @author : xiaoheshang
     * @version: 2.0
     * @time : 2019/6/19 - 1:50 PM
     * @Param :
     * @function :  实例化Bean
     */
    private Object instantiationBean(Class<?> cls) throws Exception{
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
     * @author : xiaoheshang
     * @version: 2.0
     * @time : 2019/6/19 - 1:50 PM
     * @Param :
     * @function :  设置Bean 的依赖关系
     */
    private void initializeBeanDi( Class<?> cls, Object object){
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

//    @Override
//    public Object getBean(Class<?> cls) {
//        Object object = beanContainer.get(cls);
//        if(object == null){
//            //触发Bean 实例化以及依赖注入
//            try {
//                object = instantiationBean(cls);
//            } catch (Exception e) {
//                //TODO 日志功能有待完善
//                System.out.println();
//                e.printStackTrace();
//            }
//        }
//        return object;
//    }

//    @Override
//    public Object instantiationBean(Class<?> cls) throws Exception {
//        if(!beanDefinitionMap.containsKey(cls)){
//            throw new Exception("not found object :" + cls.getName());
//        }
//        BeanDefinition beanDefinition = beanDefinitionMap.get(cls);
//        Object bean = beanDefinition.getAnntionTypeAndProcessor().resolveObject();
//        return bean;
//    }

    public void setBeanDefinitionMap(Map<Class<?>, BeanDefinition> beanDefinitionMap) {
        this.beanDefinitionMap = beanDefinitionMap;
    }

}
