package com.dragontalker.linkedlist;

public class Josephu {

    public static void main(String[] args) {

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
