package com.nicai.experience.nio;

import org.junit.Test;

import java.io.IOException;

/**
 * @author guozhe
 * @date 2020-04-30
 */
public class SocketChannelPracticeTest {

    /**
     * 先运行ServerSocketChannelPractice
     * 再跑此测试，观察ServerSocketChannelPractice接收数据
     *
     * @throws IOException
     */
    @Test
    public void test1() throws IOException {
        SocketChannelPractice.sendSomething("得到的点点滴滴");
    }
}