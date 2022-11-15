package linkedlist.code.josephusproblem;

import linkedlist.code.common.nodemodule.Node;

/**
 *              环形单链表的约瑟夫问题(❤❤❤)
 *  题目：
 *      环形单向链表，从1开始报数，报到目标数m，当前节点删除，再重新从1开始报数，到m
 *      再删除，直到剩下最后一个节点
 *    输入：一个环形单向链表的头结点head和报数的值m
 *    返回：最后生存下来的节点，且这个节点自己组成环形单向链表，其它节点都删除。
 *    进阶：
 *    如果链表节点数为N，如何在时间复杂度为O(N)时完成问题要求？
 *
 *
 */
public class JosephusProblem {

    public static Node josephusKill1(Node head,int m){
        //如果头结点head为空，或者只有头结点一个元素，或者m<1时，返回head;
        if(head == null || head.next == head || m < 1){
            return head;
        }
        //获取环形链表的最后一个节点
        Node last = head;
        while(last.next!=head){
            last = last.next;
        }
        int count = 0;
        while(head!=last){
            //当count=m时，将head节点移除
            if(++count == m){
                last.next = head.next;
                count = 0;
            }else{
                //当count!=m时，last复制为last.next即head;
                last = last.next;
                //last = head;
            }
            //head始终保持为last的下一个节点
            head = last.next;
        }
        return head;
    }

    /**
     * 通过数学计算的方法，先计算出最后哪个节点存活，直接返回那个节点
     * @param head
     * @param m
     * @return
     */
    public Node josephusKill2(Node head,int m){
        if(head == null || head.next == head || m < 1){
            return head;
        }

        Node cur = head.next;
        int temp = 1;
        while(cur!=head){
            temp++;
            cur=cur.next;
        }
        temp = getLive(temp,m);
        while(--temp!=0){
            head = head.next;
        }
        head.next=head;
        return head;
    }

    public int getLive(int i,int m){
        if(i==1){
            return 1;
        }
        return (getLive(i-1,m)+m-1) % i+1;
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
        n5.next = n1;

        System.out.println(josephusKill1(n1, 2).value);
    }

}
