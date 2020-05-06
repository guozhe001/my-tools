package com.nicai.experience.nio;

import com.nicai.experience.threadpool.ThreadPoolUtils;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.Future;

/**
 * @author guozhe
 * @date 2020-05-06
 */
@Slf4j
public class AsynchronousServerSocketChannelPractice {

    public static void main(String[] args) throws InterruptedException {
        practiceCompletionHandler();
//        practiceFuture();
        Thread.currentThread().join();
    }

    /**
     * 练习使用CompletionHandler的方式处理AsynchronousServerSocketChannel的accept
     * 以及AsynchronousSocketChannel的read
     */
    private static void practiceCompletionHandler() {
        try {
            AsynchronousServerSocketChannel asynchronousServerSocketChannel = getAsynchronousServerSocketChannel();
            Attachment attachment = new Attachment();
            attachment.setAsynchronousServerSocketChannel(asynchronousServerSocketChannel);
            asynchronousServerSocketChannel.accept(attachment, new AsynchronousServerSocketChannelAcceptHandler());
        } catch (IOException e) {
            log.error("practiceCompletionHandler failed", e);
        }

    }

    /**
     * 练习使用Future的方式处理AsynchronousServerSocketChannel的accept
     * 以及AsynchronousSocketChannel的read
     */
    private static void practiceFuture() {
        try {
            AsynchronousServerSocketChannel asynchronousServerSocketChannel = getAsynchronousServerSocketChannel();
            Attachment attachment = new Attachment();
            attachment.setAsynchronousServerSocketChannel(asynchronousServerSocketChannel);
            Future<AsynchronousSocketChannel> future = asynchronousServerSocketChannel.accept();
            AsynchronousSocketChannel asynchronousSocketChannel = future.get();
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            while (asynchronousSocketChannel.read(byteBuffer).get() > 0) {
                byteBuffer.flip();
                byte[] bytes = new byte[byteBuffer.limit()];
                byteBuffer.get(bytes);
                String request = new String(bytes, StandardCharsets.UTF_8);
                log.info("receive ={}", request);
                asynchronousSocketChannel.write(ByteBuffer.wrap("i'm AsynchronousServerSocketChannelPractice,with Future".getBytes()));
            }
        } catch (Exception e) {
            log.error("practiceFuture failed", e);
        }

    }

    private static AsynchronousServerSocketChannel getAsynchronousServerSocketChannel() throws IOException {
        AsynchronousServerSocketChannel asynchronousServerSocketChannel = AsynchronousServerSocketChannel.open(
                AsynchronousChannelGroup.withThreadPool(ThreadPoolUtils.getThreadPoolExecutor("server-%s", 2)));
        asynchronousServerSocketChannel.bind(new InetSocketAddress(8080));
        return asynchronousServerSocketChannel;
    }

}
