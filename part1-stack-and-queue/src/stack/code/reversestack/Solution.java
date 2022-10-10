/**
 * @author RPiswand
 * @create 2022/10/10
 */
package stack.code.reversestack;

import stack.code.getMin.MyStack1;

import java.util.Stack;

/**
 *    如何仅用递归函数和栈操作逆序一个栈
 *
 *  题目：一个栈依次压入1,2,3,4,5，那么从栈顶到栈底分别是5,4,3,2,1。将这个栈转置后，从栈顶到栈底为1,2,3,4,5，
 *  也就是实现栈中元素的逆序，但是只能用递归函数来实现，不用其他数据结构。
 *
 *
 */
public class Solution {

    public static int geyAndRemoveLastElement(Stack<Integer> stack){
        int result= stack.pop();
        if(stack.isEmpty()){
            return  result;
        }else{
            int last = geyAndRemoveLastElement(stack);
            stack.push(result);
            return last;
        }
    }

    public static void reverse(Stack<Integer> stack){
        if(stack.isEmpty()){
            return;
        }
        int  i = geyAndRemoveLastElement(stack);
        reverse(stack);
        stack.push(i);
    }

    public static  Stack<Integer> stackForTest = new Stack<>();

    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            stackForTest.push(i);
        }

        Solution.reverse(stackForTest);

        for (int i = 1; i <= 5; i++) {
            System.out.println(stackForTest.pop());
        }
    }

}
