package com.nicai.experience.nio;

import cn.hutool.core.io.FileUtil;
import com.google.common.base.Stopwatch;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author guozhe
 * @date 2020-04-30
 */
@Slf4j
public class FileChannelPracticeTest {

    private static final List<String> CONTEXT = IntStream.range(0, 10000).mapToObj(i -> UUID.randomUUID().toString()).collect(Collectors.toList());

    static final File FILE = FileUtil.writeUtf8Lines(CONTEXT, "BufferPracticeFile.txt");

    @Test
    public void backup() throws IOException {
        Stopwatch stopwatch = Stopwatch.createStarted();
        File backup = FileChannelPractice.backupWithNio(FileUtil.writeUtf8Lines(CONTEXT, "BufferPracticeFile.txt"), "BufferPracticeFile_backup.txt");
        log.info("nio backupWithNio file with {} lines of data spend {} MILLISECONDS", CONTEXT.size(), stopwatch.elapsed(TimeUnit.MILLISECONDS));
        printFileContext(backup);
        FileUtil.del(FILE);
        FileUtil.del(backup);
    }

    /**
     * 打印文件中的数据
     */
    private static void printFileContext(File file) {
        List<String> list = FileUtil.readUtf8Lines(file);
        Assert.assertEquals(CONTEXT.size(), list.size());
        for (int i = 0; i < CONTEXT.size(); i++) {
            Assert.assertEquals(CONTEXT.get(i), list.get(i));
        }
    }

}