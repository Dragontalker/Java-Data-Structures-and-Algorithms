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

    // 添加一个节点到双向链表的最后
    public void add(HeroNode2 heroNode) {

        // 因为head节点不能动, 因此我们需要一个辅助变量 temp
        HeroNode2 temp = head;
        // 遍历链表, 找到最后
        while (true) {
            // 找到链表的最后
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        // 当退出while循环的时候, temp就指向了链表的最后
        // 将最后一个节点的next 指向 新的节点
        // 形成一个双向链表
        temp.next = heroNode;
        heroNode.pre = temp;
    }

    // 修改一个节点的内容, 可以看到双向链表的节点内容修改和单向链表一样
    // 只是节点的类型改成了 HeroNode2
    public void update(HeroNode2 newHeroNode) {
        // 判断是否为空
        if(head.next == null) {
            System.out.println("链表为空~");
            return;
        }
        // 找到需要修改的节点, 根据no编号
        // 定义一个辅助变量
        HeroNode2 temp = head.next;
        boolean flag = false; // 表示是否找到该节点
        while(true) {
            if(temp == null) {
                break; // 已经遍历完链表
            }
            if(temp.no == newHeroNode.no) {
                // 找到
                flag = true;
                break;
            }
            temp = temp.next;
        }
        // 根据flag判断是否找到要修改的节点
        if(flag) {
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        } else { // 没有找到
            System.out.printf("没有找到编号 %d 的节点, 不能修改\n", newHeroNode.no);
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