package framework.bean;

import framework.annotation.bean.Autowired;
import framework.annotation.bean.Bean;
import framework.annotation.mvc.Controller;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

/**
 * @author : xiaoheshang
 *
 * @time : 2019/6/13 - 2:03 PM
 * @Param :
 * @function : 实例化Bean 工厂
 */
public class BeanFactory {

    /**
     * Bean 容器
     */
    public static Map<Class<?>, Object> beanContainer = new ConcurrentHashMap<>();

    /**
     * @author : xiaoheshang
     *
     * @time : 2019/6/13 - 2:06 PM
     * @Param :
     * @function : 从容器中获取Bean
     */
    public static Object getBean(Class<?> cls){
       return beanContainer.get(cls);
    }

    /**
     * @author : xiaoheshang
     *
     * @time : 2019/6/13 - 2:19 PM
     * @Param :
     * @function : 初始化Beans
     * TODO: 需要解决循环注入问题、根据变量名获取实例问题
     */
    public static void initializeBean(List<Class<?>> classList){
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
