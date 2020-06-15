package com.nicai.experience.proxy;

/**
 * @author guozhe
 */
public interface HelloService {

    /**
     * print hello world
     */
    void hello();

    /**
     * print the name
     *
     * @param name 指定打印的名字
     */
    void hello(String name);
}
