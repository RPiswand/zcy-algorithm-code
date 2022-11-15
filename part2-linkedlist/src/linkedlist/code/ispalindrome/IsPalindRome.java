package linkedlist.code.ispalindrome;

import linkedlist.code.common.nodemodule.Node;

import java.util.Stack;

/**
 *                  判断一个链表是否为回文结构(❤❤)
 *  题目：
 *      给定一个链表的头节点head，请判断该链表是否为回文结构
 *  进阶：
 *      如果链表长度为N，时间复杂度达到O(N)，额外空间复杂度达到O(1)
 *
 */


public class IsPalindRome {

    public boolean isPalindrome1(Node head){
        Stack<Node> stack = new Stack<>();
        Node cur = head;
        while(cur!=null){
            stack.push(cur);
            cur=cur.next;
        }
        while(head!=null){
            if(head.value != stack.pop().value){
                return false;
            }
            head = head.next;
        }
        return true;
    }

    public boolean isPalindrome2(Node head){
        if(head==null || head.next==null){
            return true;
        }
        Node right = head.next;
        Node cur = head;
        while(cur.next!=null || cur.next.next!=null){
            right = right.next;
            cur = cur.next.next;
        }
        Stack<Node> stack = new Stack<>();
        while(right!=null){
            stack.push(right);
            right = right.next;
        }
        while(!stack.isEmpty()){
            if(head.value!=stack.pop().value){
                return false;
            }
            head = head.next;
        }
        return true;
    }

    public boolean isPalindrome3(Node head){
        if(head == null || head.next == null){
            return true;
        }
        Node n1 = head;
        Node n2 =head;
        while(n2.next!=null && n2.next.next !=null){
            n1 = n1.next;
            n2=n2.next.next;
        }
        n2 = n1.next;
        n1.next = null;
        Node n3 = null;
        while(n2!=null){
            n3 = n2.next;
            n2.next = n1;
            n1 = n2;
            n2 = n3;
        }

        n3 = n1;
        n2=head;
        boolean res = true;

        while(n1!=null&&n2!=null){
            if(n1.value!=n2.value){
                res = false;
                break;
            }
            n1= n1.next;
            n2=n2.next;
        }
        n1 = n3.next;
        n3.next=null;
        while(n1!=null){
            n2=n1.next;
            n1.next = n3;
            n3=n1;
            n1=n2;
        }
        return res;

    }

}
