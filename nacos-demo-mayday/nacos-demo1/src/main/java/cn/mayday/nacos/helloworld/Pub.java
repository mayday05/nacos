package cn.mayday.nacos.helloworld;


import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingFactory;
import com.alibaba.nacos.api.naming.NamingService;

public class Pub {

    public static void main(String[] args) throws NacosException, InterruptedException {
        // 发布的服务名称
        String serviceName = "helloword.service";
        // 构造一个nacos实例，入参是nacos server的ip和服务端口
        NamingService naming = NamingFactory.createNamingService("192.168.179.103:8848");

        // 发布一个服务，该服务对外提供的ip为192.168.179.103，端口为8888
        System.out.println("+++++++++++ 服务注册 +++++++++++++");
        naming.registerInstance(serviceName, "192.168.179.103", 8888);

        // 一直注册状态
        Thread.sleep(Integer.MAX_VALUE);
    }
}
