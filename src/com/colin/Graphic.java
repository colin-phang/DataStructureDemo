package com.colin;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * e25
 * 图，网状的数据结构，数据结构中最复杂的元素
 * <p>
 * 比较稠密的图 用邻接矩阵表示
 * 一般对角线为0，以为顶点不会邻接自己
 * 无向图 矩阵关于对角线对称
 * <p>
 * 顶点多，比较稀疏，用邻接表表示，每个顶点对应一个链表（表示其关联的顶点或边）
 * <p>
 * 需要考虑算法，回答关于图的问题：
 * 一个顶点连接哪些边
 * 一个边连接哪些顶点
 * <p>
 * 相邻顶点
 * 相邻边
 * <p>
 * a是否与b连通
 * a到b的最短路径
 * <p>
 * 经典问题：
 * 最短路径
 * 最大流量
 * 关键路径
 * 二部图
 * <p>
 * 在许多领域有迫切的实用意义
 * Created by Colin on 2017/5/10.
 */
public class Graphic {

    public static void main(String[] args) {
        int[][] graphic = {//存储0~5节点之间的关系
                {0, 1, 1, 1, 0},
                {1, 0, 1, 1, 1},
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 1, 0, 0, 0}
        };

        int[] traveled = new int[graphic.length];//存放已遍历过的节点
//        deepTravel(graphic, traveled, 0);

        int[][] graphic1 = {//存储0~7节点之间的关系
                {0, 1, 1, 0, 0, 0, 0},
                {1, 0, 0, 1, 0, 0, 1},
                {1, 0, 0, 0, 0, 1, 1},
                {0, 1, 0, 0, 1, 0, 0},
                {0, 0, 0, 1, 0, 1, 1},
                {0, 0, 1, 0, 1, 0, 0},
                {0, 1, 1, 0, 1, 0, 0}
        };
        wideTravel(graphic1, 0);
    }

    /**
     * 广度优先遍历
     * 求最短路径
     * 类似树的逐层遍历
     */
    public static void wideTravel(int[][] graphic, int startNode) {
        List<Integer> toBeTravelList = new ArrayList<>();//存放等待遍历的节点
        Set<Integer> traveledSet = new HashSet<>();//存放已经遍历的节点
        toBeTravelList.add(startNode);//开始遍历的节点

        while (!toBeTravelList.isEmpty()) {
            int node = toBeTravelList.remove(0);
            System.out.println("遍历了 ：" + node);
            traveledSet.add(node);

            int[] relation = graphic[node];

            for (int i = 0; i < relation.length; i++) {
                if (relation[i] == 1//相连关系
                        && !traveledSet.contains(i)//未遍历
                        && toBeTravelList.indexOf(i) < 0//不在待遍历列表中，避免重复遍历
                        ) {
                    System.out.println("添加进待遍历 ：" + i);
                    toBeTravelList.add(i);//添加进待遍历列表
                }
            }
        }
    }

    /**
     * 深度优先遍历
     * <p>
     * 类似于树的先根序遍历，不过图的节点路径是可重复的，需要标记已经遍历过的节点
     *
     * @param graphic
     * @param traveled
     * @param node
     */
    public static void deepTravel(int[][] graphic, int[] traveled, int node) {
        System.out.println("遍历了:" + node);
        traveled[node] = 1;

        int[] relative = graphic[node];//存储了 当前节点与其他节点的连接关系 0 or 1
        for (int i = 0; i < relative.length; i++) {//i是节点
            if (relative[i] == 1 && traveled[i] == 0) {// 与当前节点相连，且之前未被遍历过
                deepTravel(graphic, traveled, i);
            }
        }
    }
}
