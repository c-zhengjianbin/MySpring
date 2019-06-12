package framework.web.servlet;

import framework.handler.HoldMapper;
import framework.handler.MappingInfo;

import javax.servlet.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by zhengjianbin on 2019/6/11.
 */
public class TestServlet implements Servlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        for(MappingInfo mappingInfo : HoldMapper.mappingInfoList){
            try {
                mappingInfo.handle(servletRequest, servletResponse);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }

        servletResponse.getWriter().write("Hello MySpring Servlet");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
