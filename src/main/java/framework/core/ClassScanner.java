package framework.core;

import java.io.IOException;
import java.net.JarURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * @author : xiaoheshang
 *
 * @time : 2019/6/12 - 1:19 PM
 * @Param :
 * @function : 通过包名获取包下的类型
 */
public class ClassScanner {

    public static List<Class<?>> scannPackage(String packageName) throws IOException, ClassNotFoundException {
        List<Class<?>> classList = new ArrayList<Class<?>>();
        String path = packageName.replace(".", "/");
        // 问题1：什么使用线程的上下文加载器
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Enumeration<URL> resources = classLoader.getResources(path);
        while(resources.hasMoreElements()){
            URL reource = resources.nextElement();
            if(reource.getProtocol().contains("jar")){
                JarURLConnection jarURLConnection = (JarURLConnection) reource.openConnection();
                String jarFilePath = jarURLConnection.getJarFile().getName();
                classList.addAll(getClassFromJar(jarFilePath, path));
            }else{

            }
        }
        return classList;
    }

    public static List<Class<?>> getClassFromJar(String jarFilePath, String path) throws IOException, ClassNotFoundException {
        List<Class<?>> classList = new ArrayList<Class<?>>();

        JarFile jarFile = new JarFile(jarFilePath);

        Enumeration<JarEntry> jarEntryEnumeration = jarFile.entries();
        while(jarEntryEnumeration.hasMoreElements()){
            JarEntry jarEntry = jarEntryEnumeration.nextElement();
            String entryName = jarEntry.getName();
            //获取的
            if (entryName.startsWith(path)&&entryName.endsWith(".class")){
                //路径替换
                String classFullName = entryName.replace("/",".").substring(0,entryName.length()-6);
                //反射获取类信息并添加至list
                classList.add(Class.forName(classFullName));
            }
        }
        return classList;
    }

}
