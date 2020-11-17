package com.nicai.experience.fibonacci;

import com.nicai.util.Generator;
import lombok.extern.slf4j.Slf4j;

/**
 * 斐波那契数列生成器
 *
 * @author guozhe
 */
@Slf4j
public class Fibonacci implements Generator<Integer> {

    private int count = 0;

    @Override
    public Integer next() {
        return fib(count++);
    }

//    private Integer fib(int n) {
//        if (n < 2) {
//            return n;
//        }
//        return fib(n - 2) + fib(n - 1);
//    }

    public int fib(int n) {
        assert n >= 0;
        int[] c = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            if (i < 2) {
                c[i] = i;
            } else {
                c[i] = c[i - 2] + c[i - 1];
            }
        }
        return c[n];
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        long l = System.currentTimeMillis();
        for (int i = 0; i < 46; i++) {
            System.out.print(fibonacci.next() + " ");
        }
        System.out.println("");
        log.info("spend {} milliseconds", System.currentTimeMillis() - l);
    }
}
