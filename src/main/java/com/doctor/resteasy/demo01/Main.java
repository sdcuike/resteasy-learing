package com.doctor.resteasy.demo01;

import java.util.ArrayList;
import java.util.List;

import org.jboss.resteasy.plugins.server.embedded.SecurityDomain;
import org.jboss.resteasy.plugins.server.netty.NettyJaxrsServer;
import org.jboss.resteasy.spi.ResteasyDeployment;

/**
 * @author sdcuike
 *
 *         Create At 2016年3月28日
 */
public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
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
        resources.add(new Demo01ServiceImpl());
        deployment.setResources(resources);
        nettyJaxrsServer.start();

    }

}
