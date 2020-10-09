package com.nicai.algorithm.leetcode.editor.cn;
//在二维平面上计算出两个由直线构成的矩形重叠后形成的总面积。 
//
// 每个矩形由其左下顶点和右上顶点坐标表示，如图所示。 
//
// 
//
// 示例: 
//
// 输入: -3, 0, 3, 4, 0, -1, 9, 2
//输出: 45
// 上面的例子的重叠矩形的左下顶点和右上顶点坐标分别是：0,0;3,2
//
// 说明: 假设矩形面积不会超出 int 的范围。 
// Related Topics 数学 
// 👍 90 👎 0

/**
 * 矩形面积
 *
 * @author nicai
 */
public class P223RectangleArea {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
            int area1 = computeArea(A, B, C, D);
            int area2 = computeArea(E, F, G, H);
            int allArea = area1 + area2;
            // 如果第一个矩形的右上小于等于第二个定点的左下,或者第一个矩形的左下大于等于第二个矩形的右上
            if ((C <= E && D <= F) || (A >= G && B >= H)) {
                return allArea;
            }
            int pointLeftDownX = Math.abs(A) < Math.abs(E) ? A : E;
            int pointLeftDownY = Math.abs(B) < Math.abs(F) ? B : F;
            int pointRightUpX = Math.abs(C) < Math.abs(G) ? C : G;
            int pointRightUpY = Math.abs(D) < Math.abs(H) ? D : H;
            int chongdie = computeArea(pointLeftDownX, pointLeftDownY, pointRightUpX, pointRightUpY);
            System.out.println("area1:" + area1 + ", area2:" + area2 + ", chongdie:" + chongdie);
            return allArea - chongdie;
        }

        /**
         * 计算一个矩形的面积；
         * 传入的必须是左下坐标和右上坐标，否则返回0
         *
         * @param pointLeftDownX 左下坐标x
         * @param pointLeftDownY 左下坐标y
         * @param pointRightUpX  右上坐标x
         * @param pointRightUpY  右上坐标y
         * @return 面积
         */
        private int computeArea(int pointLeftDownX, int pointLeftDownY, int pointRightUpX, int pointRightUpY) {
            if (pointLeftDownX >= pointRightUpX || pointLeftDownY >= pointRightUpY) {
                return 0;
            }
            return Math.abs(pointLeftDownX - pointRightUpX) * Math.abs(pointLeftDownY - pointRightUpY);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}