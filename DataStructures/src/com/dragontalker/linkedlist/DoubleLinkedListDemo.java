package com.dragontalker.linkedlist;

public class DoubleLinkedListDemo {

    public static void main(String[] args) {

    }
}

// 创建一个双向链表的类
class DoubleLinkedList {

}

// 定义 HeroNode2 , 每个HeroNode 对象就是一个节点
class HeroNode2 {
    public int no;
    public String name;
    public String nickname;
    public HeroNode next; // 指向下一个节点, 默认为null
    public HeroNode pre; // 指向下一个节点, 默认为null

    // 构造器
    public HeroNode2(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    // 为了显示方便, 我们重写toString

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}