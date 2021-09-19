package com.dragontalker.linkedlist;

public class Josephu {

    public static void main(String[] args) {
        // 测试一把看看构建环形链表, 和遍历是否ok
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);
        circleSingleLinkedList.showBoy();
    }
}

// 创建一个环形的单向列表
class CircleSingleLinkedList {
    // 创建一个first节点, 当前没有编号
    private Boy first = new Boy(-1);
    // 添加小孩节点, 构建成一个环形的链表
    public void addBoy(int nums) {
        // nums 做一个数据校验
        if(nums < 1) {
            System.out.println("nums的值不正确");
            return;
        }
        Boy curBoy = null; // 辅助指针, 帮助构建环形链表
        // 使用for循环来创建我们的环形链表
        for(int i = 1; i <= nums; i++) {
            // 根据编号创建小孩节点
            Boy boy = new Boy(i);
            // 如果是第一个小孩
            if (i == 1) {
                first = boy;
                first.setNext(first); // 构成环
                curBoy = first;
            } else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }

    // 遍历当前的环形链表
    public void showBoy() {
        // 判断是否为空
        if(first == null) {
            System.out.println("没有任何小孩~");
            return;
        }
        // 因为first不能动, 因为我们仍然使用一个辅助指针完成遍历
        Boy curBoy = first;
        while(true) {
            System.out.printf("小孩的编号 %d \n", curBoy.getNo());
            if(curBoy.getNext() == first) {
                break;
            }
            curBoy = curBoy.getNext();
        }
    }
}

// 创建一个Boy类, 表示一个节点
class Boy {
    private int no; // 编号
    private Boy next; // 指向下一个节点, 默认是null

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "no=" + no +
                '}';
    }
}
