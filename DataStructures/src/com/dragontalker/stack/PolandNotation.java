package com.dragontalker.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {

    public static void main(String[] args) {
        // 先定义一个逆波兰表达式
        // (30+4)x5-6 => 30 4 + 5 x 6 - = 164
        // 4*5-8+60+8/2 => 4 5 x 8 - 60 + 8 2 / + = 76
        // 为了说明方便, 逆波兰表达式的数字和符号使用空格隔开
        String suffixExpression = "30 4 + 5 x 6 -";
        System.out.println("逆波兰表达式=" + suffixExpression);
        // 思路
        // 1. 先将 "3 4 + 5 x 6 -" => 放到ArrayList中
        // 2. 将 ArrayList 传递给一个方法, 遍历 ArrayList 配合栈 完成计算

        List<String> list = getListString(suffixExpression);
        System.out.println("rpnList=" + list);

        int res = calculate(list);
        System.out.println("计算的结果是=" + res);

    }

    // 将一个逆波兰表达式, 依次将数据和运算符 放入到 ArrayList中
    public static List<String> getListString(String suffixExpression) {
        // 将 suffixExpression 分割
        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<>();
        for(String ele : split) {
            list.add(ele);
        }
        return list;
    }

    // 完成对逆波兰表达式的运算
    public static int calculate(List<String> ls) {
        // 创建一个栈, 只需要一个栈即可
        Stack<String> stack = new Stack<String>();
        // 遍历ls
        for(String item : ls) {
            // 这里使用正则表达式来取出数
            if(item.matches("\\d+")) { // 匹配的是多位数
                // 入栈
                stack.push(item);
            } else {
                // pop出两个数, 并运算, 再入栈
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                switch (item) {
                    case "+":
                        res = num1 + num2;
                        break;
                    case "-":
                        res = num1 - num2;
                        break;
                    case "x":
                        res = num1 * num2;
                        break;
                    case "/":
                        res = num1 / num2;
                        break;
                    default:
                        break;
                }
                // 把res入栈
                stack.push(res + "");
            }
        }
        // 最后留在stack中的数据是运算结果
        return Integer.parseInt(stack.pop());
    }
}
