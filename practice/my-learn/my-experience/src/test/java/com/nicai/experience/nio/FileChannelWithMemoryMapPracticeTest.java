//package com.nicai.experience.nio;
//
//import cn.hutool.system.SystemUtil;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.Assert;
//import org.junit.BeforeClass;
//import org.junit.Rule;
//import org.junit.Test;
//import org.junit.contrib.java.lang.system.SystemOutRule;
//
//import java.io.File;
//import java.io.IOException;
//
//@Slf4j
//public class FileChannelWithMemoryMapPracticeTest {
//
//    @Rule
//    public SystemOutRule systemOutRule = new SystemOutRule().enableLog();
//
//    private static final String FILE_NAME = "helloMMap.txt";
//
//    private static String FILE_PATH;
//
//    @BeforeClass
//    public static void getPath() {
//        FILE_PATH = SystemUtil.get(SystemUtil.USER_DIR) + SystemUtil.get(SystemUtil.FILE_SEPARATOR) + FILE_NAME;
//    }
//
//    @Test
//    public void mmap() throws InterruptedException, IOException {
//        FileChannelWithMemoryMapPractice.mmapWrite(new File(FILE_PATH));
//        Assert.assertTrue(systemOutRule.getLog().contains("写入内容"));
//    }
//
//    @Test
//    public void mmap2() throws IOException {
//        FileChannelWithMemoryMapPractice.mmapRead(new File(FILE_PATH));
//        Assert.assertTrue(systemOutRule.getLog().contains("hello mmap-"));
//    }
//
//}