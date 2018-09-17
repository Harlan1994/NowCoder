package seclab.zsyh;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/9/16
 * Time: 19:56
 * Description:
 */
public class ZSYH02 {

    public static int[] fibonacci;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
//        fibonacci = new int[n + 1];
//        fibonacci[1] = 1;
//        fibonacci[2] = 2;
//        for (int i = 3; i <= n; i++) {
//            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
//        }
//        System.out.println(fibonacci[n]);
        System.out.println(getFib(n));
    }

    /**
     * 返回斐波那契数第n个值,n从0开始
     * 实现方式，基于递归实现
     *
     * @param n
     * @return
     * @author mhy2011@163.com
     * @since 2015年8月18日上午9:41:30
     */
    public static int getFib(int n) {
        if (n < 0) {
            return -1;
        } else if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else {
            return getFib(n - 1) + getFib(n - 2);
        }
    }
}
