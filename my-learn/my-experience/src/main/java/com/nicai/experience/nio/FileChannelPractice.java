package com.nicai.experience.nio;

import cn.hutool.core.io.FileUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.StandardOpenOption;

/**
 * @author guozhe
 * @date 2020-04-30
 */
@Slf4j
public class FileChannelPractice {

    /**
     * 使用NIO方式读取一个文件
     *
     * @param file 待备份的源文件
     */
    static File backupWithNio(File file, String backupFileName) throws IOException {
        /*
         * 分配一个类型为IntBuffer的缓冲区，缓冲区的容量为1024个值
         * 此时POSITION和LIMIT分别为0和1024
         */
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        // array方法返回整个数组，可能是一个空数组，建议先调用hasArray方法来确认是否有元素
        byte[] array = buffer.array();
        log.info("allocate array length={}", array.length);
        // 打开一个读通道
        FileChannel readChannel = FileChannel.open(file.toPath(), StandardOpenOption.READ);
        // 打开一个写通道
        File backupFile = FileUtil.touch(backupFileName);
        FileChannel writeChannel = FileChannel.open(backupFile.toPath(), StandardOpenOption.WRITE);
        // 读取通道里面的数据到buffer里面
        int i = 0;
        while (true) {
            int read = readChannel.read(buffer);
            log.info("i={} readLines={}, after read buffer.position()={}, buffer.limit()={}", i, read, buffer.position(), buffer.limit());
            if (read <= 0) {
                break;
            }
            // 切换为读模式
            buffer.flip();
            log.info("i={}, after flip buffer.position()={}, buffer.limit()={}", i, buffer.position(), buffer.limit());
            int write = writeChannel.write(buffer);
            log.info("i={} write={}, after write buffer.position()={}, buffer.limit()={}", i, write, buffer.position(), buffer.limit());
            // 切换为写模式
            buffer.clear();
            log.info("i={}, after clear buffer.position()={}, buffer.limit()={}", i, buffer.position(), buffer.limit());
            i++;
        }
        writeChannel.close();
        return backupFile;
    }

}
