package com.dragontalker.linkedlist;

public class SingleLinkedList {

    public static void main(String[] args) {

    }
}

// 定义HeroNode, 每个HeroNode 对象就是一个节点
class HeroNode {
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;

    // 构造器
    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }
}
