package seclab.xunlei;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/9/12
 * Time: 19:40
 * Description:
 */
public class HongHeiJiMu {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] AB = scanner.nextLine().split(" ");
        int a = Integer.parseInt(AB[0]);
        int b = Integer.parseInt(AB[1]);
        int[] array = new int[17];
        for (int i = 0; i < array.length; i++) {
            array[i] = b;
        }
        int k = 0;
        while (k * a + (7 - k) * b <= 0)
            k++;
        int res = ((k - 1) * a + b * (8 - k)) * 2;
        if (k - 1 >= 3) {
            res += 3 * a;
        } else {
            res += (k - 1) * a + b * (4 - k);
        }
        System.out.println(res);
        System.out.println(-2 & 8);
    }
}

