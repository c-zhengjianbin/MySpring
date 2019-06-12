package framework.handler;

import framework.annotation.mvc.Controller;
import framework.annotation.mvc.RequestMapping;
import framework.annotation.mvc.RequestParam;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : xiaoheshang
 *
 * @time : 2019/6/12 - 2:57 PM
 * @Param :
 * @function : Mapping 持有者
 */
public class HoldMapper {

        public static List<MappingInfo> mappingInfoList = new ArrayList<MappingInfo>();

        public static void resolveMappingHandler(List<Class<?>> classes){
            for(Class<?>  cls: classes){
                if(cls.isAnnotationPresent(Controller.class)){
                    presentHandlerFromController(cls);
                }
            }
        }

        private static void presentHandlerFromController(Class<?> cls){
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
                MappingInfo mappingInfo = new MappingInfo(uri, method, cls, params);
                HoldMapper.mappingInfoList.add(mappingInfo);
            }
        }

}
