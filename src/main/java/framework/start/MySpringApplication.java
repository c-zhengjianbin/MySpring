package framework.start;

import framework.bean.v1.BeanFactory;
import framework.core.ClassScanner;
import framework.annotation.processor.v1.AnnotationProcessor;
import framework.web.server.TomcatServer;
import org.apache.catalina.LifecycleException;

import java.io.IOException;
import java.util.List;

/**
 * @author : zhengjianbin
 *
 * @time : 2019/6/11 - 4:04 PM
 * @Param :
 * @function : MySpring 启动类
 */
public class MySpringApplication {

    public static void run(Class<?> cls, String[] args){
        v1StartSpringboot(cls, args);


    }


    /**
     * @author : zhengjianbin
     * @version: 2.0
     * @time : 2019/7/8 - 11:23 AM
     * @Param : 
     * @function : 2.0 版本启动SpringBoot
     */
    private static void v2StartSpringboot(Class<?> cls, String[] args){
    }


    /**
     * @author : zhengjianbin
     * @version: 1.0
     * @time : 2019/6/13 - 2:03 PM
     * @Param :
     * @function : 1.0 版本启动SpringBoot
     */
    private static void v1StartSpringboot(Class<?> cls, String[] args){
        TomcatServer tomcatServer = new TomcatServer(args);
        try {
            List<Class<?>> classList = ClassScanner.scannPackage(cls.getPackage().getName());
            classList.forEach( it -> System.out.println("扫描后得到的ClassName:"+it.getName()));
            BeanFactory beanFactory = new BeanFactory();
            beanFactory.initializeBean(classList);
            AnnotationProcessor.resolveMappingHandler(classList, beanFactory);
            tomcatServer.startServer();
        } catch (LifecycleException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
