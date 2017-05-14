package com.colin.model;

/**
 * Created by Colin on 2017/5/14.
 */
public class Pos {
    public int i;
    public int j;

    public Pos(int i, int j) {
        this.i = i;
        this.j = j;
    }

    @Override
    public int hashCode() {
        return 1000 * i + j;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Pos == false) {
            return false;
        }
        Pos pos = (Pos) obj;
        return this.i == pos.i && this.j == pos.j;
    }
}
