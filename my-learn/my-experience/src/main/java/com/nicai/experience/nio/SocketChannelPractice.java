package com.nicai.experience.nio;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @author guozhe
 * @date 2020-04-30
 */
@Slf4j
public class SocketChannelPractice {

    public static void sendSomething(String data) throws IOException {
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("localhost", 8080));
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.put(data.getBytes());
        buffer.flip();
        socketChannel.write(buffer);
        log.info("{}", new String(buffer.array()));
    }
}
