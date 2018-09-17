package seclab.xiecheng;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/9/4
 * Time: 18:31
 * Description:
 */
public class XC01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long number = scanner.nextLong();
        System.out.println(numberOfOne(number));
    }

    public static long numberOfOne(long number) {
        long count = 0;
        while (number != 0) {
            count++;
            number = number & (number - 1);
        }
        return count;
    }
}
