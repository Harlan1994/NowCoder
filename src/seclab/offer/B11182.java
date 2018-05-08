package seclab.offer;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/5/2
 * Time: 12:26
 * Description:
 */
public class B11182 {

    public static void main(String[] args) {
        int[] ints = new int[]{4, 5, 1, 6, 2, 7, 3, 8};
        int k = 8;
        ArrayList<Integer> arrayList = GetLeastNumbers_Solution1(ints, k);
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.print(arrayList.get(i) + " ");
        }
    }

    // 冒泡排序法，复杂度很高O(n*k)
    public static ArrayList<Integer> GetLeastNumbers_Solution1(int[] input, int k) {

        // 冒泡法？
        ArrayList<Integer> integers = new ArrayList<>();
        if (k > input.length) return new ArrayList<>();

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < input.length - 1 - i; j++) {
                if (input[j] < input[j + 1]) {
                    int temp = input[j];
                    input[j] = input[j + 1];
                    input[j + 1] = temp;
                }
            }

            integers.add(input[input.length - 1 - i]);
        }

        return new ArrayList<>(integers);
    }

    // 堆排序O(log(n)*k)
    public static ArrayList<Integer> GetLeastNumbers_Solution2(int[] input, int k) {
        return null;

    }

    // 快速排序O(log(n)*n)

}
