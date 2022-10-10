package stack.code.twostackstoqueue;

import java.util.Stack;

/**
 * 由两个栈组成一个队列
 * <p>
 * 题目：编写一个类，用两个栈实现一个队列。支持队列的基本操作(add、poll、peek)
 * <p>
 * 思考：
 * 栈的特点是先进后出，而队列的特点是先进先出；
 * 可以利用两个栈，将顺序反过来，进而实现队列的基本操作。
 * 基本思路：一个栈作为压入栈，一个栈作为弹出栈；两栈之间通过出栈，入栈将元素倒置
 * 理想情况先压后出：
 * [1,2,3,4,5]  --压栈-->                                --出栈--> [1,2,3,4,5]
 *                          |  5  |   -倒->   |   1   |
 *                          |  4  |           |   2   |
 *                          |  3  |           |   3   |
 *                          |  2  |           |   4   |
 *                          |  1  |           |   5   |
 *                          --------         ----------
 *                          stackPush        stackPop
 * 需注意：
 * 1.stackPush想向stackPop中倒数据，stackPop必须为空，不然会打乱入栈顺序
 * 2.stackPush向stackPop倒数据时，必须一次性全部将数据倒入到stackPop中
 */
public class TwoStacksToQueue {

    //压入栈
    private Stack<Integer> stackPush;
    //弹出栈
    private Stack<Integer> stackPop;

    public TwoStacksToQueue() {
        stackPush = new Stack<>();
        stackPop = new Stack<>();
    }

    //压入栈压入元素
    public void add(int num) {
        stackPush.push(num);
    }

    /**
     * 注意两点：
     * 1.弹出栈为空时，才能从压入栈倒数据
     * 2.压入栈倒入弹出栈时，必须一次性倒入
     * @return
     */
    public int poll() {
        if(stackPush.isEmpty() && stackPop.isEmpty()){
            throw  new RuntimeException("Queue is empty");
        }else if(stackPop.isEmpty()){ //先判断pop栈有没有元素，不是说明pop栈有已经倒置好了的元素，可直接弹出
            //如果pop栈没有元素，就需要一次性将push栈中现有的所有元素一次性全部弹出压入pop栈中
            while(!stackPush.isEmpty()){
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.pop();
    }

    public int peek() {
        if(stackPush.isEmpty() && stackPop.isEmpty()){
            throw  new RuntimeException("Queue is empty");
        }else if(stackPop.isEmpty()){
            while(!stackPush.isEmpty()){
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.pop();
    }

}
