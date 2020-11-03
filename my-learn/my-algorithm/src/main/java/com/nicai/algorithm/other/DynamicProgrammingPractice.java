package com.nicai.algorithm.other;

import cn.hutool.core.util.StrUtil;
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
        // 二维数组，记录已经计算过的最大价格
        int[][] table = new int[products.length][bagCapacity + 1];
        // 动态规划map，key为二维数组的某个值如table[0][0]对应的key为"00"，value为价格之和最大的商品列表
        Map<String, List<Product>> map = Maps.newHashMap();
        for (int j = 0; j < products.length; j++) {
            for (int currentBagCapacity = 1; currentBagCapacity <= bagCapacity; currentBagCapacity++) {
                // 更新当前的单元格的值
                setCell(products[j], j, currentBagCapacity, table, map);
            }
        }
        return map.get(getKey(products.length - 1, bagCapacity));
    }

    private void setCell(Product product, int j, int currentBagCapacity, int[][] table, Map<String, List<Product>> map) {
        String key = getKey(j, currentBagCapacity);
        // 如果此商品可以被容量为currentBagCapacity的背包装下
        if (product.weight <= currentBagCapacity) {
            // 如果此前已经计算过此容量的背包数据，则比较如果偷当前商品
            if (j > 0) {
                // 获取计算过的旧的此容量的商品列表的价值
                int oldMaxPrice = table[j - 1][currentBagCapacity];
                // 偷取当前商品之后剩余空间可以偷取的商品列表的价格
                int surplusCapacityProductPrice = table[j - 1][currentBagCapacity - product.weight];
                // 如果偷取当前商品+偷取当前商品剩下的容量的商品价值之和大于旧的此容量的价值之和；则重新设置当前容量的偷取的商品列表
                if (product.price + surplusCapacityProductPrice > oldMaxPrice) {
                    ArrayList<Product> newProducts = surplusCapacityProductPrice > 0 ?
                            Lists.newArrayList(map.get(getKey(j - 1, currentBagCapacity - product.weight))) :
                            Lists.newArrayList();
                    newProducts.add(product);
                    map.put(key, newProducts);
                    table[j][currentBagCapacity] = product.price + surplusCapacityProductPrice;
                } else {
                    table[j][currentBagCapacity] = oldMaxPrice;
                    map.put(key, map.get(getKey(j - 1, currentBagCapacity)));
                }
            } else {
                // 如果此前未计算过背包容量为i的数据，则把当前商品设置为容量为i的背包的偷取商品列表
                map.put(key, Lists.newArrayList(product));
                table[j][currentBagCapacity] = product.price;
            }
        } else {
            // 如果此前未计算过背包容量为i的数据，则把当前商品设置为容量为i的背包的偷取商品列表
            table[j][currentBagCapacity] = j > 0 ? table[j - 1][currentBagCapacity] : 0;
            map.put(key, j > 0 ? map.get(getKey(j - 1, currentBagCapacity)) : Lists.newArrayList());
        }
    }

    /**
     * 根据二维数组的下标信息组装key
     *
     * @param j
     * @param i
     * @return
     */
    private String getKey(int j, int i) {
        return StrUtil.format("{}{}", j, i);
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
