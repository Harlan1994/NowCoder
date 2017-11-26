package seclab.huawei;

import java.util.Scanner;

/**
 * User: Harlan1994
 * Date: 2017/8/6
 * Time: 20:23
 * Description: 计算字符串最后一个单词的长度，单词以空格隔开。
 */
public class A21224 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            String str = input.nextLine();
            str = str.trim();
            System.out.println(str.length() - 1 - str.lastIndexOf(" "));
        }
    }
}