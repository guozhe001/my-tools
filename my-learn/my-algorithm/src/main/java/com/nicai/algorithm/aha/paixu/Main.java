package com.nicai.algorithm.aha.paixu;

/**
 * @author guozhe
 * @date 2018/11/13
 */
public class Main {

    public static void main(String[] args) {
        tongPaiXu(new int[]{1, 0, 9, 6, 3, 5, 0});
        int[] a = {1, 0, 9, 6, 3, 5, 0, 87, 456, 234, 787, 45234, 787856, 998, 7978, 45, 2345, 7};
        maoPao(a);
    }

    private static void tongPaiXu(int[] a) {
        TongPaiXu paiXu = new TongPaiXu();
        for (int i : a) {
            System.out.print(i + "  ");
        }
        System.out.println("");
        System.out.println("================================================");
        paiXu.print(paiXu.sort(a));
        paiXu.print(paiXu.sort1(a));
        paiXu.printDesc(paiXu.sort1(a));
    }

    private static void maoPao(int[] a) {
        MaoPao paiXu = new MaoPao();
        paiXu.print(a);
        paiXu.print(paiXu.sort(a));
        paiXu.print(paiXu.sort1(a));
        paiXu.print(paiXu.sort2(a));
    }
}
