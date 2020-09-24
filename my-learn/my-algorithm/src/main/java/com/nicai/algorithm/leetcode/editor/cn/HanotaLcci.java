package com.nicai.algorithm.leetcode.editor.cn;
//在经典汉诺塔问题中，有 3 根柱子及 N 个不同大小的穿孔圆盘，盘子可以滑入任意一根柱子。一开始，所有盘子自上而下按升序依次套在第一根柱子上(即每一个盘子只
//能放在更大的盘子上面)。移动圆盘时受到以下限制: 
//(1) 每次只能移动一个盘子; 
//(2) 盘子只能从柱子顶端滑出移到下一根柱子; 
//(3) 盘子只能叠在比它大的盘子上。 
//
// 请编写程序，用栈将所有盘子从第一根柱子移到最后一根柱子。 
//
// 你需要原地修改栈。 
//
// 示例1: 
//
//  输入：A = [2, 1, 0], B = [], C = []
// 输出：C = [2, 1, 0]
// 
//
// 示例2: 
//
//  输入：A = [1, 0], B = [], C = []
// 输出：C = [1, 0]
// 
//
// 提示: 
//
// 
// A中盘子的数目不大于14个。 
// 
// Related Topics 递归 
// 👍 48 👎 0

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 汉诺塔问题
 * 汉诺塔的时间复杂度：O(2的n次方-1)
 * 1个盘子：T1 = 1 = 2
 * 2个盘子：T2 = 3
 * 3个盘子：T3 = T2 + T1 +T2 = 3+1+3 = 7
 * 四个盘子：T4 = T3 + T1 + T3 = 7 + 1 +7 = 15
 *
 * @author nicai
 */
public class HanotaLcci {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
            Stack<Integer> stackA = toStack(A);
            Stack<Integer> stackB = toStack(B);
            Stack<Integer> stackC = toStack(C);
            hanota(stackA, stackB, stackC, A.size());
            A = toList(stackA);
            B = toList(stackB);
            C = toList(stackC);
            return C;
        }

        private List<Integer> toList(Stack<Integer> stack) {
            if (stack.isEmpty()) {
                return Lists.newArrayList();
            }
            Integer[] array = new Integer[stack.size()];
            for (int i = stack.size() - 1; i >= 0; i--) {
                array[i] = stack.pop();
            }
            return Arrays.asList(array);
        }

        /*
         * 1、如果有一个盘子：把盘子从A移动到C即可
         * 2、如果有两个盘子：A中的第一个盘子移动到B，把A中剩下的盘子移动到C，把B的盘子移动到C
         * 3、如果有三个盘子：先使用第二个方法，把上面两个盘子移动到B，再把剩下的盘子移动到C，最后使用第二步把B的盘子移动到C
         * 4、循环以上步骤
         * 数据结构，因为汉诺塔一次只能移动一个盘子，并且只能移动柱子最顶端的盘子，和栈的结构完全一致
         */
        public void hanota(Stack<Integer> A, Stack<Integer> B, Stack<Integer> C, int num) {
            if (num == 1) {
                C.push(A.pop());
            } else if (num == 2) {
                B.push(A.pop());
                C.push(A.pop());
                C.push(B.pop());
            } else if (num >= 3) {
                hanota(A, C, B, num - 1);
                hanota(A, B, C, 1);
                hanota(B, A, C, num - 1);
            }
        }

        /**
         * 把list中的数据压入栈
         *
         * @param integers 数字列表
         * @return 栈
         */
        private Stack<Integer> toStack(List<Integer> integers) {
            Stack<Integer> stack = new Stack<>();
            for (int i : integers) {
                stack.push(i);
            }
            return stack;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}