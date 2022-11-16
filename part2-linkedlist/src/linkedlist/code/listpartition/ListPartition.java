package linkedlist.code.listpartition;

import linkedlist.code.common.nodemodule.Node;

/**
 *              将单向链表按某值划分成左边小、中间相等、右边大的形式（❤❤）
 *  题目：
 *      给定一个单向链表的头节点head，节点的值类型是整数，再给定一个整数pivot。实现一个调整
 *      链表的函数，将链表调整为左部分都是值小于pivot的节点，中间部分都是值等于pivot的节点，
 *      右部分都是值大于pivot的节点。没有顺序要求
 *
 *  进阶：
 *      在左、中、右三个部分的内部也做顺序要求，要求每部分里的节点从左到右的顺序与原链表中节点的先后次序一致
 */

public class ListPartition {

    public Node listPartition1(Node head,int pivot){
        if(head == null){
            return head;
        }
        Node cur = head;
        int i=0;
        while(cur!=null){
            i++;
            cur=cur.next;
        }
        Node[] nodeArr = new Node[i];
        i = 0;
        cur=head;
        for (i = 0; i !=nodeArr.length; i++) {
            nodeArr[i] = cur;
            cur=cur.next;
        }
        arrPartition(nodeArr,pivot);
        for(i=1;i!=nodeArr.length;i++){
            nodeArr[i-1].next=nodeArr[i];
        }
        nodeArr[i-1].next = null;
        return nodeArr[0];
    }

    public void arrPartition(Node[] nodeArr,int pivot){
        int small = -1;
        int big = nodeArr.length;
        int index=0;
        while(index!=big){
            if(nodeArr[index].value<pivot){
                swap(nodeArr,++small,index++);
            }else if(nodeArr[index].value==pivot){
                index++;
            }else{
                swap(nodeArr,--big,index);
            }
        }
    }

    public void swap(Node[] nodeArr,int a,int b){
        Node tmp = nodeArr[a];
        nodeArr[a]=nodeArr[b];
        nodeArr[b]=tmp;
    }


    public Node listPartition2(Node head,int pivot){
        Node sH = null;
        Node sT = null;
        Node eH = null;
        Node eT = null;
        Node bH = null;
        Node bT = null;
        Node next = null;
        while(head!=null){
            next = head.next;
            head.next = null;
            if(head.value < pivot){
                if(sH == null){
                    sH = head;
                    sT = head;
                }else{
                    sT.next = head;
                    sT = head;
                }
            }else if(head.value == pivot){
                if(eH == null){
                    eH = head;
                    eT = head;
                }else{
                    eT.next = head;
                    eT = head;
                }
            }else{
                if(bH == null){
                    bH = head;
                    bT = head;
                }else{
                    bT.next = head;
                    bT = head;
                }
            }
            head = head.next;
        }
        if(sT!=null){
            sT.next = eH;
            eT = eT==null?sT:eT;
        }
        if(eT!=null){
            eT.next = bH;
        }
        return sH!=null?sH : eH!=null?eH:bH;
    }


}
