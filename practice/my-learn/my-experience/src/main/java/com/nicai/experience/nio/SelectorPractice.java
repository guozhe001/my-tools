package com.nicai.experience.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author guozhe
 * @date 2020-04-30
 */
public class SelectorPractice {

    public static void main(String[] args) throws IOException {
        Selector selector = Selector.open();
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(8080));
        // 设置为非阻塞模式
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        while (true) {
            int select = selector.select();
            if (select == 0) {
                continue;
            }
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                iterator.remove();
                if (selectionKey.isAcceptable()) {
                    // 已经有客户端连接到服务端,已经连接并不代表可以读取，读取的操作继续异步处理
                    SocketChannel accept = serverSocketChannel.accept();
                    accept.configureBlocking(false);
                    accept.register(selector, SelectionKey.OP_READ);
                }
                if (selectionKey.isReadable()) {
                    SocketChannel channel = (SocketChannel) selectionKey.channel();
                    ChannelUtils.printSocketChannel("SelectorPractice", channel);
                    channel.write(ByteBuffer.wrap("SelectorPractice接收到您的请求".getBytes()));
                    channel.close();
                }
            }
        }
    }

}
