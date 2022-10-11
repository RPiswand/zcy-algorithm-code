package stack.code.sortstackbyonestack;

import java.util.Stack;

/**
 *              用一个栈 实现 另一个栈的排序(❤)
 *  题目：
 *      一个栈中元素的类型为整型，现在想将该栈从顶到底按从大到小的顺序排序，
 *      只许申请一个栈。除此之外，可以申请新的变量，但不能申请额外的数据结构。
 *
 *
 *  思考：
 *      感觉有点儿和之前的两个栈组成队列很像，只是在两个栈之间倒数据时，增加了排序的操作
 *
 *      原本的栈(stack)，需要一直将元素弹出，将弹出的元素值记为cur
 *      往申请的辅助栈(help)中压入数据时,需进行排序操作
 *      1.因为要求是让stack从栈顶到栈底是按从大到小的顺序排列，所以在将stack弹出的元素
 *        压入help时，要求让help满足从栈顶到栈底是按从小到大的顺序排列，方便后面一步到位
 *        从help倒置到stack中
 *      2.如果cur小于或者等于help栈顶元素时，直接将cur压入help栈顶
 *      3.如果cur大于help栈顶元素时，就将help栈顶元素弹出并压入stack栈中保存，直到cur小于或等于help栈顶元素
 *      4.直到将stack栈中所有元素都压入help栈中后，直接将help栈中元素全部弹出压入stack栈中即可。
 *
 */
public class SortStackByStack {

    public static void sort(Stack<Integer> stack){
        //申请一个辅助栈
        Stack<Integer> help = new Stack<>();

        while(!stack.isEmpty()){
            //记stack弹出的元素值为cur
            int cur = stack.pop();
            //当辅助栈里面有元素，并且栈顶元素比stack弹出元素值大时
            while(!help.isEmpty() && help.peek()>cur){
                //将辅助栈中比cur大的元素全弹出并压入stack中
                stack.push(help.pop());
            }
            //经过上面的操作，可时刻保持辅助栈中栈底是最小元素，往上依次增大，
            //直至将stack中的所有元素全部都压入辅助栈中
            help.push(cur);
        }

        //将辅助栈中排好序的元素全部弹出并压入stack栈中
        while(!help.isEmpty()){
            stack.push(help.pop());
        }

    }

    public static void main(String[] args) {
        int[] nums = {5,6,9,2,3,4,1};
        Stack<Integer> stack = new Stack<>();
        for (int num : nums) {
            stack.push(num);
        }
        System.out.println("-----push finished-----");
        SortStackByStack.sort(stack);
        System.out.println("-----sort finished-----");
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }


    }

}
