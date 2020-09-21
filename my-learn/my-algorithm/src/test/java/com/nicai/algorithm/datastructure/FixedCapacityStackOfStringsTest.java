package com.nicai.algorithm.datastructure;

import org.junit.Assert;
import org.junit.Test;

/**
 * 固定容量的栈测试
 *
 * @author guozhe
 * @date 2020/09/21
 */
public class FixedCapacityStackOfStringsTest {

    /**
     * 测试字符串反转
     * 如输入["a", "b", "c"] 返回["c", "b", "a"]
     */
    public String[] reverse(String[] strings) {
        int length = strings.length;
        FixedCapacityStackOfStrings fixedCapacityStackOfStrings = new FixedCapacityStackOfStrings(length);
        for (String s : strings) {
            fixedCapacityStackOfStrings.push(s);
        }
        String[] result = new String[length];
        for (int i = 0; i < length; i++) {
            result[i] = fixedCapacityStackOfStrings.pop();
        }
        return result;
    }

    @Test
    public void reverse() {
        String[] reverse = reverse(new String[]{"a", "b", "c"});
        Assert.assertEquals("c", reverse[0]);
        Assert.assertEquals("b", reverse[1]);
        Assert.assertEquals("a", reverse[2]);
    }


}