package seclab.XZ2017;

import java.util.Scanner;

/**
 * User: Harlan1994
 * Date: 2017/8/26
 * Time: 19:14
 * Description: 注意：要连续
 */
public class XZ29588 {

    private static int maxSum(int array[]) {
        int sum = array[0], b = array[0];
        for (int i = 1; i < array.length; i++) {
            if (b >= 0) { // b[i-1] + a[i] >= 0说明越加会越大，其实和if(b[j-1]+a[j]>a[j]) b[j]=b[j-1]+a[j];效果一样
                b += array[i];
            } else {
                b = array[i];
            }
            sum = sum > b ? sum : b;
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int array[] = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        System.out.println(maxSum(array));
    }
}