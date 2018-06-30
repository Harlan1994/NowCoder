package seclab.huawei;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/6/26
 * Time: 10:13
 * Description:编写一个函数，传入一个int型数组，返回该数组能否分成两组，使得两组中各元素加起来的和相等，并且，所有5的倍数必须在其中一个组中，
 * 所有3的倍数在另一个组中（不包括5的倍数），
 * 能满足以上条件，返回true；不满足时返回false。
 */
public class A21316 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = scanner.nextInt();
            }
            System.out.println(check(array));
        }
    }

    public static boolean check(int[] array) {
        int[] left = new int[array.length];
        int threeSum = 0;
        int fiveSum = 0;
        int count = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 5 == 0) { // 可以包括三的倍数
                fiveSum += array[i];
            } else if (array[i] % 3 == 0) { // 如果也是5的倍数，不能放
                threeSum += array[i];
            } else {
                left[count++] = array[i];
            }
        }
        // 放完3和5的倍数，剩下的就需要另外算了
        // 计算两个的差值的绝对值，那么只要剩下的可以组成两组和相等的就行了
        int delta = Math.abs(fiveSum - threeSum);
        return checkCore(0, count, 0, delta, left);
    }

    // 两个集合设置为A，B,以A为例，A每次只有两种选择，加上或者不加上当前数字
    // 知道序列的最后就构成了一种选择方式，在判断是否相等即可
    static boolean checkCore(int i, int n, int sum, int delta, int[] array) {
        if (n == i) {
            return (Math.abs(sum) == delta);
        } else {
            // 当前数字i，加还是不加两种选择，加他就比B集合多了array[i],不加就少了array[i]
            // 这里的sum其实是一个差值，表示两个集合相差多少，如果相差的绝对值和之前计算的差值的绝对值一致
            // 那么肯定存在一种两组想家和相等的分法
            return checkCore(i + 1, n, sum + array[i], delta, array) ||
                    checkCore(i + 1, n, sum - array[i], delta, array);
        }
    }
}
