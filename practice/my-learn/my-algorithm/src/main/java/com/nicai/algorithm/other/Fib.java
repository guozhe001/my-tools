package com.nicai.algorithm.other;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author guozhe
 * @date 2023/3/22
 */
public class Fib {


    public static void main(String[] args) throws IOException {
        System.out.println("please input number n:");
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        Integer n = Integer.valueOf(line);
        int result = fib(n);
        System.out.println("the result=" + result);
    }

    private static int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }
}
