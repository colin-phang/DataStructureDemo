package com.colin;

import com.colin.model.Person;

import java.util.HashSet;
import java.util.Set;

/**
 * Hash，意译散列，音译哈希
 * 十分快速地通过关键字定位数据的位置
 * 可能占用更多空间，一般1.5倍以上
 * 典型的以空间换时间
 * Created by Colin on 2017/5/3.
 */
public class MyHash {
    //判断重复，判断hashCode，再根据equals()的实现
    public static void main(String[] args) {
        Set<Person> set = new HashSet();
        set.add(new Person("john", 10));
        set.add(new Person("john", 10));
        set.add(new Person("john", 10));
        set.add(new Person("john", 11));
        set.add(new Person("lucy", 10));
        set.add(new Person("anna", 10));
        System.out.println(set);
    }

}
