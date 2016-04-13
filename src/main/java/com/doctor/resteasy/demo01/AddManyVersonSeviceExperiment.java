package com.doctor.resteasy.demo01;

import java.util.ArrayList;
import java.util.List;

import org.jboss.resteasy.core.ResourceMethodRegistry;
import org.jboss.resteasy.plugins.server.embedded.SecurityDomain;
import org.jboss.resteasy.plugins.server.netty.NettyJaxrsServer;
import org.jboss.resteasy.spi.ResteasyDeployment;

/**
 * @author sdcuike
 *
 *           多版本测试：路径不变（接口注解上的路径），根据getHeaderString("version") 内容调用其对应服务。
 *         1.verson对应服务是否调用＝yes
 *         2.不同版本服务同时启动或只启动一个服务，测试调用服务是否对应版本服务＝yes
 *         3.version为后台没有的服务测试＝yes
 * 
 * 
 *         Create At 2016年4月13日
 */
public class AddManyVersonSeviceExperiment {

    /**
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        String hostname = "127.0.0.1";
        int port = 8990;
        SecurityDomain securityDomain = null;
        String rootResourcePath = "/";
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
        ResourceMethodRegistry resourceMethodRegistry = (ResourceMethodRegistry) deployment.getRegistry();
        resourceMethodRegistry.setWiderMatching(true);// 不设置也可以

        deployment.getProviderFactory().register(MyContainerRequestFilter.class);

        deployment.getRegistry().addSingletonResource(new Demo01ServiceImpl());
        deployment.getRegistry().addSingletonResource(new Demo01ServiceImpl2(), "/2");

    }

}
