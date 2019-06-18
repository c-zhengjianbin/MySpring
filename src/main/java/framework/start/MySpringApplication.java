package framework.start;

import framework.bean.BeanFactory;
import framework.core.ClassScanner;
import framework.annotation.processor.AnnotationProcessor;
import framework.web.server.TomcatServer;
import org.apache.catalina.LifecycleException;

import java.io.IOException;
import java.util.List;

/**
 * @author : xiaoheshang
 *
 * @time : 2019/6/11 - 4:04 PM
 * @Param :
 * @function : MySpring 启动类
 */
public class MySpringApplication {

    public static void run(Class<?> cls, String[] args){
        TomcatServer tomcatServer = new TomcatServer(args);
        try {
            List<Class<?>> classList = ClassScanner.scannPackage(cls.getPackage().getName());
            classList.forEach( it -> System.out.println("扫描后得到的ClassName:"+it.getName()));
            BeanFactory.initializeBean(classList);
            AnnotationProcessor.resolveMappingHandler(classList);
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
