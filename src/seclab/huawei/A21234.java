package seclab.huawei;

import java.util.Scanner;

/**
 * User: Harlan1994
 * Date: 2017/8/19
 * Time: 13:24
 * Description:
 */
public class A21234 {

    public static void main(String[] args) {
        int num;
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            num = scanner.nextInt();

            System.out.println(reverse(String.valueOf(num)));
        }
    }

    public static char[] reverse(String str) {
        int i = 0, j = str.length() - 1;
        char c[] = str.toCharArray();
        while (i < j) {
            char temp = c[i];
            c[i] = c[j];
            c[j] = temp;
            i++;
            j--;
        }

        return c;
    }
}