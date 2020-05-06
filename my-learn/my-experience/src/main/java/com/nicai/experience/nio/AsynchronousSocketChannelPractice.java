package com.nicai.experience.nio;

import com.nicai.experience.threadpool.ThreadPoolUtils;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author guozhe
 * @date 2020-05-06
 */
public class AsynchronousSocketChannelPractice {

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        AsynchronousSocketChannel asynchronousSocketChannel = AsynchronousSocketChannel.open(
                AsynchronousChannelGroup.withThreadPool(ThreadPoolUtils.getThreadPoolExecutor("client-%s", 2)));
        Future<?> connect = asynchronousSocketChannel.connect(new InetSocketAddress(8080));
        connect.get();
        ByteBuffer buffer = ByteBuffer.allocate(2048);
        buffer.put("i'm AsynchronousSocketChannelPractice,with CompletionHandler".getBytes());
        buffer.flip();
        Attachment attachment = new Attachment();
        attachment.setByteBuffer(buffer);
        attachment.setReadMode(false);
        attachment.setAsynchronousSocketChannel(asynchronousSocketChannel);
        // 发送数据
        asynchronousSocketChannel.write(buffer, attachment, new AsynchronousSocketChannelWriteHandler());
        Thread.sleep(2000L);
    }
}
