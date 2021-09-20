package com.dragontalker.stack;

import java.util.ArrayList;
import java.util.List;

public class PolandNotation {

    public static void main(String[] args) {
        // 先定义一个逆波兰表达式
        // (3+4)x5-6 => 3 4 + 5 x 6 -
        // 为了说明方便, 逆波兰表达式的数字和符号使用空格隔开
        String suffixExpression = "3 4 + 5 x 6 -";
        // 思路
        // 1. 先将 "3 4 + 5 x 6 -" => 放到ArrayList中
        // 2. 将 ArrayList 传递给一个方法, 遍历 ArrayList 配合栈 完成计算

        List<String> rpnList = getListString(suffixExpression);
        System.out.println("rpnList=" + rpnList);
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
}
