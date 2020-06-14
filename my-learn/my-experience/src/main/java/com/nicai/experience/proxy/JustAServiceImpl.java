package com.nicai.experience.proxy;

import lombok.extern.slf4j.Slf4j;

/**
 * @author guozhe
 */
@Slf4j
public class JustAServiceImpl implements JustAService {

    @Override
    public void hello() {
        log.info("hello world!");
    }

    @Override
    public void hello(String name) {
        log.info("hello {}!", name);
    }

}
