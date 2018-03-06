package seclab.huawei;

import java.util.Scanner;

/**
 * User: Harlan1994
 * Date: 2017/8/6
 * Time: 20:23
 * Description: 写出一个程序，接受一个有字母和数字以及空格组成的字符串，
 * 和一个字符，然后输出输入字符串中含有该字符的个数。不区分大小写。
 */
public class A21225 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.next().toLowerCase();
        char c = input.next().toLowerCase().charAt(0);

        int count = 0;
        if (str != null && str.length() > 0) {
            for (int i = 0; i < str.length(); i++) {
                if (c == str.charAt(i)) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
