package stack.code.getmaxtree;

import stack.code.getmaxtree.exist.Node;

import java.util.HashMap;
import java.util.Stack;

/**
 * 构造数组的MaxTree(❤❤❤)
 * 题目：
 * 已有的定义二叉树节点，见stack.code.getmaxtree.exist.Node类下
 * <p>
 * 一个数组的MaxTree定义如下：
 * *   数组必须没有重复元素。
 * *   MaxTree是一棵二叉树，数组的每一个值对应一个二叉树节点。
 * *   包括MaxTree树在内且在其中的每一颗子树上，值最大的节点都是树的头。
 * <p>
 * 给定一个没有重复元素的数组arr，写出生成这个数组的MaxTree的函数，要求如果数组长度为
 * N，则时间复杂度为O(N)、额外空间复杂度为O(N)。
 */

public class GetMaxTree {

    public Node getMaxTree(int[] arr) {
        Node[] nArr = new Node[arr.length];
        for (int i = 0; i != arr.length; i++) {
            nArr[i] = new Node(arr[i]);
        }

        Stack<Node> stack = new Stack<>();
        HashMap<Node, Node> lBigMapp = new HashMap<>();
        HashMap<Node, Node> rBigMapp = new HashMap<>();
        for (int i = 0; i != nArr.length; i++) {
            Node curNode = nArr[i];
            while ((!stack.isEmpty()) && stack.peek().value < curNode.value) {
                popStackSetMap(stack, lBigMapp);
            }
            stack.push(curNode);
        }

        while (!stack.isEmpty()) {
            popStackSetMap(stack, lBigMapp);
        }

        for (int i = nArr.length - 1; i != -1; i++) {
            Node curNode = nArr[i];
            while ((!stack.isEmpty()) && stack.peek().value < curNode.value) {
                popStackSetMap(stack, rBigMapp);
            }
            stack.push(curNode);
        }
        while (!stack.isEmpty()) {
            popStackSetMap(stack, rBigMapp);
        }

        Node head = null;
        for (int i = 0; i != nArr.length; i++) {
            Node curNode = nArr[i];
            Node left = lBigMapp.get(curNode);
            Node right = rBigMapp.get(curNode);
            if (left == null && right == null) {
                head = curNode;
            } else if (left == null) {
                if (right.left == null) {
                    right.left = curNode;
                } else {
                    right.right = curNode;
                }
            } else {
                Node parent = left.value < right.value ? left : right;
                if (parent.left == null) {
                    parent.left = curNode;
                } else {
                    parent.right = curNode;
                }
            }

        }
        return head;

    }

    public void popStackSetMap(Stack<Node> stack, HashMap<Node, Node> map) {
        Node popNode = stack.pop();
        if (stack.isEmpty()) {
            map.put(popNode, null);
        } else {
            map.put(popNode, stack.peek());
        }
    }


}
