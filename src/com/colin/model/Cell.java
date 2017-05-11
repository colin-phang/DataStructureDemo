package com.colin.model;

/**
 * Created by Colin on 2017/5/11.
 */
public class Cell {

    private int node;
    private int weight;

    public Cell(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }

    public int getNode() {
        return node;
    }

    public int getWeight() {
        return weight;
    }
}
