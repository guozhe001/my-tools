package com.nicai.experience.nio;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * @author guozhe
 * @date 2020-05-06
 */
@Slf4j
public class AsynchronousServerSocketChannelAcceptHandler implements CompletionHandler<AsynchronousSocketChannel, Attachment> {

    @Override
    public void completed(AsynchronousSocketChannel result, Attachment attachment) {
        // 完成说明有客户端连接到当前服务端
        try {
            SocketAddress clientAddress = result.getRemoteAddress();
            log.info("clientAddress={}", clientAddress);
            // 已经接收到数据之后，继续监听
            attachment.getAsynchronousServerSocketChannel().accept(attachment, this);
            Attachment newAttachment = new Attachment();
            newAttachment.setAsynchronousServerSocketChannel(attachment.getAsynchronousServerSocketChannel());
            newAttachment.setAsynchronousSocketChannel(result);
            newAttachment.setByteBuffer(ByteBuffer.allocate(1024));
            result.read(newAttachment.getByteBuffer(), newAttachment, new AsynchronousSocketChannelReadHandler());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void failed(Throwable exc, Attachment attachment) {
        log.error("AsynchronousServerSocketChannel accept failed", exc);
    }
}
