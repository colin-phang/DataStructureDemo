package com.colin;

/**
 * 概率模拟算法求圆周率
 * 正方形面积s1 = l*l
 * 圆形面积 s2 = pi* (l/2) * (l/2) = pi*l*l/4
 * 所以 随机点落在圆形面积内的概率 是 s2/s1 = pi/4
 * 由此求出圆周率
 * Created by Colin on 2017/5/16.
 */
public class PI {

    public static void main(String[] args) {
        int count = 100_000_000;//1亿个点

        int n = 0;
        for (int i = 0; i < count; i++) {
            //假设圆心为原点，正方形内所有的点 x<=1且y<=1
            double x = Math.random();
            double y = Math.random();
            if ((x * x + y * y) <= 1)//离原点距离1以内的就落在圆上
                n++;
        }

        double pi = (double) n / count * 4;
        System.out.println(pi);

    }
}
