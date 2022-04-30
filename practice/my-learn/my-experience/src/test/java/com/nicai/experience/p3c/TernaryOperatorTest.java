package com.nicai.experience.p3c;

import org.junit.Test;

/**
 * @author guozhe
 * @date 2020-04-27
 */
public class TernaryOperatorTest {

    @Test(expected = NullPointerException.class)
    public void getResultIntegerFalse() {
        TernaryOperator.getResultInteger(false);
    }

    @Test
    public void getResultIntegerTrue() {
        TernaryOperator.getResultInteger(true);
    }

    @Test
    public void getResultInteger1() {
        TernaryOperator.getResultInteger1(false);
    }

}