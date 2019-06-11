package test;

import framework.starter.MySpringApplication;
import framework.web.server.TomcatServer;
import org.apache.catalina.LifecycleException;

/**
 * @author : xiaoheshang
 *
 * @time : 2019/6/11 - 4:05 PM
 * @Param :
 * @function : 日常测试类
 */
public class MainTest {

    public static void main(String[] args){
        MySpringApplication.run(MainTest.class, args);
        TomcatServer tomcatServer = new TomcatServer(args);
        try {
            tomcatServer.startServer();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
    }

}
