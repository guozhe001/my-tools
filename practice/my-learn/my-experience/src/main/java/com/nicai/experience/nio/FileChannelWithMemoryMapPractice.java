package com.nicai.experience.nio;

import cn.hutool.core.io.FileUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.StandardOpenOption;
import java.util.UUID;

/**
 * FileChannel使用内存映射练习
 *
 * @author guozhe
 * @date 2020-04-30
 */
@Slf4j
public class FileChannelWithMemoryMapPractice {
    static final File FILE = FileUtil.touch(FileUtil.newFile("helloMMap.txt"));

    /**
     * 内存映射练习
     *
     * @param file 文件
     */
    static void mmapWrite(File file) throws IOException, InterruptedException {
        // 打开文件通道，如果想要使用内存映射读写，此处的OpenOption要和内存映射的MapMode一致，不能一个只读另一个读写，否则会抛NonWritableChannelException异常
        MappedByteBuffer buffer;
        try (FileChannel readChannel = FileChannel.open(file.toPath(), StandardOpenOption.WRITE, StandardOpenOption.READ)) {
            // 内存映射：方式是读写，从位置为0的地方开始，大小为2048位
            buffer = readChannel.map(FileChannel.MapMode.READ_WRITE, 0L, 128);
            // 循环添加内存
            String writeContext = "hello mmap-" + UUID.randomUUID().toString();
            log.info("写入内容={} time={}", writeContext, System.currentTimeMillis());
            // 增加文件内容，在buffer中增加内容相当于把数据写入文件中
            buffer.put(writeContext.getBytes());
            Thread.sleep(10000L);
        }
    }

    public static void mmapRead(File file) throws IOException {
        MappedByteBuffer mappedByteBuffer;
        /*
         * 打开文件通道，如果想要使用内存映射读写，即使在做内存映射时的模式是MapMode.READ_ONLY，此处打开通道也需要是读写模式，否则会抛：
         * java.io.IOException: Channel not open for writing - cannot extend file to required size
         */
        try (FileChannel fileChannel = FileChannel.open(file.toPath(), StandardOpenOption.READ, StandardOpenOption.WRITE)) {
            mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, 128);
            int count = 1;
            while (true) {
                if (mappedByteBuffer.isLoaded()) {
                    break;
                }
                log.info("内容尚未加载到内存中,count={}", count);
                count++;
            }
            // 一直循环尝试读取文件内容
            while (mappedByteBuffer.hasRemaining()) {
                System.out.print((char) mappedByteBuffer.get());
            }
            System.out.println();
            System.out.println(String.format("read time = %s", System.currentTimeMillis()));
        }
    }

}
