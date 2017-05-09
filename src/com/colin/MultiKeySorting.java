package com.colin;

import com.colin.model.Card;

import java.util.LinkedList;

/**
 * e24
 * MSD 高关键字 优先分组
 * LSD 低关键字 优先分组
 *      1. 没有排序，通过分组&收集 完成
 *      2. 适用于关键字多、每个关键字的取值数量少（例如无限大的整数范围的取值范围就太大了）
 * Created by Colin on 2017/5/9.
 */
public class MultiKeySorting {

    public static void main(String[] args) {
        LinkedList<Card> cards = new LinkedList<>();
        cards.add(new Card(2, 1));
        cards.add(new Card(4, 2));
        cards.add(new Card(1, 5));
        cards.add(new Card(2, 8));
        cards.add(new Card(3, 1));
        cards.add(new Card(2, 4));
        cards.add(new Card(4, 2));
        cards.add(new Card(1, 3));
        cards.add(new Card(1, 8));
        cards.add(new Card(3, 9));
        cards.add(new Card(2, 7));
        cards.add(new Card(3, 6));
        cards.add(new Card(4, 2));
        cards.add(new Card(2, 10));
        cards.add(new Card(3, 7));
        System.out.println(cards);

        multiKeySortingByLinkedList(cards);
        System.out.println(cards);
    }

    /**
     * 链式基数排序
     * @param cards
     */
    private static void multiKeySortingByLinkedList(LinkedList<Card> cards) {
        //低关键字 分组
        LinkedList[] lowKeys = new LinkedList[10];
        for (int i = 0; i < lowKeys.length; i++) {
            lowKeys[i] = new LinkedList();
        }
        while (cards.size() > 0) {
            Card card = cards.remove();
            int point = card.getPoint();
            lowKeys[point - 1].add(card);
        }

        //收集
        for (int i = 0; i < lowKeys.length; i++) {
            cards.addAll(lowKeys[i]);
        }

        //高关键字 分组
        LinkedList[] highKeys = new LinkedList[4];
        for (int i = 0; i < highKeys.length; i++) {
            highKeys[i] = new LinkedList();
        }
        while (cards.size() > 0) {
            Card card = cards.remove();
            int type = card.getType();
            highKeys[type - 1].add(card);
        }

        //收集
        for (int i = 0; i < highKeys.length; i++) {
            cards.addAll(highKeys[i]);
        }

    }
}
