package com.nicai.algorithm.leetcode.editor.cn;
//给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。 
//
// 
//
// 示例： 
//
// 输入：
//
//   1
//    \
//     3
//    /
//   2
//
//输出：
//1
//
//解释：
//最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
// 
//
// 
//
// 提示： 
//
// 
// 树中至少有 2 个节点。 
// 本题与 783 https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/ 
//相同 
// 
// Related Topics 树 
// 👍 135 👎 0

import java.util.*;

/**
 * 二叉搜索树的最小绝对差
 *
 * @author nicai
 */
public class P530MinimumAbsoluteDifferenceInBst {
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        private final Queue<TreeNode> queue = new LinkedList<>();

        /**
         * 其实这个提的题的考察主要是遍历二叉树，遍历之后把所有的可能性计算出来即可
         *
         * @param root 跟节点
         * @return 请你计算树中任意两节点的差的绝对值的最小值
         */
        public int getMinimumDifference(TreeNode root) {
            // 遍历树，获取所有的数字，然后遍历所有数字进行两两相减获取绝对值最小的数字
            return getMinValue(getAllVal(root));
        }

        /**
         * 列表中的数字两两相减，获取相减后绝对值最小的数字
         *
         * @param integerList 树节点的数值列表
         * @return 任意两节点相减绝对值最小的数字
         */
        private int getMinValue(List<Integer> integerList) {
            Integer result = null;
            for (int i = 0; i < integerList.size() - 1; i++) {
                for (int j = i + 1; j < integerList.size(); j++) {
                    int abs = Math.abs((integerList.get(i) - integerList.get(j)));
                    result = Objects.isNull(result) ? abs : Math.min(Math.abs(result), abs);
                }
            }
            return result;
        }

        /**
         * 获取树的所有节点的值
         *
         * @param root root节点
         * @return 所有节点的值列表
         */
        private List<Integer> getAllVal(TreeNode root) {
            List<Integer> values = new ArrayList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                TreeNode treeNode = queue.poll();
                if (Objects.nonNull(treeNode)) {
                    values.add(treeNode.val);
                    addChildToQueue(treeNode);
                }
            }
            return values;
        }

        /**
         * 把指定的树的子节点添加到队列
         *
         * @param treeNode 树
         */
        private void addChildToQueue(TreeNode treeNode) {
            queue.offer(treeNode.left);
            queue.offer(treeNode.right);
        }

    }

//leetcode submit region end(Prohibit modification and deletion)

}