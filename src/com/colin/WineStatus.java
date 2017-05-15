package com.colin;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 泊松分酒问题
 * <p>
 * 三个瓶子中的酒量看成一个状态，即图中的节点
 * 经过操作把一个状态转成另一种状态，即图中的边
 * 分酒问题就成为 求节点通路的问题
 * <p>
 * 这个问题特殊之处在于 开始只有一个状态（节点），这个图的节点（其他的分酒状态）要动态产生出来。
 * <p>
 * 解法就是，对已有的状态 不断地进行可能的操作来产生新状态，直到不能产生新的状态，计算就停止了。
 * 这一过程中，如果碰到了最终要求的状态，则该题有解。
 * Created by Colin on 2017/5/15.
 */
public class WineStatus {
    public static void main(String[] args) {
        Set<WineStatus> allState = new HashSet<>();

        WineStatus wineStatus = new WineStatus(12, 0, 0);
        allState.add(wineStatus);

        for (; ; ) {
            Set<WineStatus> subSet = new HashSet<>();

            for (WineStatus status : allState) {//深度优先遍历
                subSet.addAll(status.op());
            }

            if (allState.containsAll(subSet)) break;
            allState.addAll(subSet);
        }


        Iterator<WineStatus> iterator = allState.iterator();
        while (iterator.hasNext()) {
            WineStatus status = iterator.next();

            if (status.has(6)) {
                while (status != null) {
                    System.out.println(status);
                    status = status.from;
                }
            }
        }


    }

    public int[] full = {12, 8, 5};
    public int[] wine = new int[3];
    public WineStatus from;


    public WineStatus(int wine0, int wine1, int wine2) {
        wine[0] = wine0;
        wine[1] = wine1;
        wine[2] = wine2;
    }

    /**
     * 返回所有可能的倒酒组合
     *
     * @return
     */
    public Set op() {
        Set<WineStatus> statuses = new HashSet<>();
        //两个遍历，代表wine数组之间倒酒，由i桶倒向j桶
        for (int i = 0; i < wine.length; i++) {
            for (int j = 0; j < wine.length; j++) {
                if (i == j) continue;
                if (wine[i] == 0) continue;
                if (wine[j] == full[j]) continue;

                WineStatus n = new WineStatus(wine[0], wine[1], wine[2]);//新状态
                n.from = this;

                //由i桶倒向j桶
                n.wine[j] += n.wine[i];
                n.wine[i] = 0;

                if (n.wine[j] > n.full[j]) {
                    n.wine[i] = n.wine[j] - n.full[j];
                    n.wine[j] = n.full[j];
                }


                statuses.add(n);
            }
        }

        return statuses;
    }

    public boolean has(int status) {
        for (int i = 0; i < wine.length; i++) {
            if (status == wine[i])
                return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return wine[0] * 1000 + wine[1] * 100 + wine[2];
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof WineStatus == false) {
            return false;
        }
        WineStatus status = (WineStatus) obj;
        return
                wine[0] == status.wine[0]
                        && wine[1] == status.wine[1]
                        && wine[2] == status.wine[2];
    }

    @Override
    public String toString() {
        return wine[0] + " " + wine[1] + " " + wine[2];
    }
}
