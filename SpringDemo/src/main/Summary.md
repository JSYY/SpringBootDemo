#--------------------------------数据库相关--------------------------------#
注意：在进行Mybatis操作时需要先下载mysql数据库，配置好数据库端口和用户访问密码

Orm（对象关系映射）
利用对象和数据库之间映射的数据，把java程序中的对象持久化到数据库的表内

在数据库访问过程中，“数据源”无疑是最重要的概念之一，它不仅可以对与数据库访问相关的各种参数进行封装和统一管理，还可以管理数据库连接池，提高数据库连接性能。
在用户没有配置数据源的情况，若容器中存在 HikariDataSource 类，则 Spring Boot 就会自动实例化 Hikari，并将其作为其数据源。
Spring Boot 的 JDBC 场景启动器（spring-boot-starter-data-jdbc）通过 spring- boot-starter-jdbc 默认引入了 HikariCP 数据源（包含 HikariDataSource 类），
因此 Spring Boot 默认使用 HikariCP 作为其数据源。

使用 Mapper 进行开发时，需要遵循以下规则：
mapper 映射文件中 namespace 必须与对应的 mapper 接口的完全限定名一致。
mapper 映射文件中 statement 的 id 必须与 mapper 接口中的方法的方法名一致
mapper 映射文件中 statement 的 parameterType 指定的类型必须与 mapper 接口中方法的参数类型一致。
mapper 映射文件中 statement 的 resultType 指定的类型必须与 mapper 接口中方法的返回值类型一致。


#-------------------------------Java语法相关--------------------------------#
参考main/java/com/example/SpringDemo/JavaTest
DeadLock：关于死锁的情况
LockTest：Java中Lock的相关用法，包括TryLock测试
Event:Java事件机制
Clone：深拷贝与浅拷贝
StringTest:String与StringBuilder以及StringBuffer的区别
JavaNio：NIO与BIO/浅谈Netty
Jvm：java虚拟机内存相关&&堆与栈

用法注意：
java集合遍历请使用iterator迭代器；
集合判空时请使用isEmpty方法
可以利用Set元素唯一的特性，可以快速对一个集合进行去重操作，避免使用List的contains()进行遍历去重或者判断包含操作。
使用集合转数组的方法，必须使用集合的toArray(T[] array)，传入的是类型完全一致、长度为0的空数组。

#-------------------------------SpringBoot注解相关--------------------------#
get与post区别
1.get没有请求体，post有
2.get传输比post快
3.get只能携带少量数据(因为url长度有限制)，而post可以携带大量数据
4.get的请求参数是放在url中的，因此是不安全的，而post的请求参数是存放在请求体中，安全性较强

RequestBody主要用来获取post请求中的请求体中的数据，且不能用于get
RequestParam可以用于接收get请求中具体的参数，参数与参数之间用“？”间隔
PathVariable用于接收url中的{}内的参数

SpringBoot的依赖注入：
在注解中，所有的Controller、Service、Mapper本质上都会被认定为一个Component，在项目启动时在容器中被构造

#------------------------------enjoy life----------------------------------#
人生中的悲与喜、失败与成功，如果换一种角度去思考这些(在遇到一些开心的事情时，我会想我为什么会开心，当我痛苦难过时，我也会去思考
为什么会这样，甚至会流泪，在这样思考一段时间后，情绪便不再能够持续的控制我，内心便会开始趋向于一种平和)，并且考虑它们的前因后果，
你会发现你不再关注他们之后对你情绪的影响 而是发现你在切身的感受这个世界，并且内心也会变得平静下来。所以我想人真正的成熟应该不是
去追求完美，或者说去把自己打造成一台成功运转的机器，而是敢于直面人生这个测试平台中所产生的一个又一个bug(一个又一个磨难)，并且乐于
去体会它、感受它进而去解决它，然后会发现无论遇到什么样的状况，你都会变得从然且面带微笑。
