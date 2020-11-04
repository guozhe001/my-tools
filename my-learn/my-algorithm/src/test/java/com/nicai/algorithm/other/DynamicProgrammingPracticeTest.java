package com.nicai.algorithm.other;

import lombok.extern.slf4j.Slf4j;
import mockit.Tested;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

@Slf4j
public class DynamicProgrammingPracticeTest {

    private static final DynamicProgrammingPractice.Product GUITAR = new DynamicProgrammingPractice.Product("吉他", 1500, 1);
    private static final DynamicProgrammingPractice.Product SPEAKER = new DynamicProgrammingPractice.Product("音响", 3000, 4);
    private static final DynamicProgrammingPractice.Product COMPUTER = new DynamicProgrammingPractice.Product("电脑", 2000, 3);
    private static final DynamicProgrammingPractice.Product IPHONE = new DynamicProgrammingPractice.Product("iphone", 2000, 1);
    private static final DynamicProgrammingPractice.Product MP3 = new DynamicProgrammingPractice.Product("MP3", 1000, 1);

    @Tested
    private DynamicProgrammingPractice dynamicProgrammingPractice;

    @Test
    public void stealMaxPrice() {
        Assert.assertEquals(3500, dynamicProgrammingPractice.stealMaxPrice(
                new DynamicProgrammingPractice.Product[]{GUITAR, SPEAKER, COMPUTER}, 4));
    }

    @Test
    public void stealMaxPrice1() {
        Assert.assertEquals(4000, dynamicProgrammingPractice.stealMaxPrice(
                new DynamicProgrammingPractice.Product[]{GUITAR, SPEAKER, COMPUTER, IPHONE}, 4));
    }

    @Test
    public void stealMaxPrice2() {
        Assert.assertEquals(4500, dynamicProgrammingPractice.stealMaxPrice(
                new DynamicProgrammingPractice.Product[]{GUITAR, SPEAKER, COMPUTER, IPHONE, MP3}, 4));
    }

    /**
     * 改变商品的顺序，验证结果是否正确
     */
    @Test
    public void stealMaxPrice3() {
        Assert.assertEquals(4500, dynamicProgrammingPractice.stealMaxPrice(
                new DynamicProgrammingPractice.Product[]{SPEAKER, GUITAR, COMPUTER, IPHONE, MP3}, 4));
    }

    @Test
    public void steal() {
        List<DynamicProgrammingPractice.Product> steal = dynamicProgrammingPractice.steal(
                new DynamicProgrammingPractice.Product[]{GUITAR, SPEAKER, COMPUTER}, 4);
        Assert.assertEquals(2, steal.size());
        Assert.assertTrue(steal.contains(GUITAR));
        Assert.assertTrue(steal.contains(COMPUTER));
        Assert.assertEquals(3500, sumPrice(steal));
    }


    @Test
    public void steal1() {
        List<DynamicProgrammingPractice.Product> steal = dynamicProgrammingPractice.steal(
                new DynamicProgrammingPractice.Product[]{GUITAR, SPEAKER, COMPUTER, IPHONE}, 4);
        Assert.assertEquals(2, steal.size());
        Assert.assertTrue(steal.contains(COMPUTER));
        Assert.assertTrue(steal.contains(IPHONE));
        Assert.assertEquals(4000, sumPrice(steal));
    }

    @Test
    public void steal2() {
        List<DynamicProgrammingPractice.Product> steal = dynamicProgrammingPractice.steal(
                new DynamicProgrammingPractice.Product[]{GUITAR, SPEAKER, COMPUTER, IPHONE, MP3}, 4);
        Assert.assertEquals(3, steal.size());
        Assert.assertTrue(steal.contains(GUITAR));
        Assert.assertTrue(steal.contains(IPHONE));
        Assert.assertTrue(steal.contains(MP3));
        Assert.assertEquals(4500, sumPrice(steal));
    }

    /**
     * 汇总商品列表的价格
     *
     * @param products 商品列表
     * @return 商品列表的价格之和
     */
    private int sumPrice(List<DynamicProgrammingPractice.Product> products) {
        return products.stream().map(product -> product.price).reduce(Integer::sum).orElse(0);
    }

    @Test
    public void test() {
        int[][] table = new int[1][4];
        table[0][0] = 1500;
        table[0][1] = 1500;
        table[0][2] = 1500;
        table[0][3] = 1500;
        for (int i = 0; i < table.length; i++) {
            int[] ints = table[i];
            for (int j = 0; j < ints.length; j++) {
                log.info("row={},column={},value={}", i, j, ints[j]);
            }
        }
    }

}