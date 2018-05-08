package seclab.offer;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/5/8
 * Time: 13:20
 * Description:
 */
public class B11217 {

    public static void main(String[] args) {
        int[] ints = new int[]{2, 3, 4, 2, 6, 2, 5, 1};
        int size = 3;
        ArrayList<Integer> integers = maxInWindows(ints, size);
    }

    public static ArrayList<Integer> maxInWindows(int[] num, int size) {

        ArrayList<Integer> integers = new ArrayList<>();
        if (num.length <= 0 || size > num.length || size == 0) return integers;

        // 窗口开始位置
        for (int i = 0; i <= num.length - size; i++) {
            int max = num[i];
            for (int j = i; j < num.length && j < i + size; j++) {
                if (max < num[j]) {
                    max = num[j];
                }
            }
            integers.add(max);
        }

        return integers;
    }
}
