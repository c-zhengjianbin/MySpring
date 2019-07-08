package framework.bean.v1;

import framework.annotation.bean.Autowired;
import framework.annotation.bean.Bean;
import framework.annotation.mvc.Controller;
import framework.bean.factory.AbstractBeanFactory;

import java.lang.reflect.Field;
import java.util.List;

/**
 * @author : zhengjianbin
 * @version : 1.0
 * @time : 2019/6/13 - 2:03 PM
 * @Param :
 * @function : 实例化Bean 工厂，Bean 的依赖注入在初始化时触发
 */
public class BeanFactory extends AbstractBeanFactory {

    @Override
    protected Object createBean(Class<?> cls) {
        return null;
    }

    /**
     * @author : zhengjianbin
     * @version : 1.0
     * @time : 2019/6/13 - 2:06 PM
     * @Param :
     * @function : 从容器中获取Bean
     */
    @Override
    public Object getBean(Class<?> cls){
       return beanContainer.get(cls);
    }

    /**
     * @author : zhengjianbin
     * @version : 1.0
     * @time : 2019/6/13 - 2:19 PM
     * @Param :
     * @function : 初始化Beans
     * TODO: 需要解决循环注入问题、根据变量名获取实例问题
     */
    public void initializeBean(List<Class<?>> classList){
        classList.forEach(aClass -> {
            if(!aClass.isAnnotationPresent(Bean.class) && !aClass.isAnnotationPresent(Controller.class)){
                return;
            }
            try {
                Object o = aClass.newInstance();
                for(Field field : aClass.getDeclaredFields()){
                    if(field.isAnnotationPresent(Autowired.class)){
                        Class<?> fieldType = field.getType();
                        Object dependObject = getBean(fieldType);
                        if(dependObject == null){
                            dependObject = fieldType.newInstance();
                        }
                        field.setAccessible(true);
                        field.set(o, dependObject);
                    }
                }
                beanContainer.put(aClass, o);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        });
    }


}
