package com.dragontalker.linkedlist;

public class SingleLinkedListDemo {

    public static void main(String[] args) {
        // 进行测试
        // 先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        // 创建初始链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        //singleLinkedList.add(hero1);
        //singleLinkedList.add(hero2);
        //singleLinkedList.add(hero3);
        //singleLinkedList.add(hero4);

        //加入按标号的顺序
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.addByOrder(hero3);

        // 显示一把
        singleLinkedList.list();

        // 测试修改节点的代码
        HeroNode newHeroNode = new HeroNode(2, "小卢", "玉麒麟~~");
        singleLinkedList.update(newHeroNode);

        // 修改后的链表情况
        System.out.println("修改后的链表情况~~");
        singleLinkedList.list();

        // 删除一个节点
        singleLinkedList.del(1);
        singleLinkedList.del(4);
        System.out.println("删除后的链表情况~~");
        singleLinkedList.list();

        // 测试一下 求单链表中的有效节点的个数
        System.out.println("有效的节点个数 = " + getLength(singleLinkedList.getHead()));

        // 测试一下 看看是否得到了倒数第K个节点
        HeroNode res = findLastIndexNode(singleLinkedList.getHead(), 3);
        System.out.println("res = " + res);
    }

    // 查找单链表中的倒数第k个节点 [新浪面试题]
    // 思路
    // 1. 编写一个方法, 接收head节点, 同时接收一个index
    // 2. index 表示是倒数第index个节点
    // 3. 先把链表从头到尾遍历, 得到链表的总的长度 getLength
    // 4. 得到size后, 我们从链表的第一个开始遍历(size-index)个, 就可以得到
    // 5. 如果找到了, 则返回该节点, 否则返回null
    public static HeroNode findLastIndexNode(HeroNode head, int index) {
        // 判断如果链表为空, 返回null
        if(head.next == null) {
            return null; // 没有找到
        }
        // 第一个遍历得到链表的长度(节点个数)
        int size = getLength(head);
        // 第二次遍历 size-index 位置, 就是我们倒数的第K个节点
        // 先做一个index的校验
        if(index <= 0 || index > size) {
            return null;
        }
        // 定义一个辅助变量, for 循环定位到倒数的index
        HeroNode cur = head.next;
        for(int i = 0; i < size - index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    // 方法: 获取到单链表的节点的个数(如果是带头节点的链表, 需要不统计头节点)
    /**
     *
     * @param head 链表的头节点
     * @return 返回的就是有效节点的个数
     */
    public static int getLength(HeroNode head) {
        if(head.next == null) { // 空链表
            return 0;
        }
        int length = 0;
        // 定义一个辅助的变量, 这里我们没有统计头节点
        HeroNode cur = head.next;
        while(cur != null) {
            length++;
            cur = cur.next; // 遍历
        }
        return length;
    }
}

// 定义SingleLinkedList
class SingleLinkedList {
    // 先初始化一个头节点, 头节点不要动, 不存放具体的数据
    private HeroNode head = new HeroNode(0, null, null);

    // 返回头节点
    public HeroNode getHead() {
        return head;
    }

    // 添加节点到单向链表
    // 思路: 当不考虑变好顺序时
    // 1. 找到当前链表的最后节点
    // 2. 将最后这个节点的next 指向 新的节点
    public void add(HeroNode heroNode) {

        // 因为head节点不能动, 因此我们需要一个辅助变量 temp
        HeroNode temp = head;
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
        temp.next = heroNode;
    }

    // 第二种方式在添加英雄时, 根据排名将英雄插入到指定位置
    // (如果有这个排名, 则添加失败, 并给出提示)
    public void addByOrder(HeroNode heroNode) {
        // 因为头节点不能动, 因为我们仍然通过一个辅助指针(变量)来帮助找到添加的位置
        // 因为单链表, 也因为我们找的temp是位于添加位置的前一个节点, 否则插入不了
        HeroNode temp = head;
        boolean flag = false; // flag标志添加的编号是否存在, 默认为false
        while(true) {
            if(temp.next == null) { // 说明temp已经在链表的最后
                break;
            }
            if(temp.next.no > heroNode.no) { // 位置找到, 就在temp的后面插入
                break;
            } else if (temp.next.no == heroNode.no) { // 说明希望添加的heroNode的编号已然存在
                flag = true; // 说明编号存在
                break;
            }
            temp = temp.next; // 后移, 遍历当前链表
        }
        // 判断flag的值
        if(flag) { // 不能添加, 说明编号存在
            System.out.printf("准备插入的英雄编号 %d 已经存在了, 不能加入\n", heroNode.no);
        } else {
            // 插入到链表中, temp的后面
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    // 修改节点的信息, 根据no编号来修改, 即no编号不能改
    // 说明
    // 1. 根据 newHeroNode 的 no 来修改即可
    public void update(HeroNode newHeroNode) {
        // 判断是否为空
        if(head.next == null) {
            System.out.println("链表为空~");
            return;
        }
        // 找到需要修改的节点, 根据no编号
        // 定义一个辅助变量
        HeroNode temp = head.next;
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

    // 删除节点
    // 思路
    // 1. head 不能动, 因为我们需要一个temp辅助节点找到待删除节点的前一个节点
    // 2. 说明我们在比较时, 是temp.next.no 和 服下药删除的节点的 no 比较
    public void del(int no) {
        HeroNode temp = head;
        boolean flag = false; // 标志是否找到待删除的节点
        while(true) {
            if(temp.next == null) { // 已经到链表的最后
                break;
            }
            if(temp.next.no == no) {
                flag = true;
                break;
            }
            temp = temp.next; // temp后移, 遍历
        }
        // 判断flag
        if(flag) { // 找到
            // 可以删除
            temp.next = temp.next.next;
        } else {
            System.out.printf("要删除的 %d 节点不存在\n", no);
        }
    }

    // 显示链表(遍历)
    public void list() {
        // 判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        // 因为头节点不能动, 因为我们需要一个辅助变量来遍历
        HeroNode temp = head.next;
        while (temp != null) {
            // 输出节点的信息
            System.out.println(temp);
            // 将next后移, 一定小心
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
                '}';
    }
}
