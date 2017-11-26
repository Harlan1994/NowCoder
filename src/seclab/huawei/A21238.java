package seclab.huawei;

import java.util.Scanner;

/**
 * User: Harlan1994
 * Date: 2017/8/14
 * Time: 14:01
 * Description: 输入一个int型的正整数，计算出该int型数据在内存中存储时1的个数。
 *
 * 此题可以巧妙应用二进制的与运算
 *
 */
public class A21238 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int num = scanner.nextInt();
            int countOfOne = 0;
            while (num > 0) {
                num = num & (num - 1);
                countOfOne++;
            }
            System.out.println(countOfOne);
        }
    }
}