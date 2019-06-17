# MySpring

## 一、项目介绍
*  ☘️目的:
     * 加深Spring 设计思想的理解，迅速解决Spring 相关问题
     * 和大家一起深入学习Spring
     
*  ☘️功能:
     * 集成Tomcat，实现一键启动
     * 实现自定义注解：Controller、RequestMapping、RequestParam等  
     * 实现自定义Dispatcher处理请求转发
     * 自动扫描类
     * 实现依赖注入
     * 不断完善中......🚧
*  ☘️目录:
     * 项目结构与包名注释🌴
    ```
    ├── java
    │   ├── framework
    │   │   ├── annotation------注解包
    │   │   │   ├── bean
    │   │   │   │   ├── Autowired.java
    │   │   │   │   └── Bean.java
    │   │   │   └── mvc
    │   │   │       ├── Controller.java
    │   │   │       ├── RequestMapping.java
    │   │   │       └── RequestParam.java
    │   │   ├── bean
    │   │   │   └── BeanFactory.java
    │   │   ├── context
    │   │   ├── core
    │   │   │   └── ClassScanner.java
    │   │   ├── handler------Mapping 处理
    │   │   │   ├── AnnotationProcessor.java
    │   │   │   └── ControllerMappingInfo.java
    │   │   ├── start------启动包
    │   │   │   └── MySpringApplication.java
    │   │   └── web
    │   │       ├── server------Tomcat 配置
    │   │       │   └── TomcatServer.java
    │   │       └── servlet------请求转发包
    │   │           └── MyDispatcherServlet.java
    │   └── test------测试包
    │       ├── MainTest.java
    │       ├── controller
    │       │   └── TestController.java
    │       └── service
    │           └── UserService.java
    ```
## 二、知识体系
*  ☘️介绍：Spring 框架汇集了Java 诸多相关知识、设计模式。熟练掌握这些知识是熟悉Spring 的前提，特此将这个项目中涉及到的技术进行整理。和大家一起再次把理论打牢。
        
*  ☘️Java:
     * 什么是反射？如何利用反射操作private 属性的字段？
     * 什么是元数据（MetaData）？
     * 什么是注解？为什么要用注解？什么是注解处理器？Java 中的内置三大注解是什么？
     * 如何使用File 读取Java 包并遍历包中类文件？(具体到哪个方法)
     * 创建对象的方式有几种，分别是什么？
     * ConcurrentHashMap 是什么？为什么要用？
     * 如何检查类上的注解器？（具体到哪个方法）
     * 什么是Servlet？传统使用Xml 方式配置Servlet 有什么劣势？
     * 不断完善中......🚧
     
*  ☘️Spring
     * 什么是Spring？为什么要使用它？
     * Spring 设计的核心目的是什么？
     * 什么是IOC 容器，它的作用？
     * 什么是依赖注入？如何理解注入这个词？
     * 动态代理与静态代理的区别？
     * 不断完善中......🚧
     
*  ☘️设计模式
     *什么是工厂模式？为什么要用它？它由哪几个部分组成？
     * 不断完善中......🚧