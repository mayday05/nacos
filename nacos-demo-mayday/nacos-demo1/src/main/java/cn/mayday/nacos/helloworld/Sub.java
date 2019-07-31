package cn.mayday.nacos.helloworld;

import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingFactory;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.listener.NamingEvent;

public class Sub {

    public static void main(String[] args) throws NacosException, InterruptedException {
        // 订阅的服务名称
        String serviceName = "helloword.service";
        // 构造一个nacos实例，入参是nacos server的ip和服务端口
        NamingService naming = NamingFactory.createNamingService("192.168.179.103:8848");

        // 订阅一个服务
        naming.subscribe(serviceName, event -> {
            if (event instanceof NamingEvent) {

                System.out.println(" ++++++++++++订阅到数据 ++++++++++++");

                System.out.println(((NamingEvent) event).getInstances());
            }
        });

        System.out.println("++++++++++++ 订阅完成，准备等待订阅数据 ++++++++++++ ");

        // 等待
        Thread.sleep(Integer.MAX_VALUE);
    }
}
