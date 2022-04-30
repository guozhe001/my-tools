//package com.nicai.algorithm.sort;
//
//import com.nicai.util.ArrayUtil;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.Assert;
//import org.junit.Test;
//import org.powermock.reflect.Whitebox;
//
//import java.util.Objects;
//import java.util.stream.IntStream;
//
//
///**
// * InsertSortTest
// *
// * @author guozhe
// * @date 2020/08/24
// */
//@Slf4j
//public class InsertSortTest {
//
//    InsertSort insertSort = new InsertSort();
//
//    @Test
//    public void sort() {
//        commonAssert(new InsertSort().sort(getNode(ArrayUtil.randomIntArray(100), 0)), true);
//    }
//
//    private void commonAssert(Node node, boolean check) {
//        while (Objects.nonNull(node)) {
//            int currentNum = node.getNum();
//            log.info("num={}", node.getNum());
//            node = node.getNextNode();
//            if (check && Objects.nonNull(node)) {
//                Assert.assertTrue(currentNum < node.getNum());
//            }
//        }
//    }
//
//    @Test
//    public void count() throws Exception {
//        int count = Whitebox.invokeMethod(insertSort, "count", getNode(ArrayUtil.randomIntArray(100), 0));
//        Assert.assertEquals(100, count);
//    }
//
//    @Test
//    public void getNode() throws Exception {
//        Node node = getNode(IntStream.range(0, 5).toArray(), 0);
//        commonAssert(node, false);
//        Node result = Whitebox.invokeMethod(insertSort, "getNode", node, 0);
//        Assert.assertEquals(0, result.getNum());
//    }
//
//    private Node getNode(int[] nums, int index) {
//        if (index >= nums.length) {
//            return null;
//        } else {
//            Node node = new Node();
//            node.setNum(nums[index]);
//            node.setNextNode(getNode(nums, index + 1));
//            return node;
//        }
//    }
//}