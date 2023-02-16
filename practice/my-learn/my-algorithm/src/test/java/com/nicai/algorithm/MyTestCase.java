package com.nicai.algorithm;

import org.junit.Assert;

/**
 * @author guozhe
 * @date 2023/2/8
 */
public abstract class MyTestCase<T, D> {

    public void invokeAndAssert(T param, D expect) {
        D result = invoke(param);
        Assert.assertEquals(expect, result);
    }

    protected abstract D invoke(T param);

}
