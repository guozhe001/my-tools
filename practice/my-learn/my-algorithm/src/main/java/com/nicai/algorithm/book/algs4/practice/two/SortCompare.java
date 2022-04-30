package com.nicai.algorithm.book.algs4.practice.two;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;
import com.nicai.exception.NicaiException;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * @author guozhe
 * @date 2020/12/01
 */
public class SortCompare<T extends Comparable<T>> {


    /**
     * 随机生成长度为length的数组，对算法alg进行times次测试
     *
     * @param alg    算法名称
     * @param length 随机数组的长度
     * @param times  测试次数
     * @return 花费的总时间
     */
    private static double timeRandomInput(String alg, int length, int times) {
        double total = 0.0;
        Double[] doubles = new Double[length];
        for (int i = 0; i < times; i++) {
            for (int j = 0; j < length; j++) {
                doubles[j] = StdRandom.uniform();
            }
            total += time(alg, doubles);
        }
        return total;
    }

    /**
     * 测试指定的算法名称alg对数组a进行排序，返回执行时间
     *
     * @param alg 算法名称
     * @param a   数组
     * @return 执行时间
     */
    public static double time(String alg, Double[] a) {
        Sort<Double> sort;
        switch (alg) {
            case "Insertion":
                sort = new Insertion<>();
                break;
            case "Selection":
                sort = new Selection<>();
                break;
            case "Shell":
                sort = new Shell<>();
                break;
            case "Merge":
                sort = new Merge<>();
                break;
            case "Quick":
                sort = new Quick<>();
                break;
            case "Heap":
                sort = new Heap<>();
                break;
            default:
                throw new NicaiException(StrUtil.format("未定义的排序算法:{}", alg));
        }
        Stopwatch timer = new Stopwatch();
        sort.sort(a);
        return timer.elapsedTime();
    }

    public static void main(String[] args) {
        Assert.isTrue(args.length == 4);
        String alg1 = args[0];
        String alg2 = args[1];
        int length = Integer.parseInt(args[2]);
        int times = Integer.parseInt(args[3]);
        double t1 = timeRandomInput(alg1, length, times);
        double t2 = timeRandomInput(alg2, length, times);
        StdOut.printf("For %d random Doubles\n %s is", length, alg1);
        StdOut.printf("%.If times faster than %s\n", t2 / t1, alg2);
    }
}
