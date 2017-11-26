package seclab.other;

import java.util.Arrays;
import java.util.Scanner;

/**
 * User: Harlan1994
 * Date: 2017/9/9
 * Time: 16:22
 * Description:
 */
public class SJ1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int magicNum = scanner.nextInt();
        int num = magicNum;

        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            if ((num - 1) % 2 == 0) {
                num -= 1;
                sb.append("1");
            } else {
                num -= 2;
                sb.append("2");
            }
            num /= 2;
        }
        sb.reverse();
        System.out.println(sb.toString());
    }
}