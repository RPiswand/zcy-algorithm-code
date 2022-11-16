package linkedlist.code.copylistwithrand;

import java.util.HashMap;

/**
 *                  复制含有随机指针节点的链表(❤❤)
 *  题目：
 *      Node类中的value是节点值，next指针和正常单链表中next指针的意义一样，都指向
 *      下一个节点，rand指针是Node类中新增的指针，这个指针可能指向链表中的任意一个
 *      节点，也可能指向null
 *
 *      给定一个由Node节点类型组成的无环单链表的头节点head，请实现一个函数完成这个
 *      链表中所有结构的复制，并返回复制的新链表的头节点。
 *
 *  进阶：
 *      不使用额外的数据结构，只用有限几个变量，且在时间复杂度为O(N)内完成原问题要
 *      实现的函数。
 *
 */

public class CopyListWithRand {

    public Node copyListWithRand1(Node head){
        HashMap<Node,Node> map = new HashMap<>();
        Node cur = head;
        while(cur!=null){
            map.put(cur,new Node(cur.value));
            cur = cur.next;
        }
        cur = head;
        while(cur!=null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).rand = map.get(cur.rand);
            cur = cur.next;
        }
        return map.get(head);
    }

    public Node copyListWithRand2(Node head){
        if(head == null){
            return head;
        }
        Node cur = null;
        Node next = null;
        while(cur!=null){
            next = cur.next;
            cur.next = new Node(cur.value);
            cur.next.next = next;
            cur = next;
        }
        cur=head;
        Node curCopy = null;
        while(cur!=null){
            next = cur.next.next;
            curCopy = cur.next;
            cur.rand = cur.rand!=null?cur.rand.next:null;
            cur=next;
        }
        Node res = head.next;
        cur = head;
        while(cur!=null){
            next = cur.next.next;
            curCopy = cur.next;
            cur.next = next;
            curCopy.next = next!=null?next.next:null;
            cur = next;
        }
        return res;
    }

}
