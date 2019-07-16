package framework.mappinghandler.v2;

import framework.annotation.mvc.RequestParam;
import org.apache.catalina.connector.Request;

import javax.servlet.ServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhengjianbin on 2019/7/16.
 */
public class MethodInvoke {

    public static void methodInvoke(Object object, Method method, ServletResponse response){
       Parameter[] parameters = method.getParameters();
       List<Object> para = new ArrayList<>();
       for(Parameter parameter : parameters){
           if(parameter.isAnnotationPresent(RequestParam.class)){
               para.add(parameter.getDeclaredAnnotation(RequestParam.class).value());
           }
       }
       Object[] params = para.toArray(new Object[para.size()]);
        try {
           Object result = method.invoke(object, params);
            response.getWriter().print(result);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
