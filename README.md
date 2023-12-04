# qb聊天室客户端

本项目是qb聊天室的客户端项目，主要是由java swing实现。项目界面比较丑陋，只能说勉强实现功能。

![image-20231130184954514](https://cdn.jsdelivr.net/gh/YuanErya/pictures@main/img/202311301849546.png)

## 项目介绍
这个项目是我研究websocket的时候来实现的一个小demo。java swing 实在是有点太难用了，客户端实在是有些丑陋了。但是基本的功能都还是实现了的。
整体功能的实现是通过http请求向服务端发起请求完成登录注册等一系列操作。登录之后服务端会返回一个登录凭证，凭借登录凭证可以构建出ws的链接地址，从而和服务端建立长连接。
聊天室只有你一个人的时候会触发自动回复。
并且在逻辑上是实现了私聊的功能。通过规定的指令方式可以达到私聊的目的。



![image-20231130185725905](https://cdn.jsdelivr.net/gh/YuanErya/pictures@main/img/202311301857933.png)

![image-20231130190343403](https://cdn.jsdelivr.net/gh/YuanErya/pictures@main/img/202311301903437.png)

## 安装和运行

客户端比较简单，只需要修改代码中与服务端的连接信息就能够顺利连接上服务端进行通讯。
具体需要修改的部分是//服务端端口//服务端地址，之后就可以执行启动客户端。启动客户端并不会检测服务端的状态，在有实际操作的时候，但是服务端异常就会抛出异常。

````java
public class ConstantString {
    //ws的连接配置
    public static final String HOST="localhost";//服务端地址
    public static final String PORT="13268";//服务端端口
    public static final String BASE_URI="ws://"+HOST+":"+PORT+"/qbserver/";

    //服务端http请求的配置
    public static final String baseUrl="http://"+HOST+":"+PORT;
    public static final String SENT_CODE_URL=baseUrl+"/qbserver/api/sentEmailCode";
    public static final String LOGIN_PASSWORD_URL=baseUrl+"/api/qbserver/user/login/password";
    public static final String LOGIN_CODE_URL=baseUrl+"/api/qbserver/user/login/code";
    public static final String REGISTER_URL=baseUrl+"/api/qbserver/user/register";
}
````

## 联系方式

如果有兴趣了解这个小demo也可以联系我

qq:1508014225