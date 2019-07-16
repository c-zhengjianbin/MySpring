package framework.web.servlet;

import framework.annotation.processor.v1.AnnotationProcessor;
import framework.annotation.processor.v2.AnnotationProcessorV2;
import framework.bean.v2.DefaultBeanFactory;
import framework.mappinghandler.v2.ControllerMappingInfo;
import framework.mappinghandler.v2.MethodInvoke;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by zhengjianbin on 2019/6/11.
 */
public class MyDispatcherServlet extends DefaultBeanFactory implements Servlet  {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        invoke(servletRequest, servletResponse);
        /**
         * v1 版本代码
         *  List<ControllerMappingInfo> controllerMappingInfos = AnnotationProcessor.controllerMappingInfoList;
         */

        /**
         * v2 版本代码
         *List<ControllerMappingInfo> controllerMappingInfos = AnnotationProcessorV2.getControllerList();
         *for(ControllerMappingInfo controllerMappingInfo : controllerMappingInfos){
         *   try {
         *       controllerMappingInfo.invoke(servletRequest, servletResponse);
         *   } catch (IllegalAccessException e) {
         *       e.printStackTrace();
         *   } catch (InstantiationException e) {
         *       e.printStackTrace();
         *   } catch (InvocationTargetException e) {
         *       e.printStackTrace();
         *   }
         *  }
         */
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }

    public boolean invoke(ServletRequest servletRequest, ServletResponse servletResponse){
        String reqUri = ((HttpServletRequest) servletRequest).getRequestURI();
        if(reqUri.contains("/favicon.ico")){
            return false;
        }
        try {
            Method method = DefaultBeanFactory.getMethodByUrl(reqUri);
            MethodInvoke.methodInvoke(getBean(method.getDeclaringClass()), method, servletResponse);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
