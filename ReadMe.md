## **1.配置日志 日志可分为生产环境日志与开发环境日志**
1. 开发环境日志主要打印在控制台，以可以以不同颜色显示不同级别的提示信息为要；
2. 生产环境日志主要是用于追溯bug，以提示信息尽可能详尽为要；

mybatis要debug级别才可以打印sql，需要另外使用logger来描述；
myBatis日志打印过于详细，需配置简化打印的sql

## **2.配置jpa**
使用jpa主要是因为它可以根据实体类生成数据表，当数据字段有增减时，更改实体类就可以对相应的数据表做出更改，而不必像逆向工程样需要重新生成一大堆代码；
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

## 3.多工程
参考pom构建即可

