package com.dragontalker.linkedlist;

public class DoubleLinkedListDemo {

    public static void main(String[] args) {

    }
}

// 创建一个双向链表的类
class DoubleLinkedList {

    // 先初始化一个头节点, 头节点不要动, 不存放具体的数据
    private HeroNode2 head = new HeroNode2(0, null, null);

    // 返回头节点
    public HeroNode2 getHead() {
        return head;
    }

    // 遍历双向链表的方法
    // 显示链表(遍历)
    public void list() {
        // 判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        // 因为头节点不能动, 因为我们需要一个辅助变量来遍历
        HeroNode2 temp = head.next;
        while (temp != null) {
            // 输出节点的信息
            System.out.println(temp);
            // 将next后移, 一定小心
            temp = temp.next;
        }
    }
}

// 定义 HeroNode2 , 每个HeroNode 对象就是一个节点
class HeroNode2 {
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next; // 指向下一个节点, 默认为null
    public HeroNode2 pre; // 指向下一个节点, 默认为null
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