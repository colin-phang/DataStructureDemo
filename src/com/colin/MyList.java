package com.colin;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Colin on 2017/5/3.
 */
public class MyList {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("cat");
        list.add("monkey");
        list.add("dog");
        list.add("dog");
        list.add("dog");
        list.add("elephant");
        list.add("sheep");

        System.out.println(list);

        for (int i = 0; i < list.size(); i++) {
            int j = list.lastIndexOf(list.get(i));
            if (i != j) {
                list.remove(j);
                i--;
            }
        }

        System.out.println(list);
    }
}
