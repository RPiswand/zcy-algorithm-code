package queue.code.getmaxwindow;

import java.util.LinkedList;

/**
 *          生成窗口最大值数组(❤❤)
 *
 *  题目：
 *      有一个整型数组arr和一个大小为w的窗口从数组的最左边滑到最右边，窗口每次向
 *      右边滑动一个位置。
 *
 *      例如，数组为[4,3,5,4,3,3,6,7]，窗口大小为3时：
 *
 *      [4  3   5]  4   3   3   6   7           窗口中最大值为5
 *      4  [3   5  4]   3   3   6   7           窗口中最大值为5
 *      4  3   [5  4   3]   3   6   7           窗口中最大值为5
 *      4  3   5  [4   3   3]   6   7           窗口中最大值为4
 *      4  3   5  4   [3   3   6]   7           窗口中最大值为6
 *      4  3   5  4   3   [3   6   7]           窗口中最大值为7
 *    如果数组长度为n，窗口大小为w，则一共产生n-w+1个窗口的最大值。
 *    实现一个函数：
 *    * 输入：整型数组arr，窗口大小为w。
 *    * 输出：一个长度为n-w+1的数组res，res[i]表示每一种窗口状态下的最大值。
 *
 *    上面例子，结果应该返回{5,5,5,4,6,7}
 *
 */

public class MaxWindow {

    public static int[] getMaxWindow(int[] arr,int w){
        //先判断是否满足窗口滑动前置条件
        if(arr==null || w<1 || arr.length<w){
            return null;
        }
        //双端队列，保存入队元素下标
        LinkedList<Integer> qmax = new LinkedList<>();
        //arr长度为n，窗口为w，一共产生n-w+1个窗口最大值
        int[] res = new int[arr.length-w+1];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            // 当qmax不为空，并且队列尾部元素小于等于当前入队列的元素时，
            // 直接将队列尾部的元素poll，直到不满足条件
            while(!qmax.isEmpty() && arr[qmax.peekLast()]<=arr[i]){
                qmax.pollLast();
            }
            //当qmax为空或者qmax队尾元素大于入队列元素时，直接加到队尾
            qmax.addLast(i);
            //当qmax队列头元素等于i-w时，说明队列头保存的下标已经不在窗口内了，故将其弹出
            if(qmax.peekFirst()==i-w){
                qmax.pollFirst();
            }
            //当移动了w个元素过后，窗口形成，队列头保存的就是当前窗口的最大值
            if(i>=w-1){
                res[index++] = arr[qmax.peekFirst()];
            }
        }
        return res;
    }

}
