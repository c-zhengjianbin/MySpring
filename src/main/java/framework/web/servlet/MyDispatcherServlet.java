package framework.web.servlet;

import framework.annotation.processor.v1.AnnotationProcessor;
import framework.annotation.processor.v2.AnnotationProcessorV2;
import framework.mappinghandler.v2.ControllerMappingInfo;

import javax.servlet.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * Created by zhengjianbin on 2019/6/11.
 */
public class MyDispatcherServlet implements Servlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        //List<ControllerMappingInfo> controllerMappingInfos = AnnotationProcessor.controllerMappingInfoList;
        List<ControllerMappingInfo> controllerMappingInfos = AnnotationProcessorV2.getControllerList();
        for(ControllerMappingInfo controllerMappingInfo : controllerMappingInfos){
            try {
                controllerMappingInfo.invoke(servletRequest, servletResponse);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
