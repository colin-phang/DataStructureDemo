package com.colin;

import java.util.Arrays;

/**
 * 两个有序数组合并成一个有序数组
 * Created by Colin on 2017/5/7.
 */
public class Merger {

    public static void main(String[] args) {
        int[] a = {3, 5, 6, 8, 10};
        int[] b = {1, 2, 7, 9, 12, 13};
        int[] x = merge(a, b);
        for (int i = 0; i < x.length; i++) {
            System.out.print(x[i]+" ");
        }
    }

    private static int[] merge(int[] a, int[] b) {
        int[] x = new int[a.length + b.length];
        int ai = 0;
        int bi = 0;
        int xi = 0;
        while (ai < a.length && bi < b.length) {
            if (a[ai] < b[bi])
                x[xi++] = a[ai++];
            else
                x[xi++] = b[bi++];
        }

        while (ai < a.length)
            x[xi++] = a[ai++];

        while (bi < b.length)
            x[xi++] = b[bi++];

        return x;
    }


}
