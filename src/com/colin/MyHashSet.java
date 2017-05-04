package com.colin;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Colin on 2017/5/3.
 */
public class MyHashSet {
    //无序、不重复
//    HashSet、TreeSet
    public static void main(String[] args) {
        String[] a = {"li", "lin", "guan", "wu", "jim"};
        String[] b = {"li,数学,99", "lin,物理,89", "jim,英文,96", "jim,语文,77", "jim,化学,77"};


        Set<String> setA = new HashSet<>();
        for (int i = 0; i < a.length; i++) {
            setA.add(a[i]);
        }
        Set<String> setB = new HashSet<>();
        for (int i = 0; i < b.length; i++) {
            setB.add(b[i].split(",")[0]);
        }

        //求差集
        setA.removeAll(setB);

        Iterator<String> iterator = setA.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
}
