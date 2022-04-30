package com.nicai.experience.nio;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.StandardCharsets;

/**
 * @author guozhe
 * @date 2020-05-06
 */
@Slf4j
public class AsynchronousSocketChannelReadHandler implements CompletionHandler<Integer, Attachment> {

    @Override
    public void completed(Integer result, Attachment attachment) {
        try {
            AsynchronousSocketChannel asynchronousSocketChannel = attachment.getAsynchronousSocketChannel();
            ByteBuffer byteBuffer = attachment.getByteBuffer();
            byteBuffer.flip();
            byte[] bytes = new byte[byteBuffer.limit()];
            byteBuffer.get(bytes);
            String string = new String(bytes, StandardCharsets.UTF_8);
            log.info("receive client request ={}", string);
            asynchronousSocketChannel.write(ByteBuffer.wrap("i'm AsynchronousServerSocketChannelPractice,with CompletionHandler".getBytes()));
            asynchronousSocketChannel.close();
        } catch (IOException e) {
            log.info("close asynchronousSocketChannel failed", e);
        }

    }

    @Override
    public void failed(Throwable exc, Attachment attachment) {
        log.error("AsynchronousSocketChannel read failed", exc);
    }
}
