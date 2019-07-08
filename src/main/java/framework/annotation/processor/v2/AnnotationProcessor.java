package framework.annotation.processor.v2;

import framework.annotation.mvc.Controller;
import framework.annotation.mvc.RequestMapping;
import framework.annotation.mvc.RequestParam;
import framework.bean.v2.DefaultBeanFactory;
import framework.mappinghandler.v2.ControllerMappingInfo;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhengjianbin on 2019/7/5.
 */
public class AnnotationProcessor extends DefaultBeanFactory {

    public static List<ControllerMappingInfo> controllerMappingInfoList = new ArrayList<>();

    /**
     * @author : zhengjianbin
     * @version : 2.0
     * @time : 2019/6/13 - 1:41 PM
     * @Param :
     * @function : 解析扫描到的类包含的注解
     */
    public void resolveMappingHandler(List<Class<?>> classes){
        for(Class<?>  cls: classes){
            if(cls.isAnnotationPresent(Controller.class)){
                handleControllerAnnotation(cls);
            }
        }
    }

    /**
     * @author : zhengjianbin
     * @version : 2.0
     * @time : 2019/6/13 - 1:41 PM
     * @Param :
     * @function : 处理Controller 注解
     */
    private void handleControllerAnnotation(Class<?> cls){
        Method[] methods = cls.getDeclaredMethods();
        for(Method method : methods){
            if(!method.isAnnotationPresent(RequestMapping.class)){
                continue;
            }
            String uri = method.getDeclaredAnnotation(RequestMapping.class).value();
            List<String> paramList = new ArrayList<String>();
            for(Parameter parameter : method.getParameters()){
                if(parameter.isAnnotationPresent(RequestParam.class)){
                    paramList.add(parameter.getDeclaredAnnotation(RequestParam.class).value());
                }
            }
            String[] params = paramList.toArray(new String[paramList.size()]);
            Object controllerBean = getBean(cls);
            ControllerMappingInfo controllerMappingInfo = new ControllerMappingInfo(uri,controllerBean, method, params);
            controllerMappingInfoList.add(controllerMappingInfo);
        }
    }

}
