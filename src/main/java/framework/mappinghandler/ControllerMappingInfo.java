package framework.mappinghandler;

import framework.bean.v1.BeanFactory;

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
    //TODO 需要优化此处的BeanFactory
    private BeanFactory beanFactory;
    public ControllerMappingInfo(String uri, Method method, Class<?> controller, String[] methodParas, BeanFactory beanFactory) {
        this.uri = uri;
        this.method = method;
        this.controller = controller;
        this.methodParas = methodParas;
        this.beanFactory = beanFactory;
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

        Object controllerObject = beanFactory.getBean(controller);
        Object responseObject = method.invoke(controllerObject, parameters);
        response.getWriter().print(responseObject.toString());
        return true;
    }

}
