package com.colin.model;

/**
 * Created by Colin on 2017/5/10.
 */
public class Card {
    //花色
    private int type;
    //点数
    private int point;

    public Card(int type, int point) {
        this.type = type;
        this.point = point;
    }

    public int getType() {
        return type;
    }

    public int getPoint() {
        return point;
    }

    @Override
    public String toString() {
        return "Card{" + type + " , " + point + '}';
    }
}
