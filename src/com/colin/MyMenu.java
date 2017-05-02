package com.colin;

import java.util.List;
import java.util.Scanner;

/**
 * Created by Colin on 2017/5/3.
 */
public class MyMenu {

    public static void main(String[] args) {
        MyMenu myMenu = new MyMenu();
        myMenu.add("水果", "苹果");
        myMenu.add("水果", "香蕉");
        myMenu.add("水果", "梨");
        myMenu.add("苹果", "红富士");
        myMenu.add("苹果", "中国红");
        myMenu.add("苹果", "糖心苹果");
        myMenu.add("糖心苹果", "新疆产");
        myMenu.add("糖心苹果", "湖北产");

        String result = myMenu.select("水果");
        System.out.println("你选择了" + result);
    }

    private Tree tree = new Tree();


    private String select(String fruit) {
        Scanner scanner = new Scanner(System.in);
        for (; ; ) {
            List<String> list = tree.getChild(fruit);
            if (list.isEmpty()) {
                break;
            }
            for (int i = 0; i < list.size(); i++) {
                System.out.println(i + ". " + list.get(i));
            }
            System.out.println("输入u返回上一级");
            System.out.println("请选择：");

            String input = scanner.nextLine();
            if ("u".equals(input)) {
                String parent = tree.getParent(fruit);
                if (parent != null) {
                    fruit = parent;
                }
                continue;
            }
            try {
                String nextCursor = list.get(Integer.parseInt(input));
                fruit = nextCursor;
            } catch (Exception e) {
                System.out.println("请重新选择！");
                continue;
            }

        }

        return fruit;
    }

    private void add(String parent, String child) {
        tree.add(parent, child);
    }

}
