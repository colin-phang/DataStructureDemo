package com.colin;

import java.util.ArrayList;
import java.util.List;

public class Tree {

    public static void main(String[] args) {
        // write your code here
        Tree tree = new Tree();
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

        
        System.out.println(tree.getChild("中国"));
        System.out.println(tree.getChild("广东"));
        System.out.println(tree.getParent("九寨沟"));

    }

    public void add(String parent, String child) {
        nodes.add(new Node(parent, child));
    }


    public static class Node {
        private String parent;
        private String child;

        public Node(String parent, String child) {
            this.parent = parent;
            this.child = child;
        }
    }

    private List<Node> nodes = new ArrayList<>();

    public List<String> getChild(String parent) {
        List<String> childs = new ArrayList<>();
        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i).parent.equals(parent)) {
                childs.add(nodes.get(i).child);
            }
        }
        return childs;
    }


    public String getParent(String child) {
        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i).child.equals(child)) {
                return nodes.get(i).parent;
            }
        }
        return null;
    }
}
