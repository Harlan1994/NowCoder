package seclab.offer;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/6/22
 * Time: 16:28
 * Description:输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，序列4，5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 * <p>
 * Solution: 按照栈先进后出的特点，我们有以下分析：
 * 1。假设有两个序列pushA, popA分别是入栈序列和出栈序列
 * 2。设立两个指针i=0, j=0，从头开始遍历pushA，假如遍历到和pushA[i] == popA[j],那么pushA[i]前面的元素必定按照先进后出的顺序排在popA[j]的后面。
 * 3。我们模拟入栈和出栈，当pushA[i] != popA[j]时入栈，否则，尝试出栈。将栈中和popA[j++]相等的一一退出。
 * 4。一直遍历到i结尾，然后再进行一次3中的出栈操作（可能已经遍历完了但是还没有出完）
 * 5。加入栈中还有元素，那么肯定不符合出栈入栈的顺序
 */
public class B11174_栈的压入弹出序列 {

    public static void main(String[] args) {

    }

    private Stack<Integer> stack = new Stack<>();

    public boolean IsPopOrder(int[] pushA, int[] popA) {

        int j = 0;
        // 从头到尾遍历pushA
        for (int i = 0; i < pushA.length; i++) {
            if (pushA[i] == popA[j]) {
                j++;
                while (!stack.isEmpty()) {
                    if (stack.peek() == popA[j]) {
                        j++;
                        stack.pop();
                    } else break;
                }
            } else {
                stack.push(pushA[i]);
            }
        }
        while (!stack.isEmpty()) {
            if (stack.peek() == popA[j]) {
                j++;
                stack.pop();
            } else break;
        }

        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }
}
