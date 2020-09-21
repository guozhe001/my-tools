package com.nicai.algorithm.leetcode.editor.cn;
//将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。 
//
// 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下： 
//
// L   C   I   R
// E T O E S I I G
// E   D   H   N
// 
//
// 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。 
//
// 请你实现这个将字符串进行指定行数变换的函数： 
//
// string convert(string s, int numRows); 
//
// 示例 1: 
//
// 输入: s = "LEETCODEISHIRING", numRows = 3
// 输出: "LCIRETOESIIGEDHN"
// 
//
// 示例 2: 
//
// 输入: s = "LEETCODEISHIRING", numRows = 4
// 输出: "LDREOEIIECIHNTSG"
// 解释:
//
// L     D     R
// E   O E   I I
// E C   I H   N
// T     S     G
// Related Topics 字符串 
// 👍 838 👎 0

import java.util.*;

/**
 * Z 字形变换
 *
 * @author nicai
 */
public class P6ZigzagConversion {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String convert(String s, int numRows) {
            // 初始化保存每一行数据的队列
            Map<Integer, Queue<String>> map = initQueueMap(numRows);
            /*
             * 保存行
             */
            Stack<Queue<String>> stack = new Stack<>();
            stack.push(map.get(0));
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                Queue<String> pop = stack.pop();
                pop.offer(String.valueOf(chars[i]));
                // 如果当前是第一行
                if (map.get(0) == pop) {
                    for (int j = numRows - 1; j > 0; j--) {
                        stack.push(map.get(j));
                    }
                }
                if (map.get(numRows - 1) == pop) {
                    for (int j = 0; j < numRows - 1; j++) {
                        stack.push(map.get(j));
                    }
                }
                if (map.get(0) == pop && map.get(numRows - 1) == pop) {
                    stack.push(pop);
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < numRows; i++) {
                Queue<String> strings = map.get(i);
                System.out.println("row=" + i + ": " + strings);
                while (!strings.isEmpty()) {
                    stringBuilder.append(strings.poll());
                }
            }
            return stringBuilder.toString();
        }

        private Map<Integer, Queue<String>> initQueueMap(int numRows) {
            Map<Integer, Queue<String>> map = new HashMap<>(numRows);
            for (int i = 0; i < numRows; i++) {
                map.put(i, new LinkedList<>());
            }
            return map;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}