package com.dragontalker.queue;

public class ArrayQueueDemo {

    public static void main(String[] args) {

    }
}

// 使用数组模拟队列 - 编写一个ArrayQueue类
class ArrayQueue {
    private int maxSize; // 表示数组的最大容量
    private int front; // 队列头
    private int rear; // 队列尾
    private int[] arr; // 该数组用于存放数据, 模拟队列

    // 创建队列的构造器
    public ArrayQueue(int arrMaxSize) {
        this.maxSize = arrMaxSize;
        this.arr = new int[maxSize];

        // 指向队列头部, 分析出front是指向队列头的前一个位置
        this.front = -1;

        // 指向队列尾, 指向队列尾的数据(即就是队列最后一个数据)
        this.rear = -1;
    }

    // 判断队列是否满
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    // 判断是否队列为空
    public boolean isEmpty() {
        return rear == front;
    }

    // 添加数据到队列
    public void addQueue(int n) {
        // 判断队列是否满
        if (isFull()) {
            System.out.println("队列满, 不能加入数据~");
            return;
        }

        // 让rear后移
        rear ++;
        arr[rear] = n;
    }

    // 获取队列的数据, 出队列
    public int getQueue() {
        // 判断队列是否空
        if (isEmpty()) {
            // 通过抛出异常来处理
            throw new RuntimeException("队列空, 不能取数据~");
        }

        // front后移
        front++;
        return arr[front];
    }

}
