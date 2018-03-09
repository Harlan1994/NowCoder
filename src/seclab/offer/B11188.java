package seclab.offer;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/3/7
 * Time: 15:32
 * Description:
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。
 * 并将P对1000000007取模的结果输出。 即输出P%1000000007
 */
public class B11188 {

    public int InversePairs(int[] array) {
        int[] copy = new int[array.length];
        for (int i = 0; i < array.length; i++) copy[i] = array[i];
        int count = InversePairsCore(array, copy, 0, array.length - 1);
        return count;
    }

    public int InversePairsCore(int[] array, int[] copy, int start, int end) {
        if (start == end) {
            copy[start] = array[start];
            return 0;
        }

        int length = (end - start) / 2;

        // 一直按照一半一半的划分下去，直到化成成一个一个的。
        int leftCount = InversePairsCore(copy, array, start, start + length) % 1000000007;
        int rightCount = InversePairsCore(copy, array, start + length + 1, end) % 1000000007;

        int i = start + length, j = end; /**从最后一个开始归并**/
        int indexCopy = end;
        int count = 0;

        /**
         * 这是归并阶段，从后到前归并，按照从小到大的顺序排序。
         * 因为比较时前面的和后面的都是经过各自归并排序的，因此当归并时发现前面的比后面的大，那么后面的就可能有多个,
         * 例如 (5，6，7/1，3，6) 7比6大，那自然的7肯定比6前面的数字都大，故都需要统计一次。
         * 归并之后是有顺序的，也就是原本比后面大的情况经过排序之后就没有了，故不会重复统计。
         */
        while (i >= start && j >= start + length + 1) {
            if (array[i] > array[j]) {
                copy[indexCopy--] = array[i--];
                count += j - start - length; /**当前j前面的(包括j)都需要统计一次**/
                count %= 1000000007;/**每次都需要模一次避免过大**/
            } else {
                copy[indexCopy--] = array[j--];
            }
        }

        while (i >= start) copy[indexCopy--] = array[i--];
        while (j >= start + length + 1) copy[indexCopy--] = array[j--];

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
