package seclab.guide;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/4/23
 * Time: 12:48
 * Description: 仅用递归函数和栈操作逆序一个栈
 */
public class ReverseStackByStackAndReverseOps {

    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.push(1);
        deque.push(2);
        deque.push(3);

        reverse(deque);
    }

    public static void reverse(Deque<Integer> stack) {
        if (stack.isEmpty()) return;
        Integer i = getAndRemoveLast(stack);
        reverse(stack);
        stack.push(i);

        while (!stack.isEmpty()) {
            System.out.print(stack.poll() + " ");
        }
    }

    /**
     * 获取栈中最后一个元素，递归的方式
     *
     * @param integers
     * @return
     */
    public static Integer getAndRemoveLast(Deque<Integer> integers) {
        Integer integer = integers.poll();

        if (integers.isEmpty()) {
            return integer;
        } else {
            Integer last = getAndRemoveLast(integers);
            integers.push(integer);
            return last;
        }
    }
}
