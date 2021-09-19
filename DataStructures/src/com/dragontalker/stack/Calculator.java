package com.dragontalker.stack;

public class Calculator {

    public static void main(String[] args) {
        // 根据前面老师的思路, 完成表达式的运算
        String expression = "3+2*6-2";
        // 创建两个栈, 数栈, 符号栈
        ArrayStack2 numberStack = new ArrayStack2(10);
        ArrayStack2 operatorStack = new ArrayStack2(10);
        // 定义需要的相关变量
        int index = 0; // 用于扫描
        int num1;
        int num2;
        int operator;
        int res;
        char ch; // 将每次扫描得到的char保存到ch中
        // 开始while循环扫描expression
        do {
            // 依次得到expression的每一个字符
            ch = expression.substring(index, index + 1).charAt(0);
            // 判断ch是什么, 然后做相应的处理
            if (operatorStack.isOperator(ch)) { // 如果是运算符
                // 判断当前的符号栈是否为空
                if (operatorStack.isEmpty()) {
                    operatorStack.push(ch);
                } else {
                    if (operatorStack.priority(ch) <= operatorStack.priority(operatorStack.peek())) {
                        num1 = numberStack.pop();
                        num2 = numberStack.pop();
                        operator = operatorStack.pop();
                        res = numberStack.cal(num1, num2, operator);
                        // 把运算的结果入数栈
                        numberStack.push(res);
                        // 然后将当前的操作符入符号栈
                        operatorStack.push(ch);
                    } else {
                        // 如果当前的操作符的优先级大于栈中的操作符, 就直接入符号栈
                        operatorStack.push(ch);
                    }
                }
            } else { // 如果是数, 则直接入数栈
                numberStack.push(ch - 48);
            }
            // 让index+1, 并判断是否扫描到expression最后
            index++;
        } while (index < expression.length());
        while (!operatorStack.isEmpty()) {
            // 如果符号栈为空, 则计算到最后的结果, 数栈中只有一个数字[结果]
            num1 = numberStack.pop();
            num2 = numberStack.pop();
            operator = operatorStack.pop();
            res = numberStack.cal(num1, num2, operator);
            numberStack.push(res);
        }
        // 将数栈的最后数pop出, 就是最后的结果
        int result = numberStack.pop();
        System.out.printf("表达式 %s = %d", expression, result);
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

    // 增加一个方法, 可以返回当前栈顶的值, 但不是真正的pop
    public int peek() {
        return stack[top];
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
    public int priority(int operator) {
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
    public int cal(int num1, int num2, int operator) {
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