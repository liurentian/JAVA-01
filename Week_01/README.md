#学习笔记

## 第一课 JVM 基础

### 作业1、分析 HelloByteCode.class 字节码
1、 编译 java 文件、反编译 class 文件
> D:\IdeaProjects\JAVA-01> javac -g ./Week_01/code/HelloByteCode.java

> D:\IdeaProjects\JAVA-01> javap -c -verbose HelloByteCode

2、分析 HelloByteCode.class 文件

### 作业2、自定义一个 Classloader，加载一个 Hello.xlass 文件，执行 hello 方法，此文件内容是一个 Hello.class 文件所有字节（x=255-x）处理后的文件。

链接：https://github.com/liurentian/JAVA-01/tree/main/Week_01/code/HelloClassLoader.java


### 作业3、画一张图，展示 Xmx、Xms、Xmn、Meta、DirectMemory、Xss 这些内存参数的关系。

链接：http://note.youdao.com/noteshare?id=684c83181f4d7c8a5a43a849f67e540d

### 作业4、检查一下自己维护的业务系统的 JVM 参数配置，用 jstat 和 jstack、jmap 查看一下详情，并且自己独立分析一下大概情况，思考有没有不合理的地方，如何改进。


