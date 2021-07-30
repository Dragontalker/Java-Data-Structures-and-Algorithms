package com.dragontalker.linkedlist;

public class SingleLinkedListDemo {

    public static void main(String[] args) {

    }
}

// 定义SingleLinkedList
class SingleLinkedList {
    // 先初始化一个头节点, 头节点不要动, 不存放具体的数据
    private HeroNode head = new HeroNode(0, null, null);

    // 添加节点到单向链表
    // 思路: 当不考虑变好顺序时
    // 1. 找到当前链表的最后节点
    // 2. 将最后这个节点的next 指向 新的节点
    public void add(HeroNode heroNode) {

        // 因为head节点不能动, 因此我们需要一个辅助变量 temp
        HeroNode temp = head;
        // 遍历链表, 找到最后
        while(true) {
            // 找到链表的最后
            if (temp.next == null) {
                temp.next = heroNode;
                break;
            }
            temp = temp.next;
        }
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

    // 为了显示方便, 我们重写toString

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", next=" + next +
                '}';
    }
}
