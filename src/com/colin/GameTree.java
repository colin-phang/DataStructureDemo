package com.colin;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Colin on 2017/5/16.
 */
public class GameTree {

    //两个人玩取球游戏，每个人每次只能取1/3/7/8个球，直到一方无法按照这个规则取球则输。
    public static int[] options = {1, 3, 7, 8};
    public static Map<Integer, Boolean> cache = new HashMap<>();


    public static void main(String[] args) {
        System.out.println(new Date());
        System.out.println(game(50));
        System.out.println(new Date());
        System.out.println(gameWithCache(50));
        System.out.println(new Date());


    }

    private static boolean game(int count) {
        for (int i = 0; i < options.length; i++) {
            if (count > options[i]) {//剩余球数 比 准备取的球数多
                int restCount = count - options[i];//我方取完球
                if (game(restCount) == false)
                    return true;
            }

        }
        return false;
    }

    private static boolean gameWithCache(int count) {
        for (int i = 0; i < options.length; i++) {
            if (count > options[i]) {//剩余球数 比 准备取的球数多
                int restCount = count - options[i];//我方取完球

                boolean oppCanWin;
                //提升效率：动态规划（动态缓冲），已经计算好的子问题存储起来，以后直接取用
                if (cache.get(restCount) == null) {
                    oppCanWin = game(restCount);
                    cache.put(restCount, oppCanWin);
                } else {
                    oppCanWin = cache.get(restCount);
                }

                if (oppCanWin == false)
                    return true;
            }

        }
        return false;
    }
}
