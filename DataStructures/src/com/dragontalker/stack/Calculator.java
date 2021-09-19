package com.dragontalker.stack;

public class Calculator {

    public static void main(String[] args) {

    }
}

// 先创建一个栈, 直接使用前面创建好的
// 定义一个栈结构, 需要扩展功能
class ArrayStack2 {
    private final int maxSize; // 栈的大小
    private int[] stack; // 数组, 模拟栈, 数据就放在该数组中
    private int top; // top表示栈顶, 初始化为-1

    // 构造器
    public ArrayStack2(int maxSize) {
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

    // 返回运算符的优先级, 优先级是程序员来确定, 优先级使用数字表示
    // 数字越大, 则优先级越高
    public int priority(char operator) {
        if(operator == '*' || operator == '/') {
            return 1;
        } else if (operator == '-' || operator == '+') {
            return 0;
        } else {
            return -1; // 假定目前的表达式只有+, -, *, /
        }
    }

    // 判断是不是一个运算符
    public boolean isOperator(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    // 计算方法
    public int cal(int num1, int num2, char operator) {
        int res;
        switch(operator) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1; // 注意顺序
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                res = 0;
                break;
        }
        return res;
    }
}