package framework.handler;

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
public class MappingInfo {

    private String uri;
    private Method method;
    private Class<?> controller;
    private String[] args;

    public MappingInfo(String uri, Method method, Class<?> controller, String[] args) {
        this.uri = uri;
        this.method = method;
        this.controller = controller;
        this.args = args;
    }

    public boolean handle(ServletRequest request, ServletResponse response) throws IllegalAccessException, InstantiationException, InvocationTargetException, IOException {
        String reqUri = ((HttpServletRequest) request).getRequestURI();
        if(!this.uri.equals(reqUri)){
            return false;
        }
        Object[] parameters = new Object[args.length];
        for(int i = 0; i < args.length; i++){
            parameters[i] = request.getParameter(args[i]);
        }

        Object controllerObject = controller.newInstance();
        Object responseObject = method.invoke(controllerObject, parameters);
        response.getWriter().print(responseObject.toString());
        return true;
    }

}
