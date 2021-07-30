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

        // 直接将数据加入
        arr[rear] = n;

        // 将 rear 后移, 这里必须考虑取模
        rear = (rear + 1) % maxSize;
    }

    // 获取队列的数据, 出队列
    public int getQueue() {
        // 判断队列是否空
        if (isEmpty()) {
            // 通过抛出异常来处理
            throw new RuntimeException("队列空, 不能取数据~");
        }

        // 这里需要分析出front是指向队列的第一个元素
        // 1. 先把front对应的值保存到一个临时变量
        // 2. 将 front 后移, 考虑取模
        // 3. 将临时保存的变量返回
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    // 显示队列的所有数据
    public void showQueue() {
        // 遍历
        if (isEmpty()) {
            System.out.println("队列空的, 没有数据~");
            return;
        }

        // 思路: 从front开始遍历, 遍历多少个元素
        // 动脑筋
        for (int i = front; i < front + 2; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }
}
