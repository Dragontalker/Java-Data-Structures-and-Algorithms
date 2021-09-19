package com.dragontalker.linkedlist;

public class DoubleLinkedListDemo {

    public static void main(String[] args) {
        // 测试
        System.out.println("双向链表的测试");
        // 先创建节点
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");
        // 创建一个双向链表
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero4);

        doubleLinkedList.list();

        // 修改的测试
        HeroNode2 newHeroNode = new HeroNode2(4, "公孙胜", "入云龙");
        doubleLinkedList.update(newHeroNode);

        System.out.println("修改后的链表情况~~");
        doubleLinkedList.list();

        // 删除的测试
        doubleLinkedList.del(3);

        System.out.println("删除后的链表情况~~");
        doubleLinkedList.list();
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

    // 从双向链表中删除一个节点
    public void del(int no) {

        // 判断当前链表是否为空
        if(head.next == null) { // 空链表
            System.out.println("链表为空, 无法删除");
            return;
        }

        HeroNode2 temp = head.next;
        boolean flag = false; // 标志是否找到待删除的节点
        while(true) {
            if(temp == null) { // 已经到链表的最后
                break;
            }
            if(temp.no == no) {
                flag = true;
                break;
            }
            temp = temp.next; // temp后移, 遍历
        }
        // 判断flag
        if(flag) { // 找到
            // 可以删除
            temp.pre.next = temp.next;
            if(temp.next != null) {
                temp.next.pre = temp.pre;
            }
        } else {
            System.out.printf("要删除的 %d 节点不存在\n", no);
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
        return "HeroNode2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}