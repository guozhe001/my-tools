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

import javax.swing.tree.TreeNode;

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
        /**
         * 其实这个提的题的考察主要是遍历二叉树，遍历之后把相邻的计算出来即可
         *
         * @param root 跟节点
         * @return 请你计算树中任意两节点的差的绝对值的最小值
         */
        public int getMinimumDifference(TreeNode root) {
            return 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}