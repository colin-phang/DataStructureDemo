package com.colin;

import java.util.Set;

/**
 * 井字棋
 * <p>
 * Created by Colin on 2017/5/18.
 */
public class TicTacToe {
    public static final int MAN_GO = 0;
    public static final int AI_GO = 1;
    private int iAI;
    private int whichGoing;//当前是AI还是MAN在下棋

    public static void main(String[] args) {
        TicTacToe ttt = new TicTacToe();
        ttt.setAI(AI_GO);//0机器先走，1人先走，-1机器不参与
        ttt.start();
    }

    public TicTacToe() {
        System.out.println("-------------------------");
        System.out.println("1 2 3");
        System.out.println("4 5 6");
        System.out.println("7 8 9");
        System.out.println("-------------------------");
    }

    private void setAI(int n) {
        iAI = n;
    }

    private void start() {
        for (; ; ) {
            int r = testFinish();
            if (r == 0) System.out.println("x方胜出");
            if (r == 1) System.out.println("o方胜出");
            if (r == 2) System.out.println("平局结束");
            if (r >= 0) break;
        }

    }

    private int testFinish() {
        return 0;
    }

    private Set set_all;
    private Set[] set_xo;
    private int iGo;

}
