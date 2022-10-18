package linkedlist.code.printcommon;

import linkedlist.code.printcommon.exist.Node;

/**
 *              打印两个有序链表的公共部分(❤)
 *    题目：
 *      给定两个有序链表的头指针head1和head2，打印两个链表的公共部分。
 *
 *
 */

public class PrintCommon {

    public void printCommonPart(Node head1,Node head2){
        System.out.println("Common Part : ");
        while(head1!=null && head2!=null){
            if(head1.value<head2.value){
                head1 = head1.next;
            }else if(head1.value>head2.value){
                head2=head2.next;
            }else{
                System.out.print(head1.value + " ");
                head1= head1.next;
                head2= head2.next;
            }
        }
        System.out.println();
    }

}
