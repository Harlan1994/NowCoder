package seclab.huawei;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/3/6
 * Time: 20:56
 * Description:写出一个程序，接受一个十六进制的数值字符串，输出该数值的十进制字符串。（多组同时输入 ）
 */
public class A21228 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String str = scanner.next().substring(2);
            Integer integer = Integer.parseInt(str, 16);
            System.out.println(integer);
        }
    }
}
