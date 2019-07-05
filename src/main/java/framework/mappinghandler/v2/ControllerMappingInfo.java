package framework.mappinghandler.v2;

import framework.bean.v2.DefaultBeanFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by zhengjianbin on 2019/7/5.
 */
public class ControllerMappingInfo {

    private String uri;
    private Object controllerBean;
    private Method method;
    private String[] methodParas;

    public ControllerMappingInfo(String uri, Object controllerBean, Method method, String[] methodParas) {
        this.uri = uri;
        this.controllerBean = controllerBean;
        this.method = method;
        this.methodParas = methodParas;
    }

    public boolean invoke(ServletRequest request, ServletResponse response) throws IllegalAccessException, InstantiationException, InvocationTargetException, IOException {
        String reqUri = ((HttpServletRequest) request).getRequestURI();
        if(!this.uri.equals(reqUri)){
            return false;
        }
        Object[] parameters = new Object[methodParas.length];
        for(int i = 0; i < methodParas.length; i++){
            parameters[i] = request.getParameter(methodParas[i]);
        }

        Object responseObject = method.invoke(controllerBean, parameters);
        response.getWriter().print(responseObject.toString());
        return true;
    }

}
