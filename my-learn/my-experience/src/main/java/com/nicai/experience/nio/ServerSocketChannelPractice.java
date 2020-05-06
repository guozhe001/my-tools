package com.nicai.experience.nio;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @author guozhe
 * @date 2020-04-30
 */
@Slf4j
public class ServerSocketChannelPractice {

    public static void main(String[] args) throws IOException {
        test();
    }

    public static void test() throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(8080));
        while (true) {
            SocketChannel accept = serverSocketChannel.accept();
            print(accept);
        }

    }

    private static void print(SocketChannel socketChannel) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while (true) {
            int read = socketChannel.read(buffer);
            if (read <= 0) {
                break;
            }
            buffer.flip();
            log.info("{}", new String(buffer.array()));
        }


    }
}
