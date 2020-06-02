package com.nicai.experience.nio;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FileChannelWithMemoryMapPracticeTest {

    private static final String FILE_PATH = "/Users/guozhe/code/open-source/my-tools/my-learn/my-experience/helloMMap.txt";

    private static final ExecutorService es = Executors.newFixedThreadPool(1);
    private static final ExecutorService es1 = Executors.newFixedThreadPool(1);

    @Test
    public void mmap() throws InterruptedException {
        es.execute(() -> {
            try {
                FileChannelWithMemoryMapPractice.mmapWrite(new File(FILE_PATH));
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread.sleep(100L);
        es1.execute(() -> {
            try {
                FileChannelWithMemoryMapPractice.mmapRead(new File(FILE_PATH));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        Thread.sleep(11000L);
    }


}