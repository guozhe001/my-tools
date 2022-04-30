package com.nicai.experience.p3c;

/**
 * 阿里巴巴Java开发手册
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
        // a + b计算之后的返回结果为int类型
        Integer result = flag ? a + b : c;
        return result;
    }

    /**
     * 当flag为false时，不会报NPE
     *
     * @param flag
     * @return
     */
    static Integer getResultInteger1(Boolean flag) {
        return flag ? a : c;
    }

}
