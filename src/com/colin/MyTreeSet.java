package com.colin;

import com.colin.model.Person;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * 排序树形结构
 * 元素可以比较大小
 * 会按照某种排序规则的顺序输出
 * Created by Colin on 2017/5/4.
 */
public class MyTreeSet {

    public static void main(String[] args) {
        Set<Person> treeSet = new TreeSet<>(new PersonComparator());
        treeSet.add(new Person("lucy", 15));
        treeSet.add(new Person("lee", 11));
        treeSet.add(new Person("alisa", 18));
        treeSet.add(new Person("john", 11));
        treeSet.add(new Person("john", 11));
        treeSet.add(new Person("john", 18));
        treeSet.add(new Person("john", 15));
        System.out.println(treeSet);
    }

    public static class PersonComparator implements Comparator<Person> {
        @Override
        public int compare(Person o1, Person o2) {
            int nameCompare = o1.getName().compareTo(o2.getName());
            if (nameCompare != 0)
                return nameCompare;
            return o2.getAge() - o1.getAge();//age降序
        }
    }
}
