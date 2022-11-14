package linkedlist.code.removemidandrationode;

import linkedlist.code.common.nodemodule.Node;

/**
 *              删除链表的中间节点和a/b处的节点(❤)
 *     题目：
 *       给定链表的头节点head，实现删除链表的中间节点的函数
 *       例如：
 *          不删除任何节点；
 *          1->2，删除节点1；
 *          1->2->3，删除节点2；
 *          1->2->3->4，删除节点2；
 *          1->2->3->4->5，删除节点3；
 *       进阶：
 *       给定链表的头节点head、整数a和b，实现删除位于a/b处节点的函数。
 *       例如：
 *          链表：1->2->3->4->5，假设a/b的值为r。
 *          如果r等于0，不删除任何节点；
 *          如果r在区间(0,1/5]上，删除节点1；
 *          如果r在区间(1/5,2/5]上，删除节点2；
 *          如果r在区间(2/5,3/5]上，删除节点3；
 *          如果r在区间(3/5,4/5]上，删除节点4；
 *          如果r在区间(4/5,1]上，删除节点5；
 *          如果r大于1，不删除任何节点。
 *
 *      a/b这里不是指具体位置数值，是整体来看，处于整个链表a/b处的节点。
 */

public class RemoveMidOrRatioNode {

    public Node removeMidNode(Node head){
        if(head ==null||head.next == null){
            return head;
        }
        if(head.next.next==null){
            return head.next;
        }
        Node pre = head;
        Node cur = head.next.next;
        while(cur.next!=null&& cur.next.next!=null){
            pre=pre.next;
            cur=cur.next.next;
        }
        pre.next=pre.next.next;
        return head;
    }

    public Node removeRatioNode(Node head, int a, int b){
        if(a<1|| a>b){
            return head;
        }
        int n=0;
        Node cur = head;
        while(cur!=null){
            n++;
            cur=cur.next;
        }
        n = (int)Math.ceil(((double) (a*n))/(double) b);
        if(n==1){
            head = head.next;
        }
        if(n>1){
            cur = head;
            while(--n!=1){
                cur= cur.next;
            }
            cur.next=cur.next.next;
        }
        return head;
    }
}
