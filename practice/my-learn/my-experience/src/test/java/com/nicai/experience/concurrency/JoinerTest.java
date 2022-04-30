package com.nicai.experience.concurrency;

import org.junit.Test;

public class JoinerTest {


    @Test
    public void run() {
        Sleeper sleepy = new Sleeper("Sleepy", 1500);
        Sleeper grumpy = new Sleeper("Grumpy", 1500);

        Joiner dopey = new Joiner("dopey", sleepy);
        Joiner doc = new Joiner("doc", grumpy);
        grumpy.interrupt();
    }
}