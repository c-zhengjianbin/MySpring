package framework.annotation.processor;

import framework.annotation.mvc.Controller;
import framework.annotation.mvc.RequestMapping;
import framework.annotation.mvc.RequestParam;
import framework.mappinghandler.ControllerMappingInfo;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : xiaoheshang
 *
 * @time : 2019/6/12 - 2:57 PM
 * @Param :
 * @function : 注解处理器
 */
public class AnnotationProcessor {

        public static List<ControllerMappingInfo> controllerMappingInfoList = new ArrayList<>();

        /**
         * @author : xiaoheshang
         *
         * @time : 2019/6/13 - 1:41 PM
         * @Param :
         * @function : 解析扫描到的类包含的注解
         */
        public static void resolveMappingHandler(List<Class<?>> classes){
            for(Class<?>  cls: classes){
                if(cls.isAnnotationPresent(Controller.class)){
                    handleControllerAnnotation(cls);
                }
            }
        }

        /**
         * @author : xiaoheshang
         *
         * @time : 2019/6/13 - 1:41 PM
         * @Param :
         * @function : 处理Controller 注解
         */
        private static void handleControllerAnnotation(Class<?> cls){
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
                ControllerMappingInfo controllerMappingInfo = new ControllerMappingInfo(uri, method, cls, params);
                AnnotationProcessor.controllerMappingInfoList.add(controllerMappingInfo);
            }
        }

}
