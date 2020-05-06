package com.nicai.experience.nio;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

/**
 * @author guozhe
 * @date 2020-05-06
 */
@Slf4j
public class ChannelUtils {

    private ChannelUtils() {

    }

    /**
     * 读取并输出SocketChannel中的内容
     *
     * @param bizName       业务名称
     * @param socketChannel 需要读取并输出的SocketChannel
     * @throws IOException IO异常
     */
    public static void printSocketChannel(String bizName, SocketChannel socketChannel) throws IOException {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        int num;
        while ((num = socketChannel.read(byteBuffer)) > 0) {
            byteBuffer.flip();
            byte[] bytes = new byte[num];
            byteBuffer.get(bytes);
            String string = new String(bytes, StandardCharsets.UTF_8);
            log.info("bizName={} printSocketChannel={}", bizName, string);
            byteBuffer.clear();
        }
    }
}
