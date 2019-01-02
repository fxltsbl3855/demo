# ZeroMQ 集成步骤

## 1. 引入依赖
```
<dependency>
	<groupId>cn.com.yto56.basic.framework</groupId>
	<artifactId>yto-framework-plugin-zeromq</artifactId>
	<version>3.1.0-SNAPSHOT</version>
</dependency>
```

## 2. 增加配置文件

```
spring.zeromq.sender.address=tcp://*:5557
spring.zeromq.receiver.address=tcp://localhost:5557
```
sender.address为要发送消息到ZeroMQ的地址。
receiver.address为要监听的ZeroMQ的地址。


## 3. 发送消息示例
```
@Service
public class ZeroMqSenderDemo {

    @Autowired
    Sender<String> sender;

    public String send() {
        for (int i = 0; i < 100; i++) {
            boolean b = sender.send("topic2", "msg" + i);
        }
        return "success";
    }

}
```

注入ZeroMQ消息发送类Sender，并且指定发送消息的业务类型，框架自动序列化。


## 4. 监听消息示例
```
@Subscriber(topic = "topic2", threadSize = 10)
public class ZeroMqReceicerDemo implements MessageCallback<String> {

    @Override
    public void onMessage(String p) {
        System.out.println(Thread.currentThread().getName() + " msg: " + p);
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
```
增加注解@Subscriber来订阅一个主题，threadSize为处理消息类的线程池大小。

## 5. 广播模式的配置

框架默认为ZeroMq的发布订阅模式(Push/Pull)：
```
spring.zeromq.sender.mode=7
spring.zeromq.receiver.mode=8
```
该配置可省略

框架同样支持请求响应模式(Request/Response)和广播模式(Publisher/Subscriber)，其配置分别如下：

请求响应模式(Request/Response)：

```
spring.zeromq.sender.mode=3
spring.zeromq.receiver.mode=4
```

广播模式(Publisher/Subscriber):

```
spring.zeromq.sender.mode=1
spring.zeromq.receiver.mode=2
```

## 备注：

Windows环境下开发需将文件jzmq.dll和libzmq.dll放在JDK安装目录下的bin目录中，不是jre目录下的bin目录。
