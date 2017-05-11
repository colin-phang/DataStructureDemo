package com.colin;

import com.colin.model.Cell;

import java.util.*;

/**
 * e28
 * 最短路径
 * 边无权：
 * 边有权：迪杰斯特拉算法
 * Created by Colin on 2017/5/11.
 */
public class Graphic1 {
    public static void main(String[] args) {
        List<Cell>[] paths = new List[11];

        for (int i = 0; i < paths.length; i++) {
            paths[i] = new ArrayList<>();
        }

        paths[0].add(new Cell(1, 3));
        paths[0].add(new Cell(4, 1));
        paths[1].add(new Cell(2, 1));
        paths[1].add(new Cell(6, 3));
        paths[1].add(new Cell(9, 4));
        paths[1].add(new Cell(5, 5));
        paths[1].add(new Cell(0, 3));
        paths[2].add(new Cell(1, 1));
        paths[2].add(new Cell(3, 1));
        paths[2].add(new Cell(6, 7));
        paths[3].add(new Cell(2, 1));
        paths[3].add(new Cell(10, 2));
        paths[4].add(new Cell(0, 1));
        paths[4].add(new Cell(5, 2));
        paths[5].add(new Cell(4, 2));
        paths[5].add(new Cell(1, 5));
        paths[5].add(new Cell(7, 2));
        paths[5].add(new Cell(8, 3));

        paths[6].add(new Cell(2, 3));
        paths[6].add(new Cell(3, 7));
        paths[6].add(new Cell(8, 2));
        paths[6].add(new Cell(10, 1));
        paths[7].add(new Cell(5, 2));
        paths[8].add(new Cell(5, 3));
        paths[8].add(new Cell(6, 2));
        paths[9].add(new Cell(1, 4));
        paths[9].add(new Cell(10, 2));
        paths[10].add(new Cell(3, 2));
        paths[10].add(new Cell(6, 1));
        paths[10].add(new Cell(9, 2));

//        求与0号节点邻接的所有最小路径
        Map<Integer, Integer> map = new HashMap();

        while (true) {
            int min = Integer.MAX_VALUE;
            int minNode = 0;
            System.out.println("第一步");
            for (int i = 0; i < paths[0].size(); i++) {
                Cell cell = paths[0].get(i);
                if (map.get(cell.getNode()) == null && cell.getWeight() < min) {
                    minNode = cell.getNode();
                    min = cell.getWeight();
                    System.out.println("0号节点开始的所有最小路径 minNode = " + minNode);
                }
            }

            System.out.println("第二步");
            //与map中的点邻接 同时又不在map中 所有的点
            Iterator<Integer> iterator = map.keySet().iterator();
            while (iterator.hasNext()) {
                int node = iterator.next();
                //集合中的节点对应的最小路径值
                int weight = map.get(node);
                for (int i = 0; i < paths[node].size(); i++) {
                    Cell cell = paths[node].get(i);
                    if (map.get(cell.getNode()) == null) {
                        System.out.println("与map中的点 " + node + " 邻接 同时又不在map中的点 " + cell.getNode() + " , 路径长度 = " + cell.getWeight());
                        if (cell.getWeight() + weight < min) {
                            minNode = cell.getNode();
                            min = cell.getWeight() + weight;
                            System.out.println("最小路径" + cell.getNode() + " = " + min);
                        }
                    }
                }
            }

            if (min < Integer.MAX_VALUE) {
                map.put(minNode, min);
                System.out.println(minNode + " 节点放入map中");
                System.out.println();
            } else {
                System.out.println();
                break;
            }

        }

        System.out.println(map);
    }
}
