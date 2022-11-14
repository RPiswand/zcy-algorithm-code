package linkedlist.code.reversepart;

import linkedlist.code.common.nodemodule.Node;


/**
 *              反转部分单向链表(❤)
 *   题目：
 *      给定一个单向链表的头节点head，以及两个整数from和to，在单向链表上
 *      把第from个节点到第to个节点这一部分进行反转
 *  要求：
 *      1.如果链表长度为N，时间复杂度要求为O(N)，额外空间复杂度要求为O(1)
 *      2.如果不满足1<=from<=to<=N，则不用调整。
 *
 *   例如：
 *      1->2->3->4->5->null   from=2 ,to=4
 *      1->4->3->2->5->null
 */


public class ReversePart {

    public static Node reversePart(Node head,int from,int to){
        //用来计算单向链表长度
        int len = 0;
        //表示from节点的前一个节点
        Node fPre = null;
        //表示to节点的后一个节点
        Node tPos = null;
        Node node1 = head;
        while(node1!=null){
            len++;
            //定位fPre和tPos节点位置
            fPre = len==from-1?node1:fPre;
            tPos = len==to+1?node1:tPos;
            node1 = node1.next;
        }

        if(from>to || from < 1 || to >len){
            return head;
        }
        /**
         *     (*)标注：
         *     类似于直接单向链表排序代码中的参数，且已经走了第一次循环
         *
         *      [1] -> [2] -> [3] -> [4] -> [5] -> null
         *      .......................................
         *      [1] -> [2] -> [3] -> [4] -> [5] -> null
         *      fPre                        tPos
         *      .......................................
         *      { node1 = fPre == null? head:fPre.next;
         *        Node node2 = node1.next;
         *        node1.next = tPos;}
         *               ---------------------
         *              |                    ↓
         *      [1] -> [2] -> [3] -> [4] -> [5] -> null
         *      fPre   n1     n2            tPos
         *
         *      .......................................
         *  单向链表：
         *
         *      .......................................
         *
         *      pre=null;
         *      next=null;
         *      [1] -> [2] -> [3] -> [4] -> [5] -> null
         *      head
         *      .......................................
         *
         *      pre=null;
         *        ↑
         *      [1] (->) [2] -> [3] -> [4] -> [5] -> null
         *      head     next
         *
         *      .......................................
         *
         *      null;
         *        ↑
         *      [1]      [2] -> [3] -> [4] -> [5] -> null
         *      pre      next
         *               head
         *     类比：
         *
         *                ---------------------
         *               |                    ↓
         *       [1] -> [2] -> [3] -> [4] -> [5] -> null
         *       fPre   n1     n2            tPos
         *
         *  此时，就和题目代码循环前一致，node1相当于pre，node2相当于head，
         *  next无所谓，进入后会被赋值为node2.next
         *
         *
         *
         */
        //node1按条件重新指向head或者fPre的下一个节点(反转的第一个节点)--pre(*)
        node1 = fPre == null? head:fPre.next;
        //node2 赋值为 node1.next ，即 反转的第一个节点的下一个节点--head(*)
        Node node2 = node1.next;
        //反转后，反转的第一个节点排到反转部分的最后，所以node1.next指向to的后一个节点，即tPos
        node1.next = tPos;
        Node next = null;
        while(node2!=tPos){
            next = node2.next;
            node2.next = node1;
            node1 = node2;
            node2 = next;
        }

        if(fPre!=null){
            fPre.next = node1;
            return head;
        }

        return node1;

    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = null;

        Node res = reversePart(n1, 2, 4);
        while(res!=null){
            System.out.println(res.value);
            res=res.next;
        }
    }
}
