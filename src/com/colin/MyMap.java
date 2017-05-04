package com.colin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用Map实现树形结构
 * Created by Colin on 2017/5/4.
 */
public class MyMap {
    //KeySet、EntrySet两种方式遍历Map
    public static void main(String[] args) {
        MyTree tree = new MyTree();
        tree.add("中国", "广东");
        tree.add("中国", "北京");
        tree.add("中国", "湖北");
        tree.add("中国", "四川");
        tree.add("四川", "成都");
        tree.add("四川", "九寨沟");
        tree.add("湖北", "武汉");
        tree.add("广东", "广州");
        tree.add("广州", "天河区");
        tree.add("广州", "海珠区");
        tree.add("广州", "番禺区");
        tree.add("广东", "深圳");

        System.out.println(tree.getParent("深圳"));
        System.out.println(tree.getChilds("中国"));
    }

    public static class MyTree {
        Map<String, String> mapUp = new HashMap<>();
        Map<String, List<String>> mapDown = new HashMap<>();

        public void add(String parent, String child) {
            mapUp.put(child, parent);
            List childs = mapDown.get(parent);
            if (childs == null) {
                childs = new ArrayList();
                mapDown.put(parent, childs);
            }
            childs.add(child);
        }

        public String getParent(String child) {
            return mapUp.get(child);
        }

        public List<String> getChilds(String parent) {
            return mapDown.get(parent);
        }
    }

}
