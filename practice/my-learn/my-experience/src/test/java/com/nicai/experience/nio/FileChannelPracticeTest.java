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

    private static List<String> CONTEXT;

    static {
        CONTEXT = getContext();
    }

    @Test
    public void backup() throws IOException {
        Stopwatch stopwatch = Stopwatch.createStarted();
        File file = getSourceFile();
        printAndAssert(file);
        File backup = FileChannelPractice.backupWithNio(file, "BufferPracticeFile_backup.txt");
        log.info("nio backupWithNio file with {} lines of data spend {} MILLISECONDS", CONTEXT.size(), stopwatch.elapsed(TimeUnit.MILLISECONDS));
        printAndAssert(backup);
        FileUtil.del(file);
        FileUtil.del(backup);
    }

    File getSourceFile() {
        return FileUtil.writeUtf8Lines(CONTEXT, FileUtil.touch("BufferPracticeFile.txt"));
    }

    private static List<String> getContext() {
        return IntStream.range(0, 10000).mapToObj(i -> UUID.randomUUID().toString()).collect(Collectors.toList());
    }

    @Test
    public void backupFileTransferFrom() throws IOException {
        Stopwatch stopwatch = Stopwatch.createStarted();
        File sourceFile = getSourceFile();
        printAndAssert(sourceFile);
        File backup = FileChannelPractice.backupFileTransferFrom(sourceFile, "BufferPracticeFile_backup.txt");
        log.info("nio backupWithNio file with {} lines of data spend {} MILLISECONDS", CONTEXT.size(), stopwatch.elapsed(TimeUnit.MILLISECONDS));
        printAndAssert(backup);
        FileUtil.del(sourceFile);
        FileUtil.del(backup);
    }

    @Test
    public void backupFileTransferTo() throws IOException {
        Stopwatch stopwatch = Stopwatch.createStarted();
        File sourceFile = getSourceFile();
        printAndAssert(sourceFile);
        File backup = FileChannelPractice.backupFileTransferTo(sourceFile, "BufferPracticeFile_backup.txt");
        log.info("nio backupWithNio file with {} lines of data spend {} MILLISECONDS", CONTEXT.size(), stopwatch.elapsed(TimeUnit.MILLISECONDS));
        printAndAssert(backup);
        FileUtil.del(sourceFile);
        FileUtil.del(backup);
    }

    /**
     * 打印文件中的数据
     */
    private static void printAndAssert(File file) {
        List<String> list = FileUtil.readUtf8Lines(file);
        Assert.assertEquals(CONTEXT.size(), list.size());
        for (int i = 0; i < CONTEXT.size(); i++) {
            Assert.assertEquals(CONTEXT.get(i), list.get(i));
            log.info("{}", list.get(i));
        }
    }

}