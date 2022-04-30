package com.nicai.experience.nio;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;

/**
 * TOMCAT源码学习
 * 主要针对nio的使用这一块
 *
 * @author guozhe
 * @date 2020-05-07
 */
public class TomcatSourceCodeLearn {

    public static void main(String[] args) throws LifecycleException {
        Tomcat tomcat = new Tomcat();
        /*
         在 Tomcat 中，使用 Connector 来处理连接，一个 Tomcat 可以配置多个 Connector，分别用于监听不同端口，或处理不同协议。
         默认不指定协议会使用"org.apache.coyote.http11.Http11NioProtocol"来处理
         Http11NioProtocol的构造函数的endpoint为NioEndpoint
         Tomcat 使用不同的 endpoint 来处理不同的协议请求， NioEndpoint使用非阻塞 IO 来进行处理 HTTP/1.1 协议的请求
         */
        Connector connector = new Connector();
        connector.setPort(8080);
        tomcat.setConnector(connector);
        tomcat.start();
        tomcat.getServer().await();
    }

}
