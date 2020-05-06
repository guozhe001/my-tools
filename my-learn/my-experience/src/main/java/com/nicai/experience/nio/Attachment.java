package com.nicai.experience.nio;

import lombok.Data;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;

/**
 * @author guozhe
 * @date 2020-05-06
 */
@Data
public class Attachment {

    private boolean readMode;
    private AsynchronousServerSocketChannel asynchronousServerSocketChannel;
    private AsynchronousSocketChannel asynchronousSocketChannel;
    private ByteBuffer byteBuffer;
}
