# MySpring

## 一、项目介绍
* ### ☘️目的:
     * 加深Spring 设计思想的理解，迅速解决Spring 相关问题。
     * 和大家一起深入学习Spring。
     
* ### ☘️功能:
     * #### v1版本🚶‍
         * 集成Tomcat实现一键启动，自动扫描类，依赖注入。
         * 实现自定义注解：Controller、RequestMapping、RequestParam等。
         * 实现自定义Dispatcher处理请求转发。
         * 版本状态：已完成。
     * #### v2版本🏃‍
         * 将依赖注入由初始化触发升级获取Bean 时触发。
         * 引入BeanDefinition 描述实例信息
         * 版本状态：进行中🚧。
     
* ### ☘️目录:
     * 项目结构与包名注释🌴。
    ```
    ├── framework
    │   ├── annotation
    │   │   ├── bean
    │   │   │   ├── Autowired.java
    │   │   │   └── Bean.java
    │   │   ├── mvc
    │   │   │   ├── Controller.java
    │   │   │   ├── RequestMapping.java
    │   │   │   └── RequestParam.java
    │   │   └── processor-----注解处理器
    │   │       ├── support-----默认处理器
    │   │       │   ├── DefaultAbstractAnnotationProcessor.java
    │   │       │   └── DefaultAnnotationProcessor.java
    │   │       └── v1
    │   │           └── AnnotationProcessor.java
    │   ├── bean
    │   │   ├── definition
    │   │   │   └── BeanDefinition.java
    │   │   ├── factory
    │   │   │   ├── AbstractDefaultBeanFactory.java
    │   │   │   └── DefaultBeanFactory.java
    │   │   ├── v1
    │   │   │   └── BeanFactory.java
    │   │   └── v2
    │   │       └── BeanFactory.java
    │   ├── context
    │   ├── core
    │   │   └── ClassScanner.java
    │   ├── mappinghandler------Mapping 处理
    │   │   └── ControllerMappingInfo.java
    │   ├── start------启动包
    │   │   └── MySpringApplication.java
    │   └── web
    │       ├── server------Tomcat 配置
    │       │   └── TomcatServer.java
    │       └── servlet------请求转发包
    │           └── MyDispatcherServlet.java
    └── test------测试包
        ├── MainTest.java
        ├── controller
        │   └── TestController.java
        └── service
            └── UserService.java
    ```
    
## 二、知识体系
* ### ☘️介绍 
    Spring 框架汇集了Java 诸多相关知识、设计模式。熟练掌握这些知识是熟悉Spring 的前提，特此将这个项目中涉及到的技术进行整理。和大家一起再次把理论打牢。
        
* ### ☘️Java:
     * 什么是反射？如何利用反射操作private 属性的字段？
     * 什么是泛型？泛型的通配符"?"是什么？为什么要使用它？
     * 什么是元数据（MetaData）？
     * 什么是注解？为什么要用注解？什么是注解处理器？Java 中的内置三大注解是什么？
     * 如何使用File 读取Java 包并遍历包中类文件？(具体到哪个方法)
     * 创建对象的方式有几种，分别是什么？
     * ConcurrentHashMap 是什么？为什么要用？
     * 如何检查类上的注解器？（具体到哪个方法）
     * 什么是Servlet？传统使用Xml 方式配置Servlet 有什么劣势？
     * 不断完善中......🚧
     
* ### ☘️Spring
     * 什么是Spring？为什么要使用它？
     * Spring 设计的核心目的是什么？
     * 什么是IOC 容器，它的作用？
     * 什么是依赖注入？如何理解注入这个词？
     * 动态代理与静态代理的区别？
     * 什么是上下文？什么是应用上下文？ApplicationContext 是什么？
     * 不断完善中......🚧
     
* ### ☘️设计模式
     * 什么是工厂模式？为什么要用它？它由哪几个部分组成？
     * 什么是策略模式？
     * 什么是Command 模式？
     * 不断完善中......🚧
     
## 三、思考 🤔
* ### ☘️介绍
    对比Spring 设计思想，结合MySpring 项目从设计方向上提出一些问题。为什么Spring 这样做？

* ### ☘问题
     * 为什么依赖注入是由用户第一次向Ioc 容器索取Bean 时触发呢？MySpring 这种在初始化时就进行依赖注入，会出现什么问题？
     * 为什么在V2 版本引入了BeanDefinition 数据结构？
     
## 四、踩的深坑🚧
* ### ☘急于求成
     * 从V1 升级至V2 版本的过程中，急于求成。将Spring 框架想的太简单，太急于把V2 版本的代码迅速的写出来。在编码的过程中，想起什么类，写什么类，类之间关系混乱。
     
