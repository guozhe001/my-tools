package com.nicai.algorithm.other;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * 动态规划练习
 * 小偷、背包、电脑、音箱、吉他
 * 有限背包
 * 在万恶的资本主义社会美国，有一个小偷（罗伯特）；他有一个可以装4kg的背包，去了一家小商店，小商店里面有很多商品；请帮助他决定应该偷哪些商品。
 *
 * @author guozhe
 */
public class DynamicProgrammingPractice {

    /**
     * 给出商品列表和背包大小和背包的容量，请计算偷取哪些商品可以达到价格最大化
     *
     * @param products    商品列表
     * @param bagCapacity 背包容量
     * @return 最终偷取的商品列表
     */
    public List<Product> steal(Product[] products, int bagCapacity) {
        /*
         * 动态规划map，key为容量，value为价格之和最大的商品列表
         * TODO 未完成，不应该更新已经计算好的值；使用二维数组解决
         *
         */
        Map<Integer, List<Product>> map = Maps.newHashMap();
        // 初始化容量为0的背包，可以偷取的列表为空
        map.put(0, Lists.newArrayList());
        for (Product product : products) {
            for (int i = 1; i <= bagCapacity; i++) {
                // 如果此商品可以被容量为i的背包装下
                if (product.weight <= i) {
                    // 如果此前已经计算过此容量的背包数据，则比较如果偷当前商品
                    if (map.containsKey(i)) {
                        // 获取计算过的旧的此容量的商品列表的价值
                        int oldMaxPrice = sumPrice(map.get(i));
                        // 偷取当前商品之后剩余空间可以偷取的商品列表
                        List<Product> surplusCapacityProducts = map.get(i - product.weight);
                        // 如果偷取当前商品+偷取当前商品剩下的容量的商品价值之和大于旧的此容量的价值之和；则重新设置当前容量的偷取的商品列表
                        if (product.price + sumPrice(surplusCapacityProducts) > oldMaxPrice) {
                            ArrayList<Product> newProducts = Lists.newArrayList(surplusCapacityProducts);
                            newProducts.add(product);
                            map.put(i, newProducts);
                        }
                    } else {
                        // 如果此前未计算过背包容量为i的数据，则把当前商品设置为容量为i的背包的偷取商品列表
                        map.put(i, Lists.newArrayList(product));
                    }
                }
            }
        }
        return map.get(bagCapacity);
    }

    /**
     * 汇总商品列表的价格
     *
     * @param products 商品列表
     * @return 商品列表的价格之和
     */
    private int sumPrice(List<Product> products) {
        return products.stream().map(product -> product.price).reduce(Integer::sum).orElse(0);
    }

    /**
     * 商品信息
     */
    static class Product {
        public Product(String name, int price, int weight) {
            this.name = name;
            this.price = price;
            this.weight = weight;
        }

        /**
         * 商品名称
         */
        String name;
        /**
         * 商品价格(单位$)
         */
        int price;
        /**
         * 商品重量(单位磅)
         */
        int weight;
    }
}
