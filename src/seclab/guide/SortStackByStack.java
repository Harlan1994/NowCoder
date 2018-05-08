package seclab.guide;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/4/23
 * Time: 09:26
 * Description: 用一个辅助栈对某个栈内的元素进行排序（从大到小，栈顶到底）
 *
 * 思路：每次都获取stack中的第一个元素，然后和help栈内的元素进行比较，一直弹出，直到找到比他大的那个
 * 此时，就将其push进help栈即可。这样stack中每个元素都这样进行，最后help栈将会是从小到大的排序
 */
public class SortStackByStack {

    public static void main(String[] args) {

        Deque<Integer> integers = new ArrayDeque<>();
        integers.push(1);
        integers.push(3);
        integers.push(5);
        integers.push(6);
        integers.push(0);
        integers.push(9);
        integers.push(12);
        integers.push(15);
        integers.push(-9);
        integers.push(8);

        sortByOtherStack(integers);
    }

    public static void sortByOtherStack(Deque<Integer> stack) {
        Deque<Integer> help = new ArrayDeque<>();

        while (!stack.isEmpty()) {
            int cur = stack.poll();
            while (!help.isEmpty() && help.peek() < cur) {
                stack.push(help.poll());
            }
            help.push(cur);
        }
        while (!help.isEmpty()) {
            stack.push(help.poll());
        }

        while(!stack.isEmpty()){
            System.out.print(stack.poll() + " ");
        }
    }
}
