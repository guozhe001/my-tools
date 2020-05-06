package com.nicai.experience.nio;

import lombok.extern.slf4j.Slf4j;

import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

/**
 * @author guozhe
 * @date 2020-05-06
 */
@Slf4j
public class SocketHandler implements Runnable {

    private SocketChannel socketChannel;

    SocketHandler(SocketChannel socketChannel) {
        this.socketChannel = socketChannel;
    }

    @Override
    public void run() {
        try {
            ByteBuffer readBuffer = ByteBuffer.allocate(1024);
            int num;
            // 把socketChannel的数据读进readBuffer，并把读到的位置赋值给num
            while ((num = this.socketChannel.read(readBuffer)) > 0) {
                readBuffer.flip();
                byte[] bytes = new byte[num];
                // 读取
                readBuffer.get(bytes);
                String receive = new String(bytes, StandardCharsets.UTF_8);
                log.info("接收到客户端信息={}", receive);
                // 告诉客户端已经接收到信息
                this.socketChannel.write(ByteBuffer.wrap(String.format("感谢，已经接收到您的信息=%s", receive).getBytes()));
                readBuffer.clear();
            }

        } catch (Exception e) {
            log.error("something is wrong...", e);
        }
    }

}
