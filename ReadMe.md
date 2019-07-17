## **0.前言**
   这两年springboot框架越来越火，然后又发现自己这两年来都做着重复的事情(面向baidu编程)，很多问题错了一次又一次，工作做了一遍又一遍，是时候总结出一点东西了。打算以springboot为基础，搞出一套完整的东西，这个项目的开发过程就做为整个项目的日志吧。
## **1.配置日志 日志可分为生产环境日志与开发环境日志**
1. 开发环境日志主要打印在控制台，以可以以不同颜色显示不同级别的提示信息为要(idea提供了对不同级别的日志打印不同颜色的信息的插件，很好用，叫grep
   console)；
2. 生产环境日志主要是用于追溯bug，以提示信息尽可能详尽为要；

mybatis要debug级别才可以打印sql，需要另外使用logger来描述；
myBatis日志打印过于详细，需配置简化打印的sql

## **2.配置jpa**
使用jpa主要是因为它可以根据实体类生成数据表，当数据字段有增减时，更改实体类就可以对相应的数据表做出更改，而不必像逆向工程样需要重新生成一大堆代码；也集成了mybatis来获得更好的sql体验；
主要配置：
```
spring:
  jpa:
    hibernate:
      ddl-auto: update
      show-sql: true
      database: mysql
      #配置数据库引擎为innodb 否则默认引擎为myisam
      database-platform: org.hibernate.dialect.MySQL5InnoDBDialect
```

其他：jpa注解
1. @Entity ：修饰实体类，指明该类将映射到指定的数据表，例如：Customer 类默认的数据表名为 customer

2. @Table ：当实体类与映射的数据库表名不同名时需要使用 @Table 注解，该注解与 @Entity 注解并列使用，使用其 name 属性指明数据库的表名

3. @Id ：标识该属性为主键，一般标注在该属性的 getter 方法上

4. @GeneratedValue ：标注主键的生成策略，通过其 strategy 属性。通常与 @Id 注解一起使用。默认情况下 JPA 会自动选择一个最适合底层数据库的主键生成策略，MySQL 默认为 AUTO

5. @Basic ：用于没有任何标注的 getXxx() 方法，默认即为 @Basic,所以若一个 getter 方法无任何注解，可以使用 @Basic 注解，也可以不使用

6. @Column ：当实体的属性与其映射的数据表的列不同名时使用，一般用于 getter 方法上。其 name 属性用来指明此属性在数据表中对应的列名；unique 属性指明是否为唯一约束；nullable 属性用来指明是否可以为空，false 为不能为空；length 属性指明此列的长度。

7. @Transient ：标注此注解后在创建数据表的时候将会忽略该属性

8. @Temporal ：向数据库映射日期（Date）属性时用来调整映射的精度。Date 类型的数据有 DATE, TIME, 和 TIMESTAMP 三种精度(即单纯的日期,时间,或者两者兼备).

| Keyword |simple| JPQL snippet|     
|---|:---: |:----:| 
| And | findByLastnameAndFirstname |… where x.lastname =?1 and x.firstname = ?2|
其他见文档：https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.named-queries
## 3.多工程
参考父子pom构建即可

## 4.shiro权限控制

参考教程：https://www.cnblogs.com/liyinfeng/p/8033869.html
 
 apache shiro：
   
    1.Authentication（认证）：用户身份识别，通常被称为用户“登录”
    2. Authorization（授权）：访问控制。比如某个用户是否具有某个操作的使用权限。
    3. Session Management（会话管理）：特定于用户的会话管理,甚至在非web 或 EJB 应用程序。
    4. Cryptography（加密）：在对数据源使用加密算法加密的同时，保证易于使用。
 
 **注意： Shiro不会去维护用户、维护权限，这些需要我们自己去设计/提供，然后通过相应的接口注入给Shiro**
 
![shiro基础架构](https://github.com/AngryXiaoPao/Bg_system/blob/master/doc/img/ShiroBasicArchitecture.png "shiro基础架构")

RBAC:略

shiro配置：
 
Subject：当前用户，Subject 可以是一个人，但也可以是第三方服务、守护进程帐户、时钟守护任务或者其它–当前和软件交互的任何事件。

SecurityManager：管理所有Subject，SecurityManager 是 Shiro 架构的核心，配合内部安全组件共同组成安全伞。

Realms：用于进行权限信息的验证，我们自己实现。Realm 本质上是一个特定的安全 DAO：它封装与数据源连接的细节，得到Shiro 所需的相关的数据。在配置 Shiro 的时候，你必须指定至少一个Realm 来实现认证（authentication）和/或授权（authorization）。

我们需要实现Realms的Authentication 和 Authorization。其中 Authentication 是用来验证用户身份，Authorization 是授权访问控制，用于对用户进行的操作授权，证明该用户是否允许进行当前操作，如访问某个链接，某个资源文件等。



## 4.1 关于静态资源访问
 springboot涉及到静态资源访问的配置大致有这几个： 
 + spring.mvc.static-path-pattern 
 + 过滤器中对web请求的无差别拦截，如shiro 

springboot对于static文件夹下的静态资源默认打包是在项目根目录下的，所以项目发布后，访问资源路径是不带有static路径的，将spring.mvc.static-path-pattern配置为/static/**则访问静态资源路径必须带有static，
如果不配置spring.mvc.static-path-pattern，则shiro中必须对static文件夹下的静态资源一一做匿名可访问配置，所以比较优雅的解决方案是：
+ spring.mvc.static-path-pattern:/static/**
+ filterChainDefinitionMap.put("/static/**", "anon")

## 5.WebMvcConfigurer
  之前搭建项目框架时为了增加验证码经历了些问题，发现很多框架中都使用了WebMvcConfigurer实现类来做一些配置，后来研究发现，这个类对于项目有很大的作用，来记录下
  
  参考文档：https://blog.csdn.net/fmwind/article/details/81235401

