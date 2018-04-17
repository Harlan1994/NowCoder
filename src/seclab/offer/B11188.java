package seclab.offer;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/3/7
 * Time: 15:32
 * Description:
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 */
public class B11188 {

    public int InversePairs(int[] array) {
        int[] copy = new int[array.length];
        for (int i = 0; i < array.length; i++) copy[i] = array[i];
//        int count = InversePairsCore(array, copy, 0, array.length - 1);
        int count = InversePairsCore(array, copy, 0, array.length - 1);
        return count;
    }

    /**
     * 另一个版本，这个版本不需要呼唤array和copy，更好理解
     *
     * @param array
     * @param copy
     * @param low
     * @param high
     * @return
     */
    public int InversePairsCore(int[] array, int[] copy, int low, int high) {
        if (low == high) { // 当递归到只有一个数字的时候，无法比较，故可以开始返回了，返回0表示一个数字没有比较，也就没有逆序对
            return 0;
        }
        int mid = (low + high) / 2; // 分治
        int leftCount = InversePairsCore(array, copy, low, mid);
        int rightCount = InversePairsCore(array, copy, mid + 1, high);

        // 在merge中统计逆序对，4 5 6和1 3 4，4 > 3,那么4肯定大与3和3前面的数
        // 统计过程中不会出现重复统计的情况，因为每次merge统计过后都是已经排好序的
        int i = mid, j = high, indexCopy = high; // 必须从后往前merge
        int count = 0;
        while (i >= low && j >= mid + 1) {
            if (array[i] > array[j]) {
                copy[indexCopy--] = array[i--];
                count += j - mid;
                count %= 1000000007;
            } else {
                copy[indexCopy--] = array[j--];
            }
        }

        while (i >= low) copy[indexCopy--] = array[i--];
        while (j >= mid + 1) copy[indexCopy--] = array[j--];

        /**但是这也得每次都更新array，使得array每次都是排好序的**/
        for (int s = low; s <= high; s++) {
            array[s] = copy[s];
        }

        /**从全局看，每次返回也是需要模一次的**/
        return (leftCount + rightCount + count) % 1000000007;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.next();
            String[] numbers = input.split(",");
            int[] integers = new int[numbers.length];
            for (int i = 0; i < numbers.length; i++) {
                integers[i] = Integer.parseInt(numbers[i]);
            }

            B11188 b11188 = new B11188();
            System.out.println(b11188.InversePairs(integers));
        }
    }
}
