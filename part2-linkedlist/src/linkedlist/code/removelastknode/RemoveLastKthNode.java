package linkedlist.code.removelastknode;

import linkedlist.code.removelastknode.exist.DoubleNode;
import linkedlist.code.removelastknode.exist.Node;

/**
 *             在单链表个双链表中删除倒数第K个节点(❤)
 *    题目：
 *      分别实现两个函数，一个可以删除单链表中倒数第K个节点，
 *      另一个可以删除双链表中倒数第K个节点。
 *
 *    要求：
 *      如果链表长度为N，时间复杂度达到O(N)，额外空间复杂度达到O(1)。
 *
 */

public class RemoveLastKthNode {

    public Node removeSingleLastKthNode(Node head,int lastKth){
        if(head==null || lastKth<1){
            return head;
        }
        Node cur = head;
        while(cur != null){
            lastKth--;
            cur=cur.next;
        }
        if(lastKth==0){
            head=head.next;
        }
        if(lastKth<0){
            cur=head;
            while(++lastKth!=0){
                cur=cur.next;
            }
            cur.next=cur.next.next;
        }
        return head;
    }

    public DoubleNode removeDoubleLastKthNode(DoubleNode head,int lastKth){
        if(head == null || lastKth<1){
            return head;
        }
        DoubleNode cur = head;
        while(cur!=null){
            lastKth--;
            cur=cur.next;
        }
        if(lastKth==0){
            head = head.next;
            head.last=null;
        }
        if(lastKth<0){
            cur=head;
            while(++lastKth!=0){
                cur=cur.next;
            }
            DoubleNode newNext = cur.next.next;
            cur.next=newNext;
            if(newNext!=null){
                newNext.last=cur;
            }
        }
        return head;
    }

}
