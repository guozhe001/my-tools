package com.nicai.experience.fibonacci;

import java.util.Iterator;

/**
 * @author guozhe
 */
public class IterableFibonacci extends Fibonacci implements Iterable<Integer> {

    /**
     * 打印斐波那契数列的个数
     */
    private int count;

    public IterableFibonacci(int count) {
        this.count = count;
    }

    @Override
    public Iterator<Integer> iterator() {

        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return count > 0;
            }

            @Override
            public Integer next() {
                count--;
                return IterableFibonacci.this.next();
            }
        };
    }

    public static void main(String[] args) {
        for (int i : new IterableFibonacci(18)) {
            System.out.print(i + " ");
        }
    }

}
