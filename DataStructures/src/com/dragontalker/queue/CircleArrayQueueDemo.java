package com.dragontalker.queue;

public class CircleArrayQueueDemo {

    public static void main(String[] args) {

    }
}

class CircleArray {
    private int maxSize; // 表示数组的最大容量
    // front 变量的含义做一个调整: front 就指向队列的第一个元素, 也就是说 arr[front]
    // front 的初始值 = 0
    private int front; // 队列头
    // rear 变量的含义做一个调整: rear 指向队列的最后一个元素的后一个位置, 因为希望空出一个位置
    // rear 的初始值 = 0
    private int rear; // 队列尾
    private int[] arr; // 该数组用于存放数据, 模拟队列

    public CircleArray(int arrMaxSize) {
        this.maxSize = arrMaxSize;
        this.arr = new int[maxSize];
    }

    // 判断队列是否满
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }
}
