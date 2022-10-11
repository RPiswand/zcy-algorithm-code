package stack.code.getMin;

public class MainTest {


    //测试github提交

    public static void main(String[] args) {

        MyStack1 myStack1 = new MyStack1();
        int[] nums = {3,4,5,1,2,1};
        for (int num : nums) {
            myStack1.push(num);
        }
        System.out.println("---------MyStack1 push finished---------");
        System.out.println("current min element  : "+myStack1.getMin());
        System.out.println("----------------------");
        System.out.println("my stack pop a element : "+ myStack1.pop());
        System.out.println("----------------------");
        System.out.println("current min element  : "+myStack1.getMin());
        System.out.println("----------------------");
        System.out.println("my stack pop a element : "+ myStack1.pop());
        System.out.println("----------------------");
        System.out.println("current min element  : "+myStack1.getMin());
        System.out.println("----------------------");
        System.out.println("my stack pop a element : "+ myStack1.pop());
        System.out.println("----------------------");
        System.out.println("current min element  : "+myStack1.getMin());

        System.out.println("================================");

        MyStack2 myStack2 = new MyStack2();
        for (int num : nums) {
            myStack2.push(num);
        }
        System.out.println("---------MyStack2 push finished---------");
        System.out.println("current min element  : "+myStack2.getMin());
        System.out.println("----------------------");
        System.out.println("my stack pop a element : "+ myStack2.pop());
        System.out.println("----------------------");
        System.out.println("current min element  : "+myStack2.getMin());
        System.out.println("----------------------");
        System.out.println("my stack pop a element : "+ myStack2.pop());
        System.out.println("----------------------");
        System.out.println("current min element  : "+myStack2.getMin());
        System.out.println("----------------------");
        System.out.println("my stack pop a element : "+ myStack2.pop());
        System.out.println("----------------------");
        System.out.println("current min element  : "+myStack2.getMin());


    }
}
