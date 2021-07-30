package com.dragontalker.queue;

public class CircleArrayQueueDemo {

    public static void main(String[] args) {

    }
}

class CircleArray {
    private int maxSize; // 表示数组的最大容量
    // front 变量的含义做一个调整: front就指向队列的第一个元素, 也就是说 arr[front]
    // front 的初始值为0
    private int front; // 队列头
    private int rear; // 队列尾
    private int[] arr; // 该数组用于存放数据, 模拟队列
}
