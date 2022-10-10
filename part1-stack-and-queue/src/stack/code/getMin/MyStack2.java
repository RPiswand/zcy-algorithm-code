package stack.code.getMin;

import java.util.Stack;

/**
 * 根据MyStack1，可发现辅助栈的元素个数是小于数据栈的
 * <p>
 * 可以在压栈的时候，数据栈和辅助栈都同时压入数据，辅助栈每次都压入当时的最小元素；
 * 在出栈时，两栈同时出栈
 */
public class MyStack2 {
    //提供基础功能的数据栈
    private Stack<Integer> stackData;
    //每次数据栈压栈时，都记录最小元素的辅助栈
    private Stack<Integer> stackMin;

    public MyStack2() {
        stackData = new Stack<>();
        stackMin = new Stack<>();
    }

    //每一次数据栈压栈时，辅助栈也同时压栈，
    public void push(int num) {
        if (stackMin.isEmpty()) {
            stackMin.push(num);
        } else if (num < getMin()) {
            stackMin.push(num);
        } else {
            //压入元素比栈顶元素大时，将栈顶元素重复压栈
            stackMin.push(getMin());
        }
        stackData.push(num);
    }

    public int pop() {
        stackMin.pop();
        return stackData.pop();
    }

    public int getMin() {
        return stackMin.peek();
    }

}
