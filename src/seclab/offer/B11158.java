package seclab.offer;

import java.util.Stack;

/**
 * User: Harlan1994
 * Date: 2017/9/2
 * Time: 11:55
 * Description:
 */
public class B11158 {

    private Stack<Integer> stack1 = new Stack<Integer>(); // 入队列的栈
    private Stack<Integer> stack2 = new Stack<Integer>(); // 出队列的栈

    public static void main(String[] args) {
        B11158 b11158 = new B11158();

        int[] array = {1, 2, 3, 4, 5, 6, 7, 8};
        for(int i = 0; i < array.length; i++){
            b11158.push(array[i]);
        }

        System.out.println("Oh, shit!");
    }

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(!stack2.empty())return stack2.pop();

        while(!stack1.empty()){
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }
}