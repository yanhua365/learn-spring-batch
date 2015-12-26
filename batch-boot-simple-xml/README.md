# 快速开始

运行以下的命令:

```
mvn spring-boot:run
```

既可以运行程序,在控制台上观看输出即可.


# 深入研究

为了观察`job`运行过程中在`jobRepository`中产生的数据,就不能再使用内存数据库了.

首先我们需要启动H2 Database程序,执行H2的bin目录下的`h2.sh`,这会打开
一个H2的控制台,我们稍后会使用它,现在先执行:

```
mvn -Dspring.profiles.active=server_db spring-boot:run
```

从控制台中可以看到job的运行过程.

这是可以用H2的控制台连接数据库`jdbc:h2:tcp://localhost/~/h2data/batch-simple`,注意要使用server模式.这样就可以看到那些`BATCH_`开头的表了.

如果你在重新运行一下程序,job并不会重新跑一遍,因为相同的参数只能运行一次.可以删除`~/h2data/batch-simple`这个文件再次运行即可.