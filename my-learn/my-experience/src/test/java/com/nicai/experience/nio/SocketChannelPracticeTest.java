package com.nicai.experience.nio;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

/**
 * @author guozhe
 * @date 2020-04-30
 */
@Slf4j
public class SocketChannelPracticeTest {

    /**
     * 先运行ServerSocketChannelPractice
     * 再跑此测试，观察ServerSocketChannelPractice接收数据
     *
     * @throws IOException IO异常
     */
    @Test
    public void test1() throws IOException {
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("localhost", 8080));
        SocketChannelPractice.sendSomething(socketChannel, "得到的点点滴滴");
        readSocketChannel(socketChannel);
    }

    private void readSocketChannel(SocketChannel socketChannel) throws IOException {
        ByteBuffer readBuffer = ByteBuffer.allocate(1024);
        int num;
        while ((num = socketChannel.read(readBuffer)) > 0) {
            readBuffer.flip();
            byte[] bytes = new byte[num];
            readBuffer.get(bytes);
            String response = new String(bytes, StandardCharsets.UTF_8);
            log.info("response={}", response);
        }
    }
}