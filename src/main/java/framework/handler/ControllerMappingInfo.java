package framework.handler;

import framework.bean.BeanFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author : xiaoheshang
 *
 * @time : 2019/6/12 - 2:37 PM
 * @Param :
 * @function : 每个方法映射所包含的信息
 */
public class ControllerMappingInfo {

    private String uri;
    private Method method;
    private Class<?> controller;
    private String[] methodParas;

    public ControllerMappingInfo(String uri, Method method, Class<?> controller, String[] methodParas) {
        this.uri = uri;
        this.method = method;
        this.controller = controller;
        this.methodParas = methodParas;
    }

    /**
     * @author : xiaoheshang
     *
     * @time : 2019/6/13 - 1:33 PM
     * @Param :
     * @function : 根据请求uri，调用相应对象方法
     */
    public boolean invoke(ServletRequest request, ServletResponse response) throws IllegalAccessException, InstantiationException, InvocationTargetException, IOException {
        String reqUri = ((HttpServletRequest) request).getRequestURI();
        if(!this.uri.equals(reqUri)){
            return false;
        }
        Object[] parameters = new Object[methodParas.length];
        for(int i = 0; i < methodParas.length; i++){
            parameters[i] = request.getParameter(methodParas[i]);
        }

        Object controllerObject = BeanFactory.getBean(controller);
        Object responseObject = method.invoke(controllerObject, parameters);
        response.getWriter().print(responseObject.toString());
        return true;
    }

}
