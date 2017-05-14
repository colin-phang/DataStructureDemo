package com.colin;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 泊松分酒问题
 * Created by Colin on 2017/5/15.
 */
public class WineStatus {
    public static void main(String[] args) {
        Set<WineStatus> allState = new HashSet<>();

        WineStatus wineStatus = new WineStatus(12, 0, 0);
        allState.add(wineStatus);

        for (; ; ) {
            Set<WineStatus> subSet = new HashSet<>();

            for (WineStatus status : allState) {
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

                if (wine[i] > full[j]) {
                    wine[j] = full[j];
                    wine[i] -= full[j];
                } else {
                    wine[j] += wine[i];
                    wine[i] = 0;
                }

                WineStatus newStatus = new WineStatus(wine[0], wine[1], wine[2]);
                newStatus.from = this;
                statuses.add(newStatus);
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
