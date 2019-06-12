package framework.core;

import java.io.File;
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

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Enumeration<URL> resources = classLoader.getResources(path);
        while(resources.hasMoreElements()){
            URL reource = resources.nextElement();
            String type = reource.getProtocol();
            if(type.contains("jar")){ //解析jar 文件
                JarURLConnection jarURLConnection = (JarURLConnection) reource.openConnection();
                String jarFilePath = jarURLConnection.getJarFile().getName();
                classList.addAll(getClassFromJar(jarFilePath, path));
            }else if(type.contains("file")){  //解析普通文件
                List<Class<?>> classesFromFile = getClassFromFile(reource.getPath());
                classList.addAll(classesFromFile);
            }
        }
        return classList;
    }

    /**
     * @author : xiaoheshang
     *
     * @time : 2019/6/12 - 5:19 PM
     * @Param :
     * @function : 从普通文件中提取ClassName
     */
    private static List<Class<?>> getClassFromFile(String packageName) throws IOException, ClassNotFoundException {
        List<Class<?>> classList = new ArrayList<>();
        File openFile = new File(packageName);
        File[] childFile = openFile.listFiles();
        int fileSize = childFile.length;
        if(fileSize == 0){
            return classList;
        }
        for(File file : childFile){
            if(file.isDirectory()){
                List<Class<?>> classFromFile = getClassFromFile(file.getPath());
                classList.addAll(classFromFile);
            }else {
                String className = getClassNameFromClassFile(file.getPath());
                classList.add(Class.forName(className));
            }
        }
        return classList;
    }

    /**
     * @author : xiaoheshang
     *
     * @time : 2019/6/12 - 5:45 PM
     * @Param :
     * @function : 对.class 文件，进行文件名裁剪
     */
    private static String getClassNameFromClassFile(String path){
        String javaFilePath = path.replace("/",".");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(javaFilePath.substring(javaFilePath.indexOf("classes")+8, javaFilePath.length() - 6));
        return stringBuilder.toString();
    }

    /**
     * @author : xiaoheshang
     *
     * @time : 2019/6/12 - 5:18 PM
     * @Param :
     * @function : 从Jar 文件中提取ClassName
     */
    private static List<Class<?>> getClassFromJar(String jarFilePath, String path) throws IOException, ClassNotFoundException {
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
