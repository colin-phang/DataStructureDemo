package com.colin;

/**
 * 树排序占用很多额外的内存空间
 * <p>
 * 一棵完全二叉树的每个节点都不大于它的子节点，称为堆
 * 1. 从最后一个非叶子节点(最后一个节点的父节点)开始，调整使之比自己的所有子节点小
 * 2. 输出根节点，最后一个节点移到堆顶，从新的根节点开始继续调整(其他节点已经满足堆的性质)
 * 3. 较大元素从顶层到底层(筛选)
 * <p>
 * 完全二叉树占用内存大，可以用数组表示
 * 1. 当前节点是k，父节点=(k-1)/2
 * 2. 左孩子=2k+1,右孩子=2k+2
 * Created by Colin on 2017/5/8.
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] nums = {6, 10, 2, 5, 7, 1, 4, 8, 3, 9};

        heapSort(nums);


    }

    public static void heapSort(int[] nums) {
        int lastLeaf = nums.length - 1;
        //最后一个非叶子节点
        int lastParent = (lastLeaf - 1) / 2;

        //从最后一个非叶子节点(最后一个节点的父节点)开始，调整使之比自己的所有子节点小
        for (int i = lastParent; i >= 0; i--) {
            heapOne(nums, nums.length, i);
        }
        Utils.printArray(nums);
        System.out.println("");

        int n = nums.length;
        while (n > 0) {
            System.out.print(nums[0] + " ");//输出根节点
            nums[0] = nums[n - 1];//最后一个元素移到堆顶
            n--;
            heapOne(nums, n, 0);//根节点重新筛选
        }
    }

    /**
     * 筛选
     *
     * @param nums 堆数据
     * @param n    堆中的数据数量
     * @param k    待筛选的节点
     */
    public static void heapOne(int[] nums, int n, int k) {
        int leftIndex = 2 * k + 1;
        int rightIndex = 2 * k + 2;
        if (leftIndex >= n && rightIndex >= n) return;//k已经是叶子节点

        int leftValue = Integer.MAX_VALUE;
        int rightValue = Integer.MAX_VALUE;
        if (leftIndex < n) leftValue = nums[leftIndex];
        if (rightIndex < n) rightValue = nums[rightIndex];
        int value = nums[k];
        if (value <= leftValue && value <= rightValue) return;//满足比子节点小

        //调整，使k节点比其子节点小
        if (leftValue < rightValue) {
            nums[k] = leftValue;
            nums[leftIndex] = value;
            heapOne(nums, n, leftIndex);//调整后的节点，继续调整
        } else {
            nums[k] = rightValue;
            nums[rightIndex] = value;
            heapOne(nums, n, rightIndex);//调整后的节点，继续调整
        }
    }

}
