# MySpring

## 一、介绍
*  ☘️目的:
     * 加深Spring 设计思想的理解，迅速解决Spring 相关问题
    
*  ☘️功能:
     *  集成Tomcat，实现一键启动
     * 实现自定义注解：Controller、RequestMapping、RequestParam等  
     * 实现自定义Dispatch处理请求转发    
     * 功能不断完善中......🚧
*  ☘️目录:
     * 项目结构与包名注释🌴
    ```
    ├── main
    │   ├── java
    │   │   ├── framework            
    │   │   │   ├── annotation------注解包
    │   │   │   │   └── mvc
    │   │   │   ├── beans
    │   │   │   ├── context
    │   │   │   ├── core------核心
    │   │   │   │   └── ClassScanner.java
    │   │   │   ├── handler------Mapping 处理
    │   │   │   │   ├── HoldMapper.java
    │   │   │   │   └── MappingInfo.java
    │   │   │   ├── start------启动包
    │   │   │   │   └── MySpringApplication.java
    │   │   │   └── web
    │   │   │       ├── server------Tomcat 配置
    │   │   │       └── servlet------DispatchServlet
    │   │   └── test
    │   │       ├── MainTest.java
    │   │       └── controller
    │   │           └── TestController.java
    │   └── resources
    └── test
    └── java
    ```
## 二、架构
