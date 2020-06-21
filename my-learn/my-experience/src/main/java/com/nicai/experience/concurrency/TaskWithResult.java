package com.nicai.experience.concurrency;

import java.util.concurrent.Callable;

/**
 * 又返回值的任务
 *
 * @author guozhe
 */
public class TaskWithResult implements Callable<String> {

    private static int counter = 0;
    /**
     * 每个实例的id
     */
    private final int id = counter++;

    @Override
    public String call() {
        return "TaskWithResult id=" + id;
    }

}
