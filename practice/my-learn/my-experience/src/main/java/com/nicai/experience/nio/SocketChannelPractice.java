package com.nicai.experience.nio;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @author guozhe
 * @date 2020-04-30
 */
@Slf4j
class SocketChannelPractice {

    static void sendSomething(SocketChannel socketChannel, String data) throws IOException {
        ByteBuffer buffer = ByteBuffer.wrap(data.getBytes());
        socketChannel.write(buffer);
        log.info("{}", new String(buffer.array()));
    }
}
