package framework.web.server;

import framework.web.servlet.MyDispatcherServlet;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;

/**
 * @author : xiaoheshang
 *
 * @time : 2019/6/11 - 4:15 PM
 * @Param :
 * @function : 对Tomcat 进行封装
 */
public class TomcatServer {

    private Tomcat tomcat;
    private String[] args;

    public TomcatServer(String[] args) {
        this.args = args;
    }

    public void startServer() throws LifecycleException {
        tomcat = new Tomcat();
        tomcat.setPort(18080);

        Context context = new StandardContext();
        context.setPath("");
        context.addLifecycleListener(new Tomcat.FixContextListener());

        MyDispatcherServlet myDispatcherServlet = new MyDispatcherServlet();
        Tomcat.addServlet(context, "dispatchServlet", myDispatcherServlet);

        //URL 映射
        context.addServletMappingDecoded("/", "dispatchServlet");
        tomcat.getHost().addChild(context);

        //设置为非守护线程
        tomcat.start();
        tomcat.getServer().await();

    }

}
