package com.nicai.algorithm.leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

/**
 * P530MinimumAbsoluteDifferenceInBstTest
 *
 * @author guozhe
 * @date 2020/09/09
 */
public class P530MinimumAbsoluteDifferenceInBstTest {

    P530MinimumAbsoluteDifferenceInBst.Solution solution = new P530MinimumAbsoluteDifferenceInBst().new Solution();

    @Test
    public void getMinimumDifference() {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        int minimumDifference = solution.getMinimumDifference(treeNode);
        Assert.assertEquals(1, minimumDifference);
    }

    @Test
    public void getMinimumDifference1() {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(7);
        treeNode.left = treeNode1;
        treeNode1.right = new TreeNode(2);
        int minimumDifference = solution.getMinimumDifference(treeNode);
        Assert.assertEquals(1, minimumDifference);
    }

}