package com.nicai.algorithm.other;

import cn.hutool.core.lang.Assert;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * 素性测试是判断一个自然数是否为素数的测试。
 * 素数(prime number)就是只能被 1 和其自 身整除，且大于 1 的自然数
 *
 * @author guozhe
 * @date 2020/09/30
 */
@Slf4j
public class PrimeNumber {
    private static final Random RANDOM = new Random();

    /**
     * 是否是素数
     *
     * @param num 数值
     * @return 此数是素数，返回true，否则返回false
     */
    public boolean isPrimeNumber(int num) {
        if (num <= 1) {
            return false;
        }
        Set<Integer> usedNumbers = new HashSet<>();
        for (int i = 2; i < num; i++) {
            if (usedNumbers.contains(num / i)) {
                break;
            }
            if (num % i == 0) {
                return false;
            } else {
                usedNumbers.add(i);
            }
        }
        return true;
    }

    /**
     * 费马素性测试：
     * 费马测试被称为概率性素性测试，它判断的是“某个数是素数的概率大不大”
     * 根据“费马小定理”：
     * 随机选择 3 个比 num 小的数作为 n，计算这些数的 num 次方，再用 num 去除得到的结果，求出余数。3 个数最后得到的余数都和原本的数相同，就可以判断 num 是素数。
     *
     * @param num 待测试的数
     * @return 是否是素数
     */
    public boolean fermatTest(int num) {
        for (int j = 0; j < 3; j++) {
            int i = RANDOM.nextInt(num);
            while (i == 0) {
                i = RANDOM.nextInt(num);
            }
            double pow = Math.pow(i, num);
            int mod = (int) pow % num;
            log.info("i{} pow num{} = {}; pow mod num={}", i, num, pow, mod);
            if (mod != i) {
                return false;
            }
        }
        return true;
    }


    /**
     * 素数的性质：
     * p = 素数
     * n < p
     * n的p次方 mod p = n
     * n的p次方与p求余等于n本身
     * 对于任意素数 p，上面的公式 都是成立的。这就是“费马小定理”
     *
     * @param primeNumber 素数
     */
    public void primeNumberFeature(int primeNumber) {
        Assert.isTrue(isPrimeNumber(primeNumber));
        for (int i = 1; i < primeNumber; i++) {
            int pow = (int) Math.pow(i, primeNumber);
            log.info("i={} pow primeNumber={} = {}", i, primeNumber, pow);
            Assert.isTrue((pow % primeNumber) == i);
        }
    }

}
