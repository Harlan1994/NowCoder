package seclab.huawei;

import java.util.Scanner;

/**
 * User: Harlan1994
 * Date: 2017/8/14
 * Time: 14:10
 * Description:
 */
public class A21230 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextFloat()) {
            float num = scanner.nextFloat();
            System.out.println(Math.round(num));
        }
    }
}