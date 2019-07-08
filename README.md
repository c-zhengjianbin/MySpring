# MySpring

## [一、项目介绍](#41)
* ### ☘️目的:
     * 加深Spring 设计思想的理解，迅速解决Spring 相关问题。
     * 和大家一起深入学习Spring。
     
* ### ☘️功能:
     * #### v1版本🚶‍
         * 集成Tomcat实现一键启动，自动扫描类，依赖注入。（已完成）
         * 实现自定义注解：Controller、RequestMapping、RequestParam等。（已完成）
         * 实现自定义Dispatcher处理请求转发。（已完成）
     * #### v2版本🏃‍
         * 将依赖注入由初始化触发升级获取Bean 时触发。（已完成）
         * 请求Url 与Controller 映射引入Spring Web 设计思想。（进行中🚧）
         * 注解处理器引入Spring 思想进行处理。（进行中🚧）
         * 引入BeanDefinition 描述实例信息。（进行中🚧）

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
    │   │       ├── support-----该包下类未使用
    │   │       │   ├── DefaultAbstractAnnotationProcessor.java
    │   │       │   └── DefaultAnnotationProcessor.java
    │   │       ├── v1
    │   │       │   └── AnnotationProcessor.java
    │   │       └── v2
    │   │           └── AnnotationProcessorV2.java
    │   ├── bean
    │   │   ├── definition------该包下类未使用
    │   │   │   ├── BeanDefinition.java
    │   │   │   └── DefaultBeanDefinitionFactory.java
    │   │   ├── factory------容器工厂类，提供容器基本操作
    │   │   │   ├── AbstractBeanFactory.java
    │   │   │   └── BeanFactory.java
    │   │   ├── v1
    │   │   │   └── BeanFactory.java
    │   │   └── v2
    │   │       └── DefaultBeanFactory.java
    │   ├── context
    │   ├── core
    │   │   └── ClassScanner.java
    │   ├── mappinghandler------Mapping 处理
    │   │   ├── v1
    │   │   │   └── ControllerMappingInfo.java
    │   │   └── v2
    │   │       └── ControllerMappingInfo.java
    │   ├── start------启动包
    │   │   └── MySpringApplication.java------包含V1、V2版本启动方式
    │   └── web
    │       ├── server------Tomcat 配置
    │       │   └── TomcatServer.java
    │       └── servlet------请求转发包
    │           └── MyDispatcherServlet.java
    └── test------测试包
        ├── MainTest.java
        ├── controller
        │   ├── TestController.java
        │   └── TestControllerV2.java
        └── service
            ├── UserService.java
            └── UserServiceV2.java
            
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
     
## <h2 id="41">四、踩的深坑🚧</h2>
* ### ☘急于求成
     * 从V1 升级至V2 版本的过程中，急于求成。将Spring 框架想的太简单，急于把V2 版本的代码迅速的写出来。编码的过程中，想起什么类写什么类，类之间关系混乱。要让自己从思想上认识到，Spring 不简单，匹夫之勇写代码是无法学到真正的东西。
     
* ### ☘生搬硬套
     * 在了解Spring 依赖注入原理后，照着葫芦画瓢（关键是没画出来）。将Spring 部分组件稍微封装后，引入V2 版本，并未搞清Spring 依赖注入各个类的关系。最终导致V2 版本依赖注入
     逻辑混乱，无法实现依赖注入功能。-----2019-06-24
     * 还记得当时写这个项目的初衷吗？加深Spring 设计思想的理解。那怎样才算真正的理解呢？以依赖注入为例，要做到两点：Spring 实现依赖注入核心的设计流程是怎样的；基于这这种流程，Spring 各个类是如何协作、配合的，依赖注入
     涉及到的类关系是怎样的，是继承还是接口实现，各个类在依赖注入中发挥着怎样的作用？告诉自己：不能着急。可能并没有能力把Spring 每一项功能研究透彻，但目前能做的就是把依赖注入所涉及到的以上两点吃透，去思考人家是如何
     设计的。-----2019-06-24