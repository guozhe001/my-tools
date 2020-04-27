package com.nicai.experience.p3c;

/**
 * 三目运算符报NPE
 *
 * @author guozhe
 * @date 2020-04-27
 */
public class TernaryOperator {

    private static final Integer a = 1;
    private static final Integer b = 2;
    private static final Integer c = null;

    /**
     * 当flag为false时，会报NPE
     *
     * @param flag
     * @return
     */
    static Integer getResultInteger(Boolean flag) {
        Integer result = flag ? a + b : c;
        return result;
    }

    static int getResultInt(Boolean flag) {
        int result = flag ? a + b : c;
        return result;
    }

}
