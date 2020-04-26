package com.nicai.designpattern.singleton;

import org.junit.Test;

public class DoubleCheckLazySingletonTest {

    @Test
    public void getInstance() {
        DoubleCheckLazySingleton.getInstance();
    }
}
