package seclab.offer;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/6/22
 * Time: 16:20
 * Description:
 */
public class B11173_包含min函数的栈 {

    public static void main(String[] args) {

    }

    private Stack<Integer> integers = new Stack<>();
    private Stack<Integer> integersTmp = new Stack<>();

    public void push(int node) {
        integers.push(node);
    }

    public void pop() {
        integers.pop();
    }

    public int top() {
        return integers.peek();
    }

    public int min() {
        int min = integers.peek();
        while (!integers.isEmpty()) {
            int tmp = integers.pop();
            integersTmp.push(tmp);
            if (tmp < min) {
                min = tmp;
            }
        }

        while(!integersTmp.isEmpty()){
            integers.push(integersTmp.pop());
        }
        return min;
    }
}
