package com.dragontalker.stack;

import java.lang.reflect.Array;

public class ArrayStackDemo {

    public static void main(String[] args) {

    }
}

// 定义一个栈结构
class ArrayStack {
    private int maxSize; // 栈的大小
    private int[] stack; // 数组, 模拟栈, 数据就放在该数组中
    private int top; // top表示栈顶, 初始化为-1

    // 构造器
    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new int[this.maxSize];
        this.top = -1;
    }

    // 栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    // 栈空
    public boolean isEmpty() {
        return top == -1;
    }

    // 入栈
    public void push(int value) {
        // 先判断栈是否满
        if(isFull()) {
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = value;
    }

    // 出栈, 将栈顶的数据返回
    public int pop() {
        // 先判断是否空
        if(isEmpty()) {
            // 抛出异常
            throw new RuntimeException("栈空, 没有数据");
        }
        int value = stack[top];
        top--;
        return value;
    }

    // 显示栈的情况[遍历栈], 遍历时, 需要从栈顶开始显示数据
    public void list() {
        if(isEmpty()) {
            System.out.println("栈空, 没有数据");
            return;
        }
        for(int i = top; i > -1; i--) {
            System.out.printf("stack[%d]=%d\n", i, stack[i]);
        }
    }
}
