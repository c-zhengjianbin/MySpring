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
     * 功能不断完善中......🚧
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
     
*  🚧Spring
      
*  🚧设计模式