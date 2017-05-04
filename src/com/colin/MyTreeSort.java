package com.colin;

/**
 * 二叉树排序
 * 2的n次幂数量的数据排序
 * Created by Colin on 2017/5/5.
 */
public class MyTreeSort {

    public static void main(String[] args) {
        int[] array = {5, 8, 9, 10, 66, 3, 2, 99, 22, 92, 1, 11, 0, 16, 17, 13};
        System.out.println(array.length);

        for (int i = 0; i < array.length; i++) {

        }

    }

    private class BinaryTree {
        private TreeNode root;

    }


    private class TreeNode {
        private int data;

        private TreeNode leftChild;
        private TreeNode rightChild;

        public TreeNode(int data) {
            this.data = data;
        }
    }
}
