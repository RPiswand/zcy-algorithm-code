package stack.code.twostackstoqueue;

public class MainTest {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6};

        TwoStacksToQueue queue =  new TwoStacksToQueue();
        for (int num : nums) {
            queue.add(num);
        }
        System.out.println("---------Queue add finished---------");
        System.out.println("current poll element  : "+queue.poll());
        System.out.println("----------------------");
        System.out.println("current poll element  : "+queue.poll());
        System.out.println("----------------------");
        System.out.println("current poll element  : "+queue.poll());
        System.out.println("----------------------");
        System.out.println("current poll element  : "+queue.poll());
        System.out.println("----------------------");
        System.out.println("current peek element  : "+queue.poll());
        System.out.println("----------------------");
    }
}
