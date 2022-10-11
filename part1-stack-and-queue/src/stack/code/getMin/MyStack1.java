package stack.code.getMin;

import java.util.Stack;

/**
 *              设计一个有getMin功能的栈(❤)
 * 题目：实现一个特殊的栈，在实现栈的基本功能基础之上，再实现返回栈中最小元素的操作
 * <p>
 * pop、push、getMin操作时间复杂度为O(1)
 * <p>
 * 思考：需要另外一个栈，进行辅助，来实现记录栈中最小元素。
 * <p>
 * 根据栈先进后出的原理，辅助栈的栈顶，需满足从栈底到栈顶是从大到小的顺序压入；
 * <p>
 * 在压入值时，需要和辅助栈的栈顶元素进行比较，相等或小于时，压入辅助栈；大于时，不操作；
 * 出栈时，相等时，弹出辅助栈，维护数据栈的最小元素
 */
public class MyStack1 {

    //提供正常功能的栈
    private Stack<Integer> stackData;
    //记录当前栈中最小值的栈
    private Stack<Integer> stackMin;

    public MyStack1(){
        stackData = new Stack<>();
        stackMin = new Stack<>();
    }

    public void push(int num) {
        //当辅助栈无元素或者辅助栈栈顶元素大于新压入的元素时，同时将新压入元素压入辅助栈
        if (stackMin.isEmpty() || getMin() >= num) {
            stackMin.push(num);
        }
        stackData.push(num);
    }

    public int pop() {
        if(stackMin.isEmpty()){
            throw  new RuntimeException("Your auxiliary stack is empty");
        }
        //数据栈正常pop，因为辅助栈的压栈规则，导致数据栈出栈的元素(value)只能是大于等于辅助栈的栈顶元素
        //当value等于辅助栈栈顶元素时，辅助栈栈顶元素同时出栈
        int value = stackData.pop();
        if(value==stackMin.peek()){
            stackMin.pop();
        }
        return value;
    }

    public int getMin() {
        if(stackMin.isEmpty()){
            throw  new RuntimeException("Your auxiliary stack is empty");
        }
        return stackMin.peek();
    }

}
