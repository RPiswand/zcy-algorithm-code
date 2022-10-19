package linkedlist.code.reversesingleanddoublelist;

import linkedlist.code.reversesingleanddoublelist.exist.DoubleNode;
import linkedlist.code.reversesingleanddoublelist.exist.Node;

/**
 *                  反转单向和双向链表(❤)
 *     题目：
 *       分别实现反转单向链表和反转双向链表的函数。
 */


public class ReverseSingleAndDoubleList {

    public Node reverseSingleList(Node head){
        Node pre = null;
        Node next = null;
        while(head!=null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public DoubleNode reverseDoubleList(DoubleNode head){
        DoubleNode pre = null;
        DoubleNode next = null;
        while(head!=null){
            next = head.next;
            head.next=pre;
            head.last=next;
            pre=head;
            head=next;
        }
        return pre;
    }

}
