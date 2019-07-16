package framework.start;

import framework.annotation.processor.v2.AnnotationProcessorV2;
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
        //v1StartSpringboot(cls, args);

        v2StartSpringboot(cls, args);
    }


    /**
     * @author : zhengjianbin
     * @version: 2.0
     * @time : 2019/7/8 - 11:23 AM
     * @Param : 
     * @function : 2.0 版本启动SpringBoot
     */
    private static void v2StartSpringboot(Class<?> cls, String[] args){
        try {
            //1.扫描包
            List<Class<?>> classes = ClassScanner.scannPackage(cls.getPackage().getName());
            //2.解析Controller (依赖注入在获取Bean 时触发)
            //TODO 此处的AnnotationProcessorV2 可通过容器获取
            AnnotationProcessorV2 annotationProcessorV2 = new AnnotationProcessorV2();
//            annotationProcessorV2.resolveMappingHandler(classes);
            annotationProcessorV2.registerUrlHandler(classes);
            //3.启动Tomcat
            TomcatServer tomcatServer = new TomcatServer(args);
            tomcatServer.startServer();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }

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
            //1.扫描包
            List<Class<?>> classList = ClassScanner.scannPackage(cls.getPackage().getName());
            classList.forEach( it -> System.out.println("扫描后得到的ClassName:"+it.getName()));
            //2.实例化IOC 容器，实例化Bean
            BeanFactory beanFactory = new BeanFactory();
            beanFactory.initializeBean(classList);
            //3.解析Controller类
            AnnotationProcessor.resolveMappingHandler(classList, beanFactory);
            //4. 启动Tomcat
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
