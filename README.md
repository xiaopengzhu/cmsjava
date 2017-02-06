## 欢迎使用 “XPCMS”

> 使用Java语言开发的CMS

## 部署环境前提
* eclipse
* jdk7
* git
* maven
* tomcat
* mysql

## 部署开发环境
1. 下载 [Eclipse IDE for Java EE Developers](http://eclipse.org/downloads/)
2. 打开eclpse,导入师说CMS
3. File -> Import -> Git -> Projects from Git -> Clone URI
4. 然后在URI输入：https://xpcms.git
5. 等待eclipse自动下载jar包
6. 创建/sql/install.sql数据库

## 部署到线上（生产）
1. 复制 /src/main/resources/xpcms.properties 到 /
2. 修改 xpcms.properties 里的数据库链接、用户名和密码为生产环境的值
3. mvn package
4. 生成/dist文件夹，此文件夹为生产环境的编译目录
