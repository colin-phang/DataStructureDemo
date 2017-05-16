package com.colin;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 双栈算法 对表达式求值
 * <p>
 * 一个栈存放操作数
 * 1. 从左往右 压入栈
 * <p>
 * 一个栈存放操作符
 * 1. 操作符有优先级，优先级高的放在栈顶，遇到优先级比自己低的必须pop出栈中操作符进行计算
 * 2. 遇到)要开始运算，直到遇到(为止
 * 3. 操作符栈为空时，计算完成
 * Created by Colin on 2017/5/15.
 */
public class Expression {

    //实现0~9的加减乘法
    public static void main(String[] args) {
        char[] expression = "4*(5-1+1)-2".toCharArray();
        Stack<Integer> data = new Stack<>();
        Stack<Character> op = new Stack<>();
        Map<Character, Integer> priority = new HashMap<>();
        priority.put('(', 0);
        priority.put('+', 1);
        priority.put('-', 1);
        priority.put('*', 2);

        for (int i = 0; i < expression.length; i++) {
            char c = expression[i];
            if (c >= '0' && c <= '9') {
                data.push(c - '0');
            } else if (c == '(') {
                op.push(c);
            } else if (c == ')') {
                while (op.peek() != '(')//一直计算到遇到左括号之前
                    calc(data, op);
                //遇到左括号
                op.pop();
            } else {
                //优先级比栈顶低
                while (op.isEmpty() == false && priority.get(c) <= priority.get(op.peek())) {
                    calc(data, op);
                }

                op.push(c);
            }
        }

        while (op.isEmpty() == false) {
            calc(data, op);
        }
        System.out.println(data.pop());
    }

    private static void calc(Stack<Integer> data, Stack<Character> op) {
        int right = data.pop();
        int left = data.pop();
        char operator = op.pop();

        switch (operator) {
            case '*':
                data.push(left * right);
                break;
            case '+':
                data.push(left + right);
                break;
            case '-':
                data.push(left - right);
                break;
            default:
                break;
        }


    }
}
