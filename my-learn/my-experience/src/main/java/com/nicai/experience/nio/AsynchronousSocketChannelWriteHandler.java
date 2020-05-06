package com.nicai.experience.nio;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.CompletionHandler;
import java.nio.charset.StandardCharsets;

/**
 * @author guozhe
 * @date 2020-05-06
 */
@Slf4j
public class AsynchronousSocketChannelWriteHandler implements CompletionHandler<Integer, Attachment> {

    @Override
    public void completed(Integer result, Attachment attachment) {
        try {
            ByteBuffer byteBuffer = attachment.getByteBuffer();
            if (attachment.isReadMode()) {
                byteBuffer.flip();
                byte[] bytes = new byte[byteBuffer.limit()];
                byteBuffer.get(bytes);
                String response = new String(bytes, StandardCharsets.UTF_8);
                log.info("response={}", response);
                attachment.getAsynchronousSocketChannel().close();
            } else {
                byteBuffer.clear();
                attachment.setReadMode(true);
                attachment.getAsynchronousSocketChannel().read(byteBuffer, attachment, this);
            }

        } catch (IOException e) {
            log.error("close asynchronousSocketChannel failed", e);
        }

    }

    @Override
    public void failed(Throwable exc, Attachment attachment) {
        log.error("AsynchronousSocketChannel read failed", exc);
    }
}
