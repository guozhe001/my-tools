package com.nicai.experience.nio;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author guozhe
 * @date 2020-04-30
 */
@Slf4j
public class ServerSocketChannelPractice {

    private static final ExecutorService EXECUTOR_SERVICE = new ThreadPoolExecutor(2, 2, 0, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>(1024)
            , new ThreadFactoryBuilder().setNameFormat("ServerSocketChannelPractice-%s").build());

    public static void main(String[] args) throws IOException {
        listen();
    }

    public static void listen() throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(8080));
        while (true) {
            EXECUTOR_SERVICE.execute(new SocketHandler(serverSocketChannel.accept()));
        }
    }

}
