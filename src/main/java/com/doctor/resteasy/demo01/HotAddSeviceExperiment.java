package com.doctor.resteasy.demo01;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.jboss.resteasy.plugins.server.embedded.SecurityDomain;
import org.jboss.resteasy.plugins.server.netty.NettyJaxrsServer;
import org.jboss.resteasy.spi.ResteasyDeployment;

/**
 * @author sdcuike
 *
 *          netty 服务启动后，添加服务，删除服务，访问正常
 * 
 *         Create At 2016年4月13日
 */
public class HotAddSeviceExperiment {

    /**
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        String hostname = "127.0.0.1";
        int port = 8990;
        SecurityDomain securityDomain = null;
        String rootResourcePath = "/root";
        int ioWorkerCount = Runtime.getRuntime().availableProcessors() * 2;
        int executorThreadCount = 12;

        NettyJaxrsServer nettyJaxrsServer = new NettyJaxrsServer();

        nettyJaxrsServer.setHostname(hostname);
        nettyJaxrsServer.setPort(port);
        nettyJaxrsServer.setSecurityDomain(securityDomain);
        nettyJaxrsServer.setRootResourcePath(rootResourcePath);

        nettyJaxrsServer.setIoWorkerCount(ioWorkerCount);
        nettyJaxrsServer.setExecutorThreadCount(executorThreadCount);

        ResteasyDeployment deployment = nettyJaxrsServer.getDeployment();
        List<Object> resources = new ArrayList<>();
        // resources.add(new Demo01ServiceImpl());
        deployment.setResources(resources);
        nettyJaxrsServer.start();

        Demo01ServiceImpl demo01ServiceImpl = new Demo01ServiceImpl();
        deployment.getRegistry().addSingletonResource(demo01ServiceImpl);
        TimeUnit.SECONDS.sleep(5);
        deployment.getRegistry().removeRegistrations(Demo01Service.class);

    }

}
